package banksystem;

public class Account {
		private int id ;
		private float balance;
		


		public Account(int id, float balance) {
			super();
			this.id = id;
			this.balance = balance;
		}

		public int getId() {
			return id;
		}

		public float getBalance() {
			return balance;
		}

		public void setBalance(float balance) {
			this.balance = balance;
			Log l = new Log(0,getId(),"Account balance uppdated !" ,balance);
			Logger.log(l);
		}

		
		public boolean equals(Account a) {
			if(this.id == a.getId())
				return true ; 
			return false ;
		}
		
		

}
