import java.util.Scanner;

/************************************************************
 *==================COMMAND PATTERN==========================*
 *************************************************************/

public class Launcher extends Menu{
    Launcher(){
        this.msg = "Welcome to Frosted Dream!";
        this.options = new String[] {"Play", "Leaderboard", "Quit"};
        this.commands = new Command[] {null, new openGameOptions(), new openLeaderboard(), new Quit()};
    }
}
