package pl.mb.soft.orderapp.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import pl.mb.soft.orderapp.converters.CustomerConverter;
import pl.mb.soft.orderapp.dto.CustomerDto;
import pl.mb.soft.orderapp.entities.Customer;
import pl.mb.soft.orderapp.repositories.CustomerRepository;

import java.util.Locale;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerConverter customerConverter;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    @Qualifier("emailService")
    private EmailService emailService;

    @Value("${order.server.address}")
    private String serverAddress;

    @Autowired
    private MessageSource messageSource;


    @Override
    public void registerCustomer(CustomerDto customerDto) {
        Customer customer = customerConverter.apply(customerDto);
        customer.setActive(false);
        String token = UUID.randomUUID().toString();
        customer.setToken(token);
        String encryptedPassword = DigestUtils.md5Hex(customerDto.getPassword()).toUpperCase();
        customer.setPassword(encryptedPassword);
        String activationAddress = serverAddress + "/customer/activate?login=" + customerDto.getLogin()
                + "&token=" + token;
        customerRepository.save(customer);
        String subject = messageSource.getMessage("customer.registration.email.subject", new Object[]{},
                Locale.getDefault());
        String body = messageSource.getMessage("customer.registration.email.body",
                new Object[]{customerDto.getFirstName(), activationAddress}, Locale.getDefault());
        emailService.send(customer.getEmail(), subject, body);
    }
}
