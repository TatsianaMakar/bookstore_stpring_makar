package com.company;

//import com.company.dao.connection.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan
public class AppConfiguration {
    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public NamedParameterJdbcTemplate namedJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        Properties properties = properties();
        config.setDriverClassName(properties.getProperty("app.db.driver"));
        config.setUsername(properties.getProperty("app.db.username"));
        config.setPassword(properties.getProperty("app.db.password"));
        config.setJdbcUrl(properties.getProperty("app.db.url"));
        return new HikariDataSource(config);
    }

    @Bean
    public Properties properties() {
        try {
            Resource resource = new ClassPathResource("/application.properties");
            return PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public EntityManager entityManager() {
//       EntityManagerFactory factory=null;
        //  try {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("psql");
        EntityManager entityManager = factory.createEntityManager();
       // factory.close();
        return entityManager;
        // factory.close();
        // } finally {
        //             if (factory != null) {
        // factory.close();
//            }
        // }
    }

}
