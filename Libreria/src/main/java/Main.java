import ExecuteMenu.AuthorExecute;
import ExecuteMenu.BookExecute;
import Util.Utils;
import controller.AuthorController;
import entity.AuthorEntity;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        
        boolean session = true;
        while (session) {
            int option = Utils.integer("***** MENU *****\n1- Author.\n2- Book.\n3- Exit.");
            switch (option){
                case 1:
                    AuthorExecute.AuthorMenu();
                    break;
                case 2:
                    BookExecute.BookMenu();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Closing Session...");
                    session = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option.");
                    break;
            }
        }





    }
}
