import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;

public class Driver {

    private static JFrame frame;

    private static void createAndShowGUI(){
        //Creates the content pane
        EntryGUI gui = new EntryGUI(new InputHandler());
        
    }

    public static void main(String[]args){
   
        System.out.println("Auto Channel Limited");//Frame Heading
        createAndShowGUI();
    }

    


}