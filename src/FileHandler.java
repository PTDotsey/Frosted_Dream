//Observer
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

//Source: https://www.w3schools.com/java/java_files_read.asp
public class FileHandler implements Observer{
    @Override
    public ArrayList<String> read(){
        ArrayList<String> lines = new ArrayList<>();
        try{
            File leaderboard = new File("leaderboard.txt");
            Scanner scan = new Scanner(leaderboard);
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                lines.add(line);
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return lines;
    }

    //Source: https://www.w3schools.com/java/java_files_create.asp
    @Override
    public void write(String name, int score){
        String val = String.valueOf(score);
        String line = name + ", " + val + "\n";
        try{
            FileWriter writer = new FileWriter("leaderboard.txt", true);
            writer.write(line);
            writer.close();
            System.out.println("FileWrite successful");
        }
        catch(IOException e){
            System.out.println("Oops. An error occurred while trying to write to file.");
            e.printStackTrace();
        }
    }

    public void update(String n, int s)
    {
        write(n, s);
    }

}
