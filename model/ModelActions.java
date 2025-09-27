package cs3500.pawnsboard.model;

/**
 * Represents a set of callbacks that an observing component (such as a
 * controller or view) can implement to be notified when key changes occur
 * in the {@link PawnsGameSubject} game model.
 * <p>
 * Implementations typically update the user interface, enable or disable
 * player controls, or display messages in response to these events.
 */
public interface ModelActions {

  /**
   * Called when it becomes this subscriber’s turn to play.
   * <p>
   * For example, a controller might enable input controls or show a
   * "Your Turn" message.
   */
  void notifyTurn();

  /**
   * Called whenever the game board has changed in a way that
   * observers should reflect (e.g., a card is placed or influence changes).
   * Implementations usually refresh the board display.
   */
  void notifyGameBoardChange();

  /**
   * Called once the game has ended.
   * <p>
   * Implementations might display the winner, final scores,
   * or disable further interaction.
   */
  void notifyGameOver();
}
