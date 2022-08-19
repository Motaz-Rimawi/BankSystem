package banksystem;

public class Logger  {
	
		String driverName ;
		
		public Logger () {
			
		}
		public Logger(String driverName) {
			this.driverName = driverName ; 
		}
		
		public static void log(Log l ) {
			l.toString();
		}
		public static Log[] getLogs (){
			return null; 
		}
		
		
}
