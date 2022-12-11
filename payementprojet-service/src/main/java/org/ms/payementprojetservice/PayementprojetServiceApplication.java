package org.ms.payementprojetservice;

import org.ms.payementprojetservice.entities.Transaction;
import org.ms.payementprojetservice.repository.PayementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
@EnableFeignClients
public class PayementprojetServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayementprojetServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(PayementRepository payementRepository,
							RepositoryRestConfiguration repositoryRestConfiguration)
	{
		repositoryRestConfiguration.exposeIdsFor(Transaction.class);

		return args ->
		{
			for (Transaction c : payementRepository.findAll())
			{
				System.out.println("id-transaction  "+c.getId());
			}
		};
	}

}
