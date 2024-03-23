package deque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("A double linked list")
public class DoubleLinkedListTest {

    DoubleLinkedList<Object> doubleLinkedList;

    @BeforeEach
    public void setup() {
        doubleLinkedList = new DoubleLinkedList<>();
    }

    @Test
    @DisplayName("Se inicializa con new DoubleLinkedList()")
    public void DoubleLinkedList_OnInit_IsInstantiated() {
        new DoubleLinkedList<>();
    }

    @Nested
    @DisplayName("Tests que comprueben el método prepend")
    class Prepend {

        @Test
        @DisplayName("Al hacer preprend de la estructura vacía, el único elemento que hay es el añadido, que es además el primero y el último")
        public void prepend_EmptyList_FirstAndLastEqualNewItem() {
            Object item = "Elemento 1";

            doubleLinkedList.prepend(item);
            Object actualFirst = doubleLinkedList.first();
            Object actualLast = doubleLinkedList.last();

            assertEquals(item, actualFirst);
            assertEquals(item, actualLast);
        }

        @Test
        @DisplayName("Al hacer prepend de la estructura con un único elemento, este elemento pasa a ser el primero, y el que había pasa a ser el último")
        public void prepend_OneItem_NewItemFirstOldItemLast() {
            Object item1 = "Elemento 1";
            doubleLinkedList.prepend(item1);
            Object item2 = "Elemento 2";

            doubleLinkedList.prepend(item2);
            Object actualFirst = doubleLinkedList.first();
            Object actualLast = doubleLinkedList.last();

            assertEquals(item1, actualLast);
            assertEquals(item2, actualFirst);
        }
    }

    @Nested
    @DisplayName("Tests que comprueben el método append")
    class Append {

        @Test
        @DisplayName("Al hacer append de la estructura vacía, el único elemento que hay es el añadido, que es además el primero y el último")
        public void append_EmptyList_FirstAndLastEqualNewItem() {
            Object item = "Elemento 1";

            doubleLinkedList.append(item);
            Object actualFirst = doubleLinkedList.first();
            Object actualLast = doubleLinkedList.last();

            assertEquals(item, actualFirst);
            assertEquals(item, actualLast);
        }

        @Test
        @DisplayName("Al hacer append de la estructura con un único elemento, este elemento pasa a ser el último, y el que había pasa a ser el primero")
        public void append_OneItem_NewItemLastOldItemFirst() {
            Object item1 = "Elemento 1";
            doubleLinkedList.append(item1);
            Object item2 = "Elemento 2";

            doubleLinkedList.append(item2);
            Object actualFirst = doubleLinkedList.first();
            Object actualLast = doubleLinkedList.last();

            assertEquals(item1, actualFirst);
            assertEquals(item2, actualLast);
        }
    }

    @Nested
    @DisplayName("Test que comprueben el método deleteFirst")
    class DeleteFirst {

        @Test
        @DisplayName("Al hacer deleteFirst de la estructura vacía, se lanza un error")
        public void deleteFirst_EmptyList_ThrowsError() {
            assertThrows(DoubleLinkedQueueException.class, () -> {
                doubleLinkedList.deleteFirst();
            });
        }

        @Test
        @DisplayName("Al hacer deleteFirst de la estructura con un elemento, esta se queda vacía")
        public void deleteFirst_OneItem_FirstAndLastNull() {
            Object item = "Elemento 1";
            doubleLinkedList.prepend(item);

            doubleLinkedList.deleteFirst();

            assertThrows(DoubleLinkedQueueException.class, () -> doubleLinkedList.first());
            assertThrows(DoubleLinkedQueueException.class, () -> doubleLinkedList.last());
        }

        @Test
        @DisplayName("Al hacer deleteFirst de la estructura con más de un elemento, se elimina el primer elemento")
        public void deleteFirst_TwoOrMoreItems_FirstRemoved() {
            Object item1 = "Elemento 1";
            doubleLinkedList.prepend(item1);
            Object item2 = "Elemento 2";
            doubleLinkedList.prepend(item2);

            doubleLinkedList.deleteFirst();
            Object actualFirst = doubleLinkedList.first();

            assertEquals(item1, actualFirst);
        }
    }

