package Util;

import javax.swing.*;
import java.sql.Date;
import java.sql.Time;

public class Verification {
    public static int integer(String message){
        while(true){
            try{
                int number = Integer.parseInt(JOptionPane.showInputDialog(message));
                return number;
            } catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Por favor ingrese un número válido.");
            }
        }
    }
    public static String string (String message){
        while(true){
            String response = JOptionPane.showInputDialog(message);
            if(response == ""){
                JOptionPane.showMessageDialog(null,"No puede ingresar campos vacios.");
            }else{
                return response;
            }
        }
    }
    public static Date date() {
        while(true){
            String date = JOptionPane.showInputDialog("Fecha de salida (yyyy/mm/dd): ");
            try {
                Date date1 = Date.valueOf(date);
                return date1;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Por favor ingrese una fecha válida (yyyy-mm-dd).");
            }
        }
    }
    public static Time time() {
        while(true){
            String time = JOptionPane.showInputDialog("Hora de salida (HH:MM:SS): ");
            try {
                Time time1 = Time.valueOf(time);
                return time1;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Formato de hora incorrecto. Por favor ingrese una hora válida (HH:MM:SS).");
            }
        }
    }

}
