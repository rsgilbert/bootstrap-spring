package net.passioncloud.bootstrap;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

public abstract class MyDataSourceUtils {
    public static DataSource initializeDdl(DataSource dataSource) {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator(
                new ClassPathResource("/schema.sql")
        );
        DatabasePopulatorUtils.execute(populator, dataSource);
        return dataSource;
    }
}
