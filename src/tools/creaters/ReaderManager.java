

package tools.creaters;

import entity.Reader;
import entity.facade.ReaderFacade;
import factory.FacadeFactory;
import java.util.List;
import java.util.Scanner;
import tools.savers.FileManager;





public class ReaderManager {
    
    private ReaderFacade readerFacade = FacadeFactory.getReaderFacade();

    public Reader createReader() {
        Reader reader = new Reader();
        System.out.println("--- Зарегистрировать читателя ---");
        System.out.println("Введите имя:");
        Scanner scanner = new Scanner(System.in);
        reader.setFirstname(scanner.nextLine());
        System.out.println("Введите фамилию:");
        reader.setLastname(scanner.nextLine());
        System.out.println("Введите телефон:");
        reader.setPhone(scanner.nextLine());
        readerFacade.create(reader);
        return reader;
    }

    public void printListReaders() {
        List<Reader> listReaders = readerFacade.findAll();
        if(listReaders == null){
            System.out.println("Нет читателей");
            return;
        }
        for (Reader r : listReaders) {
            if(r != null){
                System.out.println(r.getId()+". "+r.toString());
            }
        }
    }
    
}
