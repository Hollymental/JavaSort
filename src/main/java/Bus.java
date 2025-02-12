public class Bus implements Comparable<Bus>{
    private final String number; //номер
    private final String model; //модель
    private final int mileage; //пробег

    Bus(String number, String model, int mileage){
        this.number = number;
        this.model = model;
        this.mileage = mileage;
    }

    public String getNumber() {return number;} //получить номер

    public String getModel() {return model;} //получить модель

    public int getMileage() {return mileage;} //получить пробег

    public int compareTo(Bus other) {
        int result = this.number.compareTo(other.number);
        if (result == 0) {
            result = this.model.compareTo(other.model);
            if (result == 0) {
                return Integer.compare(this.mileage, other.mileage);
            }
        }
        return result;
    }

    public static class BusBuilder{
        private String number; //номер
        private String model; //модель
        private int mileage; //пробег

        public BusBuilder setNumber(String number){
            this.number = number;
            return this;
        }

        public BusBuilder setModel(String model){
            this.model = model;
            return this;
        }

        public BusBuilder setMileage(int mileage){
            this.mileage = mileage;
            return this;
        }

        public Bus build(){
            return new Bus(number, model, mileage);
        }
    }

}