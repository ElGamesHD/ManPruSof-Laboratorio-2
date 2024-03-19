package deque;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("A double linked list")
public class DoubleLinkedListTest {

    DoubleLinkedList<Object> doubleLinkedList;

    @Test
    @DisplayName("Se inicializa con new DoubleLinkedList()")
    public void DoubleLinkedList_OnInit_IsInstantiated() {
        new DoubleLinkedList<>();
    }

    @Nested
    @DisplayName("Al crear la estructura")
    class AfterConstructor {

        @BeforeEach
        public void setup() {
            doubleLinkedList = new DoubleLinkedList<>();
        }

        @Test
        @DisplayName("Al hacer preprend, el único elemento que hay es el añadido, que es además el primero y el último")
        public void prepend_AfterConstructor_UniqueNode() {

        }

        @Test
        @DisplayName("El tamaño es 0")
        public void size_AfterConstructor_ReturnsZero() {
            int expectedSize = 0;

            int actualSize = doubleLinkedList.size();

            assertEquals(expectedSize, actualSize);
        }
    }
}
