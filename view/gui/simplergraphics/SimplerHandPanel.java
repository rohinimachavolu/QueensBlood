package cs3500.pawnsboard.view.gui.simplergraphics;

import java.awt.*;
import java.util.List;

import cs3500.pawnsboard.model.PawnCard;
import cs3500.pawnsboard.model.PlayerToken;
import cs3500.pawnsboard.view.gui.HandPanel;

public class SimplerHandPanel extends HandPanel {

  public SimplerHandPanel(PlayerToken player, List<PawnCard> playerHand) {
    super(player, playerHand);
  }

  protected void drawHand(Graphics2D g2d, int idx) {
    Color oldColor = g2d.getColor();
    switch (player) {
      case RED: g2d.setColor(Color.PINK); break;
      case BLUE: g2d.setColor(new Color(100, 170, 255));
    }
    new SimplerCardGraphic(player, playerHand.get(idx))
        .drawCard(g2d, idx * CARD_WIDTH, 0, CARD_WIDTH, CARD_HEIGHT, highlightedIdx == idx);
    g2d.setColor(oldColor);
  }
}
