package org.ms.produitprojetservice;

import org.ms.produitprojetservice.entities.StockItem;
import org.ms.produitprojetservice.entities.StockItemCategory;
import org.ms.produitprojetservice.repository.StockItemCategoryRepository;
import org.ms.produitprojetservice.repository.StockItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ProduitprojetServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProduitprojetServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(StockItemRepository stockItemRepository,
							StockItemCategoryRepository stockItemCategoryRepository,
							RepositoryRestConfiguration repositoryRestConfiguration)
	{
		repositoryRestConfiguration.exposeIdsFor(StockItem.class);
		repositoryRestConfiguration.exposeIdsFor(StockItemCategory.class);
		return args ->
		{

			//Afficher les clients existants dans la BD
			for (StockItemCategory c : stockItemCategoryRepository.findAll())
			{
				System.out.println(c.toString());
			}

			for (StockItem c : stockItemRepository.findAll())
			{
				System.out.println(c.toString());
			}
		};
	}

}
