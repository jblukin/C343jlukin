public class DNAHammingDistance {
	
	public static int hammingDistance(String firstDNASeq, String secondDNASeq) {
		
		int count = 0;
		
		for (int i = 0; i < firstDNASeq.length(); i++) {
			
			char a = firstDNASeq.charAt(i);
			char b = secondDNASeq.charAt(i);
				
				if(!(a == b)) {
					
					count++;
					
				}
			}
		
		return count;
		
	}
	
}