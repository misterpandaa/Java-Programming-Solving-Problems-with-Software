
/**
 * Finding a Gene - Using the Simplified Algorithm
 * 
 * @author Deny Kiantono 
 * @version 1.0
 */
public class Part1 {
    public String findSimpleGene(String dna) {
        String result = "";
        
        int startIndex = dna.indexOf("ATG");       
        int stopIndex = dna.indexOf("TAA", startIndex + 3);
        
        if (startIndex == -1 || stopIndex == -1) {
            return result;
        }
        
        if ((stopIndex - startIndex) % 3 == 0) {
            result = dna.substring(startIndex, stopIndex + 3);
        }
        
        return result;
    }
    
    public void testSimpleGene() {
        // DNA with no ATG
        String dna = "ATCTAACATC";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna));
        
        // DNA with no TAA
        dna = "ATTATCATGTTA";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna));
        
        // DNA with no “ATG” and “TAA”
        dna = "ATTAGTGTA";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna));
        
        // DNA with ATG, TAA and the substring between them is not a multiple of 3
        dna = "GAAATGGATAGTAA";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna));
        
        // DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene)
        dna = "TAAGATATGGTGAAGTAA";
        System.out.println("DNA strand is " + dna);
        System.out.println("Gene is " + findSimpleGene(dna));
    }
}
