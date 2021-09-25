import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.Before;
public class AccountManagemetSystemMavenTestNegative {

	AccManagementSys AMS;
	
	@Before
	public void initialize() {	
		AMS=new AccManagementSys();
	}	
	
	@Category(AccountManagemetSystemMavenTestNegative.class)
//Checking of Unique Id(Negative)
		@Test
		public void testMultipleIds() {
			AMS.CreateAccount("Mujtaba Ali",75,"Islamabad" , 125, "Saving", 70000);
			boolean check=AMS.CreateAccount("Hassan Ali",75,"Islamabad" , 127, "Saving", 75000);
			assertFalse(check);
		}
//Checking of Same Account Types(Negative)-1
		@Test
		public void testSameAccounts() {
			AMS.CreateAccount("Mujtaba Ali",75,"Islamabad" , 125, "Checking", 70000);
			boolean check=AMS.CreateAccount("Mujtaba Ali",81,"Islamabad" , 125, "Checking", 75000);
			assertFalse(check);
		}
//Checking of Same Account Types(Negative)-2
		@Test
		public void testSameAccounts1() {
			AMS.CreateAccount("Mujtaba Ali",75,"Islamabad" , 125, "Saving", 70000);
			boolean check=AMS.CreateAccount("Mujtaba Ali",81,"Islamabad" , 125, "Saving", 75000);
			assertFalse(check);
		}
//Logging into an account(Negative)-1
		@Test
		public void testLogin1() {
			AMS.CreateAccount("Mujtaba Ali",75,"Islamabad" , 125, "Checking", 70000);
			boolean check=AMS.login(77, "Mujtaba Ali");
			assertFalse(check);
		}
//Logging into an account(Negative)-2
		@Test
		public void testLogin2() {
			AMS.CreateAccount("Mujtaba Ali",75,"Islamabad" , 125, "Checking", 70000);
			boolean check=AMS.login(75, "Mujtaba Dustox");
			assertFalse(check);
		}
//Deleting an account(Negative)
		@Test
		public void testDelete2() {
			AMS.CreateAccount("Mujtaba Ali",75,"Islamabad" , 125, "Checking", 70000);
			boolean check=AMS.deleteUser(76, "Mujtaba Ali");
			assertFalse(check);
		}
//Withdraw Saving Account Negative
				@Test
				public void testWithdraw1() {
					AMS.CreateAccount("Mujtaba Ali",75,"Islamabad" , 125, "Saving", 70000);
					boolean check=AMS.withdraw(75, "Mujtaba Ali", 75000);
					assertFalse(check);
				}
//Withdraw Checking Account Negative
				@Test
				public void testWithdraw3() {
					AMS.CreateAccount("Mujtaba Ali",75,"Islamabad" , 125, "Checking", 70000);
					boolean check=AMS.withdraw(75, "Mujtaba Ali", 95000);
					assertFalse(check);
				}
//Calculate Zakat Saving Account with less than 20k balance (Negative)
				@Test
				public void testZakat1() {
					AMS.CreateAccount("Mujtaba Ali",75,"Islamabad" , 125, "Saving", 19000);
					double check=AMS.calculateZakat(75, "Mujtaba Ali");
					assertEquals(0,check,0.01);
				}
//Calculate Zakat Checking Account (Negative) [No Zakat For Checking Accounts]
				@Test
				public void testZakat2() {
					AMS.CreateAccount("Mujtaba Ali",75,"Islamabad" , 125, "Checking", 70000);
					double check=AMS.calculateZakat(75, "Mujtaba Ali");				
					assertEquals(0,check,0.01);
				}
				
				@After
				public void terminateTest() {
					System.out.println("Negative Case Tested");
				}
}
