package Camparators;

import Clases.Bus;

public class BusComporators {
    public static class SortByNumber implements ComparatorStrategy<Bus> {
        @Override
        public int compare(Bus b1, Bus b2) {
            return b1.getNumber().compareTo(b2.getNumber());
        }
    }

    public static class SortByModel implements ComparatorStrategy<Bus> {
        @Override
        public int compare(Bus b1, Bus b2) {
            return b1.getModel().compareTo(b2.getModel());
        }
    }

    public static class SortByMileage implements ComparatorStrategy<Bus> {
        @Override
        public int compare(Bus b1, Bus b2) {
            return Integer.compare(b1.getMileage(), b2.getMileage());
        }
    }
}
