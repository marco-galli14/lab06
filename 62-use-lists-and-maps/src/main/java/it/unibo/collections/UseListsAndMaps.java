package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int START = 1000;
    private static final int END = 2000;
    private static final int ELEMS = 100_000;
    private static final long AFRICA = 1_110_635_000L;
    private static final long AMERICAS = 972_005_000L;
    private static final long ANTARCTICA = 0L;
    private static final long ASIA = 4_298_723_000L;
    private static final long EUROPE = 742_452_000L;
    private static final long OCEANIA = 38_304_000L;
    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = START; i < END; i++) {
            a.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addAll(a);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int appoggio = a.getLast();
        a.set((a.size() - 1), a.getFirst());
        a.set(0, appoggio);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */

        for(int elem : a) {
            System.out.println(elem);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for(int i = 0 ; i < ELEMS; i++) {
            a.addFirst(i);
        }
        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Inserting "
                + ELEMS
                + " elements as first element in an Array List took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        long tem = System.nanoTime();
        for(int i = 0 ; i < ELEMS; i++) {
            ll.addFirst(i);
        }
        tem = System.nanoTime() - tem;
        final var mil = TimeUnit.NANOSECONDS.toMillis(tem);
        System.out.println(// NOPMD
            "Inserting "
                + ELEMS
                + " elements as first element in a Linked List took "
                + tem
                + "ns ("
                + mil
                + "ms)"
        );
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = System.nanoTime();
        final int misura = (a.size() / 2);
        for(int i = 0 ; i < START; i++) {
            a.get(misura);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Reading "
                + START
                + " times an element in the middle of an Array List took"
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        time = System.nanoTime();
        for(int i = 0 ; i < START; i++) {
            ll.get(misura);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Reading "
                + START
                + " times an element in the middle of a Linked List took"
                + time
                + "ns ("
                + millis
                + "ms)"
        );
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String, Long> mappa = new HashMap<>();
        mappa.put("Africa", AFRICA);
        mappa.put("Americas", AMERICAS);
        mappa.put("Antarctica", ANTARCTICA);
        mappa.put("Asia", ASIA);
        mappa.put("Europe", EUROPE);
        mappa.put("Oceania", OCEANIA);
        /*
         * 8) Compute the population of the world
         */
        long ris = 0L;
        for(Long elem : mappa.values()) {
            ris = ris + elem;
        }
        System.out.println("The population of the World is: " + ris);
    }
}
