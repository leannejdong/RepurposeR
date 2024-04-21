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

    @Test
    public void testDataPopulation() {
        // Create a MainForm instance
        MainForm mainForm = new MainForm();

        // Create test data
        RepurposingSuggestion[] testData = {
                new RepurposingSuggestion("Test Title 1", "Image1.jpg", "www.test.com/1", "Materials 1", "Hints 1"),
                new RepurposingSuggestion("Test Title 2", "Image2.jpg", "www.test.com/2", "Materials 2", "Hints 2")
        };

        // Set test data to MainForm
        mainForm.setRepurposingSuggestionArray(testData);
        mainForm.setNumberOfEntries(testData.length);

        // Set current entry to the first one
        mainForm.setCurrentEntry(0);

        // Call the method that triggers the display of current entry
        mainForm.triggerDisplayCurrentEntry();

        // Verify if fields display correct data
        assertEquals("Test Title 1", mainForm.txtTitle.getText());
        assertEquals("Image1.jpg", mainForm.txtImageLocation.getText());
        assertEquals("www.test.com/1", mainForm.txtWebLink.getText());
        assertEquals("Materials 1", mainForm.txtPrimaryMaterials.getText());
        assertEquals("Hints 1", mainForm.txtConstructionHints.getText());
    }

    @Test

    public void testDataDisplay(){
        // Create a MainForm instance
        MainForm mainForm = new MainForm();

        // Create test data
        RepurposingSuggestion[] testData = {
                new RepurposingSuggestion("Test Title 1", "Image1.jpg", "www.test.com/1", "Materials 1", "Hints 1"),
                new RepurposingSuggestion("Test Title 2", "Image2.jpg", "www.test.com/2", "Materials 2", "Hints 2")
        };

        // Set test data to MainForm
        mainForm.setRepurposingSuggestionArray(testData);
        mainForm.setNumberOfEntries(testData.length);

        // Set current entry to the first one
        mainForm.setCurrentEntry(0);

        // Call the method that triggers the display of current entry
        mainForm.triggerDisplayCurrentEntry();

        // Verify if fields display correct data
        assertEquals("Test Title 1", mainForm.txtTitle.getText());
        assertEquals("Image1.jpg", mainForm.txtImageLocation.getText());
        assertEquals("www.test.com/1", mainForm.txtWebLink.getText());
        assertEquals("Materials 1", mainForm.txtPrimaryMaterials.getText());
        assertEquals("Hints 1", mainForm.txtConstructionHints.getText());
    }
}