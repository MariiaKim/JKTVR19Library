
package jktvr19library;

/**
 *
 * @author pupil
 */
public class JKTVR19Library {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String flag = "base";
        if(args.length > 0){
            flag = args[0];
        }
        App app = new App(flag);
        app.run();
    }
    
}
