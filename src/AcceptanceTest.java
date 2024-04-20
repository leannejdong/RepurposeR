import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AcceptanceTest {

    @Test
    public void testSaveNewData() {
        // Arrange: Prepare the application environment
        MainForm mainForm = new MainForm();
        // Act: Simulate user interaction to create and save new data
        mainForm.txtTitle.setText("New Title");
        mainForm.txtImageLocation.setText("New Image Location");
        mainForm.txtWebLink.setText("New Web Link");
        mainForm.txtPrimaryMaterials.setText("New Primary Materials");
        mainForm.txtConstructionHints.setText("New Construction Hints");
        mainForm.btnSave.doClick(); // Simulate clicking the save button
        // Assert: Check if the new data is saved correctly
        assertEquals(4, mainForm.numberOfEntries); // Assuming only one entry is added
        assertEquals("New Title", mainForm.RepurposingSuggestionArray[0].Title); // Check if the title matches
    }
}
