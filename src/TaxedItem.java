/* @author Aureliano Yepez  */
/* TaxedItem is an Item with Tax  */

/* TaxedItem. */
class TaxedItem extends Item {

    /* Constructor. */
    public TaxedItem(Integer quantity, String name, Double cost, String serializedInfo) {
        super(quantity, name, cost, serializedInfo);
        this.totalCost = 0.0;
    }

    /* Calculate the difference for the total price with tax and original price. */
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
            this.totalCost += (super.itemCost * (1 + salesTax)) * (1 + importedTax);
            return this.totalCost;
        }  
        else {
            this.totalCost += (super.itemCost * (1 + salesTax)); 
            return this.totalCost;
        }
    }

    /* Total Taxes + Cost. */
    public Double getTotalTaxes() {
        return this.totalCost; 
    }

     /* Sales Tax. */
     final Double salesTax = 0.10; 

    /* Total Cost. */
    private Double totalCost; 
}
