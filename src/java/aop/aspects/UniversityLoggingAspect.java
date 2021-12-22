package aop.aspects;

import aop.Student;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {

//    @Before("execution(* getStudents())")
//    public void beforeGetStudentsLoggingAdvice() {
//        System.out.println("beforeGetStudentsLoggingAdvice: логгируем получение списка" +
//                "студентов перед методом getStudents");
//    }
//
//    @AfterReturning(pointcut = "execution(* getStudents())",
//                    returning = "students")
//    public void AfterReturningGetStudentsLoggingAdvice(List<Student> students) {
//        Student firstStudent = students.get(0);
//
//        String nameSurname = firstStudent.getNameSurname();
//        nameSurname = "Mr. " + nameSurname;
//        firstStudent.setNameSurname(nameSurname);
//
//        double avgGrade = firstStudent.getAvgGrade();
//        avgGrade = avgGrade+1;
//        firstStudent.setAvgGrade(avgGrade);
//
//        System.out.println("AfterReturningGetStudentsLoggingAdvice: логгируем получение списка" +
//                "студентов после метода getStudents");
//    }
//
//    @AfterThrowing(pointcut = "execution(* getStudents())",
//            throwing = "exception")
//    public void AfterThrowingGetStudentsLoggingAdvice(Throwable exception) {
//        System.out.println("AfterThrowingGetStudentsLoggingAdvice: " +
//                "логируем выборс исключения" + exception);
//    }

    @After("execution(* getStudents())")
    public void afterGetStudentsAdvice() {
        System.out.println("afterGetStudentsAdvice: " +
                "логируем нормальное завершение метода или выброс исключения");
    }

}
