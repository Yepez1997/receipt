/* Parse.java
*  Parses the string read from input to determaine
*  the type of taxed item or exempt item that is created. In other words,
*  if the given string is "import a box of choclates", keeping 
*  track of the the import key word and parsing the rest of the string 
*  is ideal. 
*  
*  To distinguish the taxed or exempt item, look into the mini database file 
*  in db/nonExempt.txt to see if the string matches a key word, if it does match a key word in 
*  searching in the list it is safely assumed that the item is taxed. 
*/

// important practice to not use .*; 
import javax.naming.spi.DirObjectFactory;
import com.sun.tools.javac.code.Attribute.Array;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/* Parse. */
public class Parse {

    /* Returns true if the item is imported. */
    public boolean isImport(String[] importantWords) {
        String search = "imported";
        for (String str : importantWords) {
            if(str.trim().contains(search)) {      
                return true;
            }
        }
        return false;
    }   

    /* Returns true if the item is tax exempt. */
    public boolean isExempt(String[] importantWordsInString) {
        try {
            // change to your directory: pwd + file.txt and paste 
            String miniDBLocation = "/Users/aurelianoyepez/Desktop/salesTaxThoughtWords/db/nonExempt.txt";
            ArrayList<String> dbItems = new ArrayList<String>();
            FileInputStream fd = new FileInputStream(miniDBLocation);
            Scanner fileScanner = new Scanner(fd); 
            
            while (fileScanner.hasNextLine()) {
                String exemptItems = fileScanner.nextLine(); 
                exemptItems = exemptItems.replaceAll("^\\s+ \\s+$", "");
                dbItems.add(exemptItems);    
            }

            String search;
            for (int i = 0; i < dbItems.size(); i++) {
                search = dbItems.get(i).trim(); 
                for (String str : importantWordsInString) {
                    if(str.trim().contains(search)) {
                        return true;
                    }
                }
            }   

            fileScanner.close(); 
            return false; 
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("File was not found");
            return false;
        }
    }

    /* Returns the String list without common article word such as "of, a, the, etc"
    * This is neccesary to minimize calls to the text file and reducing complexity - to some extent. */
    public String[] stripInformation(String itemName) {
        String[] splitWords = itemName.split(" "); 
        Set<String> conciseWords = new HashSet<>();

        for (String str : splitWords){ 
            if (str.equals("at")) {
                continue;
            }
            else if (str.equals("an")) {
                continue;
            }
            else if (str.equals("of")) {
                continue;
            }
            else if (str.equals("the")) {
                continue;
            }
            else if (str.equals("a")) {
                continue;
            }
            else {
                conciseWords.add(str);
            }
        }

        // convert back to String[]
        int count = 0;
        String[] conciseWordsToStringList = new String[conciseWords.size()];
        for (String s : conciseWords) {
            conciseWordsToStringList[count] = s;  
            count++; 
        }   
        return conciseWordsToStringList;
    }

    /* Calls isExempt and isImport in Main.java to return critical
     * information on the object being parsed. */
    public String[] getInfo(String itemName) {
        String[] importantWordsInString = stripInformation(itemName);
        return importantWordsInString; 
    }

    /* Returns true if the item is imported */
    public boolean getImported(String[] importantWords){
        boolean imported = isImport(importantWords);
        return imported;
    }

    /* Returns true if the item is exempt */
    public boolean getExempt(String[] importantWords) {
        boolean exempt = isExempt(importantWords);
        return exempt; 
    }

    /* Set name of itemName. */
    public void setName(String name) {
        this.itemName = name;
    }

    /* Get item name. */
    public String getName() {
        return itemName;
    }

    /* The item name to be parsed. */
    private String itemName; 

    /* List of words to ignore. */
    private ArrayList<String> ignoreWords = new ArrayList<String>(); 
}