    @Nested
    @DisplayName("Test que comprueben el método deleteLast")
    class DeleteLast {

        @Test
        @DisplayName("Al hacer deleteLast de la estructura vacía, se lanza un error")
        public void deleteLast_EmptyList_ThrowsError() {
            assertThrows(DoubleLinkedQueueException.class, () -> {
                doubleLinkedList.deleteLast();
            });
        }

        @Test
        @DisplayName("Al hacer deleteLast de la estructura con un elemento, esta se queda vacía")
        public void deleteLast_OneItem_FirstAndLastNull() {
            Object item = "Elemento 1";
            doubleLinkedList.prepend(item);

            doubleLinkedList.deleteLast();

            assertThrows(DoubleLinkedQueueException.class, () -> doubleLinkedList.first());
            assertThrows(DoubleLinkedQueueException.class, () -> doubleLinkedList.last());
        }

        @Test
        @DisplayName("Al hacer deleteLast de la estructura con más de un elemento, se elimina el último elemento")
        public void deleteLast_TwoOrMoreItems_LastRemoved() {
            Object item1 = "Elemento 1";
            doubleLinkedList.prepend(item1);
            Object item2 = "Elemento 2";
            doubleLinkedList.prepend(item2);

            doubleLinkedList.deleteLast();
            Object actualLast = doubleLinkedList.last();

            assertEquals(item2, actualLast);
        }
    }

    @Nested
    @DisplayName("Test que comprueben el método first")
    class First {

        @Test
        @DisplayName("Al hacer first de de la estructura vacía, se lanza un error")
        public void first_EmptyList_ThrowsError() {
            assertThrows(DoubleLinkedQueueException.class, () -> {
                doubleLinkedList.first();
            });
        }

        @Test
        @DisplayName("Al hacer first de la con un elemento, se devuelve ese elemento")
        public void first_OneElement_ReturnsElement() {
            Object item = "Elemento 1";
            doubleLinkedList.prepend(item);
            Object expectedFirst = item;

            Object actualFirst = doubleLinkedList.first();

            assertEquals(expectedFirst, actualFirst);
        }

        @Test
        @DisplayName("Al hacer first de de la estructura con más de un elemento, se devuelve el primer elemento")
        public void first_TwoOrMoreElements_ReturnsElement() {
            Object item1 = "Elemento 1";
            doubleLinkedList.prepend(item1);
            Object item2 = "Elemento 2";
            doubleLinkedList.prepend(item2);
            Object expectedFirst = item2;

            Object actualFirst = doubleLinkedList.first();

            assertEquals(expectedFirst, actualFirst);
        }
    }

    @Nested
    @DisplayName("Test que comprueben el método last")
    class Last {

        @Test
        @DisplayName("Al hacer last de de la estructura vacía, se lanza un error")
        public void last_EmptyList_ThrowsError() {
            assertThrows(DoubleLinkedQueueException.class, () -> {
                doubleLinkedList.last();
            });
        }

        @Test
        @DisplayName("Al hacer last de la con un elemento, se devuelve ese elemento")
        public void last_OneElement_ReturnsElement() {
            Object item = "Elemento 1";
            doubleLinkedList.prepend(item);
            Object expectedLast = item;

            Object actualLast = doubleLinkedList.last();

            assertEquals(expectedLast, actualLast);
        }

        @Test
        @DisplayName("Al hacer last de de la estructura con más de un elemento, se devuelve el útimo elemento")
        public void last_TwoOrMoreElements_ReturnsElement() {
            Object item1 = "Elemento 1";
            doubleLinkedList.prepend(item1);
            Object item2 = "Elemento 2";
            doubleLinkedList.prepend(item2);
            Object expectedLast = item1;

            Object actualLast = doubleLinkedList.last();

            assertEquals(expectedLast, actualLast);
        }
    }

    @Nested
    @DisplayName("Test que comprueben el método size")
    class Size {

        @Test
        @DisplayName("Al hacer size de la estructura vacía, se devuelve 0")
        public void size_EmptyList_ReturnsZero() {
            int expectedSize = 0;

            int actualSize = doubleLinkedList.size();

            assertEquals(expectedSize, actualSize);
        }

