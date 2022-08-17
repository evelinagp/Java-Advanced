package DefiningClasses6.DefiningClasses_GoogleEx07;

import java.util.ArrayList;
import java.util.List;

public class Person {
    // 1 кола, 1 компания, много родители, деца и покемони
    private String name;
    private Company company;
    private GoogleCar car;

    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon2> pokemons;

    public Person() {
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    public void setCar(GoogleCar car) {
        this.car = car;
    }


    public List<Pokemon2> getPokemons() {
        return this.pokemons;
    }

    public List<Parent> getParents() {
        return this.parents;
    }

    public List<Child> getChildren() {
        return this.children;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Company: ").append("\n");
        if (company != null) {
            sb.append(company.toString() + "\n");
        }
        sb.append("Car: ").append("\n");
        if (car != null) {
            sb.append(car.toString() + "\n");
        }
            sb.append("Pokemon:").append("\n");
            for (Pokemon2 pokemon2 : pokemons) {
                sb.append(pokemon2.toString()).append("\n");;
            }
            sb.append("Parents:").append("\n");
            for (Parent parent : parents) {
                sb.append(parent.toString()).append("\n");;
            }
            sb.append("Children:").append("\n");
            for (Child child : children) {
                sb.append(child.toString()).append("\n");;
            }
            return sb.toString();
        }


    }
