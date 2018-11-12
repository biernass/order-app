package pl.mb.soft.orderapp.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.mb.soft.orderapp.dto.CustomerDto;
import pl.mb.soft.orderapp.entities.Customer;
import pl.mb.soft.orderapp.repositories.CustomerRepository;

import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerServiceImplTest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void shouldRegisterUnregisteredCustomer(){
        CustomerDto customerDto= new CustomerDto();
        customerDto.setFirstName("michal");
        customerDto.setLastName("bier");
        customerDto.setCustomerType("VIP");
        customerDto.setLogin("mb");
        customerDto.setPassword("aaa");
        customerDto.setEmail("bbb@gmail.com");

        customerService.registerCustomer(customerDto);

        Optional<Customer> customerOptional = customerRepository.findCustomerByLogin("mb");
        assertEquals(true, customerOptional.isPresent());
        assertEquals("47BCE5C74F589F4867DBD57E9CA9F808", customerOptional.get().getPassword());


    }

}