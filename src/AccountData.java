import java.util.ArrayList;

public class AccountData {
	
	/**
	 * Attributes of class
	 */
	
	private String name= null;
    private String bankName=null;
    private String accountType=null;
    private double balance=0;
    private long accountNumber=0;
    private String email=null;
	private String address=null;
	private String phone=null;
	private String idProof=null;
	private String dob=null;
	private ArrayList<MiniStatementData> miniStatementList=new ArrayList<>();
		
	/**
	 * This is a constructor used for get user details and save to Json/text file
	 * @param name
	 * @param bankName
	 * @param accountType
	 * @param balance
	 * @param accountNumber
	 * @param email
	 * @param address
	 * @param phone
	 * @param idProof
	 * @param dob
	 */
	public AccountData (String name,String bankName, String accountType, double balance, long accountNumber,
			String email, String address, String phone, String idProof, String dob) {
		this.name=name; 
		this.bankName=bankName;
		this.accountType=accountType;
		this.balance=balance;
		this.accountNumber=accountNumber;
		this.email=email;
		this.address=address;
		this.phone=phone;
		this.idProof=idProof;
		this.dob=dob;
		
	}
	/**
	 * 
	 * Getters and Setters of Account class
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIdProof() {
		return idProof;
	}
	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public ArrayList<MiniStatementData> getMiniStatementList() {
		return miniStatementList;
	}

	public void setMiniStatementList(ArrayList<MiniStatementData> miniStatementList) {
		this.miniStatementList = miniStatementList;
	}
    
}
