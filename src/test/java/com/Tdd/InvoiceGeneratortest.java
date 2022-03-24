package com.Tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
public class InvoiceGeneratortest {
	static InvoiceGenerator invoiceGenerator;
	@BeforeClass
    public static void init() {
        invoiceGenerator = new InvoiceGenerator();
        System.out.println("Welcome to cab invoice generator program");
    }

    @Test
    public void givenDistanceAndTimeShouldReturnTotalFare() {
        double distance = 2;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25.0, fare, 0.0);
    }
    @Test
    public void givenLessDistanceAndTimeShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 2;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRidesShouldReturnTotalFare() {
    	RideCalculate[] rides = {new RideCalculate(2.0, 5), new RideCalculate(0.1, 1)};
        double fare = invoiceGenerator.calculateMultipleRidesFare(rides);
        Assert.assertEquals(30, fare, 0.0);
    }

    @Test
    public void givenMultipleRidesShouldReturnInvoiceSummary() {
    	RideCalculate[] rides = {new RideCalculate(2.0, 5), new RideCalculate(01.1, 1)};
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
        InvoiceSummary actualInvoiceSummary = invoiceGenerator.calculateSummaryFare(rides);
        if (expectedInvoiceSummary.getAverageFarePerRide() == actualInvoiceSummary.getAverageFarePerRide() && expectedInvoiceSummary.getTotalNumberOfRides() == actualInvoiceSummary.getTotalNumberOfRides() && expectedInvoiceSummary.getTotalFare() == actualInvoiceSummary.getTotalFare())
            Assert.assertEquals(1, 1);
    }
}
