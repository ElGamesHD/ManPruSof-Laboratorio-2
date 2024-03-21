package deque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("LinkedNode Test")
class LinkedNodeTest {

    LinkedNode<Object> node;

    @Test
    @DisplayName("La estructura de datos se instancia con new")
    public void isInstanciateWithNew() {
        new LinkedNode(1, null, null);
    }

    @Nested
    @DisplayName("Cuando se crea la estructura")
    class AfterConstructor {

        @Test
        @DisplayName("El metodo getItem retorna el item correcto")
        public void getItem_ExistsItem_ReturnItem() {
            Object expected = 1;
            node = new LinkedNode<>(1, null, null);

            assertEquals(expected, node.getItem());
        }

        @Test
        @DisplayName("El método getPrevious retorna null si no existe el nodo anterior")
        public void getPrevious_NotExistsPrevious_ReturnLinkedNode() {
            Object expected = null;
            node = new LinkedNode<>(1, null, null);

            LinkedNode<Object> previous = node.getPrevious();

            assertEquals(expected, previous);
        }

        @Test
        @DisplayName("El método getNext retorna null si no existe el nodo siguiente")
        public void getNext_ExistsNext_ReturnLinkedNode() {
            Object expected = null;
            node = new LinkedNode<>(1, null, null);

            LinkedNode<Object> next = node.getNext();

            assertEquals(expected, next);
        }

        @Test
        @DisplayName("El método isFirstNode retorna true si es el primero")
        public void isFirstNode_isFirst_ReturnTrue() {
            node = new LinkedNode<Object>(1, null, null);

            Boolean result = node.isFirstNode();

            assertTrue(result);
        }

        @Test
        @DisplayName("El método isLastNode retorna true si es el último")
        public void isLastNode_isLast_ReturnTrue() {
            node = new LinkedNode<Object>(1, null, null);

            Boolean result = node.isLastNode();

            assertTrue(result);
        }

        @Test
        @DisplayName("El método isNotATerminalNode retorna false si es terminal")
        public void isNotATerminalNode_Is_ReturnFalse() {
            node = new LinkedNode<Object>(1, null, null);

            Boolean result = node.isNotATerminalNode();

            assertFalse(result);
        }

        @Test
        @DisplayName("El método setItem cambia el item")
        public void setItem_ChangeItem_ReturnTrue() {
            node = new LinkedNode<>(1, null, null);
            Object newItem = 3;
            node.setItem(newItem);

            Object expected = node.getItem();

            assertEquals(expected, newItem);
        }

        @Nested
        @DisplayName("Cuando se cambia el nodo anterior")
        class AfterSettingPreviousNode {

            @BeforeEach
            public void setPreviousNode() {
                node = new LinkedNode<>(1, null, null);
                LinkedNode<Object> previousNode = new LinkedNode<>(2, null, node);
                node.setPrevious(previousNode);
            }

            @Test
            @DisplayName("El método isFirstNode retorna false si no es el primero")
            public void isFirstNode_NotFirst_ReturnFalse() {
                Boolean result = node.isFirstNode();

                assertFalse(result);
            }

            @Test
            @DisplayName("El método isNotATerminalNode retorna false si es terminal")
            public void isNotATerminalNode_Is_ReturnFalse() {
                Boolean result = node.isNotATerminalNode();

                assertFalse(result);
            }

            @Nested
            @DisplayName("Cuando se añade el nodo siguiente")
            class AfterSettingNextNode {

                @BeforeEach
                public void setNextNode() {
                    node = new LinkedNode<>(1, null, null);
                    LinkedNode<Object> previousNode = new LinkedNode<>(2, null, node);
                    node.setPrevious(previousNode);
                    LinkedNode<Object> nextNode = new LinkedNode<>(2, node, null);
                    node.setNext(nextNode);
                }

                @Test
                @DisplayName("El método isLastNode retorna false si no es el último")
                public void isLastNode_NotLast_ReturnFalse() {
                    Boolean result = node.isLastNode();

                    assertFalse(result);
                }

                @Test
                @DisplayName("El método isNotATerminalNode retorna true si no es terminal")
                public void isNotATerminalNode_Is_ReturnTrue() {
                    Boolean result = node.isNotATerminalNode();

                    assertTrue(result);
                }
            }
        }

    }
}
