package com.thoughtworks.movierental;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("Adarsh");
        customer.addRental(new Rental(new Movie("Avenger", Movie.REGULAR), 2));
    }

    @Test
    public void statement_should_return_statement_for_customer() {
        assertEquals("Rental Record for Adarsh\n" +
                "\tAvenger\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points", customer.statement());
    }

    @Test
    public void htmlStatement_should_return_statement_as_html_string() {
        assertEquals("<h1>Rental Record for <b>Adarsh</b></h1><br/>" +
                "Avenger 2.0<br/>" +
                "Amount owed is <b>2.0</b><br/>" +
                "You earned <b>1</b> frequent renter points", customer.htmlStatement());
    }
}
