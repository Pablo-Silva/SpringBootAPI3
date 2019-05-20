package com.api;

import com.api.domain.Catraca;
import com.api.repository.CatracaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApiApplication.class, args);
	}
	
    @Bean
    CommandLineRunner init(FilmeRepository filmeRepository, CatracaRepository catracaRepository) {
        return args -> {
            Filme f1 = new Filme("A lista de schindler", "180", "Drama");
            Filme f2 = new Filme("Roma", "100", "Drama");
            Filme f3 = new Filme("O Poderoso Chefão", "120", "Drama");
            filmeRepository.save(f1);
            filmeRepository.save(f2);
            filmeRepository.save(f3);


            Catraca catraca = new Catraca("catraca1", 1, null, null);
            Catraca catraca2 = new Catraca("catraca2", null, 1, null);
            Catraca catraca3 = new Catraca("catraca3", null, null, 1);

            catracaRepository.saveAll(Arrays.asList(catraca, catraca2, catraca3));
        };
    }

}