package org.example.config;


import org.example.data_access.StudentDao;
import org.example.data_access.StudentDaoListImpl;
import org.example.service.StudentManagement;
import org.example.service.StudentManagementConsoleImpl;
import org.example.util.ScannerInputService;
import org.example.util.UserInputService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration

public class AppConfig {

    @Bean("studentDao")
    public StudentDao studentDao() {
        return new StudentDaoListImpl();
    }


    @Bean("scanner")
    public Scanner scanner() {
        return new Scanner(System.in);
    }

    @Bean("userInputService")
    public UserInputService userInputService() {

        ScannerInputService scannerInputService = new ScannerInputService();
        scannerInputService.setScanner(scanner());
        return scannerInputService;
    }

    @Bean("studentManagement")
    public StudentManagement studentManagement() {
        StudentManagementConsoleImpl studentManagementConsole = new StudentManagementConsoleImpl();
        studentManagementConsole.setScannerService(userInputService());
        studentManagementConsole.setStudentDao(studentDao());

        return  studentManagementConsole;

    }


}
