import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//--OBSERVER--
public interface Observer {
    public ArrayList<String> read();

    //Source: https://www.w3schools.com/java/java_files_create.asp
    public void write(String name, int score);
}
