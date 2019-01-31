package com.thoughtworks.movierental;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;


public class CustomerTest {

    private Customer customer;
    private String customerName;

    @Before
    public void setUp() throws Exception {
        customerName = "Adarsh";
        customer = new Customer(customerName);
        customer.addRental(new Rental(new Movie("Avenger", Movie.REGULAR), 2));
    }

    // when there is no rental
    @Test
    public void statement_should_return_footer_lines_with_0_amount_if_there_is_no_rental() {
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
