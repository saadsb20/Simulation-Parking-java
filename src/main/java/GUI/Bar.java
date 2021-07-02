package GUI;

import javax.swing.*;
import java.awt.*;


public class Bar extends JLabel {

    ImageIcon bar ;
    int h ;
    int x;
    int y;
    public Bar()
    {
        bar=new ImageIcon("D:\\Project java\\src\\main\\java\\images\\bar.png");
        this.setIcon(bar);
        //Dimension size = this.getPreferredSize();
        this.x=200 ;
        this.y=10 ;
        this.h=300;
        setSize(27,this.h);
        setLocation(x,y);
    }



}