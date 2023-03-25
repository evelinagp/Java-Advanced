package DefiningClasses6.Ex.DefiningClasses_GoogleEx07;

public class Child {
    private String childName;
    private String childBirthday;

    public Child(String childName, String childBirthday) {

        this.childName = childName;
        this.childBirthday = childBirthday;
    }
    @Override
    public String toString(){
        return childName + " " + childBirthday;
    }
}
