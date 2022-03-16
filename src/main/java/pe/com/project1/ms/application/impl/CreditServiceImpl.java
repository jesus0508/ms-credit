package pe.com.project1.ms.application.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.com.project1.ms.application.CreditService;
import pe.com.project1.ms.application.model.CreditRepository;
import pe.com.project1.ms.domain.Credit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreditServiceImpl implements CreditService {

	private final CreditRepository creditRepository;

	@Override
	public Flux<Credit> findAllByCustomerId() {
		return creditRepository.findAllByCustomerId();
	}

	@Override
	public Mono<Credit> save(Credit credit) {
		return creditRepository.save(credit);
	}

}
