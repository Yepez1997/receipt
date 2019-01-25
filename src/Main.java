
/* Main.java : Parses lines, and creates proper objects  */
import java.util.ArrayList;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.naming.directory.SearchResult;

/* Main */
public class Main {

    public static void main(String[] args) {

     try {
         // try to open the file 
        FileInputStream fd = new FileInputStream(args[0]);
        Scanner fileScanner = new Scanner(fd); 
    
        Integer quantity; 
        String itemName;
        Double itemCost;

        while(fileScanner.hasNextLine()) {
            String oneLine = fileScanner.nextLine(); 
            // now we want to split string into three parts 
            String[] columns = oneLine.split(","); 
            quantity = Integer.parseInt(columns[0]); 
            itemName = columns[1]; 
            String serializedInfo = doParse(itemName);
            itemCost = Double.parseDouble(columns[2]); 
            System.out.println(oneLine);
        }
        fileScanner.close();
     }
     catch (FileNotFoundException fnfe) {
         System.out.println("File was not found");
     }
    }

    /* Gets the info needed to create the objects */
    public static String doParse(String itemName) {
        String serializedInformation = ""; 
        Parse getItemInfo = new Parse(); 
        getItemInfo.setUpIgnoreWords();
        getItemInfo.setName(itemName);
        String[] nameInfo = getItemInfo.getInfo(itemName); 
        Boolean imported = getItemInfo.getImported2(nameInfo); 
        if (imported) {
            serializedInformation += "1";
        }
        else {
            serializedInformation += "0";
        }
        Boolean taxExempt = getItemInfo.getExempt(nameInfo); 
        if (taxExempt) {
            serializedInformation += "1"; 
        }
        else { 
            serializedInformation += "0";
        }
        assert(serializedInformation.length() == 2); 
        System.out.println(serializedInformation);
        return serializedInformation;
    }


    /* Important to note what the serialized information does: 
    *  Seriazlized Info is a size of len 2.  
    *  The first index represents if the item is imported: imported ? 1 : 0 
    *  The second index is if the item is exempt: exempt ? 1 : 0
    *  Serialized info is critical to creating the right class. */    
    public static void createItem(Integer quantity, String name, Double cost, String serializedInfo) {
        Character isImported = serializedInfo.charAt(0);
        Character isExempt = serializedInfo.charAt(1);

    }


}