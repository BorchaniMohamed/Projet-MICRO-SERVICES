package org.ms.factureprojetservice;

import org.ms.factureprojetservice.entities.Invoice;
import org.ms.factureprojetservice.entities.InvoiceLine;
import org.ms.factureprojetservice.repository.InvoiceLineRepository;
import org.ms.factureprojetservice.repository.InvoiceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
@EnableFeignClients
public class FactureprojetServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(FactureprojetServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(InvoiceRepository	invoiceRepository,
							InvoiceLineRepository invoiceLineRepository,
							RepositoryRestConfiguration repositoryRestConfiguration)
	{
		repositoryRestConfiguration.exposeIdsFor(Invoice.class);
		repositoryRestConfiguration.exposeIdsFor(InvoiceLine.class);
		return args ->
		{


			for (InvoiceLine c : invoiceLineRepository.findAll())
			{
				System.out.println("id-InvoiceLine"+c.getId());
			}

			for (Invoice c : invoiceRepository.findAll())
			{
				System.out.println("id-Invoice"+c.getId());
			}
		};
	}

}
