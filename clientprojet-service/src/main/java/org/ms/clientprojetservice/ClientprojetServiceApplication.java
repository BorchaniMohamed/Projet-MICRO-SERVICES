package org.ms.clientprojetservice;


import org.ms.clientprojetservice.entities.Customer;
import org.ms.clientprojetservice.entities.CustomerCategorie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.ms.clientprojetservice.repository.CustomerCategorieRepository;
import org.ms.clientprojetservice.repository.CustomerRepository;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class ClientprojetServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(ClientprojetServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository,
							CustomerCategorieRepository customerCategorieRepository,
							RepositoryRestConfiguration repositoryRestConfiguration)
	{
		return args ->
		{
//Insérer trois clients de test dans la BD
			CustomerCategorie categorie1 = customerCategorieRepository.save(new CustomerCategorie(null, "particulier"));
			customerCategorieRepository.save(new CustomerCategorie(null,"entreprise"));

			//Afficher les clients existants dans la BD
			for (CustomerCategorie c : customerCategorieRepository.findAll())
			{
				System.out.println(c.toString());
			}
			customerRepository.save(new Customer(null,"ali","route ain km 7",new Date(),new Date(),"2233445566","Sfax","ali@ali",categorie1));
			for (Customer c : customerRepository.findAll())
			{
				System.out.println(c.toString());
			}
		};
	}

}
