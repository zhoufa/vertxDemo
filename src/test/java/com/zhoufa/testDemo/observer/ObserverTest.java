package com.zhoufa.testDemo.observer;

import com.zhoufa.demo.observer.Course;
import com.zhoufa.demo.observer.Question;
import com.zhoufa.demo.observer.Teacher;
import org.junit.Test;

public class ObserverTest {

    @Test
    public void testObserver() {
        Course course=new Course("Java设计模式精讲");
        Teacher teacher=new Teacher("laoshi");
        course.addObserver(teacher);

        Question question=new Question();
        question.setUserName("Geelly");
        question.setQuestionContent("Java");

        course.produceQues(course,question);
    }

}
