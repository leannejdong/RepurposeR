import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.Locale;

/**
 * This class is the main form of the application.
 * It contains the UI elements and event handlers for the form.
 */
public class MainForm extends JFrame implements ActionListener {
    FileManager fileManager = new FileManager();
    SpringLayout layout = new SpringLayout();

    JLabel lblTitle, lblImageLocation, lblWebLink, lblPrimaryMaterials, lblConstructionHints, lblFind;
    JTextField txtTitle, txtImageLocation, txtWebLink, txtFind;
    JTextArea txtPrimaryMaterials, txtConstructionHints;
    JButton btnFirst, btnPrevious, btnNext, btnLast;
    JButton btnNew, btnSave, btnDelete, btnFind, btnExit;

    JTextArea txtOutput;
    JButton btnSort, btnBinary, btnFilterBy;
    JTextField txtFilterBy;

    RepurposingSuggestion[] RepurposingSuggestionArray = new RepurposingSuggestion[100];

    int numberOfEntries = 0;
    int currentEntry = 0;
    boolean isNewEntry = false;


    /**
     * Constructor for the MainForm class.
     * Sets up the UI elements and event handlers.
     */
    public MainForm() throws HeadlessException {
        setTitle("Re-Purposing Suggestions");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocation(400, 200);
        setLayout(layout);



        /* Load test data */
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
//
        lblTitle = UIBuilderLibrary.BuildJLabelWithNorthWestAnchor("Idea Title:", 30, 40, layout, this);
        add(lblTitle);
        lblImageLocation = UIBuilderLibrary.BuildJLabelInlineBelow("Image File:", 18, layout, lblTitle);
        add(lblImageLocation);
        lblWebLink = UIBuilderLibrary.BuildJLabelInlineBelow("Web link:", 18, layout, lblImageLocation);
        add(lblWebLink);
        lblPrimaryMaterials = UIBuilderLibrary.BuildJLabelInlineBelow("Primary Material:", 18, layout, lblWebLink);
        add(lblPrimaryMaterials);
        lblConstructionHints = UIBuilderLibrary.BuildJLabelInlineBelow("Construction Hints:", 68, layout, lblPrimaryMaterials);
        add(lblConstructionHints);
        txtTitle = UIBuilderLibrary.BuildJTextFieldInlineToRight(10, 20, layout, lblTitle);
        add(txtTitle);
        txtImageLocation = UIBuilderLibrary.BuildJTextFieldInlineBelow(18, 4, layout, txtTitle);
        add(txtImageLocation);
        txtWebLink = UIBuilderLibrary.BuildJTextFieldInlineBelow(18, 4, layout, txtImageLocation);
        add(txtWebLink);


        txtPrimaryMaterials = new JTextArea();
        txtPrimaryMaterials.setLineWrap(true);
        JScrollPane scrollA = new JScrollPane(txtPrimaryMaterials);
        scrollA.setPreferredSize(new Dimension(250, 40));
        scrollA.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        layout.putConstraint(SpringLayout.NORTH, scrollA, 20, SpringLayout.SOUTH, lblPrimaryMaterials);
        layout.putConstraint(SpringLayout.WEST, scrollA, 10, SpringLayout.WEST, lblPrimaryMaterials);
        add(scrollA);



        txtConstructionHints = new JTextArea();
        txtConstructionHints.setLineWrap(true);
        JScrollPane scrollB = new JScrollPane(txtConstructionHints);
        scrollB.setPreferredSize(new Dimension(250, 60));
        scrollB.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
//        layout.putConstraint(SpringLayout.NORTH, scrollB, 4, SpringLayout.SOUTH, txtWebLink);
        layout.putConstraint(SpringLayout.NORTH, scrollB, 20, SpringLayout.SOUTH, lblConstructionHints);
        layout.putConstraint(SpringLayout.WEST, scrollB, 20, SpringLayout.WEST, lblConstructionHints);
        add(scrollB);
//

//
       // this.setLayout(new BorderLayout());
        lblFind = UIBuilderLibrary.BuildJLabelWithNorthWestAnchor("Find:", 380, 20, layout, this);
        add(lblFind);
        txtFind = UIBuilderLibrary.BuildJTextFieldInlineToRight(6, 5, layout, lblFind);
        add(txtFind);

        btnFind = UIBuilderLibrary.BuildJButtonInlineBelow(120, 25, "FIND", 5, this, layout, txtFind);
        this.add(btnFind);
        btnNew = UIBuilderLibrary.BuildJButtonInlineBelow(120, 25, "NEW", 5, this, layout, btnFind);
        this.add(btnNew);
        btnSave = UIBuilderLibrary.BuildJButtonInlineBelow(120, 25, "SAVE", 5, this, layout, btnNew);
        add(btnSave);
        btnDelete = UIBuilderLibrary.BuildJButtonInlineBelow(120, 25, "DELETE", 5, this, layout, btnSave);
        add(btnDelete);

//        lblFind = UIBuilderLibrary.BuildJLabelInlineBelow("Find:", 5, layout, btnDelete);
//        add(lblFind);
//        txtFind = UIBuilderLibrary.BuildJTextFieldInlineToRight(6, 5, layout, lblFind);
//        add(txtFind);

        btnFirst = UIBuilderLibrary.BuildJButtonInlineBelow(40, 25, "|<", 40, this, layout,btnDelete);
        btnFirst.setMargin(new Insets(0, 0, 0, 0));
        add(btnFirst);
        btnPrevious = UIBuilderLibrary.BuildJButtonInlineToRight(40, 25, "<<", 0, this, layout, btnFirst);
        btnPrevious.setMargin(new Insets(0, 0, 0, 0));
        add(btnPrevious);
        btnNext = UIBuilderLibrary.BuildJButtonInlineToRight(40, 25, ">>", 0, this, layout, btnPrevious);
        btnNext.setMargin(new Insets(0, 0, 0, 0));
        add(btnNext);
        btnLast = UIBuilderLibrary.BuildJButtonInlineToRight(40, 25, ">|", 0, this, layout, btnNext);
        btnLast.setMargin(new Insets(0, 0, 0, 0));
        add(btnLast);


//
        btnSort = UIBuilderLibrary.BuildJButtonInlineBelow(130, 25, "Sort by Idea Title", 5, this, layout, scrollB);
        add(btnSort);
        btnBinary = UIBuilderLibrary.BuildJButtonInlineToRight(200, 25, "Binary Search by Idea Title:", 5, this, layout, btnSort);
        add(btnBinary);
        btnFilterBy = UIBuilderLibrary.BuildJButtonInlineToRight(80, 25, "Filter by:", 5, this, layout, btnBinary);
        add(btnFilterBy);

        txtFilterBy = UIBuilderLibrary.BuildJTextFieldInlineToRight(16, 0, layout, btnFilterBy);
        add(txtFilterBy);

        txtOutput = new JTextArea();
        txtOutput.setLineWrap(true);
        JScrollPane outputPane = new JScrollPane(txtOutput);
        outputPane.setPreferredSize(new Dimension(360, 100));
        outputPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        layout.putConstraint(SpringLayout.NORTH, outputPane, 20, SpringLayout.SOUTH, btnSort);
        layout.putConstraint(SpringLayout.WEST, outputPane, 10, SpringLayout.WEST, this);
        add(outputPane);

        // Populate the UI with data read from the file using `ReadFromFile` method of the `FileManager` class.
        // It iterates over the `FileData` object and appends each repurposing suggestion to the `txtOutput` text area.
        FileData data = fileManager.ReadFromFile();
        if (data.fileData == null) {
            JOptionPane.showMessageDialog(this, "Error loading file.");
        } else {

            RepurposingSuggestionArray = data.fileData;
            for(int i = 0; i < data.count; i++){
                System.out.println(data.fileData[i]);
            }
            numberOfEntries = data.count;
        }
        DisplayCurrentEntry();

        setVisible(true);


    }

