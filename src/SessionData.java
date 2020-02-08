import com.google.gson.Gson;
import java.io.FileOutputStream;
import java.io.FileInputStream;  

/*
 * This is used for reading and writing Bank data in text/json file.
 */
public class SessionData {


	private static SessionData instance; // object of sessionData itself
	public LocalData localData; // object of localData
	Gson gson = new Gson();    	// object of Gson


	/*
	 * This function  return object of sessionData.
	 */
	public static SessionData I() {
		if (instance == null) {
			instance = new SessionData();
		}
		return instance;
	}

	/**
	 * Constructor of class
	 */
	private SessionData() {

	}

	/**
	 * Reading data from Json file and setting in Local data.
	 */
	public void init() {
		String data = readString();

		if (data==null || data.length() <= 1) {
			localData = new LocalData();
			saveLocalData();
		} else if (data.length() > 1) {
			try {
				this.localData = (gson.fromJson(data, LocalData.class)); //converting json data into java form
			} catch (Exception e) {
				localData = new LocalData();
			}
		}
	}

	/**
	 * convert data in Json form and pass to writeString function.
	 */
	public void saveLocalData() {
		String data = gson.toJson(localData, LocalData.class);
		writeString(data);
	}

	/**
	 * 
	 * This function store data in Json Form.
	 * @param data
	 */
	private void writeString(String data) {
		try{
			FileOutputStream fout=new FileOutputStream("F:\\BankSystem\\bankData.txt");
			//FileOutputStream fout=new FileOutputStream("F:\\BankSystem\\bankData.json");
			byte b[]=data.getBytes();//converting string into byte array    
			fout.write(b);    
			fout.close();     
		}catch(Exception e){System.out.println(e);} 
	}
	/**
	 * 
	 * read data from json file
	 * @return
	 */

	private String readString() {
		String data=null;
		StringBuilder str = new StringBuilder();
		try{    
			FileInputStream fin=new FileInputStream("F:\\BankSystem\\bankData.txt");
			int i=0;    
			while((i=fin.read())!=-1){  
				str.append(""+(char)i);    
			}
			data=str.toString();
			fin.close();    
		}catch(Exception e){System.out.println(e);}  
		return data;
	}

	/**
	 * clear all Json data
	 */
	public void clearLocalData() {
		localData = new LocalData();
		saveLocalData();
	}

}
