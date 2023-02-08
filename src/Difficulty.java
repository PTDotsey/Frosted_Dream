import java.util.Scanner;

public class Difficulty extends Menu{

    Difficulty(){
        this.msg = "Select difficulty:";
        this.options = new String[] {"Easy", "Medium", "Hard","Quit"};
        this.commands = new Command[] {null, new MakeGame(1), new MakeGame(2),new MakeGame(3), new Quit()};
    }
}
