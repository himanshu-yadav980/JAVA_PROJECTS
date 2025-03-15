
import javax.swing.*;

public class app{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                //instantiate a RockPeper GUI object;
                GUI_FrontEnd gui = new GUI_FrontEnd();

                //display the gui
                gui.setVisible(true); 
                // gui.addGuiComponents(true);
            }
        });
    }
}