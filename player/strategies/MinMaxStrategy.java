package cs3500.pawnsboard.player.strategies;

import java.util.List;

import cs3500.pawnsboard.model.PawnCard;
import cs3500.pawnsboard.model.PawnsGameModel;
import cs3500.pawnsboard.model.PlayerToken;
import cs3500.pawnsboard.model.ReadOnlyPawnsGameModel;

public class MinMaxStrategy implements Strategy {

  private Strategy oppStrategy;

  public MinMaxStrategy(Strategy oppStrategy) {
    this.oppStrategy = oppStrategy;
  }

  @Override
  public Move decideOnMove(ReadOnlyPawnsGameModel model, PlayerToken player) {
    List<PawnCard> hand = model.getHandForPlayer(player);
    Move bestMove = null;
    for(int row = 0; row < model.rows(); row++) {
      for (int col = 0; col < model.cols(); col++) {
        for (int cardIdx = 0; cardIdx < hand.size(); cardIdx++) {
          if (model.canPlaceAt(cardIdx, row, col)) {
            if(resultIsBetter(model.copy(), player, cardIdx, row, col)) {
              bestMove = new Move(cardIdx, row, col);
            }
          }
        }
      }
    }
    return bestMove;
  }

  private boolean resultIsBetter(PawnsGameModel copy, PlayerToken player,
                                 int cardIdx, int row, int col) {
    copy.placeCard(cardIdx, row, col);

    Move oppMove = oppStrategy.decideOnMove(copy, PlayerToken.opposite(player));
    if(oppMove == null) {
      return true;
    }

    copy.placeCard(oppMove.getCardIdx(), oppMove.getRow(), oppMove.getCol());
    return numberOfOwnedSpaces(copy, player) >= numberOfOwnedSpaces(copy, PlayerToken.opposite(player));
  }

  private int numberOfOwnedSpaces(ReadOnlyPawnsGameModel model, PlayerToken player) {
    int count = 0;
    for(int row = 0; row < model.rows(); row++) {
      for (int col = 0; col < model.cols(); col++) {
        if(model.ownerOfSpot(row, col) == player) {
          count++;
        }
      }
    }
    return count;
  }
}
