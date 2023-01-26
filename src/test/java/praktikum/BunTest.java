package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {
    private Bun bun;
    private final static String NAME_BUN = "black bun";
    private final static float PRICE_BUN = 100;

    @Before
    public void setUp() {
        bun = new Bun(NAME_BUN, PRICE_BUN);
    }

    @Test
    public void getName() {
        assertEquals("Неправильное название булочки", NAME_BUN, bun.getName());
    }

    @Test
    public void getPrice() {
        assertEquals("Неправильная цена булочки", PRICE_BUN, bun.getPrice(), 0);
    }
}