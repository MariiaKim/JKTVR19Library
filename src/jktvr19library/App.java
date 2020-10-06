/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jktvr19library;



import tools.ReadersStorageManager;
import tools.BookManager;
import tools.ReaderManager;
import entity.Reader;
import entity.Book;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class App {
    private  Scanner scanner = new Scanner(System.in);
    private  Reader[] readers = new Reader[10];
    private  Book[] books = new Book[10];

    public App() {
        ReadersStorageManager rsm = new ReadersStorageManager();
        readers = rsm.loadReadersFromFile();
    }
    
    
    
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
                    
        
            case "1":
                System.out.println("--Добавить книгу--");
                BookManager bookManager = new BookManager();
                Book book = bookManager.addBook();
                
               
                
                for(int s = 0;s < books.length;s++){
                    if(books[s] == null){
                        books[s]=book;
                        break;
                    }                   
                }      
                break;
                    
       
            case "2":
                System.out.println("--посмотреть список книг--");
                int i = 0;
                for(Book b : books){
                    if (b != null){
                        System.out.println(i+1+"."+b.toString());
                        i++;
                    }
                }
                break;
                    
        
            case "3":
                System.out.println("--Добавить читателей--");
                ReaderManager readerManager = new ReaderManager();
                Reader reader = readerManager.addReader();
                for(int p = 0;p < readers.length;p++){
                    if(readers[p] == null){
                        readers[p]=reader;
                        break;
                    }                   
                }  
                ReadersStorageManager readersStorageManager = new ReadersStorageManager();
                readersStorageManager.saveReadersToFile(readers);
                break;
                    
        
            case "4":
                System.out.println("--список читателей--");
                int j = 0;
                for(Reader r : readers){
                    if (r != null){
                        System.out.println(j+1+"."+r.toString());
                        j++;
                        
                    }
                }
                
                break;
                    
        
            case "5":
                System.out.println("--выдать книгу--");
                break;
                    
       
            case "6":
                System.out.println("--вернуть книгу--");
                break;
                    }
        }while(repeat);
    }
}
