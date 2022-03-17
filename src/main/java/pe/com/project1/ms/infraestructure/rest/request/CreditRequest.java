package pe.com.project1.ms.infraestructure.rest.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.project1.ms.domain.credit.Credit;
import pe.com.project1.ms.domain.credit.CreditType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditRequest {
	private BigDecimal principal;
	private String customerId;
	private CreditType creditType;

	public Credit toCredit() {
		Credit credit = new Credit();
		credit.setPrincipal(principal);
		credit.setCurrentBalance(principal);
		credit.setCustomerId(customerId);
		credit.setRegistrationDate(LocalDateTime.now());
		credit.setCreditType(creditType);
		return credit;
	}

}
