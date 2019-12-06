class Auth{
	
	// Attributes : Property of Object
	// Now Direct Access to Attributes is not Allowed
	private String email;
	private String password;
	
	Auth() {
		email = "NA";
		password = "NA";
	}
	
	void showAuthDetails() {
		System.out.println(">> Email is "+email);
		System.out.println(">> Password is "+password);
	}
	
	void setAuthDetails(String email, String password) {
		
		if(email.contains("@") && email.contains(".")) {
			this.email = email;
		}else {
			System.out.println(">> Invalid Email");
		}
		
		if(password.length()>=6) {
			this.password = password;
		}else {
			System.out.println(">> Invalid Password Length");
		}
	}
	
	// In case Attributes are marked as private, we shall need setter methods to access them
	// In setter we can set up rules to write data in object for security purpose
	void setEmail(String email) {
		if(email.contains("@") && email.contains(".")) {
			this.email = email;
		}else {
			System.out.println(">> Invalid Email");
		}
	}
	
	void setPassword(String password) {
		if(password.length()>=6) {
			this.password = password;
		}else {
			System.out.println(">> Invalid Password Length");
		}
	}
	
	
	// Getter Methods : To read data for private attributes
	String getEmail() {
		return email;
	}
	
	String getPassword() {
		return password;
	}
	
	
	
}


public class Encapsulation {

	public static void main(String[] args) {
		
		Auth aRef1 = new Auth();
		
		// Direct Access to Attribute (Write/Update Operation)
		//aRef1.email = "9090909090";
		//aRef1.password = "password123";
		
		// Direct Access to Attribute (Read Operation)
		//System.out.println(">> Details for "+aRef1.email);
		
		//aRef1.setAuthDetails("9090909090", "123");
		aRef1.setAuthDetails("fionna@example.com", "fionna123");
		
		aRef1.showAuthDetails();
		
		System.out.println(">> Email is: "+aRef1.getEmail());
		System.out.println(">> Password is: "+aRef1.getPassword());
		
	}

}

// Encapsulation : Attributes may be marked as private to achieve security.
