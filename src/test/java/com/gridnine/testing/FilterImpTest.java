package com.gridnine.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FilterImpTest {
    @InjectMocks
    FilterImp filterImp;

    @Test
    void futureFlightTest_success() {
        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)));
        List<Flight> expected = new ArrayList<>();
        expected.add(new Flight(segments));

        List<Flight> actual = filterImp.futureFlight(expected);
        Assertions.assertEquals(expected, actual);
        Assertions.assertNotNull(actual);
    }

    @Test
    void futureFlightTest_failed() {
        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment(threeDaysFromNow.minusDays(4), threeDaysFromNow.plusHours(2)));
        List<Flight> expected = new ArrayList<>();
        expected.add(new Flight(segments));

        List<Flight> actual = filterImp.futureFlight(expected);
        Assertions.assertNotEquals(expected, actual);
        Assertions.assertNotNull(actual);
    }

    @Test
    void arrivalAfterDepartureTest_success() {
        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)));
        List<Flight> expected = new ArrayList<>();
        expected.add(new Flight(segments));

        List<Flight> actual = filterImp.arrivalAfterDeparture(expected);
        Assertions.assertEquals(expected, actual);
        Assertions.assertNotNull(actual);
    }

    @Test
    void arrivalAfterDepartureTest_failed() {
        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment(threeDaysFromNow, threeDaysFromNow.minusHours(1)));
        List<Flight> expected = new ArrayList<>();
        expected.add(new Flight(segments));

        List<Flight> actual = filterImp.arrivalAfterDeparture(expected);
        Assertions.assertNotEquals(expected, actual);
        Assertions.assertNotNull(actual);
    }

    @Test
    void littleWaitTest_success() {
        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)));
        segments.add(new Segment(threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5)));
        List<Flight> expected = new ArrayList<>();
        expected.add(new Flight(segments));

        List<Flight> actual = filterImp.littleWait(expected);
        Assertions.assertEquals(expected, actual);
        Assertions.assertNotNull(actual);
    }

    @Test
    void littleWaitTest_failed() {
        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)));
        segments.add(new Segment(threeDaysFromNow.plusHours(6), threeDaysFromNow.plusHours(7)));
        List<Flight> expected = new ArrayList<>();
        expected.add(new Flight(segments));

        List<Flight> actual = filterImp.littleWait(expected);
        Assertions.assertNotEquals(expected, actual);
        Assertions.assertNotNull(actual);
    }
}
