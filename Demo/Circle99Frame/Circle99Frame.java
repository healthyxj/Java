import javax.swing.*;
import java.awt.*;

public class Circle99Frame extends JFrame {

    public void paint(Graphics graphics){
        graphics.drawString("Circle99", 20, 20);    //

        int x0 = getSize().width / 2;
        int y0 = getSize().height / 2;

        for(int r = 0; r < getSize().height / 2; r += 10){
            graphics.setColor(getRandomColor());
            graphics.drawOval(x0 -r, y0 - r, r * 2, r * 2);
        }
    }

    Color getRandomColor(){ //返回用RGB表示的颜色状态
        return new Color(
            (int)(Math.random() * 256),
            (int)(Math.random() * 256),
            (int)(Math.random() * 256)
        );
    }

}
