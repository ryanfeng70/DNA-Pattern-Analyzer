import java.util.*;
import java.io.*;

public class genome {    
    public static String filetostring (String filename) throws IOException {
        FileInputStream fileByteStream = null; /*File input stream*/
        Scanner inFS = null;                   /*Scanner object*/
        String genomechar = "";
        
        /*Reading file into string*/
        fileByteStream = new FileInputStream(filename);
        inFS = new Scanner(fileByteStream);
        genomechar = inFS.nextLine();
        while (inFS.hasNextLine()) {
            genomechar = genomechar + inFS.nextLine();
        }       
        fileByteStream.close();
        
        return genomechar;
    }
    
    public static char[] stringtoarray (String userinput) {
        int length = userinput.length();
        char[] genomearray = new char[length];
        
        for(int i = 0; i<length; i++) {
            genomearray[i] = userinput.charAt(i);
        }
        
        return genomearray;
    }
    
    public static void patternarray (char first, char second, char third, int genomelength, char[] genomearray) {
        int numtimes = 0;
        
        for(int i=0; i<genomelength-2; i++) {
            if(genomearray[i]==first) {
                if(genomearray[i+1]==second) {
                    if(genomearray[i+2]==third) {
                        numtimes=numtimes+1;
                    }
                }
            }
        }
        System.out.println("Sequence "+first+second+third+" occurs "+numtimes+" time(s)");
    }
    
    public static void main(String[] args) {
        try {
        System.out.println("Sorting through genome...");
        System.out.println("");
            
        String genomechar = filetostring("genome.txt");
        int genomelength = genomechar.length();
        
        char[] genomearray = stringtoarray(genomechar);
        
        patternarray('A', 'A', 'A', genomelength, genomearray);
        patternarray('C', 'T', 'C', genomelength, genomearray);
        patternarray('G', 'A', 'G', genomelength, genomearray);
        patternarray('T', 'A', 'G', genomelength, genomearray);
        
        System.out.println("");
        System.out.println("Sorted through genome.");
        }
        catch(IOException excpt) {
            System.out.println(excpt.getMessage()); 
        }
    }
    
}
