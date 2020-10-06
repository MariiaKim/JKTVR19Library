/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import entity.Reader;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class ReaderManager {

    /**
     *
     * @return
     */
    public Reader addReader() {
        Reader reader = new Reader();
        System.out.println("------зарегистрировать пользователя------");
        System.out.println("введите имя:");
        Scanner scanner = new Scanner(System.in);
        reader.setFistname(scanner.nextLine());
        System.out.println("введите фамилию:");
        reader.setLastname(scanner.nextLine());
        System.out.println("введите телефон:");
        reader.setPhone(scanner.nextLine());
        
        return reader;
    }
    
}
