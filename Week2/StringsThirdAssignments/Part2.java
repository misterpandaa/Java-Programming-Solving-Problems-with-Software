
/**
 * Using the StorageResource Class
 * 
 * @author Deny Kiantono
 * @version 1.0
 */
public class Part2 {
    public double cgRatio(String dna) {
        int totalOccurences = 0;
        
        for (int i = 0; i < dna.length(); i++) {
            if (dna.toUpperCase().charAt(i) == 'C' || dna.toUpperCase().charAt(i) == 'G') {
                totalOccurences++;
            }
         }
         
         return (double) totalOccurences / dna.length();
    }
    
    public void testcgRatio() {
        String dna = "ATGCCATAG";
        System.out.println("cgRatio on " + dna + " = " + cgRatio(dna));
    }
    
    public int countCTG(String dna) {
        int totalOccurences = 0;
        int start = 0;
        
        while(true) {
            int index = dna.toUpperCase().indexOf("CTG", start);
            
            if (index == -1) {
                break;
            }
            
            totalOccurences++;
            
            start = index + 3;
        }
        
        return totalOccurences;
    }
    
    public void testCountCTG() {
        String dna = "CTGCCTGGCTGCTG";
        System.out.println("CTG occurences on " + dna + " = " + countCTG(dna));
    }
}
