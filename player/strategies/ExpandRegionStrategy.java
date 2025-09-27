package cs3500.pawnsboard.player.strategies;


import java.util.List;

import cs3500.pawnsboard.model.PawnCard;
import cs3500.pawnsboard.model.PawnsGameModel;
import cs3500.pawnsboard.model.PlayerToken;
import cs3500.pawnsboard.model.ReadOnlyPawnsGameModel;

public class ExpandRegionStrategy implements Strategy {
  @Override
  public Move decideOnMove(ReadOnlyPawnsGameModel model, PlayerToken player) {
    int currentOwnedPlaces = numberOfOwnedSpaces(model, player);
    Move bestMove = null;
    List<PawnCard> hand = model.getHandForPlayer(player);
    for(int row = 0; row < model.rows(); row++) {
      for(int col = 0; col < model.cols(); col++) {
        for(int cardIdx = 0; cardIdx < hand.size(); cardIdx++) {
          if(model.canPlaceAt(cardIdx, row, col)) {
            PawnsGameModel copy = model.copy();
            copy.placeCard(cardIdx, row, col);
            if(currentOwnedPlaces < numberOfOwnedSpaces(copy, player)) {
              bestMove = new Move(cardIdx, row, col);
              currentOwnedPlaces = numberOfOwnedSpaces(copy, player);
            }
          }
        }
      }
    }
    return bestMove;
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
