package ExceptionsAndErrorHanling.ExceptionsAndErrorHandling_CustomExceptionLab05;

public class Student {
    private String name;
    private String email;

    public Student(String name, String email) {
        this.setName(name);
        this.email = email;
    }

    private void setName(String name) {
        for (char symbol : name.toCharArray()) {
            if (!Character.isAlphabetic(symbol)){
                throw new InvalidPersonNameException("Name must contains only letters");
            }
        }
    }
}
