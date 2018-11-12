package pl.mb.soft.orderapp.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.mb.soft.orderapp.converters.CustomerConverter;
import pl.mb.soft.orderapp.dto.CustomerDto;
import pl.mb.soft.orderapp.entities.Customer;
import pl.mb.soft.orderapp.repositories.CustomerRepository;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerConverter customerConverter;

    @Autowired
    private CustomerRepository customerRepository;



    @Override
    public void registerCustomer(CustomerDto customerDto) {
        Customer customer = customerConverter.apply(customerDto);
        customer.setActive(false);
        String token = UUID.randomUUID().toString();
        customer.setToken(token);
        String encryptedPassword = DigestUtils.md5Hex(customerDto.getPassword()).toUpperCase();
        customer.setPassword(encryptedPassword);
        customerRepository.save(customer);

    }
}
