package net.passioncloud.bootstrap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;


@Configuration
public class ApplicationForTransaction {
    public static void main(String[] args) {
//        DataSource dataSource = new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.H2).build();
//        dataSource = MyDataSourceUtils.initializeDdl(dataSource);
//        Demo.workWithCustomerService(ApplicationForTransaction.class, customerService);
        ApplicationContext ac = SpringUtils.run(ApplicationForTransaction.class, "j");
        CustomerService cs = (CustomerService) ac.getBean("customerService");
        Demo.workWithCustomerService(ApplicationForTransaction.class, cs);
    }

    // -- bean provider methods


    @Profile("j")
    @Bean
    PlatformTransactionManager transactionManager(DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }

    @Bean
    TransactionTemplateCustomerService customerService(TransactionTemplate transactionTemplate, DataSource dataSource) {
        return new TransactionTemplateCustomerService(dataSource, transactionTemplate);
    }

    @Bean
    TransactionTemplate transactionTemplate(PlatformTransactionManager transactionManager) {
        return new TransactionTemplate(transactionManager);
    }

    // -- end of bean provider methods
}
