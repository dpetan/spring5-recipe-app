package guru.springframework.converters;

import static org.junit.Assert.*;

import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

public class UnitOfMeasureToUnitOfMeasureCommandTest {

    public static final Long ID_VALUE = 1L;
    public static final String DESCRIPTION = "description";
    UnitOfMeasureToUnitOfMeasureCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void convert() {
        //given
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(ID_VALUE);
        unitOfMeasure.setDescription(DESCRIPTION);

        //when
        UnitOfMeasureCommand command = converter.convert(unitOfMeasure);

        //then
        assertEquals(ID_VALUE, command.getId());
        assertEquals(DESCRIPTION, command.getDescription());
    }

    @Test
    public void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }
}
