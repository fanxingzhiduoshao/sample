package springboot_jpa.repository;

import org.springframework.data.repository.CrudRepository;
import springboot_jpa.entity.Customer;

import java.util.List;

public interface CustomerRepository  extends CrudRepository<Customer,Long> {

    List<Customer> findByLastName(String lastName);
}
