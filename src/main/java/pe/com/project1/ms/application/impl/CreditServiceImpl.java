package pe.com.project1.ms.application.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.com.project1.ms.application.CreditService;
import pe.com.project1.ms.application.external.service.CustomerService;
import pe.com.project1.ms.application.repository.CreditRepository;
import pe.com.project1.ms.domain.credit.Credit;
import pe.com.project1.ms.domain.credit.CreditType;
import pe.com.project1.ms.domain.exception.ConflictException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreditServiceImpl implements CreditService {

	private final CreditRepository creditRepository;
	private final CustomerService customerService;

	@Override
	public Flux<Credit> findAllByCustomerId(String customerId) {
		return creditRepository.findAllByCustomerId(customerId);
	}

	@Override
	public Mono<Credit> save(Credit credit) {
		return this.assertThatCustomerCanHaveACredit(credit)
				.then(creditRepository.save(credit));
	}

	private Mono<Void> assertThatCustomerCanHaveACredit(Credit credit) {
		final String customerId = credit.getCustomerId();
		return customerService.getCustomerById(customerId)
				.then(assertThatCustomerDontHaveAnCredit(customerId, credit));
	}

	private Mono<Void> assertThatCustomerDontHaveAnCredit(String customerId, Credit credit) {
		return this.findAllByCustomerId(customerId)
				.filter(existingCredit -> checkPersonalCreditConstraint(credit, existingCredit))
				.count()
				.flatMap(existingCredit -> checkNumberOfCredits(existingCredit, credit.getCreditType()));

	}
	
	private Mono<Void> checkNumberOfCredits(Long existingCredit, CreditType creditType) {
		if(existingCredit > 0) {
			return Mono.error(new ConflictException("El cliente ya tiene un credito del tipo: " + creditType));
		}
		return Mono.empty();
	}
	
	private boolean checkPersonalCreditConstraint(Credit credit, Credit existingCredit) {
		return existingCredit.getCreditType().equals(CreditType.PERSONAL) && credit.getCreditType().equals(CreditType.PERSONAL);
	}

}
