package be.intecbrussel;

public class Student {

    private int id;
    private String name;
    private String lastName;
    private static int idCounter;

    public Student() {
    }

    public Student(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.id = ++idCounter;
    }

    public  int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Student: id=%d, name='%s', lastName='%s'", id, name, lastName);
    }
}
