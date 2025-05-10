import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {

    @Test
    public void shouldShowLastFiveByDefault() {
        PosterManager manager = new PosterManager();

        manager.add("Movie 1");
        manager.add("Movie 2");
        manager.add("Movie 3");
        manager.add("Movie 4");
        manager.add("Movie 5");
        manager.add("Movie 6");

        String[] expected = {"Movie 6", "Movie 5", "Movie 4", "Movie 3", "Movie 2"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowAllIfLessThanLimit() {
        PosterManager manager = new PosterManager(10);

        manager.add("A");
        manager.add("B");

        String[] expected = {"B", "A"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyIfLimitIsZero() {
        PosterManager manager = new PosterManager(0);

        manager.add("Movie 1");
        manager.add("Movie 2");

        String[] expected = {};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyIfNoMoviesAdded() {
        PosterManager manager = new PosterManager();

        String[] expected = {};
        String[] actualFindAll = manager.findAll();
        String[] actualFindLast = manager.findLast();

        Assertions.assertArrayEquals(expected, actualFindAll);
        Assertions.assertArrayEquals(expected, actualFindLast);
    }

    @Test
    public void shouldWorkWithOneMovieOnly() {
        PosterManager manager = new PosterManager();

        manager.add("Inception");

        String[] expected = {"Inception"};

        Assertions.assertArrayEquals(expected, manager.findAll());
        Assertions.assertArrayEquals(expected, manager.findLast());
    }
}
