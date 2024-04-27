package myapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainFormFileManagerIntegrationTest {

    @Test
    public void testLoadTestDataWithFileManagerIntegration() {
        // Arrange: Create an instance of MainForm
        MainForm mainForm = new MainForm();
        // Act: Call the loadTestData() method, which internally interacts with FileManager
        mainForm.loadTestData();
        // Assert: s
        assertEquals(4, mainForm.numberOfEntries); // Assuming loadTestData() loads 4 test entries
    }
}
