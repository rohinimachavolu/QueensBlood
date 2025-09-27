package cs3500.pawnsboard.player.strategies;

import cs3500.pawnsboard.model.PlayerToken;
import cs3500.pawnsboard.model.ReadOnlyPawnsGameModel;

public class HybridStrategy implements Strategy {

  private final Strategy first;
  private final Strategy fallback;

  public HybridStrategy(Strategy first, Strategy fallback) {
    this.first = first;
    this.fallback = fallback;
  }
  @Override
  public Move decideOnMove(ReadOnlyPawnsGameModel model, PlayerToken player) {
    Move ans = first.decideOnMove(model, player);
    if(ans != null) {
      return ans;
    }
    return fallback.decideOnMove(model, player);
  }
}
