/************************************************************
 *==================COMMAND PATTERN==========================*
 *************************************************************/

public class GameOptions extends Menu{
    GameOptions(){
        this.msg = "-----GAME OPTIONS-----";
        this.options = new String[] {"Select Difficulty","Return to Main Menu","Quit"};
        this.commands = new Command[] {null, new chooseDifficulty(), new openLauncher(), new Quit()};
    }
}
