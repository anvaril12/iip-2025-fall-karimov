package impl.logic;

import impl.GameService;
import impl.model.PixelColor;
import java.util.ArrayList;
import java.util.Random;

public class AvoidRedSquaresGameLogic implements GameLogic {
    private final PixelColor COLOR_BG = new PixelColor(0, 0, 0);
    private final PixelColor COLOR_PLAYER = new PixelColor(0, 255, 0);
    private final PixelColor COLOR_ENEMY = new PixelColor(255, 0, 0);

    private int playerX;
    private int playerY;
    
    private ArrayList<int[]> enemies;

    private int width = GameService.PIXELS_COUNT_W;
    private int height = GameService.PIXELS_COUNT_H;

    private Random random = new Random();
    private boolean gameOver = false;

    @Override
    public void init() {
        playerX = width / 2;
        playerY = height / 2;

        enemies = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            addEnemy();
        }

        gameOver = false;
    }

    private void addEnemy() {
        int x, y;
        int side = random.nextInt(4);

        if (side == 0) {
            x = random.nextInt(width);
            y = 0;
        } else if (side == 1) {
            x = width - 1;
            y = random.nextInt(height);
        } else if (side == 2) {
            x = random.nextInt(width);
            y = height - 1;
        } else {
            x = 0;
            y = random.nextInt(height);
        }

        int speedX = random.nextInt(3) - 1;
        int speedY = random.nextInt(3) - 1;

        if (speedX == 0 && speedY == 0) {
            speedX = 1;
        }

        enemies.add(new int[]{x, y, speedX, speedY});
    }

    @Override
    public void loop(PixelColor[][] pixels) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pixels[y][x] = COLOR_BG;
            }
        }

        if (gameOver) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    pixels[y][x] = COLOR_ENEMY;
                }
            }
            return;
        }

        for (int i = 0; i < enemies.size(); i++) {
            int[] enemy = enemies.get(i);

            enemy[0] += enemy[2];
            enemy[1] += enemy[3];

            if (enemy[0] <= 0 || enemy[0] >= width - 1) {
                enemy[2] = -enemy[2];
            }
            if (enemy[1] <= 0 || enemy[1] >= height - 1) {
                enemy[3] = -enemy[3];
            }
            if (enemy[0] >= 0 && enemy[0] < width && enemy[1] >= 0 && enemy[1] < height) {
                pixels[enemy[1]][enemy[0]] = COLOR_ENEMY;
            }
            if (Math.abs(enemy[0] - playerX) <= 1 && Math.abs(enemy[1] - playerY) <= 1) {
                gameOver = true;
                GameService.finishGame("Игра окончена",
                        "Вы коснqулись красного квадрата!\nНажмите Enter для новой игры.",
                        false);
            }
        }
        if (playerX >= 0 && playerX < width && playerY >= 0 && playerY < height) {
            pixels[playerY][playerX] = COLOR_PLAYER;
        }

        if (random.nextInt(100) < 5) { // 5% шанс каждый кадр
            addEnemy();
        }
    }

    @Override
    public void handleKeyPress(int keyCode) {
        if (gameOver) {
            if (keyCode == 10) {
                init();
            }
            return;
        }
        switch (keyCode) {
            case 37:
            case 65:
                if (playerX > 0) playerX--;
                break;
            case 38:
            case 87:
                if (playerY > 0) playerY--;
                break;
            case 39:
            case 68:
                if (playerX < width - 1) playerX++;
                break;
            case 40:
            case 83:
                if (playerY < height - 1) playerY++;
                break;
            case 82:
                init();
                break;
        }
    }
}