
public class MiniStatementData {
	/**
	 * 
	 * @param amount
	 * @param transactionType
	 */
	private double amount=0;
	private String transactionType=null;
	
	
	/**
	 * @param amount
	 * @param transactionType
	 */
	public MiniStatementData(double amount, String transactionType) {
		this.amount=amount;
		this.transactionType=transactionType;
	}

	/**
	 * Getters and Setters of Mini Statement class
	 * 
	 * @return
	 */
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	
}
