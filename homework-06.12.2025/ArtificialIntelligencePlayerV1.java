package impl;
import java.util.*;

public class ArtificialIntelligencePlayerV1 extends AbstractPlayer {

    @Override
    public void doTurn() {
        System.out.println("ArtificialIntelligenceV1 doing turn...");

        int winMove = findWinningMove(symbol);
        if (winMove != -1) {
            gameService.doTurn(symbol, winMove);
            return;
        }

        Symbol opponent = (symbol == Symbol.X) ? Symbol.O : Symbol.X;
        int blockMove = findWinningMove(opponent);
        if (blockMove != -1) {
            gameService.doTurn(symbol, blockMove);
            return;
        }

        if (gameService.getSymbolByLocation(5) == Symbol.NONE) {
            gameService.doTurn(symbol, 5);
            return;
        }

        List<Integer> corners = List.of(1, 3, 7, 9);
        List<Integer> freeCorners = new ArrayList<>();
        for (int corner : corners) {
            if (gameService.getSymbolByLocation(corner) == Symbol.NONE) {
                freeCorners.add(corner);
            }
        }
        if (!freeCorners.isEmpty()) {
            int randomCorner = freeCorners.get(new Random().nextInt(freeCorners.size()));
            gameService.doTurn(symbol, randomCorner);
            return;
        }

        for (int pos = 1; pos <= 9; pos++) {
            if (gameService.getSymbolByLocation(pos) == Symbol.NONE) {
                gameService.doTurn(symbol, pos);
                return;
            }
        }
    }

    private int findWinningMove(Symbol s) {
        for (int pos = 1; pos <= 9; pos++) {
            if (gameService.getSymbolByLocation(pos) == Symbol.NONE) {
                if (isWinningMove(s, pos)) {
                    return pos;
                }
            }
        }
        return -1;
    }

    private boolean isWinningMove(Symbol s, int pos) {
        int x = (pos - 1) / 3;
        int y = (pos - 1) % 3;
        return false;
    }
}