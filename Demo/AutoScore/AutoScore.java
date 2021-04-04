import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutoScore extends JFrame {
    //构造方法
    public AutoScore(){
        init();
        setSize(400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);    //EXIT和DISPOSE的区别在于前者会同时关闭JVM，后者只会关闭当前窗口
        setVisible(true);
    }

    Button btnNew = new Button();   //创建新题目的按钮
    Button btnJudge = new Button(); //判断正误的按钮
    Label lblA = new Label();   //操作数1
    Label lblB = new Label();   //操作数2
    Label lblOp = new Label();  //运算符
    Label label5 = new Label(); //等于号
    TextField txtAnswer = new TextField();  //输入框
    List listDisp = new List(); //显示已经出过的题目

    //初始化
    public void init(){
        setLayout(null);
        setSize(400, 350);

        btnNew.setLabel("question");
        getContentPane().add(btnNew);
        btnNew.setBackground(Color.lightGray);
        btnNew.setBounds(36, 96, 98, 26);

        btnJudge.setLabel("judge");
        getContentPane().add(btnJudge);
        btnJudge.setBackground(Color.lightGray);
        btnJudge.setBounds(216, 96, 94, 25);

        lblA.setText("text");
        getContentPane().add(lblA);
        lblA.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblA.setBounds(36, 24, 36, 36);

        lblB.setText("text");
        getContentPane().add(lblB);
        lblB.setFont(new Font("Dialog", Font.PLAIN,20));
        lblB.setBounds(108, 24, 36, 36);

        lblOp.setText("text");
        getContentPane().add(lblOp);
        lblOp.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblOp.setBounds(72, 24, 36, 36);

        label5.setText("=");
        getContentPane().add(label5);
        label5.setFont(new Font("Dialog", Font.PLAIN, 20));
        label5.setBounds(168, 24, 36, 36);

        getContentPane().add(txtAnswer);
        txtAnswer.setFont(new Font("Dialog", Font.PLAIN, 20));
        txtAnswer.setBounds(216,24,85,42);

        listDisp.setFont(new Font("Dialog", Font.PLAIN, 16));
        getContentPane().add(listDisp);
        listDisp.setBounds(36,144,272,106);

        SymAction lSymAction = new SymAction();
        btnNew.addActionListener(lSymAction);
        btnJudge.addActionListener(lSymAction);
    }

    //判断响应源
    class SymAction implements ActionListener{
        public void actionPerformed(ActionEvent event){
            Object obj = event.getSource();
            if(obj == btnNew){
                btnNew_ActionPerformed(event);
            }else if(obj == btnJudge){
                btnJudge_ActionPerformed(event);
            }
        }
    }

    int a = 0, b = 0;
    String op = "";
    double result = 0;

    //出题
    public void btnNew_ActionPerformed(ActionEvent event){
        a = (int)(Math.random() * 9 + 1);
        b = (int)(Math.random() * 9 + 1);
        int c = (int)(Math.random() * 4);
        switch(c){
            case 0:
                op = "+";
                result = a + b;
                break;
            case 1:
                op = "-";
                result = a - b;
                break;
            case 2:
                op = "*";
                result = a * b;
                break;
            case 3:
                op = "/";
                result = a / b;
                break;
        }
        lblA.setText(" " + a);
        lblB.setText(" " + b);
        lblOp.setText(" " + op);
        txtAnswer.setText(" ");
    }

    //判正误
    public void btnJudge_ActionPerformed(ActionEvent event){
        String str = txtAnswer.getText();
        double d = Double.valueOf(str).doubleValue();
        String disp = "" + a + op + b + " = " + str + "";
        if(d == result){
            disp += "correct!";
        }else{
            disp += "wrong!";
        }
        listDisp.add(disp);
    }

}
