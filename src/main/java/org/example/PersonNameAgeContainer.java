package org.example;

import java.util.Objects;

public class PersonNameAgeContainer {

    private String name;
    private int age;

    public PersonNameAgeContainer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonNameAgeContainer that = (PersonNameAgeContainer) o;
        return age == that.age && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override public String toString() {
        return "PersonNameAgeContainer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
