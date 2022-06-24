import java.util.Enumeration;

public class HtmlStatement extends Statement {
   public String getStartOfResult (Customer aCustomer){
      return "<H1>Rentals for <EM>" + aCustomer.getName() +
      "</EM></H1><P>\n";
   }
   
   public String getMiddleOfResult (Customer each){
      return each.getMovie().getTitle()+ ": " +
         String.valueOf(each.getCharge()) + "<BR>\n";
   }

   public String getEndOfResult (Customer aCustomer){
      return "<P>You owe <EM>" +
      String.valueOf(aCustomer.getTotalCharge()) + "</EM><P>\n" +
      "On this rental you earned <EM>" + 
      String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
      "</EM> frequent renter points<P>";
   }

   public String value(Customer aCustomer) {
      Enumeration rentals = aCustomer.getRentals();
      String result = getStartOfResult(aCustomer);
      while (rentals.hasMoreElements()) {
         Rental each = (Rental) rentals.nextElement();
         //show figures for each rental
         result += getMiddleOfResult(each);
      }
      //add footer lines
      result += getEndOfResult(aCustomer);
      return result;
   }
}