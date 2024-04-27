# DO NOT COPY

The Repurposing Suggestions Software project is aimed at developing a Java application that assists the Software Solutions Department in managing and utilizing waste items more efficiently. The application will serve as a database for storing and retrieving repurposing suggestions for various waste materials.

Here's a breakdown of the key components and functionalities of the application we are meant to deliver:

## Database for Repurposing Suggestions:

 The application will provide a platform for users to input, store, and manage repurposing suggestions for waste items.
Each suggestion will include details such as the idea title, image file location, web link (if applicable), primary materials required, and construction process or hints.

## User Interface:

 The application will feature a user-friendly interface with navigation buttons (First, Last, Next, Previous), search functionality (Find), and data management options (New, Save, Delete).
Users will be able to view a list of repurposing suggestions and navigate through them efficiently.

## Data Management:

Repurposing suggestion details will be saved and loaded from a comma-delimited text file named ``RePurposingSuggestions.txt''.
The application will handle data storage and retrieval seamlessly, ensuring that users can access the information they need effectively.
Search and Filtering:

Users will be able to search for existing repurposing suggestions by idea title and view suggestions categorized by primary material.
Additionally, the application will implement a binary search functionality to locate records by idea title within a sorted list, enhancing search efficiency.

Our Repurposing Suggestions Software project aims to streamline the process of repurposing waste items by providing staff with a centralized platform to access and utilize repurposing ideas effectively.


## Build

![Re-purposing Suggestions](R.jpg)

## Class diagram

```mermaid
classDiagram
    class FileData {
        - fileData: RepurposingSuggestion[]
        - count: int
        + FileData()
    }
    class FileManager {
        - fileName: String
        + WriteToFile(RePurposingSuggestionsData)
        + ReadFromFile(): FileData
    }
    class MainForm {
        - fileManager: FileManager
        - layout: SpringLayout
        - lblTitle: JLabel
        - lblImageLocation: JLabel
        - lblWebLink: JLabel
        - lblPrimaryMaterials: JLabel
        - lblConstructionHints: JLabel
        - txtTitle: JTextField
        - txtImageLocation: JTextField
        - txtWebLink: JTextField
        - txtPrimaryMaterials: JTextArea
        - txtConstructionHints: JTextArea
        - txtFind: JTextField
        - txtFilterBy: JTextField
        - btnFind: JButton
        - btnNew: JButton
        - btnSave: JButton
        - btnDelete: JButton
        - btnFirst: JButton
        - btnPrevious: JButton
        - btnNext: JButton
        - btnLast: JButton
        - btnSort: JButton
        - btnBinary: JButton
        - btnFilterBy: JButton
        - txtOutput: JTextArea
        + MainForm()
        + actionPerformed(e: ActionEvent): void
        - DisplayCurrentEntry(): void
    }
    class RepurposingSuggestion {
        - Title: String
        - ImageLocation: String
        - WebLink: String
        - PrimaryMaterials: String
        - ConstructionHints: String
        + RepurposingSuggestion()
        + RepurposingSuggestion(title: String, imageLocation: String, webLink: String, primaryMaterials: String, constructionHints: String)
        + toString(): String
        + compareTo(other: Object): int
    }
    class Main {
        + main(args: String[]): void
    }
    MainForm -up- FileManager
    MainForm -up- RepurposingSuggestion
    MainForm --* JLabel
    MainForm --* JTextField
    MainForm --* JTextArea
    MainForm --* JButton
    MainForm --* SpringLayout
```

## Structure charts

### Managing GUI elements

```mermaid

graph TD;
    MainForm(MainForm)
    MainForm --> lblTitle;
    MainForm --> lblImageLocation;
    MainForm --> lblWebLink;
    MainForm --> lblPrimaryMaterials;
    MainForm --> lblConstructionHints;
    MainForm --> txtTitle;
    MainForm --> txtImageLocation;
    MainForm --> txtWebLink;
    MainForm --> txtPrimaryMaterials;
    MainForm --> txtConstructionHints;
    MainForm --> txtFind;
    MainForm --> txtFilterBy;
    MainForm --> btnFind;
    MainForm --> btnNew;
    MainForm --> btnSave;
    MainForm --> btnDelete;
    MainForm --> btnFirst;
    MainForm --> btnPrevious;
    MainForm --> btnNext;
    MainForm --> btnLast;
    MainForm --> btnSort;
    MainForm --> btnBinary;
    MainForm --> btnFilterBy;
    MainForm --> txtOutput;
```

### Managing user action

```mermaid
   graph TD;
    MainForm(MainForm)
    MainForm --> actionPerformed;
    actionPerformed -->|btnNew| handleNewEntry;
    actionPerformed -->|btnSave| handleSaveEntry;
    actionPerformed -->|btnDelete| handleDeleteEntry;
    actionPerformed -->|btnFirst| handleFirstEntry;
    actionPerformed -->|btnPrevious| handlePreviousEntry;
    actionPerformed -->|btnNext| handleNextEntry;
    actionPerformed -->|btnLast| handleLastEntry;
    actionPerformed -->|btnFind| handleFind;
    actionPerformed -->|btnSort| handleSort;
    actionPerformed -->|btnBinary| handleBinarySearch;
    actionPerformed -->|btnFilterBy| handleFilterBy;
```

## Documentation

![Re-purposing Suggestion](javadoc.png)
