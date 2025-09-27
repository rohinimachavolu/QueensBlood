package cs3500.pawnsboard.model;

/**
 * Represents a card in the Pawns game.
 *
 * <p>A {@code PawnCard} has a name, a cost, a value score, and a 5x5 influence grid.
 * Cards are placed on the board and can exert influence over certain cells according
 * to this grid. This interface allows for flexible implementations in the future.
 *
 * <p>The influence grid is always 5 rows by 5 columns.
 * The central square (row 2, col 2) is considered the "center" of the card.
 */
public interface PawnCard {

  /**
   * The number of columns in a card's influence grid.
   */
  int INFLUENCE_NUM_COLS = 5;

  /**
   * The number of rows in a card's influence grid.
   */
  int INFLUENCE_NUM_ROWS = 5;

  /**
   * Returns the name of the card.
   *
   * @return the card's name as a String
   */
  String name();

  /**
   * Returns the cost of the card in terms of pips.
   *
   * @return the {@link Cost} representing the card's cost
   */
  Cost getCost();

  /**
   * Returns the value score of the card.
   * <p>
   * This represents the card's strength or attack power in the game.
   *
   * @return an integer value score
   */
  int getValueScore();

  /**
   * Determines whether this card exerts influence at a specific position in its
   * 5x5 influence grid.
   *
   * @param row the row index (0-4) in the influence grid
   * @param col the column index (0-4) in the influence grid
   * @return {@code true} if the card influences the given cell, {@code false} otherwise
   */
  boolean hasInfluence(int row, int col);
}
