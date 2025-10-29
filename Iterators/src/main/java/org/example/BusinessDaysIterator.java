package org.example;

import lombok.AllArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Iterator;

@AllArgsConstructor
public class BusinessDaysIterator implements Iterator<LocalDate> {
    private LocalDate current;

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public LocalDate next() {
        current = current.plusDays(1);
        while (isWeekend(current))
            current = current.plusDays(1);
        return current;
    }


    private boolean isWeekend(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }
}
