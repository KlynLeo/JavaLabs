public class Freighter extends Aircraft implements CargoCapable{
    private int wingSpan;
    private int maxWeight;

    public Freighter(String model, int tailNumber, int wingSpan, int maxWeight){
        super(model, tailNumber);
        this.wingSpan = wingSpan;
        this.maxWeight = maxWeight;
    }

    public int getWingSpan() {
        return wingSpan;
    }

    public void setWingSpan(int wingSpan) {
        this.wingSpan = wingSpan;
    }
    @Override
    public int getCargoMaxCapacity() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }
}
