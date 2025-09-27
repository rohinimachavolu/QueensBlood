package cs3500.pawnsboard.view.gui;

import java.util.List;

import cs3500.pawnsboard.model.PawnCard;
import cs3500.pawnsboard.model.PlayerToken;

/**
 * Represents the visual component of the Pawns game.
 * <p>
 * A {@code PawnsGameView} is responsible for displaying the game state,
 * highlighting selections, and showing messages to the user. It works
 * together with {@link ViewActions} to allow human or machine players
 * to interact with the game.
 * </p>
 * <p>
 * Example implementations:
 * <ul>
 *   <li>{@link PawnsGameGUIView} – a Swing-based GUI with board and hand panels.</li>
 * </ul>
 * </p>
 */
public interface PawnsGameView {

  /**
   * Repaints the view to reflect the current state of the game.
   * Should be called whenever the model or highlights change.
   */
  void refresh();

  /**
   * Makes the view visible to the user.
   * For example, a GUI implementation might show its window and repaint.
   */
  void setVisible();

  /**
   * Registers the {@link ViewActions} that this view should call
   * when the user interacts with it (e.g., clicks, keyboard input).
   *
   * @param actions the actions object to connect to this view
   */
  void setActions(ViewActions actions);

  /**
   * Updates the displayed state for the given player.
   * This typically refreshes the hand panel and updates the title
   * to indicate whose turn it is.
   *
   * @param turn         the player whose turn it currently is
   * @param handForPlayer the cards in this player's hand
   */
  void updatePlayer(PlayerToken turn, List<PawnCard> handForPlayer);

  /**
   * Displays a message to the user (e.g., warnings, status updates).
   *
   * @param msg the message text
   */
  void sendMessage(String msg);

  /**
   * Highlights the card in the player's hand at the given index.
   * Passing {@code -1} removes any highlight.
   *
   * @param cardIdx the index of the card to highlight, or -1 for none
   */
  void highlightCard(int cardIdx);

  /**
   * Highlights the board cell at the given coordinates.
   * Passing {@code (-1, -1)} removes any highlight.
   *
   * @param row the row index of the cell
   * @param col the column index of the cell
   */
  void highlightCell(int row, int col);
}
