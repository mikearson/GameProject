package com.company;

public class Person implements Comparable<Person> {

    private String firsName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firsName = firstName;
        this.lastName = lastName;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return lastName + " " + firsName;
    }

    @Override
    public int compareTo(Person other) {
        int cmp;
        if(0 != (cmp = lastName.compareTo(other.lastName))) {
            return cmp;
        }
        if(0 != (cmp = firsName.compareTo(other.firsName))) {
            return cmp;
        }
        return 0;
    }
}
