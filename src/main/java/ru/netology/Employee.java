package ru.netology;

public class Employee {
    public long id;
    public String firstName;
    public String lastName;
    public String country;
    public int age;

    public Employee() {

    }

    public Employee(long id, String firstName, String lastName, String country, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %s", id, firstName, lastName, country, age);
    }

    @Override
    public boolean equals(Object obj) {
        Employee e = (Employee) obj;
        return (e.id == this.id && firstName.equals(e.firstName) &&
                lastName.equals(e.lastName) && country.equals(e.country) &&
                this.age == e.age);
    }
}
