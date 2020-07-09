import javax.swing.*;

public class main {

    private static JFrame window;

    public static void main(String[] args) {
        System.out.println("Starting game");
        createWindow();
    }

    private static void createWindow(){
        window = new JFrame("Ascii dungeon crawler");
        window.setVisible(true);
        window.setSize(100, 100);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
