class ExemptItem implements Item {

    public ExceptItem(Integer quantity, String name, Double cost, String serializedInfo) {
        this.quantity = quantity;
        this.name = name;
        this.cost = cost;
        this.imported = serializedInfo.charAt(0);
    }

    public Double calculateImportTax() {
        return this.cost * quantity *importTax;
    }

    public Double calculateTaxDifference() {
        return calculateTotalTax() - this.cost;
    }

    public Double calculateSalesTax() {
        return 0.0;
    }

    public Double calculateTotalTax() {
        Double totalTax = calculateImportTax();
        return totalTax;
    }


    /* intances  */
    private Integer quantity; 
    private String name;
    private Double cost; 
    // we only care about the first one now 
    private String imported;


}