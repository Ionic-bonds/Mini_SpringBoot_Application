package com.example.workshop.transaction;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class TransactionConfig {

    @Bean
    CommandLineRunner commandLineRunner(TransactionRepository repository) {
        return args -> {
            Transaction first = new Transaction(
                1L,
                "Name",
                "abc@abc.com",
                LocalDate.of(2020, 1, 30)
            );

            Transaction second = new Transaction(
                2L,
                "Name2",
                "xyz@xyz.com",
                LocalDate.of(2020, 1, 30)
            );

            repository.deleteAll();

            repository.saveAll(
                List.of(first, second)
            );
        };
    }
}