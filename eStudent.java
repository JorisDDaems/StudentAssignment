package be.intecbrussel;

public class eStudent {

    private eeStudent [] studentlist = new eeStudent[getLengtharray()];
    private int lengtharray;



    // getters and setters

    public int getLengtharray() {
        return lengtharray;
    }
    public void setLengtharray(int lengtharray) {
        this.lengtharray = lengtharray;
    }


    private boolean present(eeStudent s) {
        for (eeStudent student : studentlist) {
            if (s.equals(student)) {
                return true;
            }
        }
        return false;
    }

    private int getFreeLocation() {
        //return which slot is empty
        for (int i = 0; i < studentlist.length; i++) {
            if (studentlist[i] == null) {
                return i;
            }
        }
        // Create new array & copy
        eeStudent[] temp = new eeStudent[studentlist.length + getLengtharray()];
        for (int i = 0; i < studentlist.length; i++) {
            temp[i] = studentlist[i];
        }

        int location = studentlist.length;
        studentlist = temp;

        return location;
    }

    public void addStudents(eeStudent student) {
        if (!present(student)) {
            int location = getFreeLocation();
            student.setName(capitalizeFirstLetter(student.getName()));
            student.setSurname(capitalizeFirstLetter(student.getSurname()));
            studentlist[location] = student;
        }
    }


    private String capitalizeFirstLetter(String name) {
        name = name.toLowerCase();
        char[] toCharArray = name.toCharArray();
        toCharArray[0] = Character.toUpperCase(toCharArray[0]);
        return new String(toCharArray);
    }



    // methodes

    public boolean symbolCheck(String input){

        if (input == "[a-zA-Z]+"){
            return true;
        }
        return false;
    }




}
