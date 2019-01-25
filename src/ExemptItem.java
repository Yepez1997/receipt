class ExemptItem extends Item {

    public ExemptItem(Integer quantity, String name, Double cost, String serializedInfo) {
        super(quantity, name, cost, serializedInfo);
        this.totalCost = 0.0;
    }


    /* Calculate the difference for the total tax and original price. */
    @Override
    Double calculateTaxDifference() {
        super.itemCostDifference = this.totalCost - super.itemCost;
        return super.itemCostDifference;
    }

    /* Calculate the total tax, includes sales and import 
     *  Both are not required. */
    @Override
    Double calculateTotalTax() {
        if (super.imported == '1') {
            this.totalCost += super.itemCost * (1 + importedTax);
            return this.totalCost;
        }
        else {
            this.totalCost = super.itemCost;
            return this.totalCost;
        }
    }

    /* Total taxes + cost */
    public Double getTotalTaxes() {
        return this.totalCost; 
    }

    /* total cost */
    private Double totalCost; 
}




