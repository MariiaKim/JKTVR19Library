/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jktvr19library;

import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class App {
    private Scanner scanner = new Scanner(System.in);
    
    public void run(){
        System.out.println("---- Библиотека ----");
        boolean repeat = true;
        do{
            
        
        System.out.println("=============================");
        System.out.println("Задачи библиотеки");
        System.out.println("0.выйти из программы");
        System.out.println("1.Добавить книгу");
        System.out.println("2.посмотреть список книг");
        System.out.println("3.Добавить читателей");
        System.out.println("4. список читателей");
        System.out.println("5.выдать книгу");
        System.out.println("6.вернуть книгу");
        System.out.println("выбирите задачу: ");
        String task = scanner.nextLine();
        System.out.println("=============================");
        switch (task){
            case "0":
                System.out.println("-----конец программы------");
                repeat = false;
                break;
                    }
        switch (task){
            case "1":
                System.out.println("--Добавить книгу--");
                break;
                    }
        switch (task){
            case "2":
                System.out.println("--посмотреть список книг--");
                break;
                    }
        switch (task){
            case "3":
                System.out.println("--Добавить читателей--");
                break;
                    }
        switch (task){
            case "4":
                System.out.println("--список читателей--");
                break;
                    }
        switch (task){
            case "5":
                System.out.println("--выдать книгу--");
                break;
                    }
        switch (task){
            case "6":
                System.out.println("--вернуть книгу--");
                break;
                    }
        }while(repeat);
    }
}
