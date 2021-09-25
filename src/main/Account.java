 
import java.util.Date;
//import java.util.*;
public class Account {
		String accountType;
		Date dateCreated;
		int accountNumber;
		int balance;
		
	
		Account(String aT , Date dateC , int aN , int bal){
			this.accountType=aT;
			this.dateCreated=dateC;
			this.accountNumber=aN;
			this.balance=bal;
		}

		void DisplayAccountInfo(){
			System.out.println("Your Account's Type:" + this.accountType);
			System.out.println("Your Account's Creation Date:" + this.dateCreated);
			System.out.println("Your Account's Number:" + this.accountNumber);
			System.out.println("Your Account's Balance:" + this.balance);
			
		}

	
		public void Account1(String acctype, Date date, int count, int balance2) {
			this.accountType=acctype;
			this.dateCreated=date;
			this.accountNumber=count;
			this.balance=balance2;
			
		}
}
