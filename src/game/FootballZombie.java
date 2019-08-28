package game;

import javax.swing.*;
import java.awt.*;

public class FootballZombie extends Zombie {

    public FootballZombie(int arr[]) {

        super(arr);
        speed = 3;
        health = 15;
        ImageIcon ii = new ImageIcon("img/zombie_football.gif");
        image = ii.getImage();
        makeRectangle();

    }

    private void makeRectangle() {

        rectangle = new Rectangle(locX + 25, locY + 28, 50, 200);

    }

    public void move() {
        locX -= speed;
        makeRectangle();
    }

}
