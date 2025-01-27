package chess;

public interface Hopper {
    // an interface for hopping chess pieces like the knight and king
    public boolean canMove(ChessBoard board, ChessPosition position, ChessPiece piece);
}
