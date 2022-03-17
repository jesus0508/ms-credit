package pe.com.project1.ms.domain.credit;

public abstract class CreditDecorator implements ICredit {

	protected ICredit creditDecorate;
	
	public CreditDecorator(ICredit creditDecorate) {
		this.creditDecorate = creditDecorate;
	}
	
	@Override
	public void setRestriction(Credit credit) {
		this.creditDecorate.setRestriction(credit);
	}

}
