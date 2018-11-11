package pl.mb.soft.orderapp.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.mb.soft.orderapp.entities.Customer;

import java.util.Optional;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void shouldFindCustomerByLoginAndPassword(){
        Optional<Customer> customer = customerRepository.findCustomerByLoginAndPassword("adam", "abc123");
        assertEquals(true, customer.isPresent());
    }
}