import java.util.Random;

public class rock_paper_scissor_BackEnd{
    private static final String computerChoices [] = {"Rock", "Paper", "Scissor"};

    //storing computer choice
    private String computerChoice;

    private int playerScore, computerScore;

    private Random random;

    public rock_paper_scissor_BackEnd(){
        random = new Random();
    }

    public String RockPaperScissor(String playerChoice){
        //generate computer choice
        computerChoice = computerChoices[random.nextInt(computerChoices.length)];
        String result;

        if(computerChoice.equals("Rock")){
            if(playerChoice.equals("Rock")){
                result = "Match draw";                
            }else if(playerChoice.equals("Paper")){
                result = "Player wins";
                playerScore++;
            }else{
                result = "Computer Wins";
                computerScore++;
            }
        }else if(computerChoice.equals("Paper")){
            if(playerChoice.equals("Paper")){
                result = "Match draws";
            }else if(playerChoice.equals("Rock")){
                result = "Computer wins";
                computerScore++;
            }else{
                result = "Player wins";
                playerScore++;
            }
        }else{
            if(playerChoice.equals("Scissor")){
                result = "Match draws";
            }else if(playerChoice.equals("Paper")){
                result = "Computer wins";
                computerScore++;
            }else{
                result = "Player wins";
                playerScore++;
            }
        }
        return result;
        
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public String getComputerChoice(){
        return computerChoice;
    }

    public int getComputerScore() {
        return computerScore;
    }
    
}