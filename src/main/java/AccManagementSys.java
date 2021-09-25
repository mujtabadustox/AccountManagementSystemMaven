import java.text.SimpleDateFormat;  
import java.util.Date; 
public class AccManagementSys {
	
	int count=1;
	double[] zakat=new double[50];
	int[] deduct=new int[50];
	

	Account[] AccountObjects = new Account[50];
	Customer[] CustomerObjects = new Customer[50];
	
	boolean CreateAccount(String name,String address,int phoneNo,String Acctype,int balance) {
		
		boolean found=false;
		
		for (int i=0 ; i<count ; i++) {
			
			if (AccountObjects[i]!=null) {
				
					if (AccountObjects[i].accountNumber==count && CustomerObjects[i].name.equals(name) && AccountObjects[i].accountType.equals(Acctype)) {
				found=true;
					}
			}
			
		}
		
		if(found==true) {
			System.out.println("Account Already Exists");
		}else {
			
			//System.out.println("Count:"+count);
			SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");  
		    Date date = new Date();  
		    AccountObjects[count]=new Account(Acctype,date,count,balance);
			CustomerObjects[count]=new Customer(name,address,phoneNo);
		
			
				if (AccountObjects[count].accountType.equals("saving") || AccountObjects[count].accountType.equals("Saving") ) {
					if (AccountObjects[count].balance>=20000) {
						double aa=AccountObjects[count].balance*2.5;
						zakat[count]=aa/100;
						AccountObjects[count].balance-=zakat[count];
					}else {
						zakat[count]=0;
						AccountObjects[count].balance-=zakat[count];
					}
					
				}
					
					count++;
			
			return true;
			
		}
		
		return false;
	}
	
	void display() {
		
		for (int i=0 ;i<count; i++) {
			
			if (AccountObjects[i]!=null) {
				CustomerObjects[i].display();
				AccountObjects[i].DisplayAccountInfo();
				System.out.println("\n");
			}
			
		}
		
	}
	
	void printStatement(int AccNo,String CTName) {
		
		for (int i=0 ;i<count; i++) {
			if (AccountObjects[i]!=null) {
				if (AccountObjects[i].accountNumber==AccNo && (CTName.equals(CustomerObjects[i].name))) {
					System.out.println("Print Statement");
					CustomerObjects[i].display();
					AccountObjects[i].DisplayAccountInfo();
					System.out.println("\n");
				}
			}
			
		}
		
	}
	
	boolean login(int AccNo,String CTName) {
		
		for (int i=0 ;i<count; i++) {
			if (AccountObjects[i]!=null) {
				if (AccountObjects[i].accountNumber==AccNo && (CTName.equals(CustomerObjects[i].name))) {
					return true;
				}
			}
			
		}
		
		
		return false;
	}
	
	boolean deleteUser(int AccNo,String CTName) {
		
		for (int i=0 ;i<count; i++) {
			if (AccountObjects[i]!=null) {
				if (AccountObjects[i].accountNumber==AccNo && (CTName.equals(CustomerObjects[i].name))) {
					AccountObjects[i]=null;
					return true;
				}
			}
			
		}
		
		
		return false;
	}
	
	void checkBalance(int AccNo,String CTName) {
		

		for (int i=0 ;i<count; i++) {
			if (AccountObjects[i]!=null) {
				if (AccountObjects[i].accountNumber==AccNo && (CTName.equals(CustomerObjects[i].name))) {
					System.out.println("Fee: 1Rs");
					AccountObjects[i].balance-=1;
					deduct[i]++;
					System.out.println("Account Balance:"+AccountObjects[i].balance);
					System.out.println("Note For Saving Accounts:The Balance is After Cutting of Zakat");
				}
			}
			
		}
		
	}
	
	void deposit(int AccNo,String CTName,int amount) {
		for (int i=0 ;i<count; i++) {
			if (AccountObjects[i]!=null) {
				if (AccountObjects[i].accountNumber==AccNo && (CTName.equals(CustomerObjects[i].name))) {
					AccountObjects[i].balance+=amount;
					System.out.println("Account Balance After Deposit:"+AccountObjects[i].balance);
				}
			}
			
		}
		
	}
	
	void withdraw(int AccNo,String CTName,int amount) {
		for (int i=0 ;i<count; i++) {
			if (AccountObjects[i]!=null) {
				if (AccountObjects[i].accountNumber==AccNo && (CTName.equals(CustomerObjects[i].name))) {
					AccountObjects[i].balance-=amount;
					System.out.println("Account Balance After Withdrawal:"+AccountObjects[i].balance);
				}
			}
			
		}
		
	}
	
	void calculateZakat(int AccNo,String CTName) {
		
		for (int i=0 ;i<count; i++) {
			if (AccountObjects[i]!=null) {
				if (AccountObjects[i].accountNumber==AccNo && (CTName.equals(CustomerObjects[i].name))) {
					if (AccountObjects[i].accountType.equals("saving") || AccountObjects[i].accountType.equals("Saving")) {
						System.out.println("Account Type: "+AccountObjects[i].accountType);
						System.out.println("Zakat: "+zakat[i]);
					}else {
						System.out.println("Your Account Type is Not Saving");
						System.out.println("Zakat: "+zakat[i]);
					}
				}
			}
			
		}
	}
	
	void displayAllDeductions(int AccNo,String CTName) {
		
		double total=0;
		
		
		for (int i=0 ;i<count; i++) {
			if (AccountObjects[i]!=null) {
				if (AccountObjects[i].accountNumber==AccNo && (CTName.equals(CustomerObjects[i].name))) {
					if (AccountObjects[i].accountType.equals("saving") || AccountObjects[i].accountType.equals("Saving")) {
						System.out.println("Fee: "+deduct[i]);
						total=total+deduct[i];
						System.out.println("Zakat: "+zakat[i]);
						total+=zakat[i];
					}else {
						System.out.println("Fee: "+deduct[i]);
						total=total+deduct[i];
						System.out.println("Zakat: "+zakat[i]);
						total+=zakat[i];
					}
				}
			}
			
		}
		
		System.out.println("Total Deductions (Including Zakat and Fee) Are: "+total);
		
	}
}
