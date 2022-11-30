import jewellery.store.project.Case;
import jewellery.store.project.LinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTests {
    private LinkedList<Case> list;

    private Case caseOnBoundary, caseInvalidData;
//    private Tray trayOnBoundary, trayInvalidData;
//    private Jewellery itemOnBoundary, itemInvalidData;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();

        caseOnBoundary = new Case("mounted","lit",1);
        caseInvalidData = new Case("","off",-1);

//        trayOnBoundary = new Tray("20cm","red",'A',1);
//        trayInvalidData = new Tray("","",'@', 0);
//
//        itemOnBoundary = new Jewellery("Ring", 20, "male", "looks good");
//        itemInvalidData = new Jewellery("", 20, "", "looks good");
    }

    @AfterEach
    void tearDown() {
        caseOnBoundary = caseInvalidData = null;
        list = new LinkedList<>();
    }

        @Test
        void isListEmpty(){
            //LinkedList<Case> list = new LinkedList<>();
            assertEquals(0, list.size());
            assertTrue(list.isEmpty());
        }

        @Test
        void addToList(){
            list.add(caseOnBoundary);
            assertEquals(1, list.size());
            assertFalse(list.isEmpty());
        }

        @Test
        void deleteFromList(){
            list.add(caseOnBoundary);
            assertEquals(1, list.size());
            assertFalse(list.isEmpty());

            list.delAll();
            assertEquals(0, list.size());
            assertTrue(list.isEmpty());
        }

        @Test
        void deleteNode(){
            list.add(caseOnBoundary);
            list.add(caseOnBoundary);
            assertEquals(2, list.size());
            assertFalse(list.isEmpty());

            list.deleteNode(1);
            assertEquals(1, list.size());
            assertFalse(list.isEmpty());
        }

        @Test
        void listOneNode(){
            list.add(caseOnBoundary);
            list.add(caseInvalidData);
            assertEquals(2, list.size());

            assertEquals(caseInvalidData.toString(), list.listOne());

        }

        @Test
        void listAllNode(){
            list.add(caseOnBoundary);
            list.add(caseInvalidData);
            assertEquals(2, list.size());

            assertEquals(caseOnBoundary.toString() + caseInvalidData.toString(), list.listAll());
        }

//        @Test
//        void getItem(){
//            list.add(caseOnBoundary);
//            System.out.println(list.listOne());
//            assertEquals(1, list.size());
//            assertFalse(list.isEmpty());
//
//            assertEquals(caseOnBoundary, list.get(1));
//            System.out.println(list.get(1));
//        }
}
