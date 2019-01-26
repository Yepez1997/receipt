
/* Main.java : Parses lines, and creates proper objects  */
import java.util.ArrayList;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.naming.directory.SearchResult;
import java.util.HashMap;

/* Main */
public class Main {

    public static void main(String[] args) {

     try {

        FileInputStream fd = new FileInputStream(args[0]);
        Scanner fileScanner = new Scanner(fd); 
    
        Integer quantity; 
        String itemName;
        Double itemCost;

        Receipt receipt = new Receipt();

        while(fileScanner.hasNextLine()) {
            String oneLine = fileScanner.nextLine(); 
            String[] columns = oneLine.split(","); 
            quantity = Integer.parseInt(columns[0]); 
            itemName = columns[1]; 
            String serializedInfo = parseString(itemName);
            itemCost = Double.parseDouble(columns[2]); 
            createItem(quantity, itemName, itemCost, serializedInfo, receipt);
            System.out.println(oneLine);
            System.out.println("#####################");
        }
        fileScanner.close();
     }
     catch (FileNotFoundException fnfe) {
         System.out.println("File was not found");
     }

    }

    /* Gets the info needed to create the objects */
    public static String parseString(String itemName) {
        String serializedInformation = ""; 
        Parse parseItemName = new Parse(); 
        parseItemName.setName(itemName);
        String[] nameList = parseItemName.getInfo(itemName); 
        Boolean isImported = parseItemName.getImported(nameList); 
        if (isImported) {
            serializedInformation += "1";
        }
        else {
            serializedInformation += "0";
        }
        Boolean isTaxExempt = parseItemName.getExempt(nameList); 
        if (isTaxExempt) {
            serializedInformation += "1"; 
        }
        else { 
            serializedInformation += "0";
        }
        assert(serializedInformation.length() == 2); 
        return serializedInformation;
    }


    /* Important to note what the serialized information does: 
    *  Seriazlized Info is a size of len 2.  
    *  The first index represents if the item is imported: imported ? 1 : 0 
    *  The second index is if the item is exempt: exempt ? 1 : 0
    *  Serialized info is critical to creating the right class. */    
    public static void createItem(Integer quantity, String name, Double cost, String serializedInfo, Receipt r) {
        //Character isImported = serializedInfo.charAt(0);
        Character isExempt = serializedInfo.charAt(1);
        if (isExempt == '1') {
            Item exemptItem = new ExemptItem(quantity,name,cost,serializedInfo);
            //System.out.println(exemptItem.calculateTaxDifference());
            r.addTaxDifferences(exemptItem.calculateTaxDifference());
            System.out.println(exemptItem.calculateTotalTax());
            r.addNamePricePair(name, exemptItem.calculateTotalTax());
        }
        else {
            Item taxedItem = new TaxedItem(quantity,name,cost,serializedInfo); 
           // System.out.println(taxedItem.calculateTaxDifference());
            r.addTaxDifferences(taxedItem.calculateTaxDifference());
            System.out.println(taxedItem.calculateTotalTax());
            r.addNamePricePair(name,taxedItem.calculateTotalTax());

        }
    }

}


