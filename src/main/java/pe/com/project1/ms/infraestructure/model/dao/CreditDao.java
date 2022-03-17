package pe.com.project1.ms.infraestructure.model.dao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.project1.ms.domain.credit.Credit;
import pe.com.project1.ms.domain.credit.CreditType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("credits")
public class CreditDao {
	@Id
	private String id;
	private BigDecimal principal;
	private BigDecimal currentBalance;
	private String customerId;
	private LocalDateTime registrationDate;
	private CreditType creditType;
	
	public CreditDao(Credit credit) {
		this.id = credit.getId();
		this.principal = credit.getPrincipal();
		this.currentBalance = credit.getCurrentBalance();
		this.customerId = credit.getCustomerId();
		this.registrationDate = credit.getRegistrationDate();
		this.creditType = credit.getCreditType();
	}
}