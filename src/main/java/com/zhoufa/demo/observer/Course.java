package com.zhoufa.demo.observer;


import java.util.Observable;

public class Course extends Observable {

    private String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void produceQues(Course course, Question question){
        System.out.println(question.getUserName()+"在"+course.courseName+"提交了问题");
        setChanged();
        notifyObservers(question);
    }
}
