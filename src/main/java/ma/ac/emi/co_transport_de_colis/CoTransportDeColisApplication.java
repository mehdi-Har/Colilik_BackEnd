package ma.ac.emi.co_transport_de_colis;

import ma.ac.emi.co_transport_de_colis.entities.Account;
import ma.ac.emi.co_transport_de_colis.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.beans.BeanProperty;
import java.util.stream.Stream;

@SpringBootApplication
public class CoTransportDeColisApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoTransportDeColisApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AccountRepository repository) {
        return args -> {
            repository.deleteAll();
            Stream.of("Elmehdi","Yasser").forEach(c->
                    repository.save(new Account(c,c,c,c)));
            repository.findAll().forEach(System.out::println);
        };
    }
}
