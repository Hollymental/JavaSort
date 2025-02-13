package Classes;

public class Student implements Comparable<Student>{
    private final String groupNumber; //номер группы
    private final double averageScore; //средний балл
    private final int recordBookNumber; //номер зачётной книжки

    Student(String groupNumber, double averageScore, int recordBookNumber){
        this.groupNumber = groupNumber;
        this.averageScore = averageScore;
        this.recordBookNumber = recordBookNumber;
    }

    public String getGroupNumber() {return groupNumber;} //получить номер группы

    public double getAverageScore() {return averageScore;} //получить средний балл

    public int getRecordBookNumber() {return recordBookNumber;} //получить номер зачётной книжки

    @Override
    public String toString() {
        return String.format("Student [ groupNumber: %-10s averageScore: %-7.2f recordBookNumber: %-5s ]"
                , groupNumber, averageScore, recordBookNumber);
    }

    public int compareTo(Student other){
        int result = this.groupNumber.compareTo(other.groupNumber);
        if (result == 0) {
            result = Double.compare(this.averageScore, other.averageScore);
            if (result == 0) {
                return Integer.compare(this.recordBookNumber, other.recordBookNumber);
            }
        }
        return result;
    }

    public static class StudentBuilder{
        private String groupNumber; //номер группы
        private double averageScore; //средний балл
        private int recordBookNumber; //номер зачётной книжки

        public StudentBuilder setGroupNumber(String groupNumber){
            this.groupNumber = groupNumber;
            return this;
        }

        public StudentBuilder setAverageScore(double averageScore){
            this.averageScore = averageScore;
            return this;
        }

        public StudentBuilder setRecordBookNumber(int recordBookNumber){
            this.recordBookNumber = recordBookNumber;
            return this;
        }

        public Student build(){
            return new Student(groupNumber, averageScore, recordBookNumber);
        }
    }

}