package GUI;

import DB.CarDAO;
import DB.CarDB;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class Display {
     static JFrame frame1;
    static String[][] data;
    public static void createDisplay(){

        frame1 = new JFrame();
        JScrollPane sp = new JScrollPane(table());
        frame1.setTitle("Cars");
        frame1.add(sp);
        // Frame Size
        frame1.setSize(500, 200);
        frame1.setVisible(true);
    }
    public static JTable table(){
        data = setData();
        String[] head = {"car_id" , "Entrée" , "Sortie" };
        JTable table ;
        table = new JTable(data,head);
        table.setBounds(30, 500, 200, 300);
        return table;
    }


    public static String[][] setData(){
        ArrayList<CarDB> st = null;
        CarDAO carDAO = null;
        try {
            carDAO = new CarDAO();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            st =  carDAO.getAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String data[][] = new String[st.size()][6];

        int i = 0;
        for (CarDB car: st) {
            data[i][0] = String.valueOf(car.getCar_id());
            data[i][1] = String.valueOf(car.getTime_entrer());
            data[i][2] = String.valueOf(car.getTime_sortie());
            i++;
        }
        return data;
    }
    public static void reload(){

        frame1.getContentPane().removeAll();
        frame1.repaint();
        JScrollPane sp = new JScrollPane(table());
        frame1.add(sp);
        // Frame Size
        frame1.setBounds(1100,50,500, 200);
        frame1.setVisible(true);
    }
}
