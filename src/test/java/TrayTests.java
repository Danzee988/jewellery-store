import jewellery.store.project.Jewellery;
import jewellery.store.project.Tray;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrayTests {

    private Tray trayOnBoundary, trayInvalidData;
    private Jewellery itemOnBoundary, itemInvalidData;

    @BeforeEach
    void setUp() {
        trayOnBoundary = new Tray("20cm","red",'A',1);
        trayInvalidData = new Tray("","",'@', 0);

        itemOnBoundary = new Jewellery("Ring", 20, "male", "looks good");
        itemInvalidData = new Jewellery("", 20, "", "looks good");
    }

    @AfterEach
    void tearDown() {
        trayOnBoundary = trayInvalidData = null;
    }

    @Nested
    class Getters {

        @Test
        void getTraySize(){
            assertEquals("20cm", trayOnBoundary.getSize());
            assertEquals("", trayInvalidData.getSize());
        }

        @Test
        void getTrayColour(){
            assertEquals("red", trayOnBoundary.getColour());
            assertEquals("", trayInvalidData.getColour());
        }

        @Test
        void getTrayNumber(){
            assertEquals(1, trayOnBoundary.getTrayNumber());
            assertEquals(0, trayInvalidData.getTrayNumber());
        }

        @Test
        void getTrayID(){
            assertEquals('A', trayOnBoundary.getId());
            assertEquals('@', trayInvalidData.getId());
        }


    }

    @Nested
    class Setters {

        @Test
        void setTraySize(){
            assertEquals("20cm", trayOnBoundary.getSize());
            trayOnBoundary.setSize("40cm");
            assertEquals("40cm", trayOnBoundary.getSize());
        }

        @Test
        void setTrayColour(){
            assertEquals("red", trayOnBoundary.getColour());
            trayOnBoundary.setColour("blue");
            assertEquals("blue", trayOnBoundary.getColour());
        }

        @Test
        void setTrayID(){
            assertEquals("A1", trayOnBoundary.identifier());
            trayOnBoundary.setTrayNumber(2);
            trayOnBoundary.setId('B');
            assertEquals("B2", trayOnBoundary.identifier());
        }

    }


    @Test
    void toStringReturnsCorrectString() {
        Tray t = trayOnBoundary;
        String stringContents = t.toString();

        assertTrue(stringContents.contains(" || Tray Dimensions: " + t.getSize()));
        assertTrue(stringContents.contains(" || Tray Colour: " + t.getColour()));
        assertTrue(stringContents.contains("Tray : " + t.identifier()));

    }
}
