import java.text.SimpleDateFormat;  
import java.util.Date; 
public class AccManagementSys {
	
	int count=1;
	double[] zakat=new double[50];
	int[] deduct=new int[50];
	

	Account[] AccountObjects = new Account[50];
	Customer[] CustomerObjects = new Customer[50];
	
	boolean CreateAccount(String name,int id,String address,int phoneNo,String Acctype,int balance) {
		
		boolean found=false;
		
		for (int i=0 ; i<count ; i++) {
			if (AccountObjects[i]!=null) {
				
				if (AccountObjects[i].accountNumber==id ) {
					
					System.out.println("Id is in Use");
					return false;
				}
				}
		}
		
		for (int i=0 ; i<count ; i++) {
			
			if (AccountObjects[i]!=null) {
				
					if (CustomerObjects[i].phoneNo==phoneNo && CustomerObjects[i].name.equals(name) && AccountObjects[i].accountType.equals(Acctype)) {
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
		    AccountObjects[count]=new Account(Acctype,date,id,balance);
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
	
	int checkBalance(int AccNo,String CTName) {
		

		for (int i=0 ;i<count; i++) {
			if (AccountObjects[i]!=null) {
				if (AccountObjects[i].accountNumber==AccNo && (CTName.equals(CustomerObjects[i].name))) {
					System.out.println("Fee: 1Rs");
					AccountObjects[i].balance-=1;
					deduct[i]++;
					System.out.println("Account Balance:"+AccountObjects[i].balance);
					System.out.println("Note For Saving Accounts:The Balance is After Cutting of Zakat");
					return AccountObjects[i].balance;
				}
			}
			
		}
		
		return -1;
		
	}
	
	int deposit(int AccNo,String CTName,int amount) {
		for (int i=0 ;i<count; i++) {
			if (AccountObjects[i]!=null) {
				if (AccountObjects[i].accountNumber==AccNo && (CTName.equals(CustomerObjects[i].name))) {
					AccountObjects[i].balance+=amount;
					System.out.println("Account Balance After Deposit:"+AccountObjects[i].balance);
					return AccountObjects[i].balance;
				}
			}
			
		}
		
		return -1;
	}
	
	boolean withdraw(int AccNo,String CTName,int amount) {
		for (int i=0 ;i<count; i++) {
			if (AccountObjects[i]!=null) {
				if (AccountObjects[i].accountNumber==AccNo && (CTName.equals(CustomerObjects[i].name))) {
					if (AccountObjects[i].accountType.equals("Saving") || AccountObjects[i].accountType.equals("saving")) {
						
						if (amount<AccountObjects[i].balance) {
						AccountObjects[i].balance-=amount;
						System.out.println("Account Balance After Withdrawal:"+AccountObjects[i].balance);
						return true;
						}else {
						return false;
						}
						
				}else if(AccountObjects[i].accountType.equals("Checking") || AccountObjects[i].accountType.equals("checking")){
					
					if (amount<((AccountObjects[i].balance)+5000)) {
						AccountObjects[i].balance-=amount;
						System.out.println("Account Balance After Withdrawal:"+AccountObjects[i].balance);
						return true;
						}else {
						return false;
						}
					
				}
						
					
				}
			}
			
		}
		
		return false;
	}
	
	double calculateZakat(int AccNo,String CTName) {
		
		for (int i=0 ;i<count; i++) {
			if (AccountObjects[i]!=null) {
				if (AccountObjects[i].accountNumber==AccNo && (CTName.equals(CustomerObjects[i].name))) {
					if (AccountObjects[i].accountType.equals("saving") || AccountObjects[i].accountType.equals("Saving")) {
						System.out.println("Account Type: "+AccountObjects[i].accountType);
						System.out.println("Zakat: "+zakat[i]);
						return zakat[i];
					}else {
						System.out.println("Your Account Type is Not Saving");
						System.out.println("Zakat: "+zakat[i]);
						return 0;
					}
				}
			}
			
		}
		
		return -1;
	}
	
	double displayAllDeductions(int AccNo,String CTName) {
		
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
		return total;
		
	}
}
