package cs3500.pawnsboard.model;

import java.util.List;

/**
 * A read-only view of the pawns game model.
 * <p>
 * Exposes only query methods so that external components
 * (e.g., controllers or views) can inspect the state of the game
 * without being able to mutate it.
 * <p>
 * This separation allows safe sharing of the model state
 * while preserving encapsulation of game logic.
 */
public interface ReadOnlyPawnsGameModel {

  // ----- Board Observations -----

  /**
   * Determines whether the card at the given hand index can be placed
   * at the specified board location.
   * <p>
   * A valid placement requires that the cell is empty and that the
   * cell has at least enough pips to cover the card’s cost.
   *
   * @param index index of the card in the current player's hand
   * @param row   board row
   * @param col   board column
   * @return {@code true} if the card can be placed; {@code false} otherwise
   */
  boolean canPlaceAt(int index, int row, int col);

  /**
   * Returns a copy of the game board as a 2D array of {@link Cell}s.
   * Modifications to the returned array will not affect the game state.
   *
   * @return the current board state
   */
  Cell[][] board();

  /**
   * Returns the owner of the specified board cell, or {@code null}
   * if the cell is unclaimed (no pips).
   *
   * @param row board row
   * @param col board column
   * @return the owning {@link PlayerToken}, or {@code null} if none
   */
  PlayerToken ownerOfSpot(int row, int col);

  /**
   * Computes the current score for the given player in a single row.
   *
   * @param player the player whose score to compute
   * @param row    the board row
   * @return the row score for the player
   */
  int scoreForRow(PlayerToken player, int row);

  /**
   * Computes the total game score for the given player across all rows.
   * Only rows where the player leads in score contribute to the total.
   *
   * @param player the player to score
   * @return the total game score
   */
  int gameScore(PlayerToken player);

  // ----- Player Observations -----

  /**
   * Retrieves the current hand of cards for the specified player.
   * The returned list is typically unmodifiable.
   *
   * @param player the player whose hand to retrieve
   * @return the player’s current hand
   */
  List<PawnCard> getHandForPlayer(PlayerToken player);

  // ----- Game Status -----

  /**
   * Returns the {@link PlayerToken} representing whose turn it is.
   *
   * @return the current player’s token
   */
  PlayerToken getTurn();

  /**
   * Determines whether the game has ended.
   * <p>
   * The game ends when both players pass consecutively.
   *
   * @return {@code true} if the game is over
   */
  boolean isGameOver();

  /**
   * Returns the winner of the game, or {@code null} if the game is a tie.
   *
   * @return the winning {@link PlayerToken}, or {@code null} for a tie
   */
  PlayerToken getWinner();

  /**
   * Returns the number of columns on the board.
   *
   * @return the column count
   */
  int cols();

  /**
   * Returns the number of rows on the board.
   *
   * @return the row count
   */
  int rows();

  /**
   * Produces a deep copy of the mutable model, preserving the
   * current game state but allowing safe manipulation of the copy.
   *
   * @return a copy of the game model
   */
  PawnsGameModel copy();
}
