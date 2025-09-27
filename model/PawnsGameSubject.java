package cs3500.pawnsboard.model;

/**
 * A variant of {@link PawnsGameModel} that supports the
 * <em>observer pattern</em>.
 * <p>
 * Subscribers (observers) can be added for each player so that they
 * are notified when key game events occur, such as board changes,
 * turn changes, or game end.
 */
public interface PawnsGameSubject extends PawnsGameModel {

  /**
   * Registers a subscriber to receive updates for the RED player.
   *
   * @param actions an implementation of {@link ModelActions} for RED
   */
  void addSubscriberForRed(ModelActions actions);

  /**
   * Registers a subscriber to receive updates for the BLUE player.
   *
   * @param actions an implementation of {@link ModelActions} for BLUE
   */
  void addSubscriberForBlue(ModelActions actions);

  /**
   * Notifies all subscribers that the current turn has changed.
   * Typically called after a successful move or a pass.
   */
  void notifyAllOfTurn();

  /**
   * Notifies all subscribers that the game board has changed
   * and may need to be re-rendered.
   */
  void notifyAllOfBoardChange();

  /**
   * Notifies all subscribers that the game has ended.
   */
  void notifyAllOfGameOver();

  /**
   * Starts the game and triggers initial notifications,
   * such as the first board and turn updates.
   */
  void startGame();
}
