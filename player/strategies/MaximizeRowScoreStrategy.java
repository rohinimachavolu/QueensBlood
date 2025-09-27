package cs3500.pawnsboard.player.strategies;

import java.util.List;

import cs3500.pawnsboard.model.PawnCard;
import cs3500.pawnsboard.model.PawnsGameModel;
import cs3500.pawnsboard.model.PlayerToken;
import cs3500.pawnsboard.model.ReadOnlyPawnsGameModel;

public class MaximizeRowScoreStrategy implements Strategy {
  @Override
  public Move decideOnMove(ReadOnlyPawnsGameModel model, PlayerToken player) {
    List<PawnCard> hand = model.getHandForPlayer(player);
    for(int row = 0; row < model.rows(); row++) {
      int curRowScore = model.scoreForRow(player, row);
      int oppRowScore = model.scoreForRow(PlayerToken.opposite(player), row);
      if(curRowScore > oppRowScore) {
        continue;
      }
      Move bestMove = tryToBeat(model, player, hand, row, oppRowScore);
      if (bestMove != null) {
        return bestMove;
      }
    }
    return null;
  }

  private Move tryToBeat(ReadOnlyPawnsGameModel model, PlayerToken player, List<PawnCard> hand, int row, int oppRowScore) {
    for(int col = 0; col < model.cols(); col++) {
      for(int cardIdx = 0; cardIdx < hand.size(); cardIdx++) {
        if(model.canPlaceAt(cardIdx, row, col)) {
          PawnsGameModel copy = model.copy();
          copy.placeCard(cardIdx, row, col);
          int newRowScore = model.scoreForRow(player, row);
          if(newRowScore >= oppRowScore) {
            return new Move(cardIdx, row, col);
          }
        }
      }
    }
    return null;
  }
}
