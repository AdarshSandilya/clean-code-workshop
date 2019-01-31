package com.thoughtworks.movierental;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class RentalTest {

    // for regular movies
    @Test
    public void calculateAmount_should_return_amount_2_for_regular_movies_rented_less_than_three_days() {
        Movie regularMovie = new Movie("movieTitle", Movie.REGULAR);
        Rental rental = new Rental(regularMovie, 1);

        assertEquals(rental.amount(), 2.0);

        rental = new Rental(regularMovie, 2);

        assertEquals(rental.amount(), 2.0);
    }

    @Test
    public void calculateAmount_should_should_charge_one_and_half_per_day_after_initial_2_days_for_regular_movies() {
        Movie regularMovie = new Movie("movieTitle", Movie.REGULAR);
        Rental rental = new Rental(regularMovie, 3);

        assertEquals(rental.amount(), 3.5);
    }

    // for new release

    @Test
    public void calculateAmount_should_charge_amount_3_per_day_for_new_releases() {
        Movie movie = new Movie("movieTitle", Movie.NEW_RELEASE);
        Rental rental = new Rental(movie, 3);

        assertEquals(rental.amount(), 9.0);
    }

    // for children movies

    @Test
    public void calculateAmount_should_charge_amount_one_and_half_for_initial_two_days_for_children_movies() {
        Movie childrenMovie = new Movie("movieTitle", Movie.CHILDRENS);
        Rental rental = new Rental(childrenMovie, 1);

        assertEquals(rental.amount(), 1.5);

        rental = new Rental(childrenMovie, 2);

        assertEquals(rental.amount(), 1.5);
    }

    @Test
    public void calculateAmount_should_should_charge_one_and_half_per_day_after_initial_3_days_for_children_movies() {
        Movie regularMovie = new Movie("movieTitle", Movie.CHILDRENS);
        Rental rental = new Rental(regularMovie, 4);

        assertEquals(rental.amount(), 3.0);
    }

    @Test
    public void frequentRenterPoints_should_return_one_if_movie_is_not_new_release() {
        Movie regularMovie = new Movie("movieTitle", Movie.CHILDRENS);
        Rental rental = new Rental(regularMovie, 3);

        assertEquals(rental.frequentRenterPoint(), 1);
    }

    @Test
    public void frequentRenterPoints_should_return_one_if_movie_is_new_release_but_rented_days_is_one_only() {
        Movie regularMovie = new Movie("movieTitle", Movie.NEW_RELEASE);
        Rental rental = new Rental(regularMovie, 1);

        assertEquals(rental.frequentRenterPoint(), 1);
    }

    @Test
    public void frequentRenterPoints_should_return_two_if_movie_is_new_release_ane_rented_days_are_more_than_one() {
        Movie regularMovie = new Movie("movieTitle", Movie.NEW_RELEASE);
        Rental rental = new Rental(regularMovie, 3);

        assertEquals(rental.frequentRenterPoint(), 2);
    }

}
