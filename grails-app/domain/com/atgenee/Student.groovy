package com.atgenee

class Student implements Serializable {

    String stuName

    Integer age

    static constraints = {

    }

    static mapping = {
        version false
    }

    Student(String stuName, Integer age) {
        this.stuName = stuName
        this.age = age
    }


    @Override
    String toString() {
        return "Student{" +
                "id="+ id + ","+
                "stuName='" + stuName + '\'' +
                ", age=" + age +
                '}';
    }
}
