class ExemptItem extends Item {

    public ExemptItem(Integer quantity, String name, Double cost, String serializedInfo) {
        super(quantity, name, cost, serializedInfo);
    }


    /* Calculate the difference for the total tax and original price. */
    @Override
    void calculateTaxDifference() {
        super.itemCostDifference = calculateTotalTax() - super.itemCost;
    }

    /* Calculate sales type. */
    @Override
    Double calculateSalesTax() {
        return 0.0;
    }

    /* Calculate the total tax, includes sales and import 
     *  Both are not required. */
    @Override
    Double calculateTotalTax() {
        Double totalTax = calculateImportTax() + calculateSalesTax();
        return totalTax;
    }

    
}




