package springboot_jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springboot_jpa.entity.Customer;
import springboot_jpa.repository.CustomerRepository;

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository customerRepository){

        return args -> {

            // save a couple of customers
            customerRepository.save(new Customer("Jack", "Bauer"));
            customerRepository.save(new Customer("Chloe", "O'Brian"));
            customerRepository.save(new Customer("Kim", "Bauer"));
            customerRepository.save(new Customer("David", "Palmer"));
            customerRepository.save(new Customer("Michelle", "Dessler"));


            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : customerRepository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            customerRepository.findById(1L)
                    .ifPresent(customer -> {
                        log.info("Customer found with findById(1L):");
                        log.info("--------------------------------");
                        log.info(customer.toString());
                        log.info("");
                    });

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            customerRepository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            // 	log.info(bauer.toString());
            // }
            log.info("");
        };
    }

}
