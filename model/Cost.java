package cs3500.pawnsboard.model;

/**
 * Number of pawns that can exist on the board or as cost for a card.
 * Allows for conversions to and from integers.
 */
public enum Cost {
  ZERO(0), ONE(1), TWO(2), THREE(3);

  private final int cost;

  Cost(int cost) {
    this.cost = cost;
  }

  public int toInt() {
    return cost;
  }

  public Cost increase() {
    switch(this) {
      case ZERO: return ONE;
      case ONE: return TWO;
      case TWO: return THREE;
      case THREE: return THREE;
      default:
        throw new RuntimeException("Unknown cost value was told to increase: " + this);
    }
  }

  public static Cost fromInt(int val) {
    switch(val) {
      case 1: return ONE;
      case 2: return TWO;
      case 3: return THREE;
      default: throw new IllegalArgumentException("Unknown value: " + val);
    }
  }
}
