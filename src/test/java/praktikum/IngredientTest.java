package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {
    private Ingredient ingredient;
    private final static String NAME_INGREDIENT = "ingredient_name";
    private final static float PRICE_INGREDIENT = 100;
    private final static IngredientType TYPE_INGREDIENT = IngredientType.SAUCE;

    @Before
    public void setUp() {
        ingredient = new Ingredient(TYPE_INGREDIENT, NAME_INGREDIENT, PRICE_INGREDIENT);
    }

    @Test
    public void getPrice() {
        assertEquals("Неверная цена ингредиента", PRICE_INGREDIENT, ingredient.getPrice(), 0);
    }

    @Test
    public void getName() {
        assertEquals("Неверное имя ингредиента", NAME_INGREDIENT, ingredient.getName());
    }

    @Test
    public void getType() {
        assertEquals("Неверный тип ингредиента", TYPE_INGREDIENT, ingredient.getType());
    }
}