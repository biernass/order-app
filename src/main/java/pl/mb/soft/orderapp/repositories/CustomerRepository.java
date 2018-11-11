package pl.mb.soft.orderapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.mb.soft.orderapp.entities.Customer;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Optional<Customer> findCustomerByLoginAndPassword(String login, String password);

}
