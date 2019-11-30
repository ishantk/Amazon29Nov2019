
/*
 
 	n-D Array is collection of n-1D Arrays
 	5-D Arrays will be a Collection of 4-D Arrays
 
 	// Try implementing GrayScale
 	
 	Image is a Collection of Pixels
 	Pixel is RGB value (0 to 255)
 	
 	pixel1 = {120, 222, 100}
 	pixel2 = {120, 222, 100}
 	pixel3 = {120, 222, 100}
 	pixel4 = {120, 222, 100}
 	pixel5 = {120, 222, 100}
 	pixel6 = {120, 222, 100}
 	pixel7 = {120, 222, 100}
 	pixel8 = {120, 222, 100}
 	pixel9 = {120, 222, 100}
 	
 	image =  {
 	
 				{ {120, 222, 100}, {120, 222, 100}, {120, 222, 100} },
 				{ {120, 222, 100}, {120, 222, 100}, {120, 222, 100} },
 				{ {120, 222, 100}, {120, 222, 100}, {120, 222, 100} }
 	
 			 }
 
 */

public class MultiDimensionalArrays {

	public static void main(String[] args) {
		
		// 1-D Arrays
		int[] repVotes = {12445, 23445, 45121, 12432, 19753};
		int[] demVotes = {53565, 32431, 12111, 43222, 11134};
		
		/*
		// 2-D Array : Array od 1-D Arrays
		int[][] votes = {
							// 0	1		2		3		4
							{12445, 23445, 45121, 12432, 19753}, // 0th Array
							// 0	1		2		3		4
							{53565, 32431, 12111, 43222, 11134},  // 1st Array
							
							// 0	1		2	
							{53565, 32431, 12111}				// 2nd Array
							
						};
		
		System.out.println(">> votes is: "+votes+" and length is: "+votes.length);
		System.out.println(">> votes[0] is: "+votes[0]+" and length is: "+votes[0].length);
		System.out.println(">> votes[1] is: "+votes[1]+" and length is: "+votes[1].length);
		
		for(int i=0;i<votes.length;i++) { // i: 0 and i: 1 and 2
			for(int j=0;j<votes[i].length;j++) { // i:0, j:0 to 4 | i:1, j:0 to 4 | i:2, j: 0 to 2
				System.out.print(votes[i][j]+"  ");
			}
			System.out.println();
		}
		
		*/
		
		int[][] votes = {
				// 0	1		2		3		4
				{12445, 23445, 45121, 12432, 19753}, // 0th Array
				// 0	1		2		3		4
				{53565, 32431, 12111, 43222, 11134},  // 1st Array
		};
		
		//int demVoteCount = 0;
		//int repVoteCount = 0;
		
		int[] voteCounts = new int[2];
		
		for(int i=0;i<votes.length;i++) { // i: 0 and i: 1
			for(int j=0;j<votes[i].length;j++) { // i:0, j:0 to 4 | i:1, j:0 to 4 
				
				/*
				if(i==0) {
					demVoteCount += votes[i][j];
				}else {
					repVoteCount += votes[i][j];
				}
				*/
				
				voteCounts[i] += votes[i][j];
			}
		}
		
		System.out.println(">> Republic Party Vote Count: "+voteCounts[0]);
		System.out.println(">> Democratic Party Vote Count: "+voteCounts[1]);
		
		if(voteCounts[0] > voteCounts[1]) {
			System.out.println(">> Republican Party Won by "+(voteCounts[0]-voteCounts[1])+" votes");
		}else {
			System.out.println(">> Democratic Party Won by "+(voteCounts[1]-voteCounts[0])+" votes");
		}
		
		int[][][] array = {
								{
										// 0	1		2		3		4
									{12445, 23445, 45121, 12432, 19753}, // 0th Array
										// 0	1		2		3		4						// 0th Array
									{53565, 32431, 12111, 43222, 11134},  // 1st Array
								},
								
								{
									// 0	1		2		3		4
									{12445, 23445, 45121, 12432, 19753}, // 0th Array
										// 0	1		2		3		4						// 1st Array
									{53565, 32431, 12111, 43222, 11134},  // 1st Array
								}
						  };
		
	}

}
