/**
 * This class is used to store the information for a repurposing suggestion.
 * It contains the title of the suggestion, the location of the image, a web link to the suggestion, the primary materials used in the suggestion, and construction hints for the suggestion.
 * It also contains a toString method to convert the object to a string, and a compareTo method to compare the object to another object.
 */

public class RepurposingSuggestion implements Comparable
{
    String Title;
    String ImageLocation;
    String WebLink;
    String PrimaryMaterials;
    String ConstructionHints;

    /**
     * Construct an empty RepurposingSuggestion object
     */
    public RepurposingSuggestion(){}


    /**
     * Construct a RepurposingSuggestion object with the specified title, image location, web link, primary materials, and construction hints
     * @param title
     * @param imageLocation
     * @param webLink
     * @param primaryMaterials
     * @param constructionHints
     */
    public RepurposingSuggestion(String title, String imageLocation, String webLink, String primaryMaterials, String constructionHints)
    {
        Title = title;
        ImageLocation = imageLocation;
        WebLink = webLink;
        PrimaryMaterials = primaryMaterials;
        ConstructionHints = constructionHints;
    }

    @Override
    public String toString() {
        return Title + ";" + ImageLocation + ";" + WebLink + ";" + PrimaryMaterials + ";" + ConstructionHints;
    }

    @Override
    public int compareTo(Object other) {

        if (other instanceof String)
        {
            //Gets the other object from the parameters and converts it to a String type before storing it.
            String searchTerm = (String)other;
            //Use the default string comparison to compare the search term against the contacts name field and return the result.
            return this.ConstructionHints.toLowerCase().compareTo(searchTerm.toLowerCase());
        }
        //Gets the other object from the parameters and converts it to a Contact type before storing it.
        RepurposingSuggestion otherContact = (RepurposingSuggestion)other;
        //Use the default string comparison to compare the 2 name fields and return the result.
        return this.ConstructionHints.compareTo(otherContact.ConstructionHints);
    }
}
