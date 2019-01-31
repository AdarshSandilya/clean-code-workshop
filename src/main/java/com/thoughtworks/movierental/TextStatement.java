package com.thoughtworks.movierental;

import java.util.List;

public class TextStatement {
     public String display(String name, List<Rental> rentals, double totalAmount, int renterPoints) {
         String result = "Rental Record for " + name + "\n";

         for (Rental each : rentals) {
             result += "\t" + each.getMovie().getTitle() + "\t" +
                     String.valueOf(each.amount()) + "\n";
         }

         //add footer lines result
         result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
         result += "You earned " + String.valueOf(renterPoints)
                 + " frequent renter points";
         return result;
     }
}
