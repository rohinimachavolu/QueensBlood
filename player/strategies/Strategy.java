package cs3500.pawnsboard.player.strategies;

import cs3500.pawnsboard.model.PlayerToken;
import cs3500.pawnsboard.model.ReadOnlyPawnsGameModel;

public interface Strategy {

  //TODO: Have this return a List<Move>, then have infallible ones that break the ties
  Move decideOnMove(ReadOnlyPawnsGameModel model, PlayerToken player);
}
