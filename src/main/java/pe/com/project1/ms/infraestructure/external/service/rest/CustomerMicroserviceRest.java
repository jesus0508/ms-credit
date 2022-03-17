package pe.com.project1.ms.infraestructure.external.service.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import pe.com.project1.ms.application.external.service.CustomerService;
import pe.com.project1.ms.domain.customer.Customer;
import pe.com.project1.ms.domain.exception.NotFoundException;
import reactor.core.publisher.Mono;

@Service
public class CustomerMicroserviceRest implements CustomerService {
	
	@Autowired
	private WebClient customerWebClient;
	
	@Override
	public Mono<Customer> getCustomerById(String id) {
		return customerWebClient
				.get()
				.uri(id)
				.retrieve()
				.bodyToMono(Customer.class)
				.switchIfEmpty(Mono.error(new NotFoundException("No se encontró un cliente con id: " + id)));
	}
}
