package Util;

import javax.swing.*;

public class Utils {
    public static int integer(String message) {
        while(true) {
            try {
                int option = Integer.parseInt(JOptionPane.showInputDialog(message));
                return option;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese una opcion válida.");
            }
        }
    }

    public static Float decimal (String message) {
        while(true) {
            try {
                float option = Float.parseFloat(JOptionPane.showInputDialog(message));
                return option;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un valor válido.");
            }
        }
    }

    public static String string (String message) {
        while(true) {
            try {
                String response = JOptionPane.showInputDialog(message);
                if(response != "") {
                    return response;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingresa datos válidos, no dejes campos vacion.");
            }
        }
    }
}
