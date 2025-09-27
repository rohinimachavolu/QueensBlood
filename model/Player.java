package cs3500.pawnsboard.model;

import java.util.List;

/**
 * Represents a player in the game model.
 *
 * <p>This is the model's internal representation of a player, not the actual human or machine
 * interacting with the GUI. Each player has a deck of {@link PawnCard}s, a hand of drawn cards,
 * and is identified by a {@link PlayerToken} (RED or BLUE).
 */
interface Player {

  /**
   * Draws the top card from the player's deck and adds it to their hand.
   * Does nothing if the deck is empty.
   */
  void drawCard();

  /**
   * Removes cards from the hand at the given indices and returns them to the deck.
   * Indices are adjusted correctly if multiple cards are removed at once.
   *
   * @param indices one or more indices of cards in the hand to remove
   */
  void removeCard(int... indices);

  /**
   * Returns a copy of the cards currently in the player's hand.
   *
   * @return a list of {@link PawnCard} objects
   */
  List<PawnCard> hand();

  /**
   * Returns the token associated with this player (e.g., RED or BLUE).
   *
   * @return the {@link PlayerToken} for this player
   */
  PlayerToken getToken();

  /**
   * Returns a copy of the player's deck (cards not yet drawn).
   *
   * @return a list of {@link PawnCard} objects in the deck
   */
  List<PawnCard> deck();
}
