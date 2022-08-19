package banksystem;

public abstract class Client extends Logger {

	private int id;
	private String name;
	private float balance;
	private Account[] accounts ;
	final protected float  comissionRate ;
	final protected float  interestRate ;
	Logger logger;
	
	public Client(float comissionrate , float interestrate) {
		this.comissionRate = comissionrate ; 
		this.interestRate = interestrate ;
		
	}

	public Client(int id, String name, float balance) {

		this.id = id;
		this.name = name;
		this.balance = balance;
		accounts = new Account[5];
		this.comissionRate = 0 ; 
		this.interestRate = 0 ; 
		logger = new Logger();
	}

	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public Account[] getAccounts() {
		return accounts;
	}
	
	public void addAccount(Account account) {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] == null )
				accounts[i] = account ; 
			else if (accounts[i].getId() == account.getId()) {
				System.out.println("You already have an account with this ID, please choose a new ID ! ");
				break ; 
			}
		}
		Log l = new Log(0,getId(),"Account " + account.getId() + "update - opened !" ,balance);
		Logger.log(l);
	}
	
	public Account getAccount(int id) {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].getId() == id) 
				return accounts[i];
		}
		return null ; 
	}
	
	public void removeAccount(int id) {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].getId() == id) {
				this.balance = accounts[i].getBalance() + this.balance;
				Log l = new Log(0,getId(),"Account " + accounts[i].getId() + "update - removed !" ,balance);
				Logger.log(l);
				accounts[i] = null;
			}
		}
		
	}
	
	public void removeAccount(Account account) {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].equals(account)) {
				this.balance = accounts[i].getBalance() + this.balance;
				Log l = new Log(0,getId(),"Account " + accounts[i].getId() + "update - removed !" ,balance);
				Logger.log(l);
				accounts[i] = null;
			}
		}
		
	}
	
	public void deposit(float amount) {
		this.balance = amount - (this.comissionRate * amount) ; 
	}
	
	public void withdraw(float amount) {
		this.balance = amount + (this.comissionRate * amount) ;
		Bank.updateTotalCommission(this.balance);
	}
	
	public void autoUpdateAccounts() {
		Log l = new Log(0,getId(),"Accounts automatically updated !" ,balance);
		Logger.log(l);
	}
	
	public boolean equals(Client c) {
		if(this.id == c.getId())
			return true ; 
		return false ;
	}
	
	public float getFortune() {
		float total = this.balance ; 
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null)
				total = total + accounts[i].getBalance(); 
		}
		return total ; 
	}
}
