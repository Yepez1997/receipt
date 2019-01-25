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
import com.sun.tools.javac.code.Attribute.Array;

public class Parse {

    /* Returns true if the item is imported. */
    public boolean isImport(String firstWordInSplit) {
        if (itemOneName == "imported") {
            this.isImported = true;
            return true; 
        }
        else {
            this.isImported = false; 
            return false; 
        }
    }


    /* Returns true if the item is tax exempt. */
    public void isExempt(ArrayList<String> importantWordsInString) {
        // want to open file and see if the elements are presnet
        FileInputStream fd = new FileInputStream();
        Scanner fileScanner = new Scanner(fd); 
        
        // o(n**2) doing these loops maybe improve ? 
        // if input is short best case is linear 
        while (fileScanner.hasNextLine()) {
            String exemptItems = fileScanner.nextLine(); 
            for (int i = 0; i < importantWordsInString.size(); i++) {
                if (importantWordsInString == exemptItems) {
                    this.isExemptItem = true;
                }
            }
        }

        fileScanner.close(); 
        // not exempt, meaning this item will get taxed 
        this.isExemptItem = false; 
    }

    /* Returns the array without common article word such as "of, a, the, etc"
    * This is neccesary to minimize calls to the text file and reducing complexity. */
    public ArrayList<String> stripInformation(String itemName) {
        ArrayList<String> splitWords = itemName.split(" "); 
        ArrayList<String> conciseWords = {}; 
        // if the word contains the ignore words do not add 
        for (String s : splitWords) {
             if (!Arrays.asList(this.ignoreWords).contains(s)) {
                conciseWords.add(s); 
             }
        }
        return null;
    }

    /* Calls isExempt and isImport to return critical
    *  information on the obect being parsed.  */
    public void getInfo() {
        ArrayList<String> splitWords = itemName.split(" ");
        // first one should be the "imported" if not it is false 
        String firstWordInSplit = splitWords.get(0);
        isImported(firstWordInSplit));
        // join array list of strings with spaces
        // then strip information
        String holder = ""; // concat to here 
        for (int i = 0; i < splitWords.size(); i++) {
            holder += (splitWords.get(0) + " ");
        }
        ArrayList<String> importantWordsInString = stripInformation(holder);
        isExempt(importantWordsInString);  
    
    }

    /* set name of itemName */
    public setName(String name) {
        this.itemName = name;
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
     private ArrayList<String> ignoreWords = {"a","at","the","of","an"}; 


}