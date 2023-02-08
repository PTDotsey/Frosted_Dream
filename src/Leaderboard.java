import java.util.ArrayList;
import java.util.Arrays;

/************************************************************
 *==================COMMAND PATTERN==========================*
 *************************************************************/

public class Leaderboard extends Menu{
    Leaderboard(){
        this.msg = "-----LEADERBOARD-----";
        this.options = new String[] {"Return to Main Menu","Quit"};
        this.commands = new Command[] {null, new openLauncher(), new Quit()};
    }

    @Override
    public void display(){
        FileHandler fh = new FileHandler();
        ArrayList<String> scores = fh.read();
        System.out.println("======Lower Scores are Higher======");
        for(String s : scores){
            System.out.println(s);
        }
        super.display();
    }
}
