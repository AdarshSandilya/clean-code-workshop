package com.thoughtworks.movierental;

class TextStatement {
     String display(String name, Rentals rentals) {
         String result = "Rental Record for " + name + "\n";

         for (Rental each : rentals) {
             result += "\t" + each.getMovie().getTitle() + "\t" +
                     String.valueOf(each.amount()) + "\n";
         }

         result += "Amount owed is " + String.valueOf(rentals.totalAmount()) + "\n";
         result += "You earned " + String.valueOf(rentals.totalRenterPoints())
                 + " frequent renter points";
         return result;
     }
}
