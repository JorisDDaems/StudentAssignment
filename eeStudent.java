package be.intecbrussel;

public class eeStudent {

    private static int idnumber;
    private String name;
    private String surname;
    private static int idcounter;

    public eeStudent(){}

    public eeStudent(String name, String surname){
        this.name = name;
        this.surname = surname;
        this.idnumber = idcounter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public static int getIdnumber() {
        return idnumber;
    }

}
