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
     *
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
