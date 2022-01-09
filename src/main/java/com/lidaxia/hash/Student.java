package com.lidaxia.hash;

import java.util.Locale;

/**
 * @author lidaxia
 * @version 1.0
 * @date 2022/1/9 19:55
 */
public class Student {
    int grade;
    int cls;
    String name;
    int age;

    public Student(int grade, int cls, String name, int age) {
        this.grade = grade;
        this.cls = cls;
        this.name = name;
        this.age = age;
    }


    @Override
    public int hashCode() {

        int B = 31;
        int hash = 0;
        hash = hash * B + grade;
        hash = hash * B + cls;
        hash = hash * B + name.hashCode();
        hash = hash * B + age;

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Student another = (Student) obj;
        return this.grade == another.grade &&
                this.cls == another.cls &&
                this.name.toLowerCase().equals(another.name.toLowerCase()) &&
                this.age == another.age;
    }
}
