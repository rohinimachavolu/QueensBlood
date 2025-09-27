package cs3500.pawnsboard.player;

import cs3500.pawnsboard.model.PlayerToken;
import cs3500.pawnsboard.view.gui.ViewActions;

/**
 * Represents a player in the Pawns board game.
 * <p>
 * A {@code Player} can either be controlled by a human through a GUI
 * ({@link HumanPlayer}) or be automated with a strategy
 * ({@link MachinePlayer}). This interface defines the minimal behavior
 * required to interact with the game controller and the view.
 */
public interface Player {

  /**
   * Provides this player with a {@link ViewActions} object that allows it
   * to communicate with the view layer (e.g., selecting cards, placing them
   * on the board, or passing a turn).
   * <ul>
   *   <li>For a {@link HumanPlayer}, this method usually does nothing, since
   *       the human interacts directly with the GUI.</li>
   *   <li>For a {@link MachinePlayer}, this is essential: it uses the
   *       {@code ViewActions} to perform its moves automatically.</li>
   * </ul>
   *
   * @param actions the object through which this player can trigger game moves
   */
  void setActions(ViewActions actions);

  /**
   * Returns the {@link PlayerToken} associated with this player.
   * <p>
   * The token uniquely identifies the player (e.g., Player 1, Player 2),
   * and is used by both the game model and the view to track whose turn it is.
   *
   * @return this player's token
   */
  PlayerToken getToken();

  /**
   * Executes this player's turn.
   * <ul>
   *   <li>For a {@link HumanPlayer}, this is typically a no-op, since the
   *       human chooses moves through the GUI instead of code.</li>
   *   <li>For a {@link MachinePlayer}, this method triggers its strategy to
   *       decide on a move and then performs that move by calling the
   *       appropriate {@link ViewActions} methods.</li>
   * </ul>
   */
  void takeTurn();
}
