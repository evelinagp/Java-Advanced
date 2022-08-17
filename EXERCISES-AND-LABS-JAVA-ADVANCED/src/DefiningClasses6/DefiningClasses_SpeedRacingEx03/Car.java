package DefiningClasses6.DefiningClasses_SpeedRacingEx03;

public class Car {
    private String model;
    private double fuel;
    private double consumption;
    private int distance;

    public Car(String model, double fuel, double consumption) {
        this.model = model;
        this.fuel = fuel;
        this.consumption = consumption;
        this.distance = 0;
    }

    public boolean drive(int distanceToDrive) {
// разстояние -> колко гориво ще ни отнеме
        double needFuel = distanceToDrive * this.consumption;
        if (needFuel <= this.fuel) {
//            изминаваме разстоянието
            this.distance += distanceToDrive;
            this.fuel -= needFuel;
            return true;
        }
        return false;
    }
    public String toString (){
      return String.format("%s %.2f %d", this.model, this.fuel, this.distance);
    }
}



