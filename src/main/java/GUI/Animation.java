package GUI;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fatah
 */
public class Animation {
    static boolean notExit=false ;

    public static void moveIN(Car c , int xMax)
    {
        if(notExit == true){
            while(c.x<=xMax)
            {
                c.x+=10;
                c.setLocation(c.x, c.y);
                try {
                    Thread.sleep(80);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
                }
                notExit=false;
            }
        }else{
            while(c.x<=xMax-130)
            {
                c.x+=10;
                c.setLocation(c.x, c.y);
                try {
                    Thread.sleep(80);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
                }
                notExit=true;
            }
        }

    }

    public static void parking(Car c)
    {
        while(c.y<=300)
        {
            c.setIconparking(c.car_id);
            c.y+=10;
            c.setLocation(c.x, c.y);
            try {
                Thread.sleep(80);
            } catch (InterruptedException ex) {
                Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public static void exitParking(Car c)
    {

        while(c.y>=80)
        {
            c.y-=10;
            c.setLocation(c.x, c.y);
            try {
                Thread.sleep(80);
            } catch (InterruptedException ex) {
                Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public static void moveOut(Car c)
    {
        while(c.x<=1080)
        {
            c.setIconExitparking(c.car_id);
            c.x+=10;
            c.setLocation(c.x, c.y);
            try {
                Thread.sleep(80);
            } catch (InterruptedException ex) {
                Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        c.x=90;
        c.y=260;

    }
    public static void BarUp(Bar c)
    {
        while(c.h<=300)
        {
            c.h+=10;
            c.setSize(27,c.h);
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    public static void BarDown(Bar c)
    {
        while(10<=c.h)
        {
            c.h-=10;
            c.setSize(27,c.h);
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }



}

