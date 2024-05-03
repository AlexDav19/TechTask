package com.gridnine.testing;

import java.util.List;

public interface Filter {
    List<Flight> futureFlight(List<Flight> flights);

    List<Flight> arrivalAfterDeparture(List<Flight> flights);

    List<Flight> littleWait(List<Flight> flights);

}
