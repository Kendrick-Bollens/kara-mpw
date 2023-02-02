package de.unistuttgart.hamster.examples;

import de.unistuttgart.hamster.facade.Hamster;
import de.unistuttgart.hamster.main.Example;
import de.unistuttgart.hamster.main.SimpleHamsterGame;

public class Example02 extends SimpleHamsterGame {
    public Example02() {
        super(Example.EXAMPLE_2);
    }

    public static void main(final String[] args) {
        createInstance(Example02.class);
    }

    Hamster paula;

    @Override
    protected void run() {
        displayInNewGameWindow();
        paula = new Hamster(game.getTerritory(), kara.getLocation(), kara.getDirection());
        kara.move();
        kara.putClover();
        kara.turnRight();
        kara.move();
        kara.move();
        kara.turnLeft();
        kara.move();
        kara.move();
        kara.move();
        kara.move();
        kara.move();
        kara.turnLeft();
        kara.move();
        kara.move();
        kara.turnRight();
        kara.move();
        kara.move();
        kara.turnLeft();
        kara.move();
        kara.move();
        kara.putClover();
        kara.move();
        kara.move();

        paula.move();
        paula.pickClover();
        paula.move();
        paula.move();
        paula.move();
        paula.move();
        paula.move();
        paula.move();
        paula.move();
        paula.turnLeft();
        paula.move();
        paula.move();
        paula.pickClover();

        kara.turnLeft();
        kara.move();
        kara.move();
        kara.move();
        kara.move();
        kara.putClover();
        kara.move();
        kara.move();
        kara.move();
        kara.move();
        kara.turnRight();
        kara.move();
        kara.move();
        kara.move();
        kara.turnRight();
        kara.move();
        kara.move();
        kara.putClover();
        kara.turnRight();
        kara.move();
        kara.turnLeft();
        kara.move();

        paula.move();
        paula.move();
        paula.turnLeft();
        paula.move();
        paula.move();
        paula.move();
        paula.move();
        paula.pickClover();
        paula.move();
        paula.move();
        paula.move();
        paula.move();
        paula.turnRight();
        paula.move();
        paula.move();
        paula.move();
        paula.turnRight();
        paula.move();
        paula.move();
        paula.pickClover();
        paula.turnRight();
        paula.move();
    }
}
