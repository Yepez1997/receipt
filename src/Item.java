/* Item.java is an abstract class to implement TaxItem.java and ExemptItem.java */

abstract class Item {
    
    public Item(Integer quantity, String name, Double cost, String serializedInfo) {
        this.itemQuantity = quantity;
        this.itemName = name;
        this.itemCost = cost;
        this.imported = serializedInfo.charAt(0); 
        this.itemCostDifference = cost;
    }


    /* abstract methods */
    abstract Double calculateTotalTax();
    abstract Double calculateTaxDifference(); 


    /* Get cost */
    public Double getCost() {
        return this.itemCost;
    }

    /* Get cost difference */
     public Double getCostDifference() {
        return this.itemCostDifference;
    }

    /* Get quantity */ 
    public Integer getQuant() {
        return this.itemQuantity; 
    }

    /* Get name */
    public String getName() {
        return this.itemName; 
    }

    /* Get imported */
    public Character getImported() {
        return this.imported;
    }


    /* Amount (real values) of numbers. */
    protected Integer itemQuantity; 

    /* Name of item. */
    protected String itemName;
   
    /* Cost of item. */
    protected Double itemCost; 
   
    /* Total Difference betweem Items Taxed and Regular Price */
    protected Double itemCostDifference; 
   
    /* First Chracter in serialiedInfo determaines if the item is imported or not. */
    protected Character imported;

    /* Import Tax. */
    protected Double importedTax = 0.05;

   
}




