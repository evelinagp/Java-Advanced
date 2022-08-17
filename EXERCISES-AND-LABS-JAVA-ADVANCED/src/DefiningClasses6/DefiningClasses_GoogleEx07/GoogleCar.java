package DefiningClasses6.DefiningClasses_GoogleEx07;

public class GoogleCar {
    private String carModel;
    private int carSpeed;

    public GoogleCar(String carModel, int carSpeed) {
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }
    @Override
    public String toString(){
        return carModel + " " + carSpeed;
    }
}
