package net.passioncloud.bootstrap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;



public class Application {

    public static void main(String[] args) {

        DevelopmentOnlyCustomerService customerService = new DevelopmentOnlyCustomerService();
        Demo.workWithCustomerService(Application.class, customerService);
    }


}
