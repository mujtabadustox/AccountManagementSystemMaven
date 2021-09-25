 
import java.util.Scanner; 


public class AMSmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean menu=true;
		int option;
		Scanner S=new Scanner(System.in);
		AccManagementSys AMS=new AccManagementSys();

		while(menu) {
			
			System.out.println("Enter An Option");
			System.out.println("Enter 1 to Create a New Account");
			System.out.println("Enter 2 to Log In into an Existing Account");
			System.out.println("Enter 3 to Delete an Existing Account");
			System.out.println("Enter 5 to view the Info of all the Existing Accounts(If u dont know Acc Number)");
			System.out.println("Enter 6 to Exit");
			option=S.nextInt(); 
			S.nextLine();
			switch(option) {
			case 1:
				System.out.println("Account Creation");
				
				System.out.println("Enter Your Name");
				String Cname="";
				Cname+=S.nextLine();
				System.out.println("Enter Your PhoneNo");
				int ph;
				ph=Integer.parseInt(S.nextLine());
				System.out.println("Enter Your Address");
				String ad="";
				ad+=S.nextLine();
				System.out.println("Enter Your Account Type (saving or checking)");
				String at="";
				at+=S.next();
				System.out.println("Put Some Balance");
				int bal=S.nextInt();
				
				
				
				boolean check=AMS.CreateAccount(Cname,ad,ph,at,bal);
				
				if(check==true) {
					System.out.println("Account Created Successfully!");
				}else {
					System.out.println("Account Creation Failed!");
				}
				
				break;
			
			case 2:
				System.out.println("Login Screen");
				System.out.println("Enter Your Account Number");
				int AccNo=Integer.parseInt(S.nextLine());
				System.out.println("Enter Your Name");
				String CustName="";
				CustName+=S.nextLine();
				
				boolean y=AMS.login(AccNo,CustName);
				
				boolean x=y;
				
				if (y==true) {
					System.out.println("You Are Logged In");
					int choice;
						while(x) {
							System.out.println("Welcome! "+CustName);
							System.out.println("Enter An Option");
							System.out.println("Enter 1 to Deposit");
							System.out.println("Enter 2 to Withdraw");
							System.out.println("Enter 3 to Check Balance");
							System.out.println("Enter 4 to Calculate Zakat");
							System.out.println("Enter 5 to Check all the Deductions");
							System.out.println("Enter 6 for Print Statement");
							System.out.println("Enter 7 to Log Out");
							choice=S.nextInt(); 
							S.nextLine();
							switch(choice) {
							case 1:
								System.out.println("Enter Amount to Deposit");
								int dbal=S.nextInt();
								AMS.deposit(AccNo,CustName,dbal);
								break;
							case 2:
								System.out.println("Enter Amount to Withdraw");
								int wbal=S.nextInt();
								AMS.withdraw(AccNo,CustName,wbal);
								break;
							case 3:
								AMS.checkBalance(AccNo,CustName);
								break;
							case 4:
								AMS.calculateZakat(AccNo,CustName);
								break;
							case 5:
								AMS.displayAllDeductions(AccNo,CustName);
								break;
							case 6:
								AMS.printStatement(AccNo,CustName);
								break;
							case 7:
								x=false;
								System.out.println("Going Back to Menu");
								break;
							}
							
							
						}
				}else {
					System.out.println("Account Doesnt Exist or Incorrect Information");
				}
				
				
				break;
			case 3:
				System.out.println("Deletion Screen");
				System.out.println("Enter Account Number to be Deleted");
				int AccNo1=Integer.parseInt(S.nextLine());
				System.out.println("Enter the User's Name");
				String CustName1="";
				CustName1+=S.nextLine();
				
				boolean z=AMS.deleteUser(AccNo1,CustName1);
				
				if (z==true) {
					System.out.println("Account Deleted Successfully!");
				}else {
					System.out.println("Operation Failed!");
				}
				break;
			case 5:
				AMS.display();
				break;
			case 6:
				System.out.println("Terminated");
				S.close();
				menu=false;
				break;
			default:
				System.out.println("Input Valid Choice");
			}
			
		}
	}

}
