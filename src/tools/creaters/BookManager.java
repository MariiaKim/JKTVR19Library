/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.creaters;

import entity.Book;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class BookManager {

    

    public Book addBook() {
        Book book = new Book();
        System.out.println("------зарегистрировать книгу------");
        System.out.println("введите инициал и автора:");
        Scanner scanner = new Scanner(System.in);
        book.setAuthor(scanner.nextLine());
        System.out.println("введите название:");
        book.setName(scanner.nextLine());
        System.out.println("введите дату:");
        do{
           String publishedYear =scanner.nextLine();
       try{
           book.setPublishedYear(Integer.parseInt(publishedYear));
           break;
       }catch(Exception e){
           System.out.println("введите цифру");
       }
       
         }while(true);
       
        return book;
    
}
    
    
}
