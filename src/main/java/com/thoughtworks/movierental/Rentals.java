package com.thoughtworks.movierental;

import java.util.ArrayList;

class Rentals extends ArrayList<Rental> {

    int totalRenterPoints() {
        return this.stream().mapToInt(Rental::frequentRenterPoint).sum();
    }

    double totalAmount() {
        return this.stream().mapToDouble((Rental::amount)).sum();
    }

}
