package com.thoughtworks.movierental;

public class Rental {

    private int daysRented;
    private Movie movie;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double calculateAmount() {
        double thisAmount = 0;
        //determine amounts for each line
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
