import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppGraphicInOut {
    public static void main(String[] args) {
        new AppFrame();
    }
}

class AppFrame extends JFrame {
    JTextField in = new JTextField(10);
    JButton btn = new JButton("Yes, I'm sure!");
    JLabel out = new JLabel("Your input is ");

    public AppFrame(){
        setLayout(new FlowLayout());

        getContentPane().add(in);   //加入对象
        getContentPane().add(btn);
        getContentPane().add(out);

        btn.addActionListener(new BtnActionAdapter());  //处理事件
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    class BtnActionAdapter implements ActionListener{
        public void actionPerformed(ActionEvent e){ //具体处理事件
            String s = in.getText();
            double d = Double.parseDouble(s);
            double sq = d * d;
            out.setText(d + "'s square is " + sq);
        }
    }
}
