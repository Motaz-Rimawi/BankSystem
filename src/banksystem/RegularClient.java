package banksystem;

public class RegularClient extends Client {
	final float comissionRate = (float)0.03 ; 
	final float interestRate = (float)0.001 ; 

	public RegularClient() {
		super((float)0.03,(float)0.001);
	}
	
	@Override
	public String toString() {
		return "RegularClient" + super.getId();
	}
}
