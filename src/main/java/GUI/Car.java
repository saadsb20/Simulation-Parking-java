package GUI;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author fatah
 */
public class Car extends JLabel {

    ImageIcon car ;
    int car_id;
    int x;
    int y;
    public Car()
    {
        this.car_id=1;
        this.x=90 ;
        this.y=260 ;
        car=new ImageIcon("D:\\Project java\\src\\main\\java\\images\\car"+this.car_id+".png");
        this.setIcon(car);
        Dimension size = this.getPreferredSize();
        setBounds(x, y, size.width, size.height);

    }
    public Car(int id,int y)
    {
        this.car_id=id;
        this.x=20 ;
        this.y=y ;
        car=new ImageIcon("D:\\Project java\\src\\main\\java\\images\\car"+this.car_id+".png");
        this.setIcon(car);
        Dimension size = this.getPreferredSize();
        setBounds(x, y, size.width, size.height);
    }
    public int getCarId() {
        return car_id;
    }



    public void setIconparking(int i)
    {
        car=new ImageIcon("D:\\Project java\\src\\main\\java\\images\\car"+i+"1.png");
        this.setIcon(car);
        Dimension size = this.getPreferredSize();
        setBounds(x, y, size.width, size.height);
    }
    public void setIconExitparking(int i)
    {
        car=new ImageIcon("D:\\Project java\\src\\main\\java\\images\\car"+i+".png");
        this.setIcon(car);
        Dimension size = this.getPreferredSize();
        setBounds(x, y, size.width, size.height);
    }

}


