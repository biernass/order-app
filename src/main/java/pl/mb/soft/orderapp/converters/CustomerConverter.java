package pl.mb.soft.orderapp.converters;

import pl.mb.soft.orderapp.dto.CustomerDto;
import pl.mb.soft.orderapp.entities.Customer;
import pl.mb.soft.orderapp.entities.CustomerType;

import java.util.function.Function;

public class CustomerConverter implements Function<CustomerDto, Customer> {

    @Override
    public Customer apply(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setLogin(customerDto.getLogin());
        customer.setPassword(customerDto.getPassword());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        CustomerType customerType = CustomerType.valueOf(customerDto.getCustomerType());
        customer.setCustomerType(customerType);
        return customer;
    }
}
