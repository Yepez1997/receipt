class TaxedItem extends Item {

    public TaxedItem(Integer quantity, String name, Double cost, String serializedInfo) {
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
        return super.itemCost * super.itemQuantity * this.salesTax;
 }


    /* Calculate the total tax, includes sales and import 
     *  Both are not required. */
    @Override
    Double calculateTotalTax() {
        Double totalTax = calculateImportTax() + calculateSalesTax();
        return totalTax;
    }

     /* Sales Tax */
     final Double salesTax = 0.10; 

}




\
