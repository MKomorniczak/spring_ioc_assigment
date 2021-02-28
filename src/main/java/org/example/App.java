package org.example;


import org.example.config.AppConfig;
import org.example.data_access.StudentDao;
import org.example.models.Student;
import org.example.service.StudentManagement;
import org.example.service.StudentManagementConsoleImpl;
import org.example.util.UserInputService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //StudentDao dao = context.getBean("studentDao", StudentDao.class);



        //UserInputService userInputService = context.getBean("userInputService", UserInputService.class);

        //StudentManagement studentManagement = context.getBean("studentManagement", StudentManagement.class);

        /*        Student TestCreateStudent = dao.save(new Student("Marek"));
        System.out.println(createdStudent);*/

        StudentManagement studentManagementConsole = context.getBean("studentManagement", StudentManagement.class);
        studentManagementConsole.create();

    }
}
