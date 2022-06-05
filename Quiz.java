import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Quiz implements ActionListener             //for click events
{
       
    String[] questions={
                            "Father of  C  programming language",
                            "Which company created java",
                            "The lowest form of Computer language is called",
                            "Which year java created",
                            "A program in execution is called",
                            "Inventor of www(world wide web) is",
                            "who crated java",
                            "8-bit is :"
                        };
    String[][] options ={
                            {"Dennis Ritchie","Jhon Kemeny","Steve jobs", "Bill Gates"},
                            {"Sunmicrosystems","KFC","Facebook","Alphabet"},
                            {"BASIC","FORTRAN","Machine Language","COBOL"},
                            {"1992","1996","1972","1492"},
                            {"Process","Instruction","Procedure","Function"},
                            {"Bill Gates","Aryan","Tim Berners lee","Damini"},
                            {"Steve jobs","bill gates","james gosling ","mark zukerburk"},
                            {"Byte","Squad","Nibble","Word"}
                        };

    char[] answers=     {'A','A','D','B','A','C','C','A'};      //correct answers
    
    char answer;            //store the clicked button and match with index of answers
    int index;
    int correct_guesses=0;
    int TotalQ=questions.length;
    float result;

    Image i;        //class already defined in java
    

    int seconds=10;

    JFrame frame= new JFrame("ME BANUNGA CROREPATI");
    JTextField textfield= new JTextField();
    JTextArea textarea = new JTextArea();



    JButton buttonA=new JButton();
    JButton buttonB=new JButton();
    JButton buttonC=new JButton();
    JButton buttonD=new JButton();

    JLabel answer_labelA = new JLabel();
    JLabel answer_labelB = new JLabel();
    JLabel answer_labelC = new JLabel();
    JLabel answer_labelD = new JLabel();

    JLabel time_label = new JLabel();

    JLabel Sec_left = new JLabel();

    JTextField right=new JTextField();

    JTextField percentage=new JTextField() ;


    Timer timer =new Timer(1000, new ActionListener()
        {            

            public void actionPerformed(ActionEvent e)

            {
                seconds--;
                Sec_left.setText(Integer.toString(seconds));    //change int to string same as ... String.valueof(int)
                if (seconds<=0)
                    displayAnswer();

            }
        } 
          );
    Quiz()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,650);
        frame.getContentPane().setBackground(new Color(0,30,5));          //rgb values of color
        frame.setLayout(null);
        frame.setResizable(false);


        i=Toolkit.getDefaultToolkit().getImage("F:\\images\\quizblack.jpg");        //setting icon
        frame.setIconImage(i);


        textfield.setBounds(0,0,650,50);
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(255,25,0));
        textfield.setFont(new Font("Ink Free",Font.BOLD,30));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);


        textarea.setBounds(0,50,650,50);
        textarea.setBackground(new Color(25,25,25));
        textarea.setForeground(new Color(25,255,0));
        textarea.setFont(new Font("Algerian",Font.BOLD,25));
        textarea.setBorder(BorderFactory.createBevelBorder(1)); //gives brighter shade of current background
        textarea.setEditable(false);
         
        


        buttonA.setBounds(0,100,100,100);
        buttonA.setFont(new Font("Arial",Font.BOLD,35));
        buttonA.addActionListener(this);
        buttonA.setText("A");



        buttonB.setBounds(0,200,100,100);
        buttonB.setFont(new Font("Arial",Font.BOLD,35));
        buttonB.addActionListener(this);
        buttonB.setText("B");


        buttonC.setBounds(0,300,100,100);
        buttonC.setFont(new Font("Arial",Font.BOLD,35));
        buttonC.addActionListener(this);
        buttonC.setText("C");


        buttonD.setBounds(0,400,100,100);
        buttonD.setFont(new Font("Arial",Font.BOLD,35));
        buttonD.addActionListener(this);
        buttonD.setText("D");



        answer_labelA.setBounds(125,100,500,100);
        answer_labelA.setForeground(new Color(25,255,0));
        answer_labelA.setFont(new Font("chiller",Font.BOLD,45));
        



        answer_labelB.setBounds(125,200,500,100);
        answer_labelB.setForeground(new Color(25,255,0));
        answer_labelB.setFont(new Font("chiller",Font.BOLD,45));
        


        answer_labelC.setBounds(125,300,500,100);
        answer_labelC.setForeground(new Color(25,255,0));
        answer_labelC.setFont(new Font("chiller",Font.BOLD,45));
        

        answer_labelD.setBounds(125,400,500,100);
        answer_labelD.setForeground(new Color(25,255,0));
        answer_labelD.setFont(new Font("chiller",Font.BOLD,45));
        

        

        Sec_left.setBounds(535,510,100,100);
        Sec_left.setBackground(new Color(25,25,25));
        Sec_left.setForeground(new Color(0,0,255));;
        Sec_left.setFont(new Font("Ink Free",Font.BOLD,60));
        Sec_left.setBorder(BorderFactory.createBevelBorder(1));
        Sec_left.setOpaque(true);
        Sec_left.setHorizontalAlignment(JTextField.CENTER);     //set text in middle of label
        Sec_left.setText(String.valueOf(seconds));


        time_label.setBounds(535,475,100,25);
        time_label.setForeground(new Color(150,50,0));           
        time_label.setFont(new Font("Algerian",Font.ITALIC,17));
        time_label.setText("TIMMER<->");

        right.setBounds(225,225,200,100);
        right.setBackground(Color.black);
        right.setForeground(Color.green);
        right.setFont(new Font("Ink free",Font.BOLD,50));
        right.setBorder(BorderFactory.createBevelBorder(1));
        right.setHorizontalAlignment(JTextField.CENTER);
        right.setEditable(false);


        percentage.setBounds(225,326,200,100);
        percentage.setBackground(Color.black);
        percentage.setForeground(Color.green);
        percentage.setFont(new Font("Ink free",Font.BOLD,50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);



       


        frame.add(time_label);
        frame.add(Sec_left);


        frame.add(answer_labelA);
        frame.add(answer_labelB);
        frame.add(answer_labelC);
        frame.add(answer_labelD);


        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);

        frame.add(textarea);
        frame.add(textfield);
        frame.setVisible(true);

        

        nextQuestion();

    }

    public void nextQuestion()
    {
        if(index>=TotalQ)//8
        {
            results();
        }
        else
        {
            textfield.setText("Question "+(index+1));
            textarea.setText(questions[index]);
            answer_labelA.setText(options[index][0]);
            answer_labelB.setText(options[index][1]);
            answer_labelC.setText(options[index][2]);
            answer_labelD.setText(options[index][3]);

            timer.start();
        }

    }

    public void actionPerformed(ActionEvent e)
    {
      
        if (e.getSource()==buttonA)
        {
            answer='A';
            if (answer== answers[index])
            {
                correct_guesses++;
            }

        }


        if (e.getSource()==buttonB)
        {
            answer='B';
            if (answer== answers[index])
            {
                correct_guesses++;
            }

        }



        if (e.getSource()==buttonC)
        {
            answer='C';
            if (answer== answers[index])
            {
                correct_guesses++;
            }

        }


        if (e.getSource()==buttonD)
        {
            answer='D';
            if (answer== answers[index])
            {
                correct_guesses++;
            }

        }


        displayAnswer();
    }
    public void displayAnswer()
    {

        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);


        if(answers[index]!='A')
            answer_labelA.setForeground(Color.RED);
                          

        if(answers[index]!='B')
            answer_labelB.setForeground(Color.RED);

        if(answers[index]!='C')
            answer_labelC.setForeground(Color.RED);


        if(answers[index]!='D')
            answer_labelD.setForeground(Color.RED);





        Timer pause =new Timer(2000, new ActionListener()
        {           

            public void actionPerformed(ActionEvent e)

            {
                answer_labelA.setForeground(Color.green);
                answer_labelB.setForeground(Color.green);
                answer_labelC.setForeground(Color.green);
                answer_labelD.setForeground(Color.green);

                seconds=10;
                Sec_left.setText(String.valueOf(seconds));

                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);

                index++;

                nextQuestion();


            }
        }   );

        pause.setRepeats(false);        //calls the actionperformed method for only one time
        pause.start();
    }

    public void results()
    {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        result= (((float)correct_guesses/TotalQ)*100);

        textfield.setText("RESULTS! :");

        textarea.setText("                  BAHUT HII UMDA KHELE AAP :)");
        textarea.setForeground(new Color(200,15,200));
        answer_labelA.setText("");
        answer_labelB.setText("");
        answer_labelC.setText("");
        answer_labelD.setText("");

        right.setText("<"+correct_guesses+"/"+TotalQ+">");
        percentage.setText(result+"%");

        frame.add(right);
        frame.add(percentage);
       
    }

    public static void main(String args[])
    {
        new Quiz();          //making object of Quiz

    }

}