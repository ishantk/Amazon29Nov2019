
public class MultiValueContainer {

	public static void main(String[] args) {
		
		// Representing Data as in Single Value Containers
		// Primtives
		int employee101 = 30000;
		int employee201 = 35000;
		int employee301 = 27000;
		int employee401 = 42000;
		int employee501 = 19000;
		
		// Challenge : When we have to store data for n number of employees and n increases, we have to rework
		// Solution : Use a Multi Value Container
		// Array : Homogeneous | Fixed in Size (After we execute Program we cannot change size of Array)
		int[] employeeSalaries = {30000, 35000, 27000, 42000, 19000};
		
		System.out.println(">> employee201 is: "+employee201);				// 35000
		System.out.println(">> employeeSalaries is: "+employeeSalaries);	// HashCode -> 7852e922
		// Explore Hashing Algo on YouTube
		
		// employee101 and other contains data and hence are known as Primitives
		// BUT,  employeeSalaries contains HashCode of an Array in Heap
		// employeeSalaries is known as REFERENCE VARIABLE
		
		//int index = 0;
		/*
		System.out.println(">> employeeSalaries["+index+"] is: "+employeeSalaries[index]);
		index++;
		System.out.println(">> employeeSalaries["+index+"] is: "+employeeSalaries[index]);
		index++;
		System.out.println(">> employeeSalaries["+index+"] is: "+employeeSalaries[index]);
		index++;
		System.out.println(">> employeeSalaries["+index+"] is: "+employeeSalaries[index]);
		index++;
		System.out.println(">> employeeSalaries["+index+"] is: "+employeeSalaries[index]);
		*/
		
		// Iterations
		
		int totalCostToCompany = 0;
		for(int index=0;index<5;index++) {
			System.out.println(">> employeeSalaries["+index+"] is: "+employeeSalaries[index]);
			totalCostToCompany = totalCostToCompany + employeeSalaries[index];
		}
		
		System.out.println(">> CostToCompany is: \u20b9"+totalCostToCompany);
		
		

	}

}
