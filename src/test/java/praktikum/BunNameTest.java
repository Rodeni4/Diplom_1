package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunNameTest {
    @Mock
    private float price;
    private final String name;

    public BunNameTest(String name) {
        this.name = name;
    }

    @Parameterized.Parameters(name = "Bun {index} -> Name: {0} ")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {"black bun"},
                {"blaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaack bun"},
                {""},
                {null},
                {"   "},
                {"~`!@#$%^&*()_+=-"}
        };
    }

    @Test
    public void getName() {
        Bun bun = new Bun(name, price);
        assertEquals("Неправильное название булочки", name, bun.getName());
    }
}