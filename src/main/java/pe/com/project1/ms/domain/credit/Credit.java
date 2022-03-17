package pe.com.project1.ms.domain.credit;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Credit {
	private String id;
	private BigDecimal principal;
	private BigDecimal currentBalance;
	private String customerId;
	private LocalDateTime registrationDate;
	private CreditType creditType;
}
