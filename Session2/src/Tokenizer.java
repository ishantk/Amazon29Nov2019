import java.util.StringTokenizer;

public class Tokenizer {

	public static void main(String[] args) {
		
		String quote = "Work Hard and get luckier";
		StringTokenizer tokenizer = new StringTokenizer(quote);
		
		/*
		System.out.println(">> "+tokenizer.nextToken());
		System.out.println(">> "+tokenizer.nextToken());
		System.out.println(">> "+tokenizer.nextToken());
		System.out.println(">> "+tokenizer.nextToken());
		System.out.println(">> "+tokenizer.nextToken());
		System.out.println(">> "+tokenizer.nextToken());*/
		
		while(tokenizer.hasMoreElements()) {
			System.out.println(tokenizer.nextToken());
		}

	}

}
