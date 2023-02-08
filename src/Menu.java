import java.util.Scanner;

/************************************************************
*==================COMMAND PATTERN==========================*
*************************************************************/

public abstract class Menu {

    String msg;
    String[] options;

    Command[] commands;

    /*validateInput - Validates user input
    * @param input - User input
    * @return boolean - Whether user input was valid or not
    */
    protected boolean validateInput(String input){

        int bound = options.length, selection;

        try{
            selection = Integer.parseInt(input);
        }
        catch (Exception e){
            System.out.println("Invalid input.");
            return false;
        }
        if(selection >= 1 && selection <= bound){return true;}

        System.out.println("Invalid input.");
        return false;
    }

    /*
    * diplay() - Displays the menu
    * @param void
    * @return void
    */
    public void display(){

        int num = 1;
        String input = "";
        Scanner scanner = new Scanner(System.in);

        System.out.println(msg);
        do{
            for(String o : options){
                System.out.println(String.valueOf(num) + ". " + o);
                num++;
            }
            num = 1;
            input = scanner.nextLine();
        }while(!validateInput(input));

        commands[Integer.parseInt(input)].execute();
    }

}
