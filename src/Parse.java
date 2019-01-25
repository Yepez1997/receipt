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
import java.util.ArrayList;
import java.util.Set;

import javax.naming.spi.DirObjectFactory;

import java.util.HashSet;

import com.sun.tools.javac.code.Attribute.Array;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

/* Parse */
public class Parse {

    /* Returns true if the item is imported. */
    public boolean isImport(String firstWordInSplit) {
        if (firstWordInSplit == "imported") {
            this.isImported = true;
            return true; 
        }
        else {
            this.isImported = false; 
            return false; 
        }
    }


    /* Returns true if the item is tax exempt. */
    public boolean isExempt(String[] importantWordsInString) {
        // want to open file and see if the elements are presnet
        try {
            // change to your directory: pwd + file.txt and paste 
            String miniDBLocation = "/Users/aurelianoyepez/Desktop/salesTaxThoughtWords/db/nonExempt.txt";
            ArrayList<String> dbItems = new ArrayList<String>();
            FileInputStream fd = new FileInputStream(miniDBLocation);
            Scanner fileScanner = new Scanner(fd); 
            
            // o(n**2) doing these loops maybe improve ? 
            // if input is short best case is linear 
            while (fileScanner.hasNextLine()) {
                String exemptItems = fileScanner.nextLine(); 
                exemptItems = exemptItems.replaceAll("^\\s+ \\s+$", ""); // replace whitespace 
                //System.out.println(exemptItems);
                // TODO:
                // insert to array and check that way 
                dbItems.add(exemptItems);    
            }
            String search;
            for (int i = 0; i < dbItems.size(); i++) {
                search = dbItems.get(i).trim(); 
                for (String str : importantWordsInString) {
                    if(str.trim().contains(search)) {
                        System.out.println("here");
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

    /* Returns the array without common article word such as "of, a, the, etc"
    * This is neccesary to minimize calls to the text file and reducing complexity. */
    public String[] stripInformation(String itemName) {
        String[] splitWords = itemName.split(" "); 
        Set<String> conciseWords = new HashSet<>();
        // if the word contains the ignore words do not add 
        String current; 
        for (int j = 0; j < splitWords.length; j++) {
            current = splitWords[j].replaceAll("^\\s+ \\s+$", ""); // remove whitespace from word 
            if (current == "at" || current == "of" || current == "the" || current == "an") {
                continue;
            }
            else {
                conciseWords.add(splitWords[j]);
                //System.out.println(splitWords[j]);
            }
        }
        int count = 0;
        String[] conciseWordsToStringList = new String[conciseWords.size()];
        for (String s : conciseWords) {
            //System.out.println(s);
            if (s == "at" || s == "of" || s == "the" || s == "an") {
                count++; 
                continue;
            }
            else {
            conciseWordsToStringList[count] = s;  
            count++; 
            }
        }
        // make sure we do not miss any elts 
        assert(conciseWords.size() == conciseWordsToStringList.length);
        return conciseWordsToStringList;
    }


    /* Calls isExempt and isImport to return critical
    *  information on the obect being parsed.  */
    public String[] getInfo(String itemName) {
        String[] splitWords = itemName.split(" ");
        // first one should be the "imported" if not it is false 
        String firstWordInSplit = splitWords[0];
        isImport(firstWordInSplit);
        // join array list of strings with spaces
        // then strip information
        String holder = ""; // concat to here 
        // this might error 
        for (int i = 0; i < splitWords.length; i++) {
            holder += (splitWords[i] + " ");
        }
        String[] importantWordsInString = stripInformation(holder);
        //boolean isExempt = isExempt(importantWordsInString); 
        return importantWordsInString; 
    }

    public boolean getExempt(String[] importantWords) {
        boolean tf = isExempt(importantWords);
        System.out.println(tf);
        return tf; 
    }

    /* set name of itemName */
    public void setName(String name) {
        this.itemName = name;
    }

    /* Array List of words to ignore */
    public void setUpIgnoreWords() {
        this.ignoreWords.add("a");
        this.ignoreWords.add("an");
        this.ignoreWords.add("the");
        this.ignoreWords.add("at"); 
        this.ignoreWords.add("of");
    }

    /* get item name */
    public String getName() {
        return itemName;
    }

    /* get imported boolean */
    public boolean getImported() {
        return isImported;
    }

    /* get isExemptedItem boolean */
      public boolean getIsExemptedItem() {
        return isExemptItem;
    }

     // ------------------------------------------------------------ // 

     // Making private to follow encapsulation 

     /* The item name to be parsed. */
     private String itemName; 

     /* Determaines if the item will be imported or not. */
     private boolean isImported; 

     /* Determaines if the item will be exempt or not */
     private boolean isExemptItem; 

     /* List of words to ignore */
     private ArrayList<String> ignoreWords = new ArrayList<String>(); 

}

