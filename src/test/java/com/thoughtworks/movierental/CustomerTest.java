package com.thoughtworks.movierental;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


public class CustomerTest {

    private Customer customer;
    private String customerName;

    @Before
    public void setUp() throws Exception {
        customerName = "someName";
        customer = new Customer(customerName);
    }

    // when there is no rental
    @Test
    public void statement_should_return_footer_lines_with_0_amount_if_there_is_no_rental(){

        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = String.format("Rental Record for %s" + System.lineSeparator()
                + "Amount owed is %s" + System.lineSeparator()
                + "You earned %s frequent renter points", customerName, String.valueOf(totalAmount), String.valueOf(frequentRenterPoints));
        assertEquals(customer.statement(), result);
    }

    // when there are rentals

    // for regular movies

    @Test
    public void statement_should_add_amount_2_for_each_of_the_regular_movies_for_first_two_days(){
        Movie regularMovie = new Movie("movieTitle", Movie.REGULAR);
        Rental rental = new Rental(regularMovie, 1);

        customer.addRental(rental);
        double totalAmount = 2.0;
        int frequentRenterPoints = 1;

        assertTrue(customer.statement().contains(String.valueOf(frequentRenterPoints)));
        assertTrue(customer.statement().contains(String.valueOf(totalAmount)));

        customer.addRental(rental);
        totalAmount = 4.0;
        frequentRenterPoints = 2;

        assertTrue(customer.statement().contains(String.valueOf(totalAmount)));
        assertTrue(customer.statement().contains(String.valueOf(frequentRenterPoints)));
    }


    @Test
    public void statement_should_add_one_and_half_times_per_day_if_rented_for_more_than_2_days_for_regular_movies(){
        Movie regularMovie = new Movie("movieTitle", Movie.REGULAR);
        Rental rental = new Rental(regularMovie, 3);

        customer.addRental(rental);
        double totalAmount = 3.5;
        int frequentRenterPoints = 1;

        assertTrue(customer.statement().contains(String.valueOf(totalAmount)));
        assertTrue(customer.statement().contains(String.valueOf(frequentRenterPoints)));
    }

    // for new release movies

    @Test
    public void statement_should_add_amount_as_multiplication_of_3_for_each_of_the_new_movies_per_days(){
        customer = new Customer(customerName);
        Movie regularMovie = new Movie("movieTitle", Movie.NEW_RELEASE);
        Rental rental = new Rental(regularMovie, 1);

        customer.addRental(rental);
        double totalAmount = 3.0;
        int frequentRenterPoints = 1;

        assertTrue(customer.statement().contains(String.valueOf(totalAmount)));
        assertTrue(customer.statement().contains(String.valueOf(frequentRenterPoints)));
    }

    @Test
    public void statement_should_add_one_point_for_new_releases_if_movies_are_rented_for_more_than_a_day(){
        customer = new Customer(customerName);
        Movie regularMovie = new Movie("movieTitle", Movie.NEW_RELEASE);
        Rental rental = new Rental(regularMovie, 2);

        customer.addRental(rental);
        double totalAmount = 6.0;
        int frequentRenterPoints = 2;

        assertTrue(customer.statement().contains(String.valueOf(totalAmount)));
        assertTrue(customer.statement().contains(String.valueOf(frequentRenterPoints)));
    }

    // for children movies

    @Test
    public void statement_should_add_one_and_half_to_amount_for_first_three_days_for_children_movies(){
        customer = new Customer(customerName);
        Movie regularMovie = new Movie("movieTitle", Movie.CHILDRENS);
        Rental rental = new Rental(regularMovie, 3);

        customer.addRental(rental);
        double totalAmount = 1.5;
        int frequentRenterPoints = 1;

        assertTrue(customer.statement().contains(String.valueOf(totalAmount)));
        assertTrue(customer.statement().contains(String.valueOf(frequentRenterPoints)));
    }

    @Test
    public void statement_should_add_one_and_half_to_amount_per_day_after_three_days_for_children_movies(){
        customer = new Customer(customerName);
        Movie regularMovie = new Movie("movieTitle", Movie.CHILDRENS);
        Rental rental = new Rental(regularMovie, 5);

        customer.addRental(rental);
        double totalAmount = 4.5;
        int frequentRenterPoints = 1;

        assertTrue(customer.statement().contains(String.valueOf(totalAmount)));
        assertTrue(customer.statement().contains(String.valueOf(frequentRenterPoints)));
    }
}
