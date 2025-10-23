package org.example;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args){
        //BusinessDaysIterator
        System.out.println("BusinessDaysIterator: ");
        Iterator<LocalDate> iter = new BusinessDaysIterator(
                LocalDate.of(2022, 1, 1));

        System.out.println(iter.next());
        System.out.println(iter.next());
        System.out.println();


        //ZippingIterator
        System.out.println("ZippingIterator: ");
        List<Integer> listA = Arrays.asList(1, 2, 3, 4);
        List<String> listB = Arrays.asList("a", "b", "c");

        Iterator<Integer> iterA = listA.iterator();
        Iterator<String> iterB = listB.iterator();

        ZippingIterator<Integer, String, String> zipped = new ZippingIterator<>(
                iterA, iterB, (num, str) -> num + str);
        while (zipped.hasNext()) {
            System.out.println(zipped.next());
        }
        System.out.println();

        //BufferingIterator
        System.out.println("BufferingIterator: ");
        Iterator<List<Integer>> iterBuffer = new BufferingIterator<>(
                List.of(1, 2, 3, 4, 5).iterator(),
                3
        );

        while (iterBuffer.hasNext()) {
            List<Integer> batch = iterBuffer.next();
            System.out.println(batch);
        }
        System.out.println();

        //FlatteningIterator
        System.out.println("FlatteningIterator: ");
        Iterator<Integer> iterFlat = new FlatteningIterator<>(
                List.of(42, 5).iterator(),
                List.of(-4).iterator(),
                List.of(999, 998, 997).iterator()
        );

        while (iterFlat.hasNext()) {
            System.out.println(iterFlat.next());
        }
        System.out.println();
    }
}