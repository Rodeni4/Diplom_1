package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient anotherIngredient;
    private Burger burger;
    private final static int NEW_INDEX = 1;
    private final static float PRICE_BUN = 50;
    private final static float PRICE_INGREDIENT = 100;
    private final static float PRICE_BURGER = 200;
    private final static String EXPECTED_RECEIPT = "(==== bun ====) = sauce ingredient = (==== bun ====) Price: 200,000000 ";

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBuns() {
        burger.setBuns(bun);
        assertEquals("Неправильная булочка", bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(ingredient);
        assertTrue("Ингредиент, не был добавлен", burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredient);
        int index = burger.ingredients.indexOf(ingredient);
        burger.removeIngredient(index);
        assertFalse("Ингредиент, не был удалён",burger.ingredients.contains(ingredient));
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(anotherIngredient);
        int index = burger.ingredients.indexOf(ingredient);
        burger.moveIngredient(index, NEW_INDEX);
        assertEquals("Ингредиент, не был перемещён", NEW_INDEX, burger.ingredients.indexOf(ingredient));
    }

    @Test
    public void getPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(PRICE_BUN);
        Mockito.when(ingredient.getPrice()).thenReturn(PRICE_INGREDIENT);
        assertEquals("Неправильная цена бургера", PRICE_BURGER, burger.getPrice(),0);
    }

    @Test
    public void getReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(PRICE_BUN);
        Mockito.when(bun.getName()).thenReturn("bun");
        Mockito.when(ingredient.getName()).thenReturn("ingredient");
        Mockito.when(ingredient.getPrice()).thenReturn(PRICE_INGREDIENT);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        assertEquals("Неправильный чек", EXPECTED_RECEIPT, burger.getReceipt().replaceAll("[\r\n]+", " "));
    }
}