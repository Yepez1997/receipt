class TaxedItem extends Item {

    public TaxedItem(Integer quantity, String name, Double cost, String serializedInfo) {
        super(quantity, name, cost, serializedInfo);
        this.totalCost = 0.0;
    }


    /* Calculate the difference for the total tax and original price. */
    @Override
    void calculateTaxDifference() {
        super.itemCostDifference = calculateTotalTax() - super.itemCost;
    }


    /* Calculate the total tax, includes sales and import 
     *  Both are not required. */
    @Override
    Double calculateTotalTax() {
        if (super.imported == '1') {
            this.totalCost += (super.itemCost * (1 + salesTax)) * (importedTax);
            return this.totalCost;
        }
        this.totalCost += (super.itemCost * (1 + salesTax)); 
        return this.totalCost;
    }

    /* Total taxes + cost */
    public Double getTotalTaxes() {
        return this.totalCost; 
    }

     /* Sales Tax */
     final Double salesTax = 0.10; 

    /* total cost */
    private Double totalCost; 
}

