package cs3500.pawnsboard.view.gui;

import cs3500.pawnsboard.model.PlayerToken;

/**
 * Represents the set of actions that a view can trigger
 * to communicate user intent back to the controller.
 * <p>
 * A {@code ViewActions} acts as a bridge between the
 * {@link PawnsGameView} and the game logic, allowing
 * both human and machine players to issue moves.
 * </p>
 */
public interface ViewActions {

  /**
   * Constant representing an "unchosen" value
   * (used when nothing is currently selected).
   */
  int UNCHOSEN = -1;

  /**
   * Selects a card from the given player's hand.
   *
   * @param player  the player making the selection
   * @param cardIdx the index of the selected card in their hand
   */
  void selectCardFromHand(PlayerToken player, int cardIdx);

  /**
   * Selects a board cell where a card will be placed.
   *
   * @param row the row index of the selected cell
   * @param col the column index of the selected cell
   */
  void selectCellToPlaceCardIn(int row, int col);

  /**
   * Confirms and executes the currently selected move.
   */
  void makeMove();

  /**
   * Passes the player's turn without making a move.
   */
  void pass();
}
