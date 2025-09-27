package cs3500.pawnsboard.model.splitters;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import cs3500.pawnsboard.model.PawnCard;
import cs3500.pawnsboard.model.SplitInput;

public class AlternatingSplit implements Consumer<SplitInput> {
  @Override
  public void accept(SplitInput splitInput) {
    for(int index = 0; index < splitInput.allCards.size(); index++) {
      if(index %2 == 0) {
        splitInput.redDeck.add(splitInput.allCards.get(index));
      } else {
        splitInput.blueDeck.add(splitInput.allCards.get(index));
      }
    }
  }
}
