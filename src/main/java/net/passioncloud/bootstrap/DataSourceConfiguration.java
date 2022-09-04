package net.passioncloud.bootstrap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

    @Configuration
    @Profile("prod")
    @PropertySource("application-prod.properties")
    public static class ProductionConfiguration {
        @Bean
        DataSource productionDataSource(@Value("${spring.datasource.url}") String url,
                                        @Value("${spring.datasource.username}") String username,
                                        // work in progress) {

        }
    }
}
