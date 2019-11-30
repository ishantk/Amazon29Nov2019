
public class StringMethods {

	public static void main(String[] args) {
		
		// Strings are IMMUTABLE. You Cannot Change them !!
		// Any Manipulation Operation on Strings will create new Strings in memory !!
		String str1 = "This is Awesome";
		String str2 = str1.toUpperCase();
		
		//str1 = str1.toUpperCase(); // Expensive Operation
		
		String str3 = str1.toLowerCase();
		
		System.out.println(">> str1 is: "+str1);
		System.out.println(">> str2 is: "+str2);

		String names = "John, Jennie, Jim, Jack, Joe";
		System.out.println(">> names is: "+names);
		
		char ch = names.charAt(0);
		System.out.println(">> ch is: "+ch);
		
		int length = names.length();
		
		System.out.println(">> Length of names is: "+length);
		
		ch = names.charAt(length-1);
		System.out.println(">> ch is: "+ch);
		
		int idx = names.indexOf('n');
		System.out.println(">> index of n is: "+idx);
		
		idx = names.lastIndexOf('J');
		System.out.println(">> last index of J is: "+idx);
		
		String s1 = names.substring(5);
		System.out.println(">> s1 is: "+s1);
		
		String s2 = names.substring(6, 10); // from 6 to 9 i.e. less than 10
		System.out.println(">> s2 is: "+s2);
		
		String[] strArr = names.split(",");
		for(String name : strArr) {
			System.out.println(name.trim()); // remove white space from leading and trailing part
		}
		
		String quote = "Search the Candle rather than cursing the Darkness";
		String[] words = quote.split(" ");
		System.out.println(">> Total Words: "+words.length);
		
		System.out.println("** word: "+quote.split(" ")[2]);
		
		for(String word : words) {
			System.out.println(">> "+word);
		}
		
		String email = "fionna@example.com";
		String image = "sea.jpg";
		String song = "hello.mp3";
		String fullName = "Mr. Harry Watson";
		
		if(email.contains("@") && email.contains(".com")) {
			System.out.println(">> A Valid Email");
		}else {
			System.out.println(">> Enter a Correct Email");
		}
		
		if(email.endsWith(".com")) {
			
		}
		
		if(image.endsWith(".jpg")) {
			
		}
		
		if(song.endsWith(".mp3")) {
			
		}
		
		if(fullName.startsWith("Mr.")) {
			System.out.println(">> Male");
		}else {
			
		}
		
		char[] chArr = quote.toCharArray(); // Convert String into Array of Characters
		
		int count = 0;
		
		for(char c : chArr) {
			System.out.print(c+" ");
			if(c == 't') {
				count++;
			}
		}
		
		System.out.println();
		
		System.out.println(">> t occurs: "+count+" times");
		
		String ipAddress = "198.121.80.90"; // PS: split takes Regular Expression as Input
		// regex : See in Future
		// . is having a special place in regex and hence it wont work directly
	
		
		String quote1 = quote.replace('t', 'o');
		System.out.println(">> quote1 is: "+quote1);
		
		System.out.println(ipAddress.replace(".", "\n").split(",")[1]);
	}

}
