package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    public List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() { return name;}


    public String statement() {
        TextStatement textStatement = new TextStatement();
        return textStatement.display(this.getName(), this.rentals, this.totalAmount(), this.totalRenterPoints());
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

    public int totalRenterPoints() {
        return rentals.stream().mapToInt(Rental::frequentRenterPoint).sum();
    }

    public double totalAmount() {
        return rentals.stream().mapToDouble((Rental::amount)).sum();
    }

}

