package net.passioncloud.bootstrap;

import net.passioncloud.bootstrap.domain.Customer;

import java.util.Collection;

public interface CustomerService {
    Collection<Customer> save(String... names);
    Customer findById(int id);


    Collection<Customer> findAll();
}
