package WumpusGame;
import java.util.Scanner;
import java.util.Random;
public class Main
{
    public static void main(String[] args)
    {
        World world = new World(5);
        Menu menu = new Menu(world);
        menu.showMainMenu();
    }
}