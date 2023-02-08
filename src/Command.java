import java.security.DigestInputStream;
import java.util.Scanner;

/************************************************************
 *==================COMMAND PATTERN==========================*
 *************************************************************/

public interface Command {
    public void execute();
}

class openLauncher implements Command {
    public void execute(){
        Launcher launcher = new Launcher();
        launcher.display();
    }
}

class openGameOptions implements Command{
    @Override
    public void execute() {
        GameOptions gameOptions = new GameOptions();
        gameOptions.display();
    }
}

class Quit implements Command{
    @Override
    public void execute(){
        System.exit(0);
    }
}

class chooseDifficulty implements Command{
    public void execute(){
        Difficulty difficulty = new Difficulty();
        difficulty.display();
    }
}

class openLeaderboard implements Command{
    public void execute(){
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.display();
    }
}

class MakeGame implements Command{

    int diff = 0;
    String store = "", name = "";

    MakeGame(int difficulty){
        this.diff = difficulty;
    }

    /*
    * name - Gets the names for the player store and player based on parameter
    * @param - The type of name
    * @return name - The name
    */
    private String name(String type){
        Scanner scan = new Scanner(System.in);
        String name = "";
        boolean valid = false;
        while(!valid){
            System.out.println("Please enter the name of your " + type + " (1-20 characters)");
            name = scan.nextLine();
            int l = name.length();
            if(l > 0 && l < 21){
                valid = true;
            }
            else{
                System.out.println("Name is not between 1 and 20 characters");
            }
        }
        return name;
    }

    //makeGame execute() polymorphicly gathers necessary information to launch the game
    @Override
    public void execute(){
        store = name("store");
        name = name("player");
        Game game = new Game(diff, store, name);
        System.out.println("Difficulty = " + String.valueOf(diff));
        System.out.println("Store Name = " + this.store + "\nPlayer name = " + this.name);
        game.runGame();
    }
}
