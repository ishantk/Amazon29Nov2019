class CA{
	void show() {
		System.out.println(">> This is show in CA");
	}
}

interface Inf{
	void show();
}

/*
class CB implements Inf{
	public void show() {
		System.out.println(">> This is show in CB");
	}
}*/


public class Anonymous {

	public static void main(String[] args) {

		// We have Object of CA which is Referred by cRef
		//CA cRef = new CA();
		//cRef.show();
		
		// We have Object of CA which is Referred by None : ANONYMOUS OBJECT
		new CA().show();

		//Inf iRef = new CB();
		//iRef.show();
		
		// Inf iRef = new Inf(); -> ERROR
		
		// Anonymous Class
		Inf iRef = new Inf() {
			
			public void show() {
				System.out.println(">> This is show form Anonymous Class");
			}
		};
		
		iRef.show();
		

	}

}
