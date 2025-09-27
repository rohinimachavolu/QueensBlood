package cs3500.pawnsboard.view.gui.simplergraphics;


import java.awt.*;

import cs3500.pawnsboard.model.Cell;

public class SimplerCellGraphic {

  private final Cell cell;

  public SimplerCellGraphic(Cell cell) {
    this.cell = cell;
  }

  public void drawCard(Graphics2D g2d, int xPos, int yPos, int width, int height, boolean highlighted) {
    Color oldColor = g2d.getColor();
    g2d.fillRect(xPos, yPos, width, height);
    g2d.setColor(Color.BLACK);
    g2d.drawRect(xPos, yPos, width, height);

    if (highlighted) {
      Stroke oldStroke = g2d.getStroke();
      g2d.setColor(Color.CYAN);
      //g2d.setStroke(new BasicStroke(10));
      g2d.fillRect(xPos, yPos, width, height);
      g2d.setColor(Color.BLACK);
      g2d.setStroke(oldStroke);
    }

    if(cell.getOwner() != null) {
      switch (cell.getOwner()) {
        case RED:
          g2d.setColor(Color.PINK);
          break;
        case BLUE:
          g2d.setColor(new Color(100, 170, 255));
          break;
      }

      //draw the cell details. Pips if there are any, card if there is any
      if (cell.getCard() == null) {
        drawPips(g2d, xPos, yPos, width, height);
        //draw the pips if they exist in the color of the owner
      } else if (cell.getCard() != null) {
        //there is a card, so draw a Card Graphic write on top of this one
        new SimplerCardGraphic(cell.getOwner(), cell.getCard()).drawCardOnCell(g2d, xPos, yPos, width, height, highlighted);
      }
    }

    g2d.setColor(oldColor);
  }

  private void drawPips(Graphics2D g2d, int xPos, int yPos, int width, int height) {
    Font oldFont = g2d.getFont();
    g2d.setFont(new Font("Arial",Font.PLAIN, oldFont.getSize() * 4));
    if(cell.numberOfPips() != null) {
      g2d.drawString("" + cell.numberOfPips().toInt(), xPos + width/2, yPos + height/2);
    }
    g2d.setFont(oldFont);
  }
}
