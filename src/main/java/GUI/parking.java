package GUI;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;


public class parking extends JPanel {

    ImageIcon image;
    static boolean[] blocEtat ;
    static Semaphore semaphoreEntree ;
    static Semaphore semaphoreSortie ;

    public parking(){
        semaphoreEntree =new Semaphore(1,true);
        semaphoreSortie =new Semaphore(1,false);
        blocEtat =new boolean[4];
        for(int i=0 ; i<blocEtat.length;i++)
        {
            blocEtat[i]=false ;
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        image =new ImageIcon("C:\\Users\\SAAD\\Downloads\\thread_sem\\img\\road.jpeg");
        image.paintIcon(this, g, WIDTH,WIDTH);

    }

}

