package cs3500.pawnsboard.view.text;

import cs3500.pawnsboard.model.Cell;
import cs3500.pawnsboard.model.Cost;
import cs3500.pawnsboard.model.PlayerToken;
import cs3500.pawnsboard.model.ReadOnlyPawnsGameModel;

public class SimplePawnsGameTextView {

  private ReadOnlyPawnsGameModel model;

  public SimplePawnsGameTextView(ReadOnlyPawnsGameModel model) {
    this.model = model;
  }

  public String toString() {
    StringBuilder builder = new StringBuilder();

    Cell[][] board = model.board();
    for(int row = 0; row < board.length; row++) {
      for(int col = 0; col < board[0].length; col++) {
        Cell cell = board[row][col];
        if(cell.getCard() == null) {
          if(cell.numberOfPips() == Cost.ZERO) {
            builder.append("_");
          } else {
            builder.append(cell.numberOfPips().toInt());
          }
        } else {
          if(cell.getOwner() == PlayerToken.RED) {
            builder.append("R");
          } else {
            builder.append("B");
          }
        }
        if(col < board[0].length - 1) {
          builder.append(" ");
        }
      }
      if(row < board.length - 1) {
        builder.append("\n");
      }
    }

    return builder.toString();
  }
}
