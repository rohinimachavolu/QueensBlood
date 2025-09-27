package cs3500.pawnsboard.view.gui.simplergraphics;

import java.awt.*;

import cs3500.pawnsboard.model.PawnCard;
import cs3500.pawnsboard.model.PlayerToken;

public class SimplerCardGraphic {

  private final PawnCard card;
  private final PlayerToken owner;

  public SimplerCardGraphic(PlayerToken owner, PawnCard card) {
    this.card = card;
    this.owner = owner;
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

    if(card != null) {
      g2d.setColor(Color.BLACK);

      Font oldFont = g2d.getFont();
      g2d.setFont(new Font("Arial",Font.PLAIN, oldFont.getSize() * 2));

      g2d.drawString(card.name(), xPos, yPos + height/15);
      g2d.drawString("Cost: " + card.getCost().toInt(), xPos, yPos + (2*height)/15);
      g2d.drawString("Value: " + card.getValueScore(), xPos, yPos + (3*height)/15);

      //draw the influence map
      drawInfluence(g2d, xPos, yPos, width, height);
      g2d.setFont(oldFont);

      //draw the card details
    }
    g2d.setColor(oldColor);
  }

  private void drawInfluence(Graphics2D g2d, int xPos, int yPos, int width, int height) {
    if(owner == PlayerToken.RED) {
      for (int row = 0; row < 5; row++) {
        String influence = "";
        for (int col = 0; col < 5; col++) {
          if (card.hasInfluence(row, col)) {
            influence += "I";
          } else if (row == 2 && col == 2) {
            influence += "C";
          } else {
            influence += "X";
          }
        }
        g2d.drawString(influence, xPos, yPos + height/2 + row * g2d.getFontMetrics().getHeight());
      }
    } else {
      for (int row = 0; row < 5; row++) {
        String influence = "";
        for (int col = 4; col >= 0; col--) {
          if (card.hasInfluence(row, col)) {
            influence += "I";
          } else if (row == 2 && col == 2) {
            influence += "C";
          } else {
            influence += "X";
          }
        }
        g2d.drawString(influence, xPos, yPos + height/2 + row * g2d.getFontMetrics().getHeight());
      }
    }
  }


  public void drawCardOnCell(Graphics2D g2d, int xPos, int yPos, int width, int height, boolean highlighted) {
    drawCard(g2d, xPos, yPos, width, height, highlighted);
  }
}
