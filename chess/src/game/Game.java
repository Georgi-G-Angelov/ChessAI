package game;

import game.Board;
import game.Color;
import game.Square;
import pieces.King;
import pieces.Piece;


//TO DO
public class Game {
    private Board board;
    private Player currentPlayer;

    public Game(Board board) {
        this.board = board;
    }

    public Game() {

    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Move getLastMove() {
        return board.getLastMove();
    }

    public void applyMove(Move move) {
        board.applyMove(move);
        //togglePlayer();
    }

    public void unapplyMove() {
        board.unapplyLast();
        //togglePlayer();
    }

    private boolean isStalemate() {
        return board.isStalemate(currentPlayer);
    }

//    public Color getPotentialWinner() {
//        for (int i = 0; i < 8; i++) {
//            if (board.getSquare(i, 0).occupiedBy() == Color.WHITE) {
//                return Color.WHITE;
//            }
//            if (board.getSquare(i, 7).occupiedBy() == Color.BLACK) {
//                return Color.BLACK;
//            }
//        }
//        return Color.NONE;
//    }

    public boolean isFinished() {
        return  isStalemate() || hasWon(currentPlayer);
    }

    public boolean hasWon(Player player) {
        for (Piece piece : player.getOpponent().getAllPieces()) {
            if (piece.getClass() == King.class) {
                return false;
            }
        }
        return true;
    }

//    public Color getGameResult() throws Exception{
//        if (isFinished()) {
//            return getPotentialWinner();
//        } else {
//            throw new Exception("game.Game not finished.");
//        }
//    }

//    private void togglePlayer() {
//        if(currentPlayer == Color.WHITE) {
//            currentPlayer = Color.BLACK;
//        } else {
//            currentPlayer = Color.WHITE;
//        }
//    }

    //TO DO
    public Move parseMove(String input) {
        return new Move();
    }

    //to be finished
    /*
    public Move parseMove(String san) {
        int length = san.length();
        if (length != 2 && length != 4) {
            return null;
        }
        if (length == 2 && (san.charAt(0) > 'h' || san.charAt(0) < 'a' || san.charAt(1) < '1' || san.charAt(1) > '8')) {
            return null;
        }
        if (length == 4 && (san.charAt(0) > 'h' || san.charAt(0) < 'a' || san.charAt(1) != 'x' ||
                            san.charAt(2) > 'h' || san.charAt(2) < 'a' || san.charAt(3) < '1' || san.charAt(3) > '8')) {
            return null;
        }
        if (length == 2) {
            // Need to implement two-block moves
            int x = san.charAt(0) - 'a';
            int y = 8 - Integer.parseInt(san.charAt(1) + "");
            Square to = board.getSquare(x, y);
            Square from = new Square();
            if (currentPlayer == Color.WHITE && san.charAt(1) == '4') {
                from = board.getSquare(x, y + 2);
                if (from.occupiedBy() == Color.WHITE) {
                    return new Move(from, to, false, false);
                }
            }
            if (currentPlayer == Color.BLACK && san.charAt(1) == '5') {
                from = board.getSquare(x, y - 2);
                if (from.occupiedBy() == Color.BLACK) {
                    return new Move(from, to, false, false);
                }
            }
            if (currentPlayer == Color.WHITE) {
                if (to.occupiedBy() == Color.BLACK) {
                    Square downLeft = board.getSquare(x - 1, y + 1);
                    Square downRight = board.getSquare(x + 1, y + 1);
                    if (downLeft != null) {
                        if (downRight == null && downLeft.occupiedBy() == Color.WHITE) {
                            from = downLeft;
                            return new Move(from, to, true, false);
                        }
                        if (downRight != null) {
                            if (downRight.occupiedBy() == Color.WHITE && downLeft.occupiedBy() != Color.WHITE) {
                                from = downRight;
                                return new Move(from, to, true, false);
                            }
                            if (downRight.occupiedBy() != Color.WHITE && downLeft.occupiedBy() == Color.WHITE) {
                                from = downLeft;
                                return new Move(from, to, true, false);
                            }
                        }
                    }
                    if (downRight != null) {
                        if (downLeft == null && downRight.occupiedBy() == Color.WHITE) {
                            from = downRight;
                            return new Move(from, to, true, false);
                        }
                    }
                }
                if (to.occupiedBy() == Color.NONE) {
                    from = board.getSquare(x, y + 1);
                    if (from != null) {
                        if (from.occupiedBy() == Color.WHITE) {
                            return new Move(from, to, false, false);
                        }

                        //En passant check
                        if (from.occupiedBy() == Color.BLACK && board.getLastMove().isTwoBlocks(from)) {
                            Square from1 = board.getSquare(x - 1, y + 1);
                            Square from2 = board.getSquare(x + 1, y +1);
                            if (from1 == null) {
                                if (from2 != null) {
                                    if (from2.occupiedBy() == Color.WHITE) {
                                        return new Move(from2, to, false, true);
                                    }
                                }
                            }
                            if (from2 == null) {
                                if (from1 != null) {
                                    if (from1.occupiedBy() == Color.WHITE) {
                                        return new Move(from1, to, false, true);
                                    }
                                }
                            }
                            if (from1 != null && from2 != null) {
                                if (from1.occupiedBy() == Color.WHITE && from2.occupiedBy() != Color.WHITE) {
                                    return new Move(from1, to, false, true);
                                }
                                if (from1.occupiedBy() != Color.WHITE && from2.occupiedBy() == Color.WHITE) {
                                    return new Move(from2, to, false, true);
                                }
                            }
                        }
                    }
                }
            }
            if (currentPlayer == Color.BLACK) {
                if (to.occupiedBy() == Color.WHITE) {
                    Square upLeft = board.getSquare(x-1, y - 1);
                    Square upRight = board.getSquare(x + 1, y - 1);
                    if (upLeft != null) {
                        if (upRight == null && upLeft.occupiedBy() == Color.BLACK) {
                            from = upLeft;
                            return new Move(from, to, true, false);
                        }
                        if (upRight != null) {
                            if (upRight.occupiedBy() == Color.BLACK && upLeft.occupiedBy() != Color.BLACK) {
                                from = upRight;
                                return new Move(from, to, true, false);
                            }
                            if (upRight.occupiedBy() != Color.BLACK && upLeft.occupiedBy() == Color.BLACK) {
                                from = upLeft;
                                return new Move(from, to, true, false);
                            }
                        }
                    }
                    if (upRight != null) {
                        if (upLeft == null && upRight.occupiedBy() == Color.BLACK) {
                            from = upRight;
                            return new Move(from, to, true, false);
                        }
                    }
                }
                if (to.occupiedBy() == Color.NONE) {
                    from = board.getSquare(x, y - 1);
                    if (from != null) {
                        if (from.occupiedBy() == Color.BLACK) {
                            return new Move(from, to, false, false);
                        }
                        //En passant check
                        if (from.occupiedBy() == Color.WHITE && board.getLastMove().isTwoBlocks(from)) {
                            Square from1 = board.getSquare(x - 1, y - 1);
                            Square from2 = board.getSquare(x + 1, y - 1);
                            if (from1 == null) {
                                if (from2 != null) {
                                    if (from2.occupiedBy() == Color.BLACK) {
                                        return new Move(from2, to, false, true);
                                    }
                                }
                            }
                            if (from2 == null) {
                                if (from1 != null) {
                                    if (from1.occupiedBy() == Color.BLACK) {
                                        return new Move(from1, to, false, true);
                                    }
                                }
                            }
                            if (from1 != null && from2 != null) {
                                if (from1.occupiedBy() == Color.BLACK && from2.occupiedBy() != Color.BLACK) {
                                    return new Move(from1, to, false, true);
                                }
                                if (from1.occupiedBy() != Color.BLACK && from2.occupiedBy() == Color.BLACK) {
                                    return new Move(from2, to, false, true);
                                }
                            }
                        }
                    }
                }
            }
            return null;
        }
        if (length == 4) {
            int x = san.charAt(2) - 'a';
            int y = 8 - Integer.parseInt(san.charAt(3) + "");
            Square pottentialEnPassant = new Square();
            if (currentPlayer == Color.WHITE) {
                pottentialEnPassant = board.getSquare(x, y + 1);
            }
            if (currentPlayer == Color.BLACK) {
                pottentialEnPassant = board.getSquare(x, y - 1);
            }
            Square to = board.getSquare(x, y);
            Square from;
            x = san.charAt(0) - 'a';
            if(Math.abs(san.charAt(0) - san.charAt(2)) != 1) {
                return null;
            }
            if (currentPlayer == Color.WHITE) {
                y = y + 1;
                from = board.getSquare(x,y);
                if (to.occupiedBy() == Color.BLACK && from.occupiedBy() == Color.WHITE) {
                    return new Move(from, to, true, false);
                }
                if (to.occupiedBy() == Color.NONE && board.getLastMove().isTwoBlocks(pottentialEnPassant)) {
                    return new Move(from, to, false, true);
                }
            }
            if (currentPlayer == Color.BLACK) {
                y = y - 1;
                from = board.getSquare(x,y);
                if (to.occupiedBy() == Color.WHITE && from.occupiedBy() == Color.BLACK) {
                    return new Move(from, to, true, false);
                }
                if (to.occupiedBy() == Color.NONE && board.getLastMove().isTwoBlocks(pottentialEnPassant)) {
                    return new Move(from, to, false, true);
                }
            }
        }
        return null;
    }
     */
}
