package pe.com.project1.ms.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Credit {
	private String id;
	private BigDecimal principal;
	private BigDecimal currentBalance;
	private String customerId;
	private LocalDateTime registrationDate;
	private CreditType creditType;
}
