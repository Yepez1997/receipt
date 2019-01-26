import java.util.ArrayList;
import java.util.HashMap;


/* Receipt: contains all informtaion about the items */

// want to add names, double and total tax difference, and total tax 
public class Receipt {

    public Receipt() {
        this.taxDifferences = new ArrayList<Double>();
        this.namePricePair = new HashMap<String, Double>();
        this.quants = new ArrayList<Integer>(); 
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
        String[] splitString = name.split(" "); 
        String filteredString = ""; 
        for (String str : splitString){ 
            if (str.equals("at")) {
                continue;
            }
            else {
                filteredString += (str + " ");
            }
        } 
        return filteredString;
    }

    /* Adds quantity to ArrayList */
    public void addQuantity(Integer q) {
        this.quants.add(q);
    }

    /* Obtains the total sales tax by adding the tax differences in the 
     * array list  */
    public Double getTotalSalesTax() {
        Double total = 0.0; 
        for (int i = 0; i < this.taxDifferences.size(); i++) {
            total += this.taxDifferences.get(i);
        }
        return total; 
    }


    // dont take the method name too seriously :)
    public void prettyPrintReceipty() {
        // concurently print quantity with the values in the map
        Double total = 0.0; 
        int count = 0; 
        System.out.println("########### Receipt ###########");
        for (HashMap.Entry<String,Double> i : this.namePricePair.entrySet()) {
            String itemName = i.getKey();
            String outputName = prettyPrintName(itemName); 
            System.out.print(this.quants.get(count));
            System.out.print(" ");
            System.out.print(outputName);
            System.out.print(": ");
            total += i.getValue();
            System.out.println(i.getValue());
            count++; 
        }
        System.out.print("Sales Tax: "); 
        System.out.println(getTotalSalesTax());
        System.out.print("Total: "); 
        System.out.println(total); 
        System.out.println("########### Receipt ###########");
    }

    /* ArrayList of tax differences : items that consist of:
     * TotalCost (After taxes) - Original Cost. */
    private ArrayList<Double> taxDifferences; 
    /* Hashmap consisting of itemName, itemCost */
    private HashMap<String, Double> namePricePair; 
    /* Quantities for each item  */
    private ArrayList<Integer> quants; 

}




