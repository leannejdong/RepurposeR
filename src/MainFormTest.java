//import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


class MainFormTest {
    @Test
    public void testLoadTestData() {
        // Arrange: Create an instance of MainForm
        MainForm mainForm = new MainForm();

        // Act: Call the loadTestData() method
        mainForm.loadTestData();

        // Assert: Check if the test data is loaded correctly
        // For example, you can check if the number of entries is as expected
        assertEquals(4, mainForm.numberOfEntries); // Assuming loadTestData() loads 4 test entries

    }
}