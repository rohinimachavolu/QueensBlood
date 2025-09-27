package cs3500.pawnsboard.model;

/**
 * Represents a single cell on the Pawns game board.
 *
 * <p>A {@code Cell} may hold a {@link PawnCard}, be owned by a {@link PlayerToken}, and/or
 * have an associated cost (measured in "pips"). Cells form the basic building blocks of
 * the {@link Board} and are used to determine card placement rules, ownership, and influence.
 *
 * <p>Implementations:
 * <ul>
 *   <li>{@link SimpleCell} — a straightforward implementation that stores ownership,
 *       card placement, and pip count directly.</li>
 * </ul>
 */
public interface Cell {

  /**
   * Returns the card currently occupying this cell, if any.
   *
   * @return the {@link PawnCard} in this cell, or {@code null} if the cell is empty
   */
  PawnCard getCard();

  /**
   * Determines whether this cell is owned by any player.
   *
   * @return {@code true} if the cell has an owner, {@code false} otherwise
   */
  boolean isOwned();

  /**
   * Returns the player who owns this cell.
   *
   * @return the {@link PlayerToken} of the owner, or {@code null} if the cell is unowned
   */
  PlayerToken getOwner();

  /**
   * Returns the number of pips (cost value) associated with this cell.
   * <p>
   * Pip values typically determine whether a card can be played in this cell.
   *
   * @return the {@link Cost} representing the cell’s pip value
   */
  Cost numberOfPips();
}
