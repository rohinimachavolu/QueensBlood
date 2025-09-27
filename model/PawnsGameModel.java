package cs3500.pawnsboard.model;

import java.util.List;
import java.util.function.Consumer;

/**
 * A mutable version of the pawns game model that supports playing cards,
 * passing turns, and setting up a new game.
 * <p>
 * Externally, the game board is represented as a {@code Cell[][]} grid
 * where each cell can hold costs, cards, or nothing. Players maintain
 * a hand of {@link PawnCard}s and take turns influencing the board.
 * <p>
 * This interface extends {@link ReadOnlyPawnsGameModel} to provide
 * mutator methods, while still allowing read-only views to be shared
 * when immutability is desired.
 */
public interface PawnsGameModel extends ReadOnlyPawnsGameModel {

  /**
   * Places the card at the given index from the current player's hand
   * onto the specified board location, applying the card’s influence,
   * updating scores, and then switching the turn.
   * <p>
   * Influence rules:
   * <ul>
   *   <li>Influenced empty spots gain one pip if not owned by the opponent.</li>
   *   <li>If a spot is owned by the opponent, ownership is taken.</li>
   * </ul>
   *
   * @param index the index of the card in the current player's hand
   * @param row   the board row to place the card
   * @param col   the board column to place the card
   * @throws IllegalArgumentException if the index is invalid
   * @throws IllegalStateException if the cell cannot support the card’s cost
   */
  void placeCard(int index, int row, int col);

  /**
   * Passes the current player's turn without placing a card.
   * If both players pass consecutively, the game ends.
   */
  void pass();

  /**
   * Initializes a new game with the given configuration using
   * separate pre-constructed decks for each player.
   *
   * @param rows     number of rows on the board
   * @param cols     number of columns on the board (must be positive and odd)
   * @param handSize number of cards each player starts with
   * @param shuffle  whether to shuffle the decks before dealing
   * @param redDeck  deck of cards for the RED player
   * @param blueDeck deck of cards for the BLUE player
   * @throws IllegalArgumentException if configuration is invalid
   */
  void setupGame(int rows, int cols, int handSize, boolean shuffle,
                 List<PawnCard> redDeck, List<PawnCard> blueDeck);

  /**
   * Initializes a new game with a combined deck of all cards, using
   * a {@link Consumer} to split the cards between players.
   *
   * @param rows     number of board rows
   * @param cols     number of board columns
   * @param handSize initial hand size
   * @param shuffle  whether to shuffle decks
   * @param allCards combined list of cards for both players
   * @param splitter a function that divides {@code allCards} into red and blue decks
   */
  void setupGame(int rows, int cols, int handSize, boolean shuffle,
                 List<PawnCard> allCards, Consumer<SplitInput> splitter);

  /**
   * Initializes a game with a prebuilt {@link Board} and
   * predefined decks. This is primarily for testing or quick setup
   * and is not typically exposed in production code.
   *
   * @param board    the board to use
   * @param handSize initial hand size
   * @param redDeck  deck of cards for the RED player
   * @param blueDeck deck of cards for the BLUE player
   */
  void setupGame(Board board, int handSize,
                 List<PawnCard> redDeck, List<PawnCard> blueDeck);
}