        @Test
        @DisplayName("Al hacer size de la estructura no vacía, se devuelve la cantidad de elementos de la estructura")
        public void size_NonEmptyList_ReturnsActualSize() {
            doubleLinkedList.prepend("Elemento 1");
            doubleLinkedList.prepend("Elemento 2");
            doubleLinkedList.prepend("Elemento 3");
            doubleLinkedList.prepend("Elemento 4");
            doubleLinkedList.prepend("Elemento 5");
            doubleLinkedList.prepend("Elemento 6");
            int expectedSize = 6;

            int actualSize = doubleLinkedList.size();

            assertEquals(expectedSize, actualSize);
        }
    }

    @Nested
    @DisplayName("Tests que comprueban el método get")
    class Get {

        @Test
        @DisplayName("Al hacer get de la estructura vacía, se lanza un error")
        public void get_EmptyList_ThrowsError() {
            int index = 0;

            assertThrows(DoubleLinkedQueueException.class, () -> {
                doubleLinkedList.get(index);
            });
        }

        @Test
        @DisplayName("Al hacer get con un índice negativo, se debe lanzar un error")
        public void get_NegativeIndex_ThrowsError() {
            doubleLinkedList.prepend("Elemento 1");
            int index = -1;

            assertThrows(DoubleLinkedQueueException.class, () -> doubleLinkedList.get(index));
        }

        @Test
        @DisplayName("Al hacer get con un índice mayor que el tamaño de la estructura," +
                "se debe lanzar un error")
        public void get_IndexOutOfBounds_ThrowsError() {
            doubleLinkedList.prepend("Elemento 1");
            doubleLinkedList.prepend("Elemento 2");
            doubleLinkedList.prepend("Elemento 3");
            doubleLinkedList.prepend("Elemento 4");
            doubleLinkedList.prepend("Elemento 5");
            int indice = 6;

            assertThrows(DoubleLinkedQueueException.class, () -> doubleLinkedList.get(indice));
        }

        @ParameterizedTest
        @CsvSource({
                "0", "1", "2", "3", "4", "5"
        })
        @DisplayName("Al hacer get con un índice correcto, te debe devolver el valor correcto")
        public void get_ValidIndex_ReturnsElement(int index) {
            Object[] datos = { "Elemento 6", "Elemento 5", "Elemento 4",
                    "Elemento 3", "Elemento 2", "Elemento 1" };
            doubleLinkedList.prepend(datos[0]);
            doubleLinkedList.prepend(datos[1]);
            doubleLinkedList.prepend(datos[2]);
            doubleLinkedList.prepend(datos[3]);
            doubleLinkedList.prepend(datos[4]);
            doubleLinkedList.prepend(datos[5]);
            Object expected = datos[datos.length - index - 1];

            Object actual = doubleLinkedList.get(index);

            assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("Tests que comprueban el método contains")
    class Contains {

        @Test
        @DisplayName("Al hacer contains de la estructura vacía, se devuelve false")
        public void contains_EmptyList_ReturnFalse() {
            Object item = "Elemento 1";

            boolean actual = doubleLinkedList.contains(item);

            assertFalse(actual);
        }

        @Test
        @DisplayName("AL hacer contains de la estructura con un elemento que no está, se devuelve false")
        public void contains_ElementNotInList_ReturnFalse() {
            doubleLinkedList.prepend("Elemento 1");
            doubleLinkedList.prepend("Elemento 2");
            doubleLinkedList.prepend("Elemento 3");
            Object item = "Elemento 4";

            boolean result = doubleLinkedList.contains(item);

            assertFalse(result);
        }

        @ParameterizedTest
        @CsvSource({
                "Elemento 1", "Elemento 3", "Elemento 4", "Elemento 6"
        })
        @DisplayName("Al hacer contains de la estructura con un elemento que está, se devuelve true")
        public void contains_ElementInList_ReturnTrue(Object item) {
            doubleLinkedList.prepend("Elemento 1");
            doubleLinkedList.prepend("Elemento 2");
            doubleLinkedList.prepend("Elemento 3");
            doubleLinkedList.prepend("Elemento 4");
            doubleLinkedList.prepend("Elemento 5");
            doubleLinkedList.prepend("Elemento 6");

            boolean result = doubleLinkedList.contains(item);

            assertTrue(result);
        }
    }
}
