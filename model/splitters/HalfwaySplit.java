package cs3500.pawnsboard.model.splitters;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import cs3500.pawnsboard.model.PawnCard;
import cs3500.pawnsboard.model.SplitInput;

public class HalfwaySplit implements Consumer<SplitInput> {
  @Override
  public void accept(SplitInput splitInput) {
    for(int index = 0; index < splitInput.allCards.size()/2; index++) {
      splitInput.redDeck.add(splitInput.allCards.get(index));
    }
    for(int index = splitInput.allCards.size()/2; index < splitInput.allCards.size(); index++) {
      splitInput.blueDeck.add(splitInput.allCards.get(index));
    }
  }
}
