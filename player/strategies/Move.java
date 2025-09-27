package cs3500.pawnsboard.player.strategies;

public final class Move {

  private final int row;
  private final int col;
  private final int cardIdx;

  public Move(int cardIdx, int row, int col) {
    this.row = row;
    this.col = col;
    this.cardIdx = cardIdx;
  }

  public int getRow() {
    return this.row;
  }

  public int getCol() {
    return this.col;
  }

  public int getCardIdx() {
    return this.cardIdx;
  }

  public String toString() {
    return cardIdx + " at (" + row + "," + col + ")";
  }
}
