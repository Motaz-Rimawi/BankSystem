package banksystem;

public class Log {
	
		long timestamp ; 
		int id ; 
		String description ; 
		float amount  ;
		
		public Log(long timestamp, int id, String description, float amount) {
			super();
			this.timestamp = timestamp;
			this.id = id;
			this.description = description;
			this.amount = amount;
		}

		@Override
		public String toString() {
			
			return timestamp + ", " + "client-" + id + ", " +  "account update – " + description + ", " + amount ; 
		}


		
}
