import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class AccountManagemetSystemMavenTest {

	
	AccManagementSys AMS;
	
	@Before
	public void initialize() {	
		AMS=new AccManagementSys();
	}
	
//Checking of Successful Account Creation(Positive)
	@Test
	public void testCreateAccount() {
		boolean check=AMS.CreateAccount("Mujtaba",512,"Islamabad" , 125, "Saving", 70000);
		assertTrue(check);		
	}
//Checking of Unique Id(Negative)
	@Test
	public void testMultipleIds() {
		AMS.CreateAccount("Mujtaba Ali",75,"Islamabad" , 125, "Saving", 70000);
		boolean check=AMS.CreateAccount("Hassan Ali",75,"Islamabad" , 127, "Saving", 75000);
		assertFalse(check);
	}
//Checking of Multiple Account Types(Positive)
	@Test
	public void testMultipleAccounts() {
		AMS.CreateAccount("Mujtaba Ali",75,"Islamabad" , 125, "Saving", 70000);
		boolean check=AMS.CreateAccount("Mujtaba Ali",81,"Islamabad" , 125, "Checking", 75000);
		assertTrue(check);
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
//Logging into an account(Positive)
	@Test
	public void testLogin() {
		AMS.CreateAccount("Mujtaba Ali",75,"Islamabad" , 125, "Checking", 70000);
		boolean check=AMS.login(75, "Mujtaba Ali");
		assertTrue(check);
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
//Deleting an account(Negative)
	@Test
	public void testDelete2() {
		AMS.CreateAccount("Mujtaba Ali",75,"Islamabad" , 125, "Checking", 70000);
		boolean check=AMS.deleteUser(76, "Mujtaba Ali");
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
//Withdraw Saving Account Negative
		@Test
		public void testWithdraw1() {
			AMS.CreateAccount("Mujtaba Ali",75,"Islamabad" , 125, "Saving", 70000);
			boolean check=AMS.withdraw(75, "Mujtaba Ali", 75000);
			assertFalse(check);
		}
//Withdraw Checking Account Positive
		@Test
		public void testWithdraw2() {
			AMS.CreateAccount("Mujtaba Ali",75,"Islamabad" , 125, "Checking", 70000);
			boolean check=AMS.withdraw(75, "Mujtaba Ali", 73000);
			assertTrue(check);
		}
//Withdraw Checking Account Negative
		@Test
		public void testWithdraw3() {
			AMS.CreateAccount("Mujtaba Ali",75,"Islamabad" , 125, "Checking", 70000);
			boolean check=AMS.withdraw(75, "Mujtaba Ali", 95000);
			assertFalse(check);
		}
//Calculate Zakat Saving Account with more than 20k balane (Positive)
		@Test
		public void testZakat() {
			AMS.CreateAccount("Mujtaba Ali",75,"Islamabad" , 125, "Saving", 70000);
			double check=AMS.calculateZakat(75, "Mujtaba Ali");
			assertEquals(1750,check,0.01);
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
	
	
	
	

}