    void loadTestData() {
RepurposingSuggestionArray[0] = new RepurposingSuggestion("Bird Bath",
                "C:\\MyIdeas\\OutdoorIdeas\\BirdBath.jpg",
                "www.MyIdeas...\\birdbath",
                "Options: concrete bowl, recycled sink, stand (brick, concrete, wood)",
                "1. Clear level ground, 2. Place stand securely, 3. Secure bowl to stand");

        RepurposingSuggestionArray[1] = new RepurposingSuggestion("Small fish bowl",
                "C:\\MyIdeas\\IndoorIdeas\\FishBowl.jpg",
                "www.MyIdeas...\\fishbowl",
                "Options: recycled glass or clear plastic bowl",
                "1. Locate recycled material, 2. Clean in preparation for use.");

        RepurposingSuggestionArray[2] = new RepurposingSuggestion("Artistic Display",
                "C:\\MyIdeas\\IndoorIdeas\\ArtisticDisplay.jpg",
                "www.MyIdeas...\\artdisplay",
                "Options: recycled plastic, paper,cardboard, ...",
                "1. Assemble materials, 2. Plan art work, 3. Create art work");
        RepurposingSuggestionArray[3] = new RepurposingSuggestion("Small herb garden",
                "C:\\MyIdeas\\OutdoorIdeas\\HerbGarden.jpg",
                "www.MyIdeas...\\herbgarden",
                "Options: recycled planks of wood, metal",
                "1. Build herb garden structure, 2. Clear level ground, 3. Place garden securely");

        numberOfEntries = 4;

    }


