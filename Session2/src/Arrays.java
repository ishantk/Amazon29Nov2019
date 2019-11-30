/*
 
 	USA		Republican		Democratic
 	R1		12445			53565
 	R2		23445			32431
 	R3		45121			12111
 	R4		12432			43222
 	R5		19753			11134
 	.
 	.
 	.
 	.
 	...
 		
 		
 	Which Party won Elections	
 	
 	
 	products : 1 2 3 4 5 6 7 8 9 10
 	For every 3rd customer -> 30% off and for every 5th customer -> 50%off
 	
 
 
 */

public class Arrays {

	public static void main(String[] args) {
		
		int[] repVotes = {12445, 23445, 45121, 12432, 19753};
		int[] demVotes = {53565, 32431, 12111, 43222, 11134};
		
		int demVoteCount = 0;
		int repVoteCount = 0;
		
		for(int i=0;i<repVotes.length;i++) { // 0-4
			//repVoteCount = repVoteCount + repVotes[i];
			//demVoteCount = demVoteCount + demVotes[i];
			
			repVoteCount += repVotes[i];
			demVoteCount += demVotes[i];
		}
		
		System.out.println(">> Republic Party Vote Count: "+repVoteCount);
		System.out.println(">> Democratic Party Vote Count: "+demVoteCount);
		
		if(repVoteCount > demVoteCount) {
			System.out.println(">> Republican Party Won by "+(repVoteCount-demVoteCount)+" votes");
		}else {
			System.out.println(">> Democratic Party Won by "+(demVoteCount-repVoteCount)+" votes");
		}
		
		

	}

}
