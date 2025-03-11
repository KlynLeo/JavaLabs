public class Airliner extends Aircraft implements PassengerCapable{
    private int capacity;
    private int wingSpan;

    public Airliner(String model, int tailNumber, int capacity, int wingSpan){
        super(model, tailNumber);
        this.capacity = capacity;
        this.wingSpan = wingSpan;
    }

    @Override
    public int getPassengerCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    public int getWingSpan() {
        return wingSpan;
    }

    public void setWingSpan(int wingSpan) {
        this.wingSpan = wingSpan;
    }
}
