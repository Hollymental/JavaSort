package model;

import java.util.Objects;

public class Bus implements Comparable<Bus> {
    private final int number;
    private final String model;
    private final int mileage;

    private Bus(BusBuilder builder) {
        this.number = builder.number;
        this.model = builder.model;
        this.mileage = builder.mileage;
    }

    public Integer getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

    @Override
    public int compareTo(Bus other) {
        int result = Integer.compare(this.number, other.number);
        if (result == 0) {
            result = this.model.compareTo(other.model);
            if (result == 0) {
                return Integer.compare(this.mileage, other.mileage);
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return  number == bus.number &&
                Objects.equals(model, bus.model) && mileage == bus.mileage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, model, mileage);
    }

    @Override
    public String toString() {
        return String.format("Bus [ number: %-10s model: %-10s mileage: %-7d ]", number, model, mileage);
    }

    public static class BusBuilder {
        private int number;
        private String model;
        private int mileage;

        public BusBuilder setNumber(int number) {
            this.number = number;
            return this;
        }

        public BusBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public BusBuilder setMileage(int mileage) {
            this.mileage = mileage;
            return this;
        }

        public Bus build() {
            return new Bus(this);
        }
    }
}
