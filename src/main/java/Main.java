import GUI.*;

import javax.swing.*;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws SQLException {
        Display.createDisplay();
        JFrame frame = new JFrame("Parking Simulator");
        parking panel = new parking();
        frame.setContentPane(panel);
        panel.setLayout(null);
        frame.setSize(1050, 520);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Bar bar = new Bar();


        Car c1 = new Car(1 , 30);
        panel.add(c1);
        Car c2 = new Car(2,80);
        panel.add(c2);
        Car c3 = new Car(3,140);
        panel.add(c3);
        panel.add(bar);


        Thread p1 = new Thread(new thread_sem.AccesVoiture(c1, 10000, TimeUnit.MILLISECONDS,bar), "voiture 1");
        Thread p2 = new Thread(new thread_sem.AccesVoiture(c2, 5000, TimeUnit.MILLISECONDS, bar), "voiture 2");
        Thread p3 = new Thread(new thread_sem.AccesVoiture(c3, 2000, TimeUnit.MILLISECONDS, bar), "voiture 3");
        p1.start();
        p2.start();
        p3.start();

        frame.setVisible(true);



    }

}
