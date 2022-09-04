package net.passioncloud.bootstrap;

import net.passioncloud.bootstrap.domain.Customer;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.Collection;

public class TransactionTemplateCustomerService extends BaseCustomerService {
    private final TransactionTemplate transactionTemplate;

    public TransactionTemplateCustomerService(DataSource dataSource, TransactionTemplate transactionTemplate) {
        super(dataSource);
        this.transactionTemplate = transactionTemplate;
    }

    @Override
    public Collection<Customer> save(String... names) {
        return transactionTemplate.execute(s -> super.save(names));
    }

    @Override
    public Customer findById(int id) {
        return transactionTemplate.execute(s -> {
          //  if(true) throw new RuntimeException("bye");
            return super.findById(id);
        });
    }

    @Override
    public Collection<Customer> findAll() {
        return transactionTemplate.execute(s -> super.findAll());
    }
}
