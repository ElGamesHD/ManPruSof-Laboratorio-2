package deque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    @DisplayName("El metodo getItem retorna el item correcto")
    public void getItem_ExistsItem_ReturnItem() {
        Object expected = 1;
        node = new LinkedNode<>(1, null, null);

        Object item = node.getItem();

        assertEquals(expected, item);
    }

    @Test
    @DisplayName("El método setItem cambia el item")
    public void setItem_ChangeItem_ReturnTrue() {
        node = new LinkedNode<>(1, null, null);
        Object expected = 3;

        node.setItem(expected);
        Object newItem = node.getItem();

        assertEquals(expected, newItem);
    }

    @Nested
    @DisplayName("Tests que comprueban los métodos get y set de Previous")
    class PreviousTest {

        @Test
        @DisplayName("El método getPrevious retorna null si no existe el nodo anterior")
        public void getPrevious_NotExistsPrevious_ReturnNull() {
            Object expected = null;
            node = new LinkedNode<>(1, null, null);

            LinkedNode<Object> previous = node.getPrevious();

            assertEquals(expected, previous);
        }

        @Test
        @DisplayName("El método getPrevious retorna el nodo anterior si existe")
        public void getPrevious_ExistsPrevious_ReturnLinkedNode() {
            node = new LinkedNode<>(1, null, null);
            LinkedNode<Object> previousNode = new LinkedNode<>(0, null, null);
            node.setPrevious(previousNode);

            LinkedNode<Object> previous = node.getPrevious();

            assertEquals(previousNode, previous);
        }

    }

    @Nested
    @DisplayName("Tests que comprueban los métodos get y set de Next")
    class nextTest {
        @Test
        @DisplayName("El método getNext retorna null si no existe el nodo siguiente")
        public void getNext_NotExistsNext_ReturnNull() {
            Object expected = null;
            node = new LinkedNode<>(1, null, null);

            LinkedNode<Object> next = node.getNext();

            assertEquals(expected, next);
        }

        @Test
        @DisplayName("El método getNext retorna el nodo posterior si existe")
        public void getNext_ExistsNext_ReturnLinkedNode() {
            node = new LinkedNode<>(1, null, null);
            LinkedNode<Object> nextNode = new LinkedNode<>(1, null, null);
            node.setNext(nextNode);

            LinkedNode<Object> next = node.getNext();

            assertEquals(nextNode, next);
        }
    }

    @Nested
    @DisplayName("Test que comprueban el método isFirstNode")
    class isFirstNodeTest {
        @Test
        @DisplayName("El método isFirstNode retorna true si es el primero")
        public void isFirstNode_OnlyOneElementIsFirst_ReturnTrue() {
            node = new LinkedNode<Object>(1, null, null);

            Boolean result = node.isFirstNode();

            assertTrue(result);
        }

        @Test
        @DisplayName("El método isFirstNode retorna false si no es el primero")
        public void isFirstNode_MoreOneElementIsFirst_ReturnTrue() {
            node = new LinkedNode<Object>(1, null, null);
            LinkedNode<Object> nextNode = new LinkedNode<>(1, null, null);
            nextNode.setPrevious(node);
            node.setNext(nextNode);

            Boolean result = node.isFirstNode();

            assertTrue(result);
        }

        @Test
        @DisplayName("El método isFirstNode retorna false si no es el primero")
        public void isFirstNode_isInMiddle_ReturnFalse() {
            node = new LinkedNode<Object>(1, null, null);
            LinkedNode<Object> previousNode = new LinkedNode<>(1, null, null);
            LinkedNode<Object> nextNode = new LinkedNode<>(1, null, null);
            previousNode.setNext(node);
            node.setPrevious(previousNode);
            nextNode.setPrevious(node);
            node.setNext(nextNode);

            Boolean result = node.isFirstNode();

            assertFalse(result);
        }

        @Test
        @DisplayName("El método isFirstNode retorna false si es el último")
        public void isFirstNode_isLast_ReturnFalse() {
            node = new LinkedNode<Object>(1, null, null);
            LinkedNode<Object> previousNode = new LinkedNode<>(1, null, null);
            previousNode.setNext(node);
            node.setPrevious(previousNode);

            Boolean result = node.isFirstNode();

            assertFalse(result);
        }
    }

    @Nested
    @DisplayName("Test que comprueban el método isLastNode")
    class isLastNodeTest {
        @Test
        @DisplayName("El método isLastNode retorna true si es el último")
        public void isLastNode_OnlyOneElementIsLast_ReturnTrue() {
            node = new LinkedNode<Object>(1, null, null);

            Boolean result = node.isLastNode();

            assertTrue(result);
        }

        @Test
        @DisplayName("El método isLastNode retorna true si es el último")
        public void isLastNode_MoreOneElementIsLast_ReturnTrue() {
            node = new LinkedNode<Object>(1, null, null);
            LinkedNode<Object> previousNode = new LinkedNode<>(1, null, null);
            previousNode.setNext(node);
            node.setPrevious(previousNode);
            Boolean result = node.isLastNode();
            assertTrue(result);
        }

        @Test
        @DisplayName("El método isLastNode retorna false si no es el último")
        public void isLastNode_MoreOneElementIsInMiddle_ReturnFalse() {
            node = new LinkedNode<Object>(1, null, null);
            LinkedNode<Object> nextNode = new LinkedNode<>(1, null, null);
            LinkedNode<Object> previousNode = new LinkedNode<>(1, null, null);
            nextNode.setPrevious(node);
            node.setNext(nextNode);
            previousNode.setNext(node);
            node.setPrevious(previousNode);

            Boolean result = node.isLastNode();

            assertFalse(result);
        }

        @Test
        @DisplayName("El método isLastNode retorna false si es el primero")
        public void isLastNode_MoreOneElementIsFirst_ReturnFalse() {
            node = new LinkedNode<Object>(1, null, null);
            LinkedNode<Object> nextNode = new LinkedNode<>(1, null, null);
            nextNode.setPrevious(node);
            node.setNext(nextNode);

            Boolean result = node.isLastNode();

            assertFalse(result);
        }
    }

    @Nested
    @DisplayName("Test que comprueban el método isNotATerminalNode")
    class isNotATerminalNodeTest {

        @Test
        @DisplayName("El método isNotATerminalNode retorna false si solo hay un elemento")
        public void isNotATerminalNode_OneElement_ReturnFalse() {
            node = new LinkedNode<Object>(1, null, null);

            Boolean result = node.isNotATerminalNode();

            assertFalse(result);
        }

        @Test
        @DisplayName("El método isNotATerminalNode retorna true si no es terminal")
        public void isNotATerminalNode_MoreOneElementIsNot_ReturnTrue() {
            node = new LinkedNode<Object>(1, null, null);
            LinkedNode<Object> nextNode = new LinkedNode<>(1, null, null);
            LinkedNode<Object> previousNode = new LinkedNode<>(1, null, null);
            nextNode.setPrevious(node);
            node.setNext(nextNode);
            previousNode.setNext(node);
            node.setPrevious(previousNode);

            Boolean result = node.isNotATerminalNode();

            assertTrue(result);
        }

        @Test
        @DisplayName("El método isNotATerminalNode retorna false si es el primero")
        public void isNotATerminalNode_MoreOneElementIsFirst_ReturnFalse() {
            node = new LinkedNode<Object>(1, null, null);
            LinkedNode<Object> nextNode = new LinkedNode<>(1, null, null);
            nextNode.setPrevious(node);
            node.setNext(nextNode);

            Boolean result = node.isNotATerminalNode();

            assertFalse(result);
        }

        @Test
        @DisplayName("El método isNotATerminalNode retorna false si es el último")
        public void isNotATerminalNode_MoreOneElementIsLAst_ReturnFalse() {
            node = new LinkedNode<Object>(1, null, null);
            LinkedNode<Object> previousNode = new LinkedNode<>(1, null, null);
            previousNode.setNext(node);
            node.setPrevious(previousNode);

            Boolean result = node.isNotATerminalNode();

            assertFalse(result);
        }
    }

}
