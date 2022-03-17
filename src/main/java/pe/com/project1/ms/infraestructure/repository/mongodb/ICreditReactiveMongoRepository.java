package pe.com.project1.ms.infraestructure.repository.mongodb;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import pe.com.project1.ms.infraestructure.model.dao.CreditDao;
import reactor.core.publisher.Flux;

public interface ICreditReactiveMongoRepository extends ReactiveMongoRepository<CreditDao, String> {

	Flux<CreditDao> findByCustomerId(String customerId);

}
