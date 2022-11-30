import jewellery.store.project.Jewellery;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JewelleryTests {
    private Jewellery itemOnBoundary, itemInvalidData;

    @BeforeEach
    void setUp() {
        itemOnBoundary = new Jewellery("Ring", 20, "male", "looks good");
        itemInvalidData = new Jewellery("", 0, "", "");
    }

    @AfterEach
    void tearDown() {
        itemOnBoundary = itemInvalidData = null;
    }

    @Nested
    class Getters {

        @Test
        void getItemType(){
            assertEquals("Ring", itemOnBoundary.getItemType());
            assertEquals("", itemInvalidData.getItemType());
        }

        @Test
        void getItemPrice(){
            assertEquals(20, itemOnBoundary.getPrice());
            assertEquals(0, itemInvalidData.getPrice());
        }

        @Test
        void getItemGender(){
            assertEquals("male", itemOnBoundary.getGender());
            assertEquals("", itemInvalidData.getGender());
        }

        @Test
        void getItemDetail(){
            assertEquals("looks good", itemOnBoundary.getItemDetail());
            assertEquals("", itemInvalidData.getItemDetail());
        }


    }

    @Nested
    class Setters {

        @Test
        void setItemType(){
            assertEquals("Ring", itemOnBoundary.getItemType());
            itemOnBoundary.setItemType("Watch");
            assertEquals("Watch", itemOnBoundary.getItemType());
        }

        @Test
        void setItemPrice(){
            assertEquals(20, itemOnBoundary.getPrice());
            itemOnBoundary.setPrice(30);
            assertEquals(30, itemOnBoundary.getPrice());
        }

        @Test
        void setItemGender(){
            assertEquals("male", itemOnBoundary.getGender());
            itemOnBoundary.setGender("female");
            assertEquals("female", itemOnBoundary.getGender());
        }

        @Test
        void setItemDetail(){
            assertEquals("looks good", itemOnBoundary.getItemDetail());
            itemOnBoundary.setItemDetail("not too good");
            assertEquals("not too good", itemOnBoundary.getItemDetail());
        }

    }


    @Test
    void toStringReturnsCorrectString() {
        Jewellery j = itemOnBoundary;
        //Case c2 = caseInvalidData;
        String stringContents = j.toString();

        assertTrue(stringContents.contains("Item: " +  j.getItemType()));
        assertTrue(stringContents.contains(" || Target Gender: " + j.getGender()));
        assertTrue(stringContents.contains(" || Item Price: " + j.getPrice()));
        assertTrue(stringContents.contains(" || Item Description: " + j.getItemDetail()));

    }
}
