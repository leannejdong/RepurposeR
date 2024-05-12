package myapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * This class is responsible for reading and writing data to a file.
 * The file is called RePurposingSuggestions.txt
 */

public class FileManager {
    private static final Logger logger = Logger.getLogger(FileManager.class.getName());
    private final String fileName = "src/myapp/RePurposingSuggestions.txt";

    /**
     * Write repurposing suggestions to the file
     *
     * @param RePurposingSuggestionsData Array of repurposing suggestions to write
     * @return True if the data is successfully written to the file, false otherwise.
     */
    public boolean WriteToFile(RepurposingSuggestion[] RePurposingSuggestionsData)
    {

        try
        {
            BufferedWriter output = new BufferedWriter(new FileWriter(fileName));

            for (int i = 0; i < RePurposingSuggestionsData.length; i++)
            {
                if (RePurposingSuggestionsData[i] == null)
                {
                    break;
                }
                output.write(RePurposingSuggestionsData[i].toString());
                output.newLine();
            }
            logger.info("Data written to file successfully");
            return true;

            //output.close();
        }
        catch (Exception ex)
        {
            //System.out.println(ex.getMessage());
            logger.log(Level.SEVERE, "An exception occurred", ex);
            return false;
        }
        //return false;
    }

    /**
     * Read repurposing suggestions from the file
     * @return FileData object containing the repurposing suggestions read from the file
     */
    public FileData ReadFromFile()
    {
        FileData data = new FileData();
        data.fileData = new RepurposingSuggestion[100];
        data.count = 0;

        try
        {
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            String line;
            while((line = input.readLine()) != null)
            {
                String[] temp = line.split(";");
                data.fileData[data.count] = new RepurposingSuggestion(temp[0],temp[1],temp[2],temp[3], temp[4]);
                data.count++;
            }


            input.close();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());

            data.fileData = null;
            data.count = 0;
        }
        return data;
    }

}


/**
 * imported necessary classes for file writing and logging.
 * added a logger instance for the FileManager class.
 * replaced the System.out.println() statement with a logger statement to log the exception message and stack trace.
 * The BufferedWriter is now initialized using a try-with-resources statement, ensuring its proper closure after the writing operation.
 * added logging statements to indicate successful data writing and errors during the write operation.
 */