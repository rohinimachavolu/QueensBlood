package cs3500.pawnsboard.view.gui.simplergraphics;

import java.awt.*;

import cs3500.pawnsboard.model.Cell;
import cs3500.pawnsboard.model.ReadOnlyPawnsGameModel;
import cs3500.pawnsboard.view.gui.BoardPanel;
import cs3500.pawnsboard.view.gui.PawnsGameGUIView;

public class SimplerBoardPanel extends BoardPanel {

  public SimplerBoardPanel(ReadOnlyPawnsGameModel model) {
    super(model);
  }

  protected void drawBoard(Graphics2D g2d) {
    Cell[][] board = model.board();
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        drawCell(g2d, board, row, col);
      }
    }
  }

  protected void drawRowScores(Graphics2D g2d) {
    //Do nothing
  }

  protected void drawCell(Graphics2D g2d, Cell[][] board, int row, int col) {
    Color oldColor = g2d.getColor();
    Cell cell = board[row][col];

    if(cell.getCard() != null){
      PawnsGameGUIView.getPlayerColor(cell.getOwner());
    } else {
      g2d.setColor(Color.GRAY);
      //color it grey
    }
    new SimplerCellGraphic(cell)
        .drawCard(g2d, col * CARD_WIDTH, row * CARD_HEIGHT,
            CARD_WIDTH, CARD_HEIGHT,
            highlightRow == row && highlightCol == col);

    g2d.setColor(oldColor);
  }

  public Dimension getPreferredLogicalSize() {
    return new Dimension((model.cols()) * CARD_WIDTH, model.rows() * CARD_HEIGHT);
  }

  public void highlightCell(int row, int col) {
    if(highlightRow == row && highlightCol == (col)) {
      row = -1;
      col = -1;
    }
    this.highlightRow = row;
    this.highlightCol = col;
  }
}
