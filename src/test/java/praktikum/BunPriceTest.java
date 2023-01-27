package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunPriceTest {
    @Mock
    private String name;
    private final float price;

    public BunPriceTest(float price) {
        this.price = price;
    }

    @Parameterized.Parameters(name = "Bun {index} -> Price:{0} ")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {100},
                {99.99F},
                {0},
                {-100},
                {Float.MIN_VALUE},
                {Float.MAX_VALUE}
        };
    }

    @Test
    public void getPrice() {
        Bun bun = new Bun(name, price);
        assertEquals("Неправильная цена булочки", price, bun.getPrice(), 0);
    }
}