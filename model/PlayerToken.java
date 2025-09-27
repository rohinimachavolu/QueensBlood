package cs3500.pawnsboard.model;

/**
 * Tokens to let clients represent one of the two players in the game
 */
public enum PlayerToken {
  RED, BLUE;

  public static PlayerToken opposite(PlayerToken player) {
    switch(player) {
      case RED: return BLUE;
      case BLUE: return RED;
      default: throw new RuntimeException("Unknown player value: " + player);
    }
  }
}
