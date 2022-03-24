package com.Tdd;

public class InvoiceGenerator {
	
	private static final double MINIMUM_COST_PER_KM = 10.0;
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5;
/*
 * Step 1- Calculate Fare
 * Given Distance and Time
 * The invoice Generator should return total fare of the journy
 */
public double calculateFare(double distance, int time) {
		// TODO Auto-generated method stub
		double fare = distance*MINIMUM_COST_PER_KM+time*COST_PER_TIME;
        if(fare<MINIMUM_FARE) return MINIMUM_FARE;
        return fare;
    }
		
	/*
	 * Step 2 - Calculate Multiple Ride
	 * 
	 * invoice Generator now take in multiple rides and calculate the aggregate total of all rides
	 * 
	 */
public double calculateMultipleRidesFare(RideCalculate[] rides) {
    double fare = 0;
    for(int i = 0;i<rides.length;i++){
        fare+=calculateFare(rides[i].getDistance(),rides[i].getTime());
    }
    return fare;
}
/*
 * Step 3 - Enhance Invoice
 * The invoice Generator now return the following parts:-
 * 1) Total number of rides
 * 2) Total Fare
 * 3) average Fare per ride
 */
public InvoiceSummary calculateSummaryFare(RideCalculate[] rides) {
    double totalFare=0;
    for(RideCalculate ride : rides){
        totalFare+=calculateFare(ride.getDistance(),ride.getTime());
    }
    return new InvoiceSummary(rides.length, totalFare);
}
}
