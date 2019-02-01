package com.thoughtworks.movierental;

class Customer {
    private String name;
    private Rentals rentals;

    Customer(String name, Rentals rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    private String getName() { return name;}


    String statement() {
        TextStatement textStatement = new TextStatement();
        return textStatement.display(this.getName(), rentals);
    }

    String htmlStatement(){
        HtmlStatement htmlStatement = new HtmlStatement();
        return htmlStatement.display(this.getName(), rentals);
    }
}

