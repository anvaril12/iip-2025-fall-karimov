import elevator.api.ElevatorService;
import elevator.impl.cmd.ElevatorCore;

import java.util.ArrayList;
import java.util.List;
public class myElevatorService extends ElevatorService {
    private List<Integer> targetFloors = new ArrayList<>();
    private boolean isMovingUp = true;
    private long lastActionTime = System.currentTimeMillis();
    private boolean isACEnabled = false;

    @Override
    public void handleInsideKeyPress(InsideKeyInput info) {
        ElevatorCore elevator = coreModule.getElevator(0);

        switch (info.getType()) {

            case FlOOR_NUMBER:
                int targetFloor = info.getFloorNumber();
                addTargetFloor(targetFloor);
                break;

            case SIGNAL_DOOR_OPEN:
                if (elevator.getElevatorState() == ElevatorState.WAITING_CLOSED) {
                    elevator.openDoors();
                }
                break;

            case SIGNAL_DOOR_CLOSE:
                if (elevator.getElevatorState() == ElevatorState.WAITING_CLOSED) {
                    elevator.closeDoors();
                }
                break;

            case AC_CHANGE:
                isACEnabled = !isACEnabled;
                elevator.setAirConditioningEnabled(isACEnabled);
                break;

            case SIGNAL_ALARM:
                simulateAlarmCall();
                break;

            case SIGNAL_DISCARD:
                targetFloors.clear();
                break;
        }
        lastActionTime = System.currentTimeMillist();
        processNextMove();
    }

    @Override
    public void handleOutsideKeyPress(elevator.api.OutsideKeyInput info) {
        int callingFLoor = info.getFloor();
        addTargetFloor(callingFloor);
        ElevatorCore elevator = coreModuleGetElevator(0);
        int currentFloor = elevator.getCurrentFloor();
        isMovingUp = callingFLoor > curretnFloor;
        lastActionTime = System.currentTimeMillis();
        processNextMove();
    }
    private void addTargetFloor(int floor) {
        if (!targetFloors.contains(floor)) {
            targetFloors.add(floor);
            targetFloors.sort(Integer::compareTo);
        }
    }
    private void processNextMove() {
        ElevatorCore elevator = CoreModule.getElevator(0);
        if(targetFloors.isEmpty()) {
            startIdleTimer();
            return;
        }

        int currentFloor = elevator.getElevatorFloor();
        ElevatorState currentState = elevator.getElevatorState();
        if(currentState == elevator.MOVING_DOWN || currentState == elevator.MOVING_UP) {
            return;
        }
        int nextFloor = findNextFloor(currentFloor);
        if(nextfloor != -1) {
            if(nextFloor == currentFloor) {
                openDoorsAndProcess(nextFloor);
            } else {
                moveToFloor(nextFloor);
            }
        }
    }
    private void startIdleTimer() {
        new Thread(() -> {
            try {
                Thread.sleep(10000);
                if(System.currentTimeMillis() - lastActionTime >= 10000) {
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
    private int findNextfloor(int currentFloor) {
        if(targetFloors.isEmpty()) return -1;
        if (isMovingUp) {
            for (int floor : targetFloors) {
                if (floor >= currentFloor) return floor;
            }
        } else {
            for (int i = targetFloors.size() - 1;i >= 0; i--) {
                if (targetFloors.get(i) <= currentFloor) return targetFloors.get(i);
            }
        }
        isMovingUp = !isMovingUp;
        return findNextFloor(currentFloor);
    }
    private void moveToFloor(int targetFloor) {
        ElevatorCore elevator = coreModule.getElevator(0);

        new Thread(() -> {
            try {
                if (elevator.getElevatorState() == ElevatorState.WAITING_OPENED) {
                    elevator.closeDoors();
                    Thread.sleep(2000);
                }
                // Ждём ещё 1 секунду перед началом движения
                Thread.sleep(1000);
                // Отправляем лифт на целевой этаж
                elevator.moveToFloor(targetFloor);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void openDoorsAndProcess(int floor) {
        targetFloors.remove(Integer.valueOf(floor));
        ElevatorCore elevator = coreModule.getElevator(0);
        if (elevator.getElevatorState() == ElevatorState.WAITING_CLOSED) {
            elevator.openDoors();
        }
        startAutoCloseTimer();
    }
    private void startAutoCloseTimer() {
        new Thread(() -> {
            try {
                Thread.sleep(5000);
                ElevatorCore elevator = coreModule.getElevator(0);
                if (elevator.getElevatorState() == ElevatorState.WAITING_OPENED) {
                    elevator.closeDoors();
                    Thread.sleep(2000);
                    processNextMove();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
    private void simulateAlarmCall() {
        new Thread(() -> {
            try {
                Thread.sleep(3000);
                coreModule.getElevator(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
