import java.util.Enumeration;

public class TextStatement extends Statement {
   public String getStartOfResult (Customer aCustomer){
      return "Rental Record for " + aCustomer.getName() +
      "\n";
   }
   
   public String getMiddleOfResult (Customer each){
      return "\t" + each.getMovie().getTitle()+ "\t" +
         String.valueOf(each.getCharge()) + "\n";
   }

   public String getEndOfResult (Customer aCustomer){
      return "Amount owed is " +
      String.valueOf(aCustomer.getTotalCharge()) + "\n" +
      "You earned " +
      String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
      " frequent renter points";
   }

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