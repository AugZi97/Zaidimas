import javax.swing.*;
import java.awt.*;

public class brick {
    int bricksXPos[] = {50,350,450,550,50,300,350,450,550,150,150,450,550,
            250,50,100,150,550,250,350,450,550,50,250,350,550,
            50,150,250,300,350,550,50,150,250,350,450,550,50,
            250,350,550,150,350,150,500,450,300,600,400,350,200,0,200,500};

    int bricksYPos[] = {50,50,50,50,100,100,100,100,100,150,200,200,200,250,
            300,300,300,300,350,350,350,350,400,400,400,400,450,
            450,450,450,450,450,500,500,500,500,500,500,550,550,
            550,550,0,0,50,100,150,200,200,250,300,350,400,400,450};

    int brickON[] = new int[55];

    private ImageIcon breakBrickImage;

    public brick()
    {
        breakBrickImage=new ImageIcon("break_brick.jpg");

        for(int i=0; i< brickON.length;i++)
        {
            brickON[i] = 1;
        }
    }

    public void draw(Component c, Graphics g)
    {
        for(int i=0; i< brickON.length;i++)
        {
            if(brickON[i]==1)
            {
                breakBrickImage.paintIcon(c, g, bricksXPos[i],bricksYPos[i]);
            }
        }
    }

    public boolean checkCollision(int x, int y)
    {
        boolean collided = false;
        for(int i=0; i< brickON.length;i++)
        {
            if(brickON[i]==1)
            {
                if(new Rectangle(x, y, 10, 10).intersects(new Rectangle(bricksXPos[i], bricksYPos[i], 50, 50)))
                {
                    brickON[i] = 0;
                    collided = true;
                    break;
                }
            }
        }
        return collided;
    }
}