package DefiningClasses6.DefiningClasses_CarSalesmanEx05;

public class Car1 {
    private String model;
    private String engineModel;
    private int weight;
    private String color;


    //   1. начин -> model,  engine;
    public Car1(String model, String engine) {
        this.model = model;
        this.engineModel = engine;
        this.color = "n/a";
        this.weight = 0;
    }

    //   2. начин -> model,  engine, weight, color;
    public Car1(String model, String engineModel, int weight, String color) {
        this(model, engineModel);
        this.weight = weight;
        this.color = color;
    }

    //   3. начин -> model,  engine, weight;
    public Car1(String model, String engineModel, int weight) {
        this(model, engineModel);
        this.weight = weight;
        this.color = "n/a";
    }

    //   4. начин -> model,  engine, color;
    public Car1(String model, String engineModel, String color) {
        this(model, engineModel);
        this.color = color;
        this.weight = 0;
    }

    public String getModel() {
        return model;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }
}
