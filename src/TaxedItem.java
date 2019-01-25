
class TaxedItem implements Item {

    public TaxedItem(Integer quantity, String name, Double cost, String serializedInfo) {
        this.quantity = quantity;
        this.name = name;
        this.cost = cost;
        this.imported = serializedInfo.charAt(0);
    }
    public Double calculateImportTax() {
        return this.cost * quantity *importTax;
    }

    // important 
    public Double calculateTaxDifference() {
        return calculateTotalTax() - this.cost;
    }

    public Double calculateSalesTax() {
        return this.cost * quantity * salesTax;
    }

    public Double calculateTotalTax() {
        Double totalTax = calculateImportTax() + calculateSalesTax();
        return totalTax;
    }


    /* intances  */
    private Integer quantity; 
    private String name;
    private Double cost;
    private Double total;
    // we only care about the first one now 
    private String imported;


}