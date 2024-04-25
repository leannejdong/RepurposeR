import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * This class is responsible for reading and writing data to a file.
 * The file is called RePurposingSuggestions.txt
 */

public class FileManager {
    String fileName = "/Users/leanne/devTafe/PRG443/RepurposeR/src/RePurposingSuggestions.txt";

    /**
     * Write repurposing suggestions to the file
     * @param RePurposingSuggestionsData Array of repurposing suggestions to write
     */
    public void WriteToFile(RepurposingSuggestion[] RePurposingSuggestionsData)
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

            output.close();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
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
