import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.Before;
import org.junit.After;

public class AccountManagemetSystemMavenTest {

	
	AccManagementSys AMS;
	
	@Before
	public void initialize() {	
		AMS=new AccManagementSys();
	}
	
	@Category(AccountManagemetSystemMavenTest.class)
//Checking of Successful Account Creation(Positive)
	@Test
	public void testCreateAccount() {
		boolean check=AMS.CreateAccount("Mujtaba",512,"Islamabad" , 125, "Saving", 70000);
		assertTrue(check);		
	}
//Checking of Multiple Account Types(Positive)
	@Test
	public void testMultipleAccounts() {
		AMS.CreateAccount("Mujtaba Ali",75,"Islamabad" , 125, "Saving", 70000);
		boolean check=AMS.CreateAccount("Mujtaba Ali",81,"Islamabad" , 125, "Checking", 75000);
		assertTrue(check);
	}
//Logging into an account(Positive)
	@Test
	public void testLogin() {
		AMS.CreateAccount("Mujtaba Ali",75,"Islamabad" , 125, "Checking", 70000);
		boolean check=AMS.login(75, "Mujtaba Ali");
		assertTrue(check);
	}
//Deleting an account(Positive)
	@Test
	public void testDelete() {
		AMS.CreateAccount("Mujtaba Ali",75,"Islamabad" , 125, "Checking", 70000);
		boolean check=AMS.deleteUser(75, "Mujtaba Ali");
		assertTrue(check);
	}
//Deleting an account(Positive)
	@Test
	public void testDelete1() {
		AMS.CreateAccount("Mujtaba Ali",75,"Islamabad" , 125, "Checking", 70000);
		AMS.deleteUser(75, "Mujtaba Ali");
		boolean check=AMS.login(75, "Mujtaba Ali");
		assertFalse(check);
	}
//Check Balance Checking Account
	@Test
	public void testCheckBalance() {
		AMS.CreateAccount("Mujtaba Ali",75,"Islamabad" , 125, "Checking", 70000);
		int check=AMS.checkBalance(75, "Mujtaba Ali");
		assertEquals(69999,check);//Fee rs:1
	}
//Check Balance Saving Account
		@Test
		public void testCheckBalance1() {
			AMS.CreateAccount("Mujtaba Ali",75,"Islamabad" , 125, "Saving", 70000);
			int check=AMS.checkBalance(75, "Mujtaba Ali");
			assertEquals(68249,check);//Fee rs:1 and Zakat rs:1750
		}
//Deposit Checking Account
		@Test
		public void testDeposit() {
			AMS.CreateAccount("Mujtaba Ali",75,"Islamabad" , 125, "Checking", 70000);
			AMS.checkBalance(75, "Mujtaba Ali");
			int check=AMS.deposit(75, "Mujtaba Ali", 25000);
			assertEquals(94999,check);//Fee rs:1 
		}
//Deposit Saving Account
		@Test
		public void testDeposit1() {
			AMS.CreateAccount("Mujtaba Ali",75,"Islamabad" , 125, "Saving", 70000);
			AMS.checkBalance(75, "Mujtaba Ali");
			int check=AMS.deposit(75, "Mujtaba Ali", 25000);
			assertEquals(93249,check);//Fee rs:1 zakat rs:1750
		}
//Withdraw Saving Account Positive
		@Test
		public void testWithdraw() {
			AMS.CreateAccount("Mujtaba Ali",75,"Islamabad" , 125, "Saving", 70000);
			boolean check=AMS.withdraw(75, "Mujtaba Ali", 65000);
			assertTrue(check);
		}
//Withdraw Checking Account Positive
		@Test
		public void testWithdraw2() {
			AMS.CreateAccount("Mujtaba Ali",75,"Islamabad" , 125, "Checking", 70000);
			boolean check=AMS.withdraw(75, "Mujtaba Ali", 73000);
			assertTrue(check);
		}
//Calculate Zakat Saving Account with more than 20k balane (Positive)
		@Test
		public void testZakat() {
			AMS.CreateAccount("Mujtaba Ali",75,"Islamabad" , 125, "Saving", 70000);
			double check=AMS.calculateZakat(75, "Mujtaba Ali");
			assertEquals(1750,check,0.01);
		}		
//Calculate Total Deductions Checking Account (No Zakat)	
		@Test
		public void testTotalDeduction() {
			AMS.CreateAccount("Mujtaba Ali",75,"Islamabad" , 125, "Checking", 70000);
			AMS.checkBalance(75, "Mujtaba Ali");//Fee Rs:1
			AMS.checkBalance(75, "Mujtaba Ali");//Fee Rs:1
			AMS.checkBalance(75, "Mujtaba Ali");//Fee Rs:1
			double check=AMS.displayAllDeductions(75, "Mujtaba Ali");
			assertEquals(3,check,0.01);//Fee Rs:3
		}
//Calculate Total Deductions		
		@Test
		public void testTotalDeduction1() {
			AMS.CreateAccount("Mujtaba Ali",75,"Islamabad" , 125, "Saving", 70000);
			AMS.checkBalance(75, "Mujtaba Ali");//Fee Rs:1
			AMS.checkBalance(75, "Mujtaba Ali");//Fee Rs:1
			AMS.checkBalance(75, "Mujtaba Ali");//Fee Rs:1
			double check=AMS.displayAllDeductions(75, "Mujtaba Ali");
			assertEquals(1753,check,0.01);//Fee Rs:3 + Zakat:1750 Rs
		}	
	
	
	@After
	public void terminateTest() {
		System.out.println("Positive Case Tested");
	}
	

}
