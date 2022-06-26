import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;
import ru.netology.game.Game;

public class GameTest {
    Game game = new Game();

    Player first = new Player(1, "Ilya", 40);
    Player second = new Player(2, "Ivan", 40);
    Player third = new Player(3, "Alex", 46);
    Player fourth = new Player(4, "Oleg", 77);


    @Test
    public void shouldShowRegisterAndMakeRound() {
        game.register(first);
        game.register(second);

        int actual = game.round("Ilya", "Ivan");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFirstWinRound() {
        game.register(third);
        game.register(first);

        Assertions.assertEquals(1, game.round("Alex", "Ilya"));
    }

    @Test
    public void shouldSecondWinRound() {
        game.register(second);
        game.register(fourth);

        Assertions.assertEquals(2, game.round("Ivan", "Oleg"));
    }

    @Test
    public void shouldShowNotRegisteredException() {
        game.register(second);
        game.register(fourth);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Ivan", "Ivan"));
    }

    @Test
    public void shouldShowNotRegisteredExceptionPlayerOneNotFound() {
        game.register(second);
        game.register(fourth);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Ivan", "OlegGGG"));
    }

    @Test
    public void shouldShowNotRegisteredExceptionPlayerTwoNotFound() {
        game.register(second);
        game.register(fourth);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("IvanNNN", "Oleg"));
    }
}
