import codewars.api.Robot;
import codewars.impl.cmd.RobotWithWorldCreation;
import java.util.Random;
import static codewars.api.Rotation.LEFT;
import static codewars.api.Rotation.RIGHT;

public class myProgramm {
    public static void main(String[] args) {
        Robot robot = new RobotWithWorldCreation("/Users/anvarkarimov/Downloads/map1.rmc");
        robot.setSpeed(10);

        Random random = new Random();

        while (robot.collectedItemsCount() < robot.totalItemsCount()) {
            int action = random.nextInt(10);

            if (action <= 7) {
                if (!robot.hasObstacle()) robot.move(1);
            } else if (action == 8) {
                robot.rotate(RIGHT);
                if (!robot.hasObstacle()) robot.move(1);
            } else {
                robot.rotate(LEFT);
                if (!robot.hasObstacle()) robot.move(1);
            }
        }
        robot.finish();
    }
}
