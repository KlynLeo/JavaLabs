public class Drone extends Aircraft{
    private String batteryLife;
    private int numberOfGuns;

    public Drone(String model, int tailNumber, String batteryLife, int numberOfGuns) {
        super(model, tailNumber);
        this.batteryLife = batteryLife;
        this.numberOfGuns = numberOfGuns;
    }

    public int getNumberOfGuns() {
        return numberOfGuns;
    }

    public void setNumberOfGuns(int numberOfGuns) {
        this.numberOfGuns = numberOfGuns;
    }

    public String getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(String batteryLife) {
        this.batteryLife = batteryLife;
    }
}
