
public class Quiz {

	Quiz(){
		System.out.println(">> This is Quiz Constructor");
	}
	
	{
		System.out.println(">> This is Quiz Block1");
	}
	
	{
		System.out.println(">> This is Quiz Block2");
	}
	
	static{
		System.out.println(">> This is Quiz static Block1");
	}
	
	static{
		System.out.println(">> This is Quiz static Block2");
	}
	
	public static void main(String[] args) {
		
		System.out.println(">> Main Started");
		
		Quiz qRef = new Quiz();
		
		System.out.println(">> Main Finished");

	}

}
