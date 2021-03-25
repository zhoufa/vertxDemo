package com.zhoufa.demo.observer;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Observable;
import java.util.Observer;

@Data
@AllArgsConstructor
public class Teacher implements Observer {

    private String teacherName;

    @Override
    public void update(Observable o, Object arg) {
        Course course=(Course)o;
        Question question=(Question)arg;
        System.out.println(teacherName+"老师的"+course.getCourseName()+"课程接收到一个"+question.getUserName()+"提交的问答："+question.getQuestionContent());
    }
}
