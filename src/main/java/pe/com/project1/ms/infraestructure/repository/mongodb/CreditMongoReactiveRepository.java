package pe.com.project1.ms.infraestructure.repository.mongodb;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import pe.com.project1.ms.application.model.CreditRepository;
import pe.com.project1.ms.domain.Credit;
import pe.com.project1.ms.infraestructure.model.dao.CreditDao;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class CreditMongoReactiveRepository implements CreditRepository {

	private final ICreditReactiveMongoRepository creditReactiveMongoRepository;
	
	@Override
	public Flux<Credit> findAllByCustomerId() {
		return creditReactiveMongoRepository.findByCustomerId().map(this::mapCreditDaoToCredit);
	}

	@Override
	public Mono<Credit> save(Credit credit) {
		return null;
	}

	private Credit mapCreditDaoToCredit(CreditDao creditDao) {
		Credit credit = new Credit();
		credit.setId(creditDao.getId());
		credit.setPrincipal(creditDao.getPrincipal());
		credit.setCurrentBalance(creditDao.getCurrentBalance());
		credit.setCustomerId(creditDao.getCustomerId());
		credit.setRegistrationDate(creditDao.getRegistrationDate());
		credit.setCreditType(creditDao.getCreditType());
		return credit;
	}
	
}
