import jewellery.store.project.Case;
import jewellery.store.project.Jewellery;
import jewellery.store.project.Tray;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CaseTests {

    private Case caseOnBoundary, caseInvalidData;
    private Tray trayOnBoundary, trayInvalidData;
    private Jewellery itemOnBoundary, itemInvalidData;

    @BeforeEach
    void setUp() {
        caseOnBoundary = new Case("mounted","lit",1);
        caseInvalidData = new Case("","off",-1);

        trayOnBoundary = new Tray("20cm","red",'A',1);
        trayInvalidData = new Tray("","",'@', 0);

        itemOnBoundary = new Jewellery("Ring", 20, "male", "looks good");
        itemInvalidData = new Jewellery("", 20, "", "looks good");
    }

    @AfterEach
    void tearDown() {
         caseOnBoundary = caseInvalidData = null;
    }

    @Nested
    class Getters {

        @Test
        void getCaseType(){
            assertEquals("mounted", caseOnBoundary.getType());
            assertEquals("", caseInvalidData.getType());
        }

        @Test
        void getCaseLighting(){
            assertEquals("lit", caseOnBoundary.getLighting());
            assertEquals("off", caseInvalidData.getLighting());
        }

        @Test
        void getCaseNumber(){
            assertEquals(1, caseOnBoundary.getDisplayNumber());
            assertEquals(-1, caseInvalidData.getDisplayNumber());
        }


    }

    @Nested
    class Setters {

        @Test
        void setCaseType(){
            assertEquals("mounted", caseOnBoundary.getType());
            caseOnBoundary.setType("Freestanding");
            assertEquals("Freestanding", caseOnBoundary.getType());
        }

        @Test
        void setCaseLighting(){
            assertEquals("lit", caseOnBoundary.getLighting());
            caseOnBoundary.setLighting("Unlit");
            assertEquals("Unlit", caseOnBoundary.getLighting());
        }

        @Test
        void setCaseNumber(){
            assertEquals(1, caseOnBoundary.getDisplayNumber());
            caseOnBoundary.setDisplayNumber(2);
            assertEquals(2, caseOnBoundary.getDisplayNumber());
        }

    }


    @Test
    void toStringReturnsCorrectString() {
        Case c1 = caseOnBoundary;
        //Case c2 = caseInvalidData;
        String stringContents = c1.toString();

        assertTrue(stringContents.contains(" || Case type: " + c1.getType()));
        assertTrue(stringContents.contains("Case number: " + c1.getDisplayNumber()));
        assertTrue(stringContents.contains(" || Case lighting: " + c1.getLighting()));
    }
}
