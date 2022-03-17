package pe.com.project1.ms.infraestructure.repository.mongodb;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import pe.com.project1.ms.application.repository.CreditRepository;
import pe.com.project1.ms.domain.credit.Credit;
import pe.com.project1.ms.infraestructure.model.dao.CreditDao;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class CreditMongoReactiveRepository implements CreditRepository {

	private final ICreditReactiveMongoRepository creditReactiveMongoRepository;
	
	@Override
	public Flux<Credit> findAllByCustomerId(String customerId) {
		return creditReactiveMongoRepository
				.findByCustomerId(customerId)
				.map(this::mapCreditDaoToCredit);
	}

	@Override
	public Mono<Credit> save(Credit credit) {
		return creditReactiveMongoRepository
				.save(new CreditDao(credit))
				.map(this::mapCreditDaoToCredit);
	}

	private Credit mapCreditDaoToCredit(CreditDao creditDao) {
		Credit credit = new Credit();
		credit.setId(creditDao.getId());
		credit.setPrincipal(creditDao.getPrincipal());
		credit.setCurrentBalance(creditDao.getCurrentBalance());
		credit.setCustomerId(creditDao.getCustomerId());
		credit.setRegistrationDate(creditDao.getRegistrationDate());
		return credit;
	}
	
}
