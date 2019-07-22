package guru.springframework.converters;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

public class IngredientToIngredientCommandTest {

    public static final String DESCRIPTION_RECIPE = "Recipe description";
    public static final BigDecimal AMOUNT = new BigDecimal("1");
    public static final String DESCRIPTION = "Cheesburger";
    public static final String DESCRIPTION_UOM = "Cup";
    public static final Long ID_VALUE = 1L;
    public static final Long UOM_ID = 2L;

    IngredientToIngredientCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @Test
    public void testConvertNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testConvertEmptyObject() {
        assertNotNull(converter.convert(new Ingredient()));
    }

    @Test
    public void testConvertWithUOM() {
        //given
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(UOM_ID);
        uom.setDescription(DESCRIPTION_UOM);

        Recipe recipe = new Recipe();
        recipe.setDescription(DESCRIPTION_RECIPE);

        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setAmount(AMOUNT);
        ingredient.setDescription(DESCRIPTION);
        ingredient.setUom(uom);
        ingredient.setRecipe(recipe);

        //when
        IngredientCommand command = converter.convert(ingredient);

        //then
        assertEquals(ID_VALUE, command.getId());
        assertEquals(AMOUNT, command.getAmount());
        assertEquals(DESCRIPTION, command.getDescription());
        assertNotNull(command.getUnitOfMeasure());
        assertEquals(UOM_ID, command.getUnitOfMeasure().getId());
        assertEquals(DESCRIPTION_UOM, command.getUnitOfMeasure().getDescription());
    }
}
