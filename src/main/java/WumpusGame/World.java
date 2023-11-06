package WumpusGame;
import java.util.Random;

public class World {
    private char[][] world;
    private int size;
    private int numWumpus;
    private Hero hero;
    private int goldX;
    private int goldY;

    public World(int size) {
        this.size = size;
        this.world = new char[size][size];
        this.hero = createHero();
        initializeWorld();
    }

    private Hero createHero() {
        Random random = new Random();
        int playerX = random.nextInt(size);
        int playerY = random.nextInt(size);
        return new Hero(playerX, playerY);
    }

    public Hero getHero() {
        return hero;
    }

    public char[][] getWorld() {
        return world;
    }

    public int getSize() {
        return size;
    }

    public void initializeWorld() {
        Random random = new Random();
        goldX = random.nextInt(size);
        goldY = random.nextInt(size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                world[i][j] = ' ';
            }
        }

        world[goldX][goldY] = 'G';
        placeCharacters('W', numWumpus);
    }

    private void placeCharacters(char character, int count) {
        Random random = new Random();
        int remainingCount = count;

        while (remainingCount > 0) {
            int x = random.nextInt(size);
            int y = random.nextInt(size);

            if (world[x][y] == ' ') {
                world[x][y] = character;
                remainingCount--;
            }
        }
    }
}