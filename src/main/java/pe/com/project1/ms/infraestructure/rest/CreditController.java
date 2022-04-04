package pe.com.project1.ms.infraestructure.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pe.com.project1.ms.application.CreditService;
import pe.com.project1.ms.domain.credit.Credit;
import pe.com.project1.ms.infraestructure.rest.request.CreditRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/credits")
@RequiredArgsConstructor
public class CreditController {

	private final CreditService creditService;
	
	@GetMapping("customer-id/{customerId}")
	@ResponseStatus(HttpStatus.OK)
	public Flux<Credit> getAllByCustomerId(@PathVariable String customerId) {
		return creditService.findAllByCustomerId(customerId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Credit> postCredit(@RequestBody CreditRequest creditRequest) {
		return creditService.save(creditRequest.toCredit());
	}
}
