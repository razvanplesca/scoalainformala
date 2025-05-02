package org.example;


import lombok.Data;


import java.io.Serializable;

@Data
class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String lastName;
    private final String firstName;
    private final int day;
    private final int month;
    private final int year;

    @Override
    public String toString() {
        return getLastName() + " " + getFirstName() + " " + getDay() + "." + getMonth() + "." + getYear();
    }
}
