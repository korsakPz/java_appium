import org.junit.jupiter.api.Test;

public class UmlTest {



    // --- Положительные тесты ---
    @Test
    void testSetAndGetFirstName_ValidData() {
        UmlTest user = new UmlTest();
        user.setFirstName("Иван");
        assertEquals("Иван", user.getFirstName());
    }

    @Test
    void testSetAndGetLastName_ValidData() {
        UmlTest user = new UmlTest();
        user.setLastName("Петров");
        assertEquals("Петров", user.getLastName());
    }

    @Test
    void testSetAndGetAge_ValidData() {
        UmlTest user = new UmlTest();
        user.setAge(30);
        assertEquals(30, user.getAge());
    }

    // --- Тесты валидации ---
    @Test
    void testSetFirstName_Null_ThrowsException() {
        UmlTest user = new UmlTest();
        assertThrows(IllegalArgumentException.class, () -> {
            user.setFirstName(null);
        });
    }

    @Test
    void testSetFirstName_Empty_ThrowsException() {
        UmlTest user = new UmlTest();
        assertThrows(IllegalArgumentException.class, () -> {
            user.setFirstName("");
        });
    }

    @Test
    void testSetAge_Negative_ThrowsException() {
        UmlTest user = new UmlTest();
        assertThrows(IllegalArgumentException.class, () -> {
            user.setAge(-1);
        });
    }

    @Test
    void testSetAge_TooLarge_ThrowsException() {
        UmlTest user = new UmlTest();
        assertThrows(IllegalArgumentException.class, () -> {
            user.setAge(151);
        });
    }
}
