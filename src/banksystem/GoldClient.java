package banksystem;

public class GoldClient extends Client {
	final float comissionRate = (float)0.02 ; 
	final float interestRate = (float)0.003 ; 

	public GoldClient() {
		super((float)0.03,(float)0.001);
	}

	@Override
	public String toString() {
		return "GoldClient" + super.getId();
	}
	
	
}
