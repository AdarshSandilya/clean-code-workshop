package com.thoughtworks.movierental;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class RentalsTest {

    @Test
    public void addRental_should_add_rental_to_the_rental_Collection() {
        Rentals rentals = new Rentals();

        assertEquals(rentals.size(), 0);

        rentals.add(new Rental(new Movie("title", Movie.REGULAR), 2));

        assertEquals(rentals.size(), 1);
    }

    @Test
    public void get_should_return_list_of_rentals() {
        Rentals rentals = new Rentals();
        rentals.add(new Rental(new Movie("title", Movie.REGULAR), 2));

        assertThat(rentals.get(0), instanceOf(Rental.class));
    }

}
