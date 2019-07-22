package guru.springframework.converters;


import static org.junit.Assert.*;

import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

public class UnitOfMeasureCommandToUnitOfMeasureTest {

    public static final Long ID_VALUE = 1L;
    public static final String DESCRIPTION = "description";
    UnitOfMeasureCommandToUnitOfMeasure converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureCommandToUnitOfMeasure();
    }

    @Test
    public void convert() {
        //given
        UnitOfMeasureCommand command = new UnitOfMeasureCommand();
        command.setId(ID_VALUE);
        command.setDescription(DESCRIPTION);

        //when
        UnitOfMeasure unitOfMeasure = converter.convert(command);

        //then
        assertEquals(ID_VALUE, unitOfMeasure.getId());
        assertEquals(DESCRIPTION, unitOfMeasure.getDescription());
    }

    @Test
    public void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new UnitOfMeasureCommand()));
    }
}
