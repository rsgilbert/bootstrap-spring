package net.passioncloud.bootstrap;

import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

// Don't do this
public class DevelopmentOnlyCustomerService extends BaseCustomerService {
    protected DevelopmentOnlyCustomerService() {
        super(createDataSource());
    }

    private static DataSource createDataSource() {
        DataSource dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2).build();
        return MyDataSourceUtils.initializeDdl(dataSource);
    }
}
