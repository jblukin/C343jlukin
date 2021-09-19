import java.util.Random;

public class RandomDNA {
	
	public String generateDNAstring(int n) {
		
		String lDNA = "";
		Random lRandomizer = new Random();
		
		for (int i = 0; i < n; i++) {
		
			int rand = lRandomizer.nextInt(4);
			
				if(rand == 1) {
				
					lDNA += "A";
				
				} else if (rand == 2) {
				
					lDNA += "C";
				
				} else if (rand == 3) {
				
					lDNA += "T";
				
				} else {
				
					lDNA += "G";
				
				}
				
			}
		
		return lDNA;
		
	}
	
	// a test client
	public static void main(String[] args) {
	
		RandomDNA RandomDNA = new RandomDNA();
		DNAHammingDistance Hamming = new DNAHammingDistance();
		
		String firstDNAstring = "";
		String secondDNAstring = "";
		String thirdDNAstring = "";
		String fourthDNAstring = "";
		String fifthDNAstring = "";
		String sixthDNAstring = "";
		
		for (int i = 10; i <= 1000; i = i * 10) {
			
			firstDNAstring = RandomDNA.generateDNAstring(i);
			secondDNAstring = RandomDNA.generateDNAstring(i);
			thirdDNAstring = RandomDNA.generateDNAstring(i);
			fourthDNAstring = RandomDNA.generateDNAstring(i);
			fifthDNAstring = RandomDNA.generateDNAstring(i);
			sixthDNAstring = RandomDNA.generateDNAstring(i);
			
		}
		
		System.out.println("firstDNAstring: " + firstDNAstring);
		System.out.println("secondDNAstring: " + secondDNAstring);
		
		int firstComp = Hamming.hammingDistance(firstDNAstring, secondDNAstring);
		System.out.println("Hamming Distance between firstDNAstring & secondDNAstring: " + firstComp + "\n");
		
		System.out.println("thirdDNAstring: " + thirdDNAstring);
		System.out.println("fourthDNAstring: " + fourthDNAstring);
		
		int secondComp = Hamming.hammingDistance(thirdDNAstring, fourthDNAstring);
		System.out.println("Hamming Distance between thirdDNAstring & fourthDNAstring: " + secondComp + "\n");
		
		System.out.println("fifthDNAstring: " + fifthDNAstring);
		System.out.println("sixthDNAstring: " + sixthDNAstring);
		
		int thirdComp = Hamming.hammingDistance(fifthDNAstring, sixthDNAstring);
		System.out.println("Hamming Distance between fifthDNAstring & sixthDNAstring: " + thirdComp);
		
	}
	
}