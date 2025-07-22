import java.util.Scanner;
import UI.*;
        
public class AppLoja {
    public static void main (String [] args){
        Scanner scanner = new Scanner(System.in);
        ConsoleMenu menu = new ConsoleMenu(scanner);
        menu.iniciarMenu();
    }
}
