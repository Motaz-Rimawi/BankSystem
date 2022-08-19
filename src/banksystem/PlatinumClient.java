package banksystem;

public class PlatinumClient extends Client {
	final float comissionRate = (float)0.01 ; 
	final float interestRate = (float)0.005 ; 

	public PlatinumClient() {
		super((float)0.03,(float)0.001);
	}

	@Override
	public String toString() {
		return "PlatinumClient" + super.getId();
	}
}
