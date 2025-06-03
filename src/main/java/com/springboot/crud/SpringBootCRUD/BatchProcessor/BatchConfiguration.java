package com.springboot.crud.SpringBootCRUD.BatchProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.springboot.crud.SpringBootCRUD.Entity.User;
import lombok.Data;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.RowMapper;


//@Configuration

@EnableBatchProcessing
public class BatchConfiguration {



    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private DataSourceConfiguration dataSourceConfiguration;

    public class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setCreate_time(rs.getTimestamp("create_time"));

            return user;
        }
    }

    @Bean
    public JdbcCursorItemReader<User> reader() {
        JdbcCursorItemReader<User> jdbcCursorItemReader = new JdbcCursorItemReader<>();
        jdbcCursorItemReader.setDataSource(dataSourceConfiguration.getDataSource());
        jdbcCursorItemReader.setSql("SELECT username, email, password, create_time FROM user_schema.user");
        jdbcCursorItemReader.setRowMapper(new UserRowMapper());

        return jdbcCursorItemReader;
    }

    @Bean
    public UserItemProcessor userItemProcessor() {
        return new UserItemProcessor();
    }

    @Bean
    public FlatFileItemWriter<User> writer() {
        FlatFileItemWriter<User> writer = new FlatFileItemWriter<>();
        writer.setResource(new ClassPathResource("Users.txt"));
        writer.setLineAggregator(new DelimitedLineAggregator<User>() {{
            setDelimiter("  ");
            setFieldExtractor(new BeanWrapperFieldExtractor<User>() {{
                setNames(new String[]{"username", "email", "password", "create_time"});
            }});
        }});

        return writer;
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1").<User, User>chunk(10)
                .reader(reader())
                .processor(userItemProcessor())
                .writer(writer())
                .build();
    }

    @Bean
    public Job exportUserJob() {
        return jobBuilderFactory.get("exportUserJob")
                .incrementer(new RunIdIncrementer())
                .flow(step1())
                .end()
                .build();
    }
}
