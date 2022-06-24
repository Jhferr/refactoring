import java.util.Enumeration;

public abstract class Statement {
   public abstract String getStartOfResult (Customer aCustomer);

   public abstract String getMiddleOfResult (Rental each);

   public abstract String getEndOfResult (Customer aCustomer);

   public String value(Customer aCustomer) {
      Enumeration rentals = aCustomer.getRentals();
      String result = getStartOfResult(aCustomer);
      while (rentals.hasMoreElements()) {
         Rental each = (Rental) rentals.nextElement();
         //show figures for this rental
         result += getMiddleOfResult(each);
      }
      //add footer lines
      result += getEndOfResult(aCustomer);
      return result;
   }
}