package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class InvoiceServiceTest {

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculatefare(distance, time);
        Assertions.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculatefare(distance, time);
        Assertions.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_shouldReturnInvoiceSummary(){
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
       Ride[] rides = {new Ride(2.0 , 5),
                       new Ride(4.0,1)};
        InvoiceSummary summary = invoiceGenerator.calculatefare(rides);
        InvoiceSummary ExpectedInvoiceSummary = new InvoiceSummary(1, 30.0);
        Assertions.assertEquals(ExpectedInvoiceSummary , summary);
    }
    @Test
    public void GivenDistanceAndTimeForUserId_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        String userId = "John";
       Ride[] rides= {new Ride(2.0,5),
                        new Ride(0.11,1)
       };
        UserID.AddRide(userId, List.of(rides));
        InvoiceSummary summary = invoiceGenerator.calculatefare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assertions.assertEquals(expectedInvoiceSummary, summary);
    }

}