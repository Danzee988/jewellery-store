import jewellery.store.project.Material;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MaterialTests {
    private Material materialOnBoundary, materialInvalidData;

    @BeforeEach
    void setUp() {
        materialOnBoundary = new Material("Gold", "14K", 12, "looks good");
        materialInvalidData = new Material("", "", 0, "");
    }

    @AfterEach
    void tearDown() {
        materialOnBoundary = materialInvalidData = null;
    }

    @Nested
    class Getters {

        @Test
        void getMaterialType(){
            assertEquals("Gold", materialOnBoundary.getMaterialType());
            assertEquals("", materialInvalidData.getMaterialType());
        }

        @Test
        void getMaterialQuality(){
            assertEquals("14K", materialOnBoundary.getQuality());
            assertEquals("", materialInvalidData.getQuality());
        }

        @Test
        void getMaterialWeight(){
            assertEquals(12, materialOnBoundary.getWeight());
            assertEquals(0, materialInvalidData.getWeight());
        }

        @Test
        void getMaterialDes(){
            assertEquals("looks good", materialOnBoundary.getMaterialDes());
            assertEquals("", materialInvalidData.getMaterialDes());
        }


    }

    @Nested
    class Setters {

        @Test
        void setMaterialType(){
            assertEquals("Gold", materialOnBoundary.getMaterialType());
            materialOnBoundary.setMaterialType("Watch");
            assertEquals("Watch", materialOnBoundary.getMaterialType());
        }

        @Test
        void setMaterialQuality(){
            assertEquals("14K", materialOnBoundary.getQuality());
            materialOnBoundary.setQuality("20K");
            assertEquals("20K", materialOnBoundary.getQuality());
        }

        @Test
        void setMaterialWeight(){
            assertEquals(12, materialOnBoundary.getWeight());
            materialOnBoundary.setWeight(10);
            assertEquals(10, materialOnBoundary.getWeight());
        }

        @Test
        void setMaterialDes(){
            assertEquals("looks good", materialOnBoundary.getMaterialDes());
            materialOnBoundary.setMaterialDes("not too good");
            assertEquals("not too good", materialOnBoundary.getMaterialDes());
        }

    }


    @Test
    void toStringReturnsCorrectString() {
        Material m = materialOnBoundary;

        String stringContents = m.toString();

        assertTrue(stringContents.contains("Material Type: " + m.getMaterialType()));
        assertTrue(stringContents.contains(" || Material Quality: " + m.getQuality()));
        assertTrue(stringContents.contains(" || Material Weight: " + m.getWeight()));
        assertTrue(stringContents.contains("|| Material Description: " + m.getMaterialDes()));

    }
}
