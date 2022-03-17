package pe.com.project1.ms.application.repository;

import pe.com.project1.ms.domain.credit.Credit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditRepository {
	Flux<Credit> findAllByCustomerId(String customerId);

	Mono<Credit> save(Credit credit);
}
