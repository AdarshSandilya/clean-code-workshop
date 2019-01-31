package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }


    public String statement() {
        String result = "Rental Record for " + this.name + "\n";

        for (Rental each : rentals) {
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(each.amount()) + "\n";
        }

        //add footer lines result
        result += "Amount owed is " + String.valueOf(totalAmount()) + "\n";
        result += "You earned " + String.valueOf(totalRenterPoints())
                + " frequent renter points";
        return result;
    }

    public String htmlStatement(){
        String header = "<h1>Rental Record for <b>" + this.name +"</b></h1><br/>";
        String body = "";
        for (Rental each : rentals) {
            body += each.getMovie().getTitle() + " " +
                    String.valueOf(each.amount()) + "<br/>";
        }

        String footer = "Amount owed is <b>" + String.valueOf(totalAmount()) + "</b><br/>" +
                "You earned <b>" + String.valueOf(totalRenterPoints())
                + "</b> frequent renter points";

        return  header + body + footer;
    }

    private int totalRenterPoints() {
        return rentals.stream().mapToInt(Rental::frequentRenterPoint).sum();
    }

    private double totalAmount() {
        return rentals.stream().mapToDouble((Rental::amount)).sum();
    }

}

