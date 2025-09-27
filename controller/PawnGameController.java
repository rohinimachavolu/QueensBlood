package cs3500.pawnsboard.controller;

/**
 * Represents a controller in the Pawns game.
 *
 * <p>A {@code PawnGameController} coordinates between the model (game state), the view (GUI
 * or textual display), and the players. It is responsible for starting the game loop and
 * ensuring that interactions are passed between components.
 *
 * <p>Implementations:
 * <ul>
 *   <li>{@link SimplePawnGameController} — handles basic interactions between a GUI view and
 *       the game model (card selection, move placement, passing, etc.).</li>
 *   <li>{@link ObservingPawnGameController} — an extension of the simple controller that also
 *       observes model events, updates the view accordingly, and triggers player actions.</li>
 * </ul>
 */
public interface PawnGameController {

  /**
   * Starts the controller.
   *
   * <p>This method initializes the game, sets up the view, and makes the GUI visible so the
   * game can begin. Typically, this involves showing the initial player hands, enabling user
   * interaction, and preparing the controller to handle moves.
   */
  void startController();
}
