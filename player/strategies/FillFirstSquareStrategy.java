package cs3500.pawnsboard.player.strategies;

import java.util.List;

import cs3500.pawnsboard.model.Cell;
import cs3500.pawnsboard.model.PawnCard;
import cs3500.pawnsboard.model.PlayerToken;
import cs3500.pawnsboard.model.ReadOnlyPawnsGameModel;

public class FillFirstSquareStrategy implements Strategy {
  @Override
  public Move decideOnMove(ReadOnlyPawnsGameModel model, PlayerToken player) {
    List<PawnCard> hand = model.getHandForPlayer(player);
    for(int row = 0; row < model.rows(); row++) {
      for(int col = 0; col < model.cols(); col++) {
        for(int cardIdx = 0; cardIdx < hand.size(); cardIdx++) {
          if(model.canPlaceAt(cardIdx, row, col)) {
            return new Move(cardIdx, row, col);
          }
        }
      }
    }
    return null;
  }
}
