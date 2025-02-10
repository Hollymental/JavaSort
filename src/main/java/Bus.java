public class Bus implements Comparable<Bus>{
    private final int number; //номер
    private final String model; //модель
    private final int mileage; //пробег

    Bus(int number, String model, int mileage){
        this.number = number;
        this.model = model;
        this.mileage = mileage;
    }

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

    public static class BusBuilder{
        private int number; //номер
        private String model; //модель
        private int mileage; //пробег

        public BusBuilder number(int number){
            this.number = number;
            return this;
        }

        public BusBuilder model(String model){
            this.model = model;
            return this;
        }

        public BusBuilder mileage(int mileage){
            this.mileage = mileage;
            return this;
        }

        public Bus build(){
            return new Bus(number, model, mileage);
        }
    }

}