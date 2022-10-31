package org.ms.clientprojetservice;


import org.ms.clientprojetservice.entities.Customer;
import org.ms.clientprojetservice.entities.CustomerCategory;
import org.ms.clientprojetservice.repository.CustomerCategoryRepository;
import org.ms.clientprojetservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ClientprojetServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(ClientprojetServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository,
							CustomerCategoryRepository customerCategoryRepository,
							RepositoryRestConfiguration repositoryRestConfiguration)
	{
		repositoryRestConfiguration.exposeIdsFor(Customer.class);
		repositoryRestConfiguration.exposeIdsFor(CustomerCategory.class);
		return args ->
		{


			for (CustomerCategory c : customerCategoryRepository.findAll())
			{
				System.out.println(c.getCustomerCategoryName());
			}

			for (Customer c : customerRepository.findAll())
			{
				System.out.println(c.getCustomerName());
			}
		};
	}

}
