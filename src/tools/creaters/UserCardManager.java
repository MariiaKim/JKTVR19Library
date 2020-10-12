
package tools.creaters;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;



public class UserCardManager  {

    public History giveBook(Book[] books,Reader[] readers) {
        History history = new History();
        System.out.println(". список читателей");
         int t=0;
         for (Reader r : readers) {
             if(r != null){
                System.out.println(t+1+"."+r.toString());
                t++;
        }
         }
//        for(int i = 0;i < readers.length;i++){
//            if(readers[i] == null){
//                System.out.println(i+1+"."+readers[i].toString());
//               // t++;
//            }
//        }
        System.out.println("выберите номер читателя");
        Scanner scanner = new Scanner(System.in);
        int readerNumber = scanner.nextInt();
        Reader reader = readers[readerNumber - 1];
        System.out.println("===список книг====");
         int i = 0;
                for(Book b : books){
                    if (b != null){
                        System.out.println(i+1+"."+b.toString());
                        i++;
                    }
                }
        System.out.println("выберите номер книги");
        int bookNumber = scanner.nextInt();
        Book book = books[bookNumber -1];
        Calendar calendar = new GregorianCalendar();
        history.setBook(book);
        history.setReader(reader);
        history.setTakeOnDate(calendar.getTime());
        
        return history;
    }
    }


