package ru.netology.tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void onePlayerWin() {
        Player player1 = new Player(5, "Крыса", 80);
        Player player2 = new Player(12, "Черепаха", 60);
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        int expected = 1;
        int actual = game.round("Крыса", "Черепаха");


        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void twoPlayerWin() {
        Player player1 = new Player(5, "Крыса", 80);
        Player player2 = new Player(12, "Черепаха", 160);
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        int expected = 2;
        int actual = game.round("Крыса", "Черепаха");


        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void draw() {
        Player player1 = new Player(5, "Крыса", 80);
        Player player2 = new Player(12, "Черепаха", 80);
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        int expected = 0;
        int actual = game.round("Крыса", "Черепаха");


        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void notOnePlayer() {
        Player player2 = new Player(12, "Черепаха", 80);
        Game game = new Game();
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Рокстони", "Черепаха")
        );
    }

    @Test
    public void notTwoPlayer() {
        Player player1 = new Player(5, "Крыса", 80);
        Game game = new Game();
        game.register(player1);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Крыса", "Рокстони")
        );
    }
}
