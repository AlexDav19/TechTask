package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



class FilterImp implements Filter {

    /**
     * Исключает вылеты до текущего момента времени.
     *
     * @return List<Flight>
     */
    @Override
    public List<Flight> futureFlight(List<Flight> flights) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            boolean check = true;
            for (int i = 0; i < flight.getSegments().size(); i++) {
                if (flight.getSegments().get(i).getDepartureDate().isBefore(LocalDateTime.now())) {
                    check = false;
                }
            }
            if (check) result.add(flight);
        }
        return result;
    }

    /**
     * Исключает сегменты с датой прилёта раньше даты вылета.
     *
     * @return List<Flight>
     */
    @Override
    public List<Flight> arrivalAfterDeparture(List<Flight> flights) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            boolean check = true;
            for (int i = 0; i < flight.getSegments().size(); i++) {
                if (flight.getSegments().get(i).getDepartureDate().isAfter(flight.getSegments().get(i).getArrivalDate())) {
                    check = false;
                }
            }
            if (check) result.add(flight);
        }
        return result;
    }

    /**
     * Исключает перелеты, где общее время, проведённое на земле, превышает два часа.
     *
     * @return List<Flight>
     */
    @Override
    public List<Flight> littleWait(List<Flight> flights) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            boolean check = true;
            int diffDate = 0;
            for (int i = 0; i < flight.getSegments().size() - 1; i++) {
                diffDate += flight.getSegments().get(i + 1).getDepartureDate().getHour() - flight.getSegments().get(i).getArrivalDate().getHour();
                if (diffDate > 2) {
                    check = false;
                }
            }
            if (check) result.add(flight);
        }
        return result;
    }
}
