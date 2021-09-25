
public class Customer {
		String name;
		String address;
		int phoneNo;
		
		Customer(String n, String a, int ph){
			this.name=n;
			this.address=a;
			this.phoneNo=ph;
		}
		
		void display(){
			System.out.println("Name:"+this.name);
			System.out.println("Address:"+this.address);
			System.out.println("phoneNo:"+this.phoneNo);
		}
		
		public void Customer1(String name2, String address2, int phoneNo2) {
			this.name=name2;
			this.address=address2;
			this.phoneNo=phoneNo2;
		}


}
