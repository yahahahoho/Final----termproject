package haksik;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {

    @Test
    void testDecreaseQuantityReducesCount() {
        Menu menu = new Menu("제육덮밥", 3);
        menu.decreaseQuantity("식권기");
        assertEquals(2, menu.remainingQuantity);
    }

    @Test
    void testDecreaseQuantityStopsAtZero() {
        Menu menu = new Menu("돈까스", 1);
        menu.decreaseQuantity("밀케어");
        menu.decreaseQuantity("밀케어");
        assertEquals(0, menu.remainingQuantity);
    }

    @Test
    void testToStringFormat() {
        Menu menu = new Menu("카레", 5);
        String expected = "카레 - 남은 수량: 5/5";
        assertEquals(expected, menu.toString());
    }
}
