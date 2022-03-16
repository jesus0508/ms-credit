package pe.com.project1.ms.application;

import pe.com.project1.ms.domain.Credit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditService {
	Flux<Credit> findAllByCustomerId();

	Mono<Credit> save(Credit credit);

}
