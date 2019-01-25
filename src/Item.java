/* Item.java is an abstract class to implement TaxItem.java and ExemptItem.java */

interface Item {

    final Double salesTax = 0.10;
    final Double importTax = 0.05;
    Double calculateImportTax();
    Double calculateSalesTax();
    Double calculateTotalTax();
    Double calculateTaxDifference(); 

}




