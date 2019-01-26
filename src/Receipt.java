import java.util.ArrayList;
import java.util.HashMap;


/* Receipt: contains all informtaion about the items */

// want to add names, double and total tax difference, and total tax 
public class Receipt {

    public Receipt() {
        this.taxDifferences = new ArrayList<Double>();
        this.namePricePair = new HashMap<String, Double>();
    }


    /* Add Key, Value pairs to the HashMap. */
    public void addNamePricePair(String name, Double totalCost) {
        this.namePricePair.put(name, totalCost);
    }

    /* Add to the Array of Tax Differences, A difference is the 
    Difference between the total cost and original cost.  */
    public void addTaxDifferences(Double taxDifferences){
        this.taxDifferences.add(taxDifferences);
    }
    
    /* Filters portions of the string to print the expected output format */
    public String prettyPrintName(String name) {
        return "";
    }

    public Double getTotalSalesTax() {
        Double total = 0.0; 
        for (int i = 0; i < this.taxDifferences.size(); i++) {
            total += this.taxDifferences.get(i);
        }
        return total; 
    }


    // dont take the method name too seriously :)
    public void theFinallyIGetToPrintTheOutputMethod() {
        // print everything from hashmap
    }



    
    private ArrayList<Double> taxDifferences; 
    private HashMap<String, Double> namePricePair; 

}




