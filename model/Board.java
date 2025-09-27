package cs3500.pawnsboard.model;

/**
 * Represents the game board in a Pawns game.
 *
 * <p>A {@code Board} is a 2D grid of {@link Cell}s, where players place {@link PawnCard}s,
 * claim territory, and contest ownership through card influence and cell costs. The board
 * provides methods for placing cards, querying ownership, and mutating cell properties
 * (such as cost or owner).
 *
 * <p>Implementations:
 * <ul>
 *   <li>{@link SimpleBoard} — a concrete implementation backed by a 2D array of cells,
 *       initialized with RED- and BLUE-owned border columns.</li>
 * </ul>
 */
public interface Board {

  /**
   * Places a card on the board at the specified location for the given player.
   *
   * @param player the {@link PlayerToken} representing the player placing the card
   * @param card   the {@link PawnCard} to place
   * @param row    the row coordinate (0-indexed)
   * @param col    the column coordinate (0-indexed)
   * @throws IllegalStateException if the cell is already occupied or owned by the opponent
   * @throws IllegalArgumentException if the coordinates are out of bounds
   */
  void placeCard(PlayerToken player, PawnCard card, int row, int col);

  /**
   * Returns the owner of the cell at the given position.
   *
   * @param row the row index
   * @param col the column index
   * @return the {@link PlayerToken} that owns this cell, or {@code null} if unowned
   * @throws IllegalArgumentException if the coordinates are out of bounds
   */
  PlayerToken getOwnwerAt(int row, int col);

  /**
   * Returns the card placed at the given position, if any.
   *
   * @param row the row index
   * @param col the column index
   * @return the {@link PawnCard} at this cell, or {@code null} if no card is present
   * @throws IllegalArgumentException if the coordinates are out of bounds
   */
  PawnCard getCardAt(int row, int col);

  /**
   * Returns the current cost (pips required) of the cell at the given position.
   *
   * @param row the row index
   * @param col the column index
   * @return the {@link Cost} value of the cell
   * @throws IllegalArgumentException if the coordinates are out of bounds
   */
  Cost getCost(int row, int col);

  /**
   * Determines if the given player can place a card at the specified location.
   * Conditions typically include:
   * <ul>
   *   <li>The cell is owned by the player</li>
   *   <li>The cell does not already contain a card</li>
   *   <li>The cell’s cost is sufficient to pay for the card</li>
   * </ul>
   *
   * @param player the player attempting to place the card
   * @param card   the card to place
   * @param row    the row index
   * @param col    the column index
   * @return {@code true} if placement is legal, {@code false} otherwise
   * @throws IllegalArgumentException if the coordinates are out of bounds
   */
  boolean canPlaceAt(PlayerToken player, PawnCard card, int row, int col);

  /**
   * Creates and returns a deep copy of the board state.
   *
   * @return a 2D array of {@link Cell} objects representing the current board
   */
  Cell[][] copy();

  /**
   * Returns the width (number of columns) of the board.
   *
   * @return the board width
   */
  int width();

  /**
   * Returns the height (number of rows) of the board.
   *
   * @return the board height
   */
  int height();

  /**
   * Claims an unowned cell for the given player, initializing it with cost {@link Cost#ONE}.
   *
   * @param player the player claiming the cell
   * @param row    the row index
   * @param col    the column index
   */
  void claimCell(PlayerToken player, int row, int col);

  /**
   * Increases the cost of the specified cell by one increment.
   *
   * @param row the row index
   * @param col the column index
   */
  void increaseCost(int row, int col);

  /**
   * Changes ownership of the specified cell while keeping its cost unchanged.
   *
   * @param token the new owner
   * @param row   the row index
   * @param col   the column index
   */
  void changeOwner(PlayerToken token, int row, int col);
}