    /**
     * Event handler for the buttons on the form.
     * @param e ActionEvent object representing the event performed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() != btnNew && e.getSource() != btnSave) {
            isNewEntry = false;
        }
        if (e.getSource() == btnNew) {
            if (numberOfEntries == 100) {
                JOptionPane.showMessageDialog(this, "The Re-Purposing Suggestion List is Full." +
                        " Cannot add any more Entries");
                return;
            }
            txtTitle.setText("");
            txtImageLocation.setText("");
            txtWebLink.setText("");
            txtPrimaryMaterials.setText("");
            txtConstructionHints.setText("");

            isNewEntry = true;
        }
        if (e.getSource() == btnSave) {
            if (isNewEntry == true) {
                RepurposingSuggestion newRepurposingSuggestion = new RepurposingSuggestion();
                newRepurposingSuggestion.Title = txtTitle.getText();
                newRepurposingSuggestion.ImageLocation = txtImageLocation.getText();
                newRepurposingSuggestion.WebLink = txtWebLink.getText();
                newRepurposingSuggestion.PrimaryMaterials = txtPrimaryMaterials.getText();
                newRepurposingSuggestion.ConstructionHints = txtConstructionHints.getText();
                RepurposingSuggestionArray[numberOfEntries] = new RepurposingSuggestion();
                numberOfEntries++;
                currentEntry = numberOfEntries - 1;
            } else {
                RepurposingSuggestionArray[currentEntry].Title = txtTitle.getText();
                RepurposingSuggestionArray[currentEntry].ImageLocation = txtImageLocation.getText();
                RepurposingSuggestionArray[currentEntry].WebLink = txtWebLink.getText();
                RepurposingSuggestionArray[currentEntry].PrimaryMaterials = txtPrimaryMaterials.getText();
                RepurposingSuggestionArray[currentEntry].ConstructionHints = txtConstructionHints.getText();
            }
            isNewEntry = false;
            fileManager.WriteToFile(RepurposingSuggestionArray);
        }
        if (e.getSource() == btnDelete) {
            int result = JOptionPane.showConfirmDialog(this, JOptionPane.ERROR_MESSAGE,
                    "Are you sure you want to delete this entry?", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                return;
            }
            for(int i = currentEntry; i < numberOfEntries; i++) {
                if(i == numberOfEntries - 1){
                    RepurposingSuggestionArray[i] = null;
                    break;
                }
                RepurposingSuggestionArray[i] = RepurposingSuggestionArray[i + 1];
            }
            numberOfEntries--;
            if(currentEntry == numberOfEntries){
                currentEntry--;
            }
            DisplayCurrentEntry();
            fileManager.WriteToFile(RepurposingSuggestionArray);
        }
        if(e.getSource() == btnFirst){
            currentEntry = 0;
            DisplayCurrentEntry();
        }
        if(e.getSource() == btnPrevious){
            if(currentEntry > 0){
                currentEntry--;
            }
            DisplayCurrentEntry();
        }
        if(e.getSource() == btnNext){
            if(currentEntry < numberOfEntries - 1){
                currentEntry++;
            }
            DisplayCurrentEntry();
        }
        if(e.getSource() == btnLast){
            currentEntry = numberOfEntries - 1;
            DisplayCurrentEntry();
        }
        if(e.getSource()==btnFilterBy){
            String filter = txtFilterBy.getText();
            txtOutput.setText("");
            for(int i = 0; i < numberOfEntries; i++){
                if(RepurposingSuggestionArray[i].ConstructionHints.toLowerCase().contains(filter.toLowerCase())){
                    txtOutput.append(RepurposingSuggestionArray[i].toString() + "\n");
                }
            }
        }
        if(e.getSource()==btnSort ||e.getSource()==btnBinary)
        {
            txtOutput.setText("Suggestions SORTED BY TITLE: \n");
            Arrays.sort(RepurposingSuggestionArray,0,numberOfEntries);
            for(int i = 0; i < numberOfEntries; i++)
            {
                txtOutput.append(RepurposingSuggestionArray[i].toString() + "\n");
            }
            if(e.getSource() == btnBinary)
            {
                String searchTerm = txtFind.getText().toUpperCase();
                int index = Arrays.binarySearch(RepurposingSuggestionArray,0,numberOfEntries,searchTerm);
                if(index >= 0)
                {
                    txtOutput.append("Found: " + RepurposingSuggestionArray[index].toString());
                }
                else
                {
                    txtOutput.append("Not Found");
                }
            }
        }
    }

    /**
     * Display the current entry in the form
     */
    private void DisplayCurrentEntry()
    {
        if(numberOfEntries == 0)
        {
            return;
        }
        txtTitle.setText(RepurposingSuggestionArray[currentEntry].Title);
        txtImageLocation.setText(RepurposingSuggestionArray[currentEntry].ImageLocation);
        txtWebLink.setText(RepurposingSuggestionArray[currentEntry].WebLink);
        txtPrimaryMaterials.setText(RepurposingSuggestionArray[currentEntry].PrimaryMaterials);
        txtConstructionHints.setText(RepurposingSuggestionArray[currentEntry].ConstructionHints);
    }
}
