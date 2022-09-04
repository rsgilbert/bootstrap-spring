package net.passioncloud.bootstrap;

import net.passioncloud.bootstrap.domain.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;


public class BaseCustomerService implements CustomerService{
    // map customer table to customer row
    private final RowMapper<Customer> rowMapper = (rs, i) ->
            new Customer(rs.getInt("id"), rs.getString("name"));

    private final JdbcTemplate jdbcTemplate;

    protected BaseCustomerService(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public Collection<Customer> save(String... names) {
        List<Customer> customerList = new ArrayList<>();

        for(String name: names) {
            if(name.equals("Jane")) {
                throw new RuntimeException("xxx " + findAll().size());
            }
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(con -> {
                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO CUSTOMERS (name) VALUES(?)",
                        Statement.RETURN_GENERATED_KEYS
                );
                ps.setString(1, name);
                return ps;
            }, keyHolder);
            // for you to get a key (ie not null), the table must be having a primary key
            int keyHolderKey = Objects.requireNonNull(keyHolder.getKey()).intValue();
            Customer customer = this.findById(keyHolderKey);
            Assert.notNull(name, "The name given must not be null");
            customerList.add(customer);
        }
        return customerList;
    }

    @Override
    public Customer findById(int id) {
        String sql = "SELECT * FROM customers WHERE id = ?";
        return this.jdbcTemplate.queryForObject(sql, this.rowMapper, id);
    }

    @Override
    public Collection<Customer> findAll() {
        String sql = "SELECT * FROM customers";
        return this.jdbcTemplate.query(sql, this.rowMapper);
    }
}
