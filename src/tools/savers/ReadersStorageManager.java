
package tools.savers;

import entity.Book;
import entity.Reader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pupil
 */
public class ReadersStorageManager {

    public void saveReadersToFile(Reader[] readers) {
        
        String fileName = "readers";
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        
        try {
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(readers);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Нет такого файла");
        } catch (IOException ex) {
            System.out.println("Ошибка ввода ввывода");
        }
    }
    public Reader[] loadReadersFromFile(){
        Reader[] readers = null;
        String fileName = "readers";
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
        fis = new FileInputStream(fileName);
        ois = new ObjectInputStream(fis);
        return (Reader[]) ois.readObject();
     } catch (FileNotFoundException ex) {
            System.out.println("Нет такого файла");
     } catch (IOException ex) {
            System.out.println("Ошибка ввода ввывода");
        } catch (ClassNotFoundException ex) {       
           System.out.println("Нет такого класса");
        }
        return readers;
    }

    

  
    
}
