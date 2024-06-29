import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;

    void newPlayer() {
        player = new Player('O');
    }

    @Test
    void getMarkerTrue() {
        newPlayer();
        assertEquals('O', player.getMarker());
    }

    @Test
    void getMarkerFalse() {
        newPlayer();
        assertNotEquals('X', player.getMarker());
    }
}