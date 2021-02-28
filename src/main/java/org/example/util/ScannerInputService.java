package org.example.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;


public class ScannerInputService implements UserInputService {

    private UserInputService userInputService;

    Scanner scanner;

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getString() {
        String stringScanner = scanner.nextLine();
        System.out.println(stringScanner);
        return stringScanner;
    }

    @Override
    public int getInt() {
        int intScanner = scanner.nextInt();

        return intScanner;
    }

    @Autowired
    public void setUserInputService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }
}
