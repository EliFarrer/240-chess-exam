package chess;


import java.util.Arrays;
import java.util.Objects;

/**
 * A chessboard that can hold and rearrange chess pieces.
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessBoard {
    public ChessPiece[][] board =  new ChessPiece[8][8];

    public ChessBoard() {}

    /**
     * Adds a chess piece to the chessboard
     *
     * @param position where to add the piece to
     * @param piece    the piece to add
     */
    public void addPiece(ChessPosition position, ChessPiece piece) {
        board[position.row - 1][position.col - 1] = piece;
    }

    /**
     * Gets a chess piece on the chessboard
     *
     * @param position The position to get the piece from
     * @return Either the piece at the position, or null if no piece is at that
     * position
     */
    public ChessPiece getPiece(ChessPosition position) {
        return board[position.row - 1][position.col - 1];
    }

    public boolean position_inBounds(ChessPosition position) {
        return (position.getRow() >= 1 && position.getRow() < 9) && (position.getColumn() >= 1 && position.getColumn() < 9);
    }

    public boolean position_isEmpty(ChessPosition position) {
        return getPiece(position) == null;
    }

    public boolean position_pieceIsOppositeColor(ChessPosition position, ChessPosition newPosition) {
        return getPiece(position).pieceColor != getPiece(newPosition).pieceColor;
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessBoard that = (ChessBoard) o;
        return Objects.deepEquals(board, that.board);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(board);
    }

    @Override
    public String toString() {
        return "ChessBoard{" +
                "board=" + Arrays.deepToString(board) +
                '}';
    }

    /**
     * Sets the board to the default starting board
     * (How the game of chess normally starts)
     */
    public void resetBoard() {
        ChessGame.TeamColor white = ChessGame.TeamColor.WHITE;
        ChessGame.TeamColor black = ChessGame.TeamColor.BLACK;
        ChessPiece.PieceType pawn = ChessPiece.PieceType.PAWN;
        ChessPiece.PieceType rook = ChessPiece.PieceType.ROOK;
        ChessPiece.PieceType queen = ChessPiece.PieceType.QUEEN;
        ChessPiece.PieceType king = ChessPiece.PieceType.KING;
        ChessPiece.PieceType knight = ChessPiece.PieceType.KNIGHT;
        ChessPiece.PieceType bishop = ChessPiece.PieceType.BISHOP;

        ChessPiece whiteRook = new ChessPiece(white, rook);
        ChessPiece blackRook = new ChessPiece(black, rook);

        ChessPiece whiteQueen = new ChessPiece(white, queen);
        ChessPiece blackQueen = new ChessPiece(black, queen);

        ChessPiece whiteKing = new ChessPiece(white, king);
        ChessPiece blackKing = new ChessPiece(black, king);

        ChessPiece whiteBishop = new ChessPiece(white, bishop);
        ChessPiece blackBishop = new ChessPiece(black, bishop);

        ChessPiece whiteKnight = new ChessPiece(white, knight);
        ChessPiece blackKnight = new ChessPiece(black, knight);

        ChessPiece whitePawn = new ChessPiece(white, pawn);
        ChessPiece blackPawn = new ChessPiece(black, pawn);


        // set rook
        board[0][0] = whiteRook; board[0][7] = whiteRook;
        board[7][0] = blackRook; board[7][7] = blackRook;

        // set knights
        board[0][1] = whiteKnight; board[0][6] = whiteKnight;
        board[7][1] = blackKnight; board[7][6] = blackKnight;

        // set bishops
        board[0][2] = whiteBishop; board[0][5] = whiteBishop;
        board[7][2] = blackBishop; board[7][5] = blackBishop;

        // set bishops
        board[0][3] = whiteQueen; board[0][4] = whiteKing;
        board[7][3] = blackQueen; board[7][4] = blackKing;

        // set pawns
        for (int i = 0; i < 8; i++) {
            board[1][i] = whitePawn;
            board[6][i] = blackPawn;
        }

        // set everything else null
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = null;
            }
        }

    }
}
