package WumpusGame;
import java.util.Scanner;

public class Menu
{
    private World gameWorld;

    public Menu(World world)
    {
        this.gameWorld = world;
    }

    public void showMainMenu()
    {
        Scanner scanner = new Scanner(System.in);
        int userChoice;

        while (true)
        {
            System.out.println("=== Wumpus Jatek ===");
            System.out.println("1. Mentes");
            System.out.println("2. Betoltes");
            System.out.println("3. Vilag Szerkesztese");
            System.out.println("4. Kilepes");

            System.out.print("Kerem valasszon 1-4 kozott: ");
            userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice)
            {
                case 1:
                    gameWorld.printWorld();
                    break;
                case 2:
                    gameWorld.displayInitialInfo();
                    break;
                case 3:
                    editWorldMenu();
                    break;
                case 4:
                    System.out.println("Kilepes a jatekbol.");
                    System.exit(0);
                default:
                    System.out.println("Ervenytelen, Probalja ujra!");
                    break;
            }
        }
    }

    private String getMenuOption(int option)
    {
        String[] options =
        {
                "Mentes",
                "Betoltes",
                "Vilag Szerkesztes",
                "Kilepes"
        };
        return options[option - 1];
    }

    private void editWorldMenu()
    {
        Scanner scanner = new Scanner(System.in);
        int userChoice;

        while (true)
        {
            System.out.println("Vilag Szerkesztes:");
            for (int i = 1; i <= 4; i++)
            {
                System.out.println(i + ". " + getEditWorldOption(i));
            }
            System.out.print("Kerem valasszon: ");
            userChoice = scanner.nextInt();
            scanner.nextLine();
            handleEditWorldChoice(userChoice);
        }
    }

    private void handleEditWorldChoice(int userChoice)
    {
        switch (userChoice)
        {
            case 1:
                setWorldDifficulty("Konnyu");
                break;
            case 2:
                setWorldDifficulty("Normal");
                break;
            case 3:
                setWorldDifficulty("Nehez");
                break;
            case 4:
                return;
            default:
                System.out.println("Ervenytelen, Probalja ujra!");
                break;
        }
    }

    private void setWorldDifficulty(String difficulty)
    {
        int size;
        if ("Konnyu".equals(difficulty))
        {
            size = gameWorld.getRandomNumberEasy();
        } else if ("Normal".equals(difficulty)) {
            size = gameWorld.getRandomNumberNormal();
        } else if ("Nehez".equals(difficulty)) {
            size = gameWorld.getRandomNumberHard();
        } else {
            size = 0;
        }
        gameWorld = new World(size);
        System.out.println("A vilag nehezsege beallitva erre: " + difficulty + ".");
        gameWorld.play();
    }

    private String getEditWorldOption(int option)
    {
        String[] options =
        {
                "Konnyu",
                "Normal",
                "Nehez",
                "Vissza a Fomenube"
        };
        return options[option - 1];
    }
}