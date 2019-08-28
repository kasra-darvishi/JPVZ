package game;

import sounds.Sound;

import javax.swing.*;
import java.awt.*;

public class GradelPlant extends Plant {

    public GradelPlant(int arr[]) {

        super(arr);

        ii = new ImageIcon("img/Agarliclol.png");
        image = ii.getImage();
        ii = new ImageIcon("img/Agarliclol.png");
        preViewImage = ii.getImage();
        makeRectangle();
        health = 1;

    }

    private void makeRectangle() {

        height = image.getHeight(null);
        width = image.getWidth(null);
        rectangle = new Rectangle(locX, locY, 130, 150);

    }

    public void update(Row row) throws InterruptedException {

        if (row.firstZombie != null) {
            if (row.firstZombie.getRectangle().intersects(this.getRectangle())) {
                ImageIcon ii = new ImageIcon("img/zombie_barax.gif");
                row.firstZombie.image =  ii.getImage();
                row.firstZombie.speed = -1;
                Sound.playSound("Yuck.wav");
            }
        }
    }

}
