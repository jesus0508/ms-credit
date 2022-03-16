package pe.com.project1.ms.infraestructure.model.dao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import pe.com.project1.ms.domain.CreditType;

@Data
@Document("creditDao")
public class CreditDao {
	@Id
	private String id;
	private BigDecimal principal;
	private BigDecimal currentBalance;
	private String customerId;
	private LocalDateTime registrationDate;
	private CreditType creditType;
}