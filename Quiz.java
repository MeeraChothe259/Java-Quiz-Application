import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {
    
    String questions[][] = new String[10][5];
    String answers[][] = new String [10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno,question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;
    
    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
            
    String name;     
    Quiz(String name){
        this.name = name;
        setBounds(50,0,1440,850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1500, 415);
        add(image);

        

        
        qno = new JLabel("");
        qno.setBounds(100,450,50,30);
        qno.setFont(new Font("Tahoma",Font.PLAIN, 24));
        add(qno);
        
        question = new JLabel("");
        question.setBounds(150,450,900,30);
        question.setFont(new Font("Tahoma",Font.PLAIN, 24));
        add(question);
        
        questions[0][0] = "Which data type is used to store true or false values?";
        questions[0][1] = "int";
        questions[0][2] = "boolean";
        questions[0][3] = "float";
        questions[0][4] = "char";

        questions[1][0] = "Which symbol is used for comments in C/C++?";
        questions[1][1] = "//";
        questions[1][2] = "#";
        questions[1][3] = "<!--";
        questions[1][4] = "*";

        questions[2][0] = "What does a loop do in programming?";
        questions[2][1] = "Repeats a block of code";
        questions[2][2] = "Stops the program";
        questions[2][3] = "Defines variables";
        questions[2][4] = "Makes code slow";

        questions[3][0] = "What is the value of variable x after: x = 5; x += 3?";
        questions[3][1] = "3";
        questions[3][2] = "5";
        questions[3][3] = "8";
        questions[3][4] = "15";

        questions[4][0] = "Which of the following is a valid variable name?";
        questions[4][1] = "number#1";
        questions[4][2] = "1number";
        questions[4][3] = "class";
        questions[4][4] = "_number";

        questions[5][0] = " What is the correct syntax to output HELLO WORLD in Java?";
        questions[5][1] = "echo \"Hello World\";";
        questions[5][2] = "System.out.println(\"Hello World\");";
        questions[5][3] = " Console.WriteLine(\"Hello World\");";
        questions[5][4] = "print(\"Hello World\")";

        questions[6][0] = "Which of the following is not a programming language?";
        questions[6][1] = "HTML";
        questions[6][2] = "Python";
        questions[6][3] = "Java";
        questions[6][4] = "C++";

        questions[7][0] = "What is recursion?";
        questions[7][1] = "A loop inside another loop";
        questions[7][2] = "A function calling itself";
        questions[7][3] = "A function without parameters";
        questions[7][4] = "None of the above";

        questions[8][0] = "Which loop is guaranteed to execute at least once?";
        questions[8][1] = "do-while";
        questions[8][2] = "do";
        questions[8][3] = "for";
        questions[8][4] = "while";

        questions[9][0] = "Which one is not a loop in programming?";
        questions[9][1] = "if";
        questions[9][2] = "for";
        questions[9][3] = "while";
        questions[9][4] = "do-while";
        
        answers[0][1] = "boolean";
        answers[1][1] = "//";
        answers[2][1] = "Repeats a block of code";
        answers[3][1] = "8";
        answers[4][1] = "_number";
        answers[5][1] = "System.out.println(\"Hello World\");";
        answers[6][1] = "HTML";
        answers[7][1] = "A function calling itself";
        answers[8][1] = "do-while";
        answers[9][1] = "if";
        
        
        opt1 = new JRadioButton("");
        opt1.setBounds(170,520,700,30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);
        
        opt2 = new JRadioButton("");
        opt2.setBounds(170,560,700,30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);
        
        opt3 = new JRadioButton("");
        opt3.setBounds(170,600,700,30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);
        
        opt4 = new JRadioButton("");
        opt4.setBounds(170,640,700,30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);
        
        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);
        
        next = new JButton("Next");
        next.setBounds(1100,550,200,40);
        next.setFont(new Font("Tahoma",Font.PLAIN, 22));
        next.setBackground(new Color(30,144,255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100,630,200,40);
        lifeline.setFont(new Font("Tahoma",Font.PLAIN, 22));
        lifeline.setBackground(new Color(30,144,255));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);
        
        submit = new JButton("Submit");
        submit.setBounds(1100,710,200,40);
        submit.setFont(new Font("Tahoma",Font.PLAIN, 22));
        submit.setBackground(new Color(30,144,255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        start(count) ;
                
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == next){
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            
            ans_given = 1;
            if(groupoptions.getSelection() == null){
                useranswers[count][0] = "";
            }else{
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            if(count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
        }else if(ae.getSource() == lifeline){
            if(count == 2 || count == 4 || count == 6 || count == 8 || count == 9){
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            
        }else{
            opt1.setEnabled(false);
            opt4.setEnabled(false);
        }
        lifeline.setEnabled(false);
    }else if(ae.getSource() == submit){
        if(groupoptions.getSelection() == null){
                useranswers[count][0] = "";
            }else{
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
               for(int i = 0; i<useranswers.length;i++){
                 if(useranswers[i][0] != null && useranswers[i][0].equals(answers[i][1])){
                       score += 10;
                   }else{
                       score += 0;
                   }
               }
               setVisible(false);
               new Score(name, score);
               
    }
    }    
    public void paint(Graphics g){
        super.paint(g);
        
        String time = "Time left- " + timer + " seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));
        
        if(timer>0){
            g.drawString(time, 1100, 500);
        }else{
            g.drawString("Times up!", 1100, 500);
        }
        
        timer--;
        
        try{
            Thread.sleep(1000);
            repaint();
        }catch(Exception e){
            e.printStackTrace();
        }
        if(ans_given == 1){
            ans_given = 0;
            timer = 15;
        }else if(timer<0){
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            if(count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if(count == 9){
                if(groupoptions.getSelection() == null){
                useranswers[count][0] = "";
            }else{
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
               for(int i = 0; i<useranswers.length;i++){
                   if(useranswers[i][0] != null && useranswers[i][0].equals(answers[i][1])){
                       score += 10;
                   }
               }
               setVisible(false);
               new Score(name, score);
		return;
            }else{
                
            }
            if(groupoptions.getSelection() == null){
                useranswers[count][0] = "";
            }else{
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            count++;
            start(count);
        }
    }
                
   
    public void start(int count){
       qno.setText("" + (count + 1) + ". ");
       question.setText(questions[count][0]);
       opt1.setText(questions[count][1]);
       
       
       opt2.setText(questions[count][2]);
       opt2.setActionCommand(questions[count][2]);
       
       opt3.setText(questions[count][3]);
       opt3.setActionCommand(questions[count][3]);
       
       opt4.setText(questions[count][4]);
       opt4.setActionCommand(questions[count][4]);
       
       groupoptions.clearSelection();
    }
    public static void main(String[] args){
        new Quiz("User");
    }
}