package org.ms.clientprojetservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientprojetServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(ClientprojetServiceApplication.class, args);
	}

	/*@Bean
	CommandLineRunner start(CustomerRepository customerRepository,
							CustomerCategoryRepository customerCategoryRepository,
							RepositoryRestConfiguration repositoryRestConfiguration)
	{
		repositoryRestConfiguration.exposeIdsFor(Customer.class);
		repositoryRestConfiguration.exposeIdsFor(CustomerCategory.class);
		return args ->
		{
//Insérer trois clients de test dans la BD
			CustomerCategory categorie1 = customerCategoryRepository.save(new CustomerCategory(null, "particulier"));
			customerCategoryRepository.save(new CustomerCategory(null,"entreprise"));

			//Afficher les clients existants dans la BD
			for (CustomerCategory c : customerCategoryRepository.findAll())
			{
				System.out.println(c.toString());
			}
			customerRepository.save(new Customer(null,"ali","route ain km 7",new Date(),new Date(),"2233445566","Sfax","ali@ali",categorie1));
			for (Customer c : customerRepository.findAll())
			{
				System.out.println(c.toString());
			}
		};
	}*/

}
