package WumpusGame;
import java.util.Random;

public class Hero
{
    private int xPosition;
    private int yPosition;
    private char facingDirection;
    private boolean isAlive;
    private boolean hasTreasure;
    private int numArrows;

    public Hero(int initialX, int initialY)
    {
        xPosition = initialX;
        yPosition = initialY;
        numArrows = maxArrows;
        facingDirection = getRandomDirection();
        isAlive = true;
        hasTreasure = false;
    }

    public int getXPosition()
    {
        return xPosition;
    }

    public int getYPosition()
    {
        return yPosition;
    }

    public char getFacingDirection()
    {
        return facingDirection;
    }

    public int getNumArrows()
    {
        return numArrows;
    }

    public boolean isAlive()
    {
        return isAlive;
    }

    public boolean hasTreasure()
    {
        return hasTreasure;
    }

    public void rotateLeft()
    {
        switch (facingDirection)
        {
            case 'N':
                facingDirection = 'W';
                break;
            case 'W':
                facingDirection = 'S';
                break;
            case 'S':
                facingDirection = 'E';
                break;
            case 'E':
                facingDirection = 'N';
                break;
        }
    }

    public void rotateRight()
    {
        switch (facingDirection)
        {
            case 'N':
                facingDirection = 'E';
                break;
            case 'E':
                facingDirection = 'S';
                break;
            case 'S':
                facingDirection = 'W';
                break;
            case 'W':
                facingDirection = 'N';
                break;
        }
    }

    public void move(World world)
    {
        int newX = xPosition;
        int newY = yPosition;

        switch (facingDirection)
        {
            case 'N':
                newY--;
                break;
            case 'E':
                newX++;
                break;
            case 'S':
                newY++;
                break;
            case 'W':
                newX--;
                break;
        }

        if (newX >= 0 && newX < world.getSize() && newY >= 0 && newY < world.getSize())
        {
            char newPosition = world.getWorld()[newY][newX];
            if (newPosition != 'W')
            {
                xPosition = newX;
                yPosition = newY;

                if (newPosition == 'G')
                {
                    hasTreasure = true;
                    world.getWorld()[newY][newX] = ' ';
                }
            }
            else
            {
                isAlive = false;
            }
        }
    }

    public void shootArrow(World world)
    {
        if (numArrows > 0)
        {
            int x = xPosition;
            int y = yPosition;

            switch (facingDirection)
            {
                case 'N':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'S':
                    y++;
                    break;
                case 'W':
                    x--;
                    break;
            }

            if (x >= 0 && x < world.getSize() && y >= 0 && y < world.getSize())
            {
                char target = world.getWorld()[y][x];
                if (target == 'W')
                {
                    System.out.println("Legyozted Wumpust!");
                    world.getWorld()[y][x] = ' ';
                } else {
                    System.out.println("Elhibaztad!");
                }
            } else {
                System.out.println("Mit csinalsz?");
            }

            numArrows--;
            System.out.println("Neked " + numArrows + " nyilad maradt.");
        } else {
            System.out.println("Nem maradt nyilad.");
        }
    }

    private char getRandomDirection() {
        char[] directions = {'N', 'S', 'E', 'W'};
        Random random = new Random();
        int randomIndex = random.nextInt(directions.length);
        return directions[randomIndex];
    }
}