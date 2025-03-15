import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GUI_FrontEnd extends JFrame implements ActionListener{
    //player button
    JButton rockButton, paperButton, scissorButton;

    //will display the choice of computerButton;
    JLabel computerChoice;

    //will display the score of computer and player
    JLabel computerScoreLabel, playerScoreLabel;

     //object of backend;
     rock_paper_scissor_BackEnd rockPaperScissor;


    public GUI_FrontEnd(){
    //invoke JFrame constructor to add title to the gui
    super("Rock Paper Scissor Game");

    //setting the size of gui
    setSize(700, 820);

    //set layout to null to disable layout management, so we can use absolute positioning for the element
    //setting x,y coordinates and width/height values.
    setLayout(null);

    //terminate the java virtual machine when closing the gui
    setDefaultCloseOperation(EXIT_ON_CLOSE);


    //setting gui to the centre
    setLocationRelativeTo(null);

    //initialize backend
    rockPaperScissor = new rock_paper_scissor_BackEnd();

    //add GUI components
    addGuiComponents();

    
    }

    private void addGuiComponents() {
        //create computer score label
        computerScoreLabel = new JLabel("Computer: 0");
      

        //set x,y cordinates and width/height values
        computerScoreLabel.setBounds(0, 43, 700, 30); 

        //set the font
        computerScoreLabel.setFont(new Font("Dailog", Font.BOLD, 26));

        //place the text in centre
        computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //add to GUI
        add(computerScoreLabel);

        //create computer choice
        computerChoice = new JLabel("Computer Choice");
        computerChoice.setBounds(200,118,200,150);
        computerChoice.setFont(new Font("Dailog", Font.BOLD, 16));
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);

        //create a Magenta border
        computerChoice.setBorder(BorderFactory.createDashedBorder(Color.magenta));
        computerChoice.setBorder(BorderFactory.createDashedBorder(Color.red, 50, 10));

        //add to GUI
        add(computerChoice);

        //create player score label;
        playerScoreLabel = new JLabel("Player : 0");
        playerScoreLabel.setBounds(175, 300, 300, 150);
        playerScoreLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //add to GUI
        add(playerScoreLabel);

        JLabel playerCalls = new JLabel("Select Your Choice!");
        playerCalls.setBounds(180, 350, 300, 150);
        playerCalls.setFont(new Font("Times New Roman", Font.BOLD, 20));
        playerCalls.setHorizontalAlignment(SwingConstants.CENTER);

        //add to GUI
        add(playerCalls);

        //player button
       
        //rockButton
        rockButton = new JButton("Rock");
        rockButton.setBounds(70, 450, 145, 100);
        rockButton.setFont(new Font("Times New Roman",  Font.ITALIC, 18));
        rockButton.addActionListener(this);

        //paperButton
        paperButton = new JButton("Paper");
        paperButton.setBounds(270, 450, 145, 100);
        paperButton.setFont(new Font("Times New Roman",  Font.ITALIC , 18));
        paperButton.addActionListener(this);

        //scissorButton
        scissorButton = new JButton("Scissor");
        scissorButton.setBounds(470, 450, 145, 100);
        scissorButton.setFont(new Font("Times New Roman",  Font.ITALIC , 18));
        scissorButton.addActionListener(this);

        //add buttons to GUI
        add(rockButton);
        add(paperButton);
        add(scissorButton);

       showDialog("Welcome to the Game...!");

    }
     
    //create a message dailog which will display result and a try agian button to play again;
    private void showDialog(String message){
        JDialog resultDailog = new JDialog(this, "Result", true);
        //owner refers to the parent object ehich in this case is GUI which is represented by "this" keyword,
        //title: refers to the title of title bar similar to the main GUI,
        //modal: refers to a property of a dailog that requires the user's immediate attention and blocks input to anything else util it is closed;
        //it is like we clicking outside of the pop-up window without closing it. 
        resultDailog.setSize(220, 250);
        resultDailog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultDailog.setResizable(true);

        //message label
        JLabel resultLabel = new JLabel(message);
        resultLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //add resultLabel to resultDailog
        resultDailog.add(resultLabel, BorderLayout.CENTER);

        //try again Button
        JButton tryAgain = new JButton("Click here to Play..!");
        tryAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //reset computer choice
                computerChoice.setText("Computer Choice");

                //close dailog box
                resultDailog.dispose();
            }
        });
        resultDailog.add(tryAgain , BorderLayout.SOUTH);

        resultDailog.setLocationRelativeTo(this);
        resultDailog.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        //get player choice
        String playerChoice = e.getActionCommand().toString();

        //play game and store result into string;
        String result = rockPaperScissor.RockPaperScissor(playerChoice);

        //update score;
        computerChoice.setText(rockPaperScissor.getComputerChoice());

        //update score
        computerScoreLabel.setText("Computer score :" + rockPaperScissor.getComputerScore());
        playerScoreLabel.setText("Player score : " + rockPaperScissor.getPlayerScore());

        //display result dailog
        showDialog(result);
    } 
}