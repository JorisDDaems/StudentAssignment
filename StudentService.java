package be.intecbrussel;

public class StudentService {

    private Student[] students = new Student[getLengthOfArray()];
    private int lengthOfArray;
    private static final String ONLY_LETTERS = "[a-zA-z]+";

    public StudentService() {

    }

    public int getLengthOfArray() {
        return lengthOfArray;
    }

    public void setLengthOfArray(int lengthOfArray) {
        this.lengthOfArray = lengthOfArray;
    }

    private boolean present(Student s) {
        for (Student stu : students) {
            if (s.equals(stu)) {
                return true;
            }
        }
        return false;
    }

    private int getFreeLocation() {
        //return which slot is empty
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                return i;
            }
        }
        // Create new array & copy
        Student[] temp = new Student[students.length + getLengthOfArray()];
        for (int i = 0; i < students.length; i++) {
            temp[i] = students[i];
        }

        int location = students.length;
        students = temp;

        return location;
    }

    public void addStudents(Student student) {
        if (!present(student)) {
            int location = getFreeLocation();
            student.setName(capitalizeFirstLetter(student.getName()));
            student.setLastName(capitalizeFirstLetter(student.getLastName()));
            students[location] = student;
        }
    }

    public boolean isValidName(String name) {
        if (!name.matches(ONLY_LETTERS)) {
            System.out.println("Wrong entry! Please enter a valid name:");
        }
        return name.matches(ONLY_LETTERS);
    }

    public boolean isValidLastName(String lastName) {
        if (!lastName.matches(ONLY_LETTERS)) {
            System.out.println("Wrong entry! Please enter a valid last name:");
        }
        return lastName.matches(ONLY_LETTERS);
    }

    private String capitalizeFirstLetter(String name) {
        name = name.toLowerCase();
        char[] toCharArray = name.toCharArray();
        toCharArray[0] = Character.toUpperCase(toCharArray[0]);
        return new String(toCharArray);
    }

    public boolean editLastName(int id, String lastName) {
        for (Student s : students) {
            if (id == s.getId()) {
                s.setLastName(capitalizeFirstLetter(lastName));
                return true;
            }
        }
        return false;
    }

    public boolean isCorrectId(int id) {
        for (Student s : students) {
            if (id == s.getId()) {
                return true;
            }
        }
        return false;
    }

    public void sort() {
        Student temp;
        for (int i = 1; i < students.length; i++) {
            for (int j = i; j > 0; j--) {
                if (students[j].getName().compareTo(students[j - 1].getName()) < 0) {
                    temp = students[j];
                    students[j] = students[j - 1];
                    students[j - 1] = temp;
                }
            }
        }
    }

    public void printStudents() {
        for (Student s : students) {
            if (s != null) {
                System.out.println(s);
            }
        }
    }

    //another option
    public boolean isValidNumber(String number) {
        return number.matches("\\d+");
    }

}
