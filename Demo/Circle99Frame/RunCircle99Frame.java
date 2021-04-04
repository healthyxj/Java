import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class RunCircle99Frame {
    public static void main(String[] args) {
        JFrame frame = new Circle99Frame(); //多态方法表示一个对象
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}
