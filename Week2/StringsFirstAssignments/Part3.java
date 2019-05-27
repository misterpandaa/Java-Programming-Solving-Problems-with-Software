
/**
 * Problem Solving with Strings
 * 
 * @author Deny Kiantono
 * @version 1.0
 */
public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb) {
        int firstIndex = stringb.indexOf(stringa);
        int lastIndex = stringb.lastIndexOf(stringa);
        
        if (firstIndex != lastIndex) {
            return true;
        } else {
            return false;
        }
    }
    
    public String lastPart(String stringa, String stringb) {
        int index = stringb.indexOf(stringa);
        
        if (index == -1) {
            return stringb;
        } else {
            return stringb.substring(index + stringa.length());
        }
    }
    
    public void test() {
        String stringa;
        String stringb;
        
        System.out.println("Testing twoOccurences");
        System.out.println("=====================");
        
        stringa = "by";
        stringb = "A story by Abby Long";
        System.out.println(stringa + " appears at least twice in " + stringb + " = " + twoOccurrences(stringa, stringb));
        
        stringa = "a";
        stringb = "banana";
        System.out.println(stringa + " appears at least twice in " + stringb + " = " + twoOccurrences(stringa, stringb));
        
        stringa = "atg";
        stringb = "ctgtatgta";
        System.out.println(stringa + " appears at least twice in " + stringb + " = " + twoOccurrences(stringa, stringb));
        
        System.out.println("\n\nTesting lastPart:");
        System.out.println("=================");
        
        stringa = "an";
        stringb = "banana";
        System.out.println("The part of the string after " + stringa + " in " + stringb + " is " + lastPart(stringa, stringb));
        
        stringa = "zoo";
        stringb = "forest";
        System.out.println("The part of the string after " + stringa + " in " + stringb + " is " + lastPart(stringa, stringb));
    }
}
