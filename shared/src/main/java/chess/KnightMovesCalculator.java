package chess;

import java.util.ArrayList;
import java.util.Collection;

public class KnightMovesCalculator implements Hopper{

    public ArrayList<ChessMove> getMoves(ChessBoard board, ChessPosition position) {
        ArrayList<ChessMove> possibleMoves = new ArrayList<ChessMove>();
        int[][] deltas = new int[][] {{1, 2}, {2, 1}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1}, {-1, -2}, {-2, -1}};
        for (int[] delta : deltas) {
            var newPosition = new ChessPosition(position.getRow() + delta[0], position.getColumn() + delta[1]);
            possibleMoves.add(new ChessMove(position, newPosition, null));
        }
        return possibleMoves;
    }


    public boolean canMove(ChessBoard board, ChessPosition position, ChessPiece piece) {return true;}


}
