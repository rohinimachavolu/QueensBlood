# QueensBlood

**QueensBlood** is a **strategic two-player card-and-board game** implemented in Java.
Players take turns placing **PawnCards** on a shared grid board to **capture territory, influence cells, and score points**.
The game supports **GUI** and **text-based play**, as well as **human vs. human**, **human vs. AI**, and **AI vs. AI** matches.

---

## Table of Contents

* [Game Overview](#game-overview)
* [Objective](#objective)
* [Components](#components)
* [How to Play](#how-to-play)

    * [Setup](#setup)
    * [Turn Sequence](#turn-sequence)
    * [Card Influence](#card-influence)
    * [Passing](#passing)
* [Winning and Scoring](#winning-and-scoring)
* [Example Turn](#example-turn)
* [Architecture](#architecture)

    * [Model](#model)
    * [Controller](#controller)
    * [View](#view)
* [Player Strategies](#player-strategies)
* [Setup and Usage](#setup-and-usage)
* [Contributing](#contributing)

---

## Game Overview

* **Players:** 2 – **Red** vs. **Blue**
* **Board:** Rectangular grid (configurable rows × columns)
* **Cards:** Each player has a deck of **PawnCards** with:

    * **Cost** – pips required to play.
    * **Value** – contributes to scoring.
    * **Influence Grid (5×5)** – determines how surrounding cells change ownership/pips when placed.

---

## Objective

Gain the **highest total score** by:

* Expanding your control over the board.
* Placing high-value cards strategically.
* Managing limited pips to play cost-effective moves.

---

## Components

| Component       | Description                                                                                       |
| --------------- | ------------------------------------------------------------------------------------------------- |
| **Cell**        | A board space that can be neutral or controlled by Red/Blue. Each cell stores *pips* (resources). |
| **PawnCard**    | A card with a cost, value, and 5×5 influence pattern.                                             |
| **Pips**        | Resources that accumulate in controlled cells; spent to place cards.                              |
| **Deck & Hand** | Each player draws cards from their deck into a hand of 5 cards.                                   |

---

## How to Play

### Setup

1. **Deck & Hand:** Each player shuffles their deck and draws an initial hand of cards.
2. **Board Initialization:**

    * Red controls the **leftmost column**; Blue controls the **rightmost column**.
    * Each controlled cell starts with **pips** (default: 2).
3. **Starting Player:** Chosen randomly.

---

### Turn Sequence

On a player’s turn:

1. **Draw Phase** – Draw a card (if the deck is not empty).
2. **Action Phase** – Either:

    * **Play a card** on a cell they control, spending that cell’s pips equal to the card’s cost.
    * **Pass** if no valid move exists or strategically to end the game earlier.
3. **Influence Phase** – Placing a card triggers its **5×5 influence pattern**:

    * Friendly cells gain pips.
    * Enemy or neutral cells may lose pips or flip ownership if pips drop below 0.

---

### Card Influence

* Influence patterns can:

    * **Increase pips** in adjacent friendly cells.
    * **Decrease pips** in enemy cells.
    * **Flip control** if the opponent’s pips are reduced to zero or less.
* Influence **propagates immediately**, creating chain reactions.

---

### Passing

* A player may **pass** their turn voluntarily.
* The game **ends** when **both players pass consecutively**.

---

## Winning and Scoring

At game end:

* Each **row** is scored separately:

    * Sum the **values of cards** Red and Blue have played in that row.
    * The player with the higher total **wins the row** and earns points equal to **their own row total**.
    * Ties in a row award **0 points** to both.
* The **final score** is the sum of all rows controlled.
* **Winner:** Player with the **higher total score**.

---

## Example Turn

Imagine a **6×6 board** mid-game:

```
R3  R2  R1  N0  B1  B2
R1  N0  N0  N0  B0  B1
...
```

* **R/B** = Red/Blue controlled cell; number = pips.
* Red plays a card costing **2 pips** in cell (row 1, column 3).
* Influence grid adds **+1 pips** to adjacent Red cells and **-1 pips** to nearby Blue cells.
* Two Blue cells drop to 0 pips → **flip to Red control**.

This single placement swings territory dramatically and sets up future plays.

---

## Architecture

The project follows **Model–View–Controller (MVC)** with the **Observer pattern** for real-time UI updates:

```
   +----------------+
   |   Controller   |  <-- Human or AI actions
   +----------------+
          |
          v
   +----------------+
   |     Model      |  <-- Game state & rules
   +----------------+
        ^      ^
        |      |
+---------------+   +------------------+
| Text View     |   | GUI View         |
| SimplePawns...|   | SingleWindow...  |
+---------------+   +------------------+
```

### Model

* **SimplePawnGameModel** – Core rules, turn order, scoring.
* **ObservablePawnGameModel** – Publishes board updates for observers.
* **Board/SimpleBoard** – 2D grid of `Cell` objects.
* **PawnCard/SimplePawnCard** – Card attributes and influence patterns.
* **SimplePlayer** – Tracks hand, deck, and resources.

### Controller

* **SimplePawnGameController** – Handles card/cell selection and validates moves.
* **ObservingPawnGameController** – Listens to model changes and drives AI moves.
* **CardReader** – Loads external card data.

### View

* **GUI:** `PawnsGameGUIView` / `SingleWindowPawnsGameGUIView`

    * Displays board, hands, scores.
    * Highlights valid moves and cell ownership.
* **Text:** `SimplePawnsGameTextView`

    * Console-based board and score updates.

---

## Player Strategies

AI players can use different strategies:

* **ExpandRegionStrategy** – Grow contiguous regions for stronger influence.
* **FillFirstSquareStrategy** – Simple, first-available valid move.
* **HybridStrategy** – Mix of region expansion and scoring.
* **MaximizeRowScoreStrategy** – Targets rows with high scoring potential.
* **MinMaxStrategy** – Depth-limited search to plan optimal moves.

---

## Setup and Usage

1. **Compile and Run**

   ```bash
   javac cs3500/pawnsboard/QueensBlood.java
   java cs3500.pawnsboard.QueensBlood
   ```
2. **Choose mode**

    * GUI: Full graphical interface.
    * Text: Console-based gameplay.
3. **Optional:** Run AI matches using `ObservingPawnGameController`.

---

