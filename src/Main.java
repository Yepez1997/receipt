import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.naming.directory.SearchResult;

/* Driver Class: Parses lines, and creates proper objects  */
public class Main {

    public static void main(String[] args) {

    // TODO: READ INPUT 
    // run main + /path to directory 
     try {
         // try to open the file 
        FileInputStream fd = new FileInputStream(args[0]);
        Scanner fileScanner = new Scanner(fd); 
        System.out.println("File has been opened");

        // open and get every line 
        Integer quantity = 0; 
        String itemName = "";
        Double itemCost = 0.0;

        while(fileScanner.hasNextLine()) {
            String oneLine = fileScanner.nextLine(); 
            // now we want to split string into three parts 
            ArrayList<String> columns = oneLine.split(","); 
            quantity = Integer.parseInt(columns.get(0)); 
            itemName = colums.get(1); 
            String serializedInfo = doParse(itemName);
            itemCost =  Double.parseDouble(colums.get(2)); 
            System.out.println(oneLine);
            // for every line we create an object 
            createItem(quantity, itemName,itemCost,serializedInfo); 
        }
        fileScanner.close();
     }
     // file not found 
     catch(FileNotFoundException fnfe) {
         System.out.println("File was not found");
     }
    }

    // need to documement alot better if we want to have 
    // serialized information 

    /* Gets the info needed to create the objects */
    public static String doParse(String itemName) {
        String serializedInformation = ""; 
        getItemInfo = new Parse(); 
        // just have to set name 
        getItemInfo.setName(itemName);
        // get info does all the work and sets the proper 
        // instances in the class
        getItemInfo.getInfo(); 

        // getInfo about imported, exempt 
        Boolean imported = getItemInfo.getImported(); 
        if (imported) {
            serializedInformation += "1";
        }
        else {
            serializedInformation += "0";
        }
        Boolean taxExempty = getItemInfo.getIsExemptedItem();
        if (taxExempty) {
            serializedInformation += "1"; 
        }
        else { 
            serializedInformation += "0";
        }
        // must assert, we do not want to classiy the item wrong
        assert(len(serializedInformation) == 2); 
        return serializedInformation;
    }

    /* Important to note what the serialized information does: 
    *  Seriazlized Info is a size of len 2.  
    *  The first index represents if the item is imported: imported ? 1 : 0 
    *  The second index is if the item is exempt: exempt ? 1 : 0
    *  Serialized info is critical to creating the right class
    * */    
    public static void createItem(Integer quantity, String name, Double cost, String serializedInfo) {
        // here we want to create the classes 
        // info needed :  name, is imported, is exempt, quantity, cost 
        Integer isImported = String.parseInt(serializedInfo.charAt(0));
        Integer isExempt = String.parseInt(serializedInfo.charAt(1));
        // now we want to create abstract classes; s

    }


}