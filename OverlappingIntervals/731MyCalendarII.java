package OverlappingIntervals;

import java.util.Map;
import java.util.TreeMap;

// List Sweep Algorithm
class MyCalendarTwo {
    Map<Integer, Integer> bookingMap;
    int maxAllowedBookings;

    public MyCalendarTwo() {
        bookingMap = new TreeMap<Integer, Integer>();
        maxAllowedBookings = 2;
    }
    
    public boolean book(int startTime, int endTime) {
        bookingMap.put(startTime, bookingMap.getOrDefault(startTime, 0) + 1);
        bookingMap.put(endTime, bookingMap.getOrDefault(endTime, 0) - 1);

        int overlappingIntervals = 0;
        for (Map.Entry<Integer, Integer> entry: bookingMap.entrySet()) {
            overlappingIntervals += entry.getValue();
            if (overlappingIntervals > maxAllowedBookings) {
                bookingMap.put(startTime, bookingMap.get(startTime) - 1);
                bookingMap.put(endTime, bookingMap.get(endTime) + 1);

                if (bookingMap.get(startTime) == 0) {
                    bookingMap.remove(startTime);
                }
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */