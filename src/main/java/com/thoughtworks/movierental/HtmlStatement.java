package com.thoughtworks.movierental;

class HtmlStatement {

    String display(String name, Rentals rentals){
        String header = "<h1>Rental Record for <b>" + name +"</b></h1><br/>";
        String body = "";
        for (Rental each : rentals) {
            body += each.getMovie().getTitle() + " " +
                    String.valueOf(each.amount()) + "<br/>";
        }

        String footer = "Amount owed is <b>" + String.valueOf(rentals.totalAmount()) + "</b><br/>" +
                "You earned <b>" + String.valueOf(rentals.totalRenterPoints())
                + "</b> frequent renter points";

        return  header + body + footer;
    }
}
