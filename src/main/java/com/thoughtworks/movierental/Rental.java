package com.thoughtworks.movierental;

class Rental {

    private int daysRented;
    private Movie movie;

    Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    Movie getMovie() {
        return movie;
    }

    double amount() {
        double thisAmount = 0;
        switch (movie.getPriceCode()) {
            case Movie.REGULAR:
                thisAmount = getAmountForRegularMovies(daysRented);
                break;
            case Movie.NEW_RELEASE:
                thisAmount += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount = getAmountForChildrenMovies(daysRented);
                break;
        }
        return thisAmount;
    }

    int frequentRenterPoint() {
        int renterPoints = 1;
        if (canAddBonus()) renterPoints++;
        return renterPoints;
    }

    private boolean canAddBonus() {
        return (movie.getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1;
    }

    private double getAmountForRegularMovies(int rentedDays) {
        double amount = 2;
        if (rentedDays > 2)
            amount += (rentedDays - 2) * 1.5;
        return amount;
    }

    private double getAmountForChildrenMovies(int rentedDays) {
        double amount = 1.5;
        if (rentedDays > 3)
            amount += (rentedDays - 3) * 1.5;
        return amount;
    }

}
