package com.gridnine.testing;

public class Main {
    public static void main(String[] args) {
        FilterImp filterImp = new FilterImp();

        System.out.println(FlightBuilder.createFlights());
        System.out.println(filterImp.futureFlight(FlightBuilder.createFlights()));
        System.out.println(filterImp.arrivalAfterDeparture(FlightBuilder.createFlights()));
        System.out.println(filterImp.longFlight(FlightBuilder.createFlights()));
    }
}