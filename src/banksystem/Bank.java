package banksystem;

public class Bank {

	Client clients[];
	Logger logService;
	int accountUpdater = 1;
	private static float totalCommision;
	float balance;

	private static Bank bank = new Bank();

	private Bank() {
		clients = new Client[100];
	}

	public static Bank getBankInstance() {
		return bank;
	}

	public float getBalance() {
		float total = 0;
		for (int i = 0; i < clients.length; i++) {
			total = total + clients[i].getFortune();
		}
		balance = total;
		return total;
	}

	public void setBalance(float balance) {
		balance = balance + totalCommision;
	}

	// Log operation
	public void addClient(Client client) {
		for (int i = 0; i < clients.length; i++) {
			if (clients[i] == null)
				clients[i] = client;
		}
		Log l = new Log(0, client.getId(), "Client " + client.getName() + "has been added !", client.getBalance());
		Logger.log(l);
	}

	// Log operation
	public void removeClient(int id) {
		for (int i = 0; i < clients.length; i++) {
			if (clients[i].getId() == id) {
				Log l = new Log(0, clients[i].getId(), "Client " + clients[i].getName() + "has been removed !",
						clients[i].getBalance());
				Logger.log(l);
				clients[i] = null;
			}
		}

	}

	public void removeClient(Client client) {
		for (int i = 0; i < clients.length; i++) {
			if (clients.equals(client)) {
				Log l = new Log(0, clients[i].getId(), "Client " + clients[i].getName() + "has been removed !",
						clients[i].getBalance());
				Logger.log(l);
				clients[i] = null;
			}
		}
	}

	public Client[] getClients() {
		return clients;
	}

	public void viewLogs() {

	}

	public void startAccountUpdater() {

	}

	public static void updateTotalCommission(float totalcomminsion) {
		totalCommision = totalcomminsion;
	}

	public void printClientList() {
		for (int i = 0; i < clients.length; i++) {
			clients[i].toString();
		}
	}
}
