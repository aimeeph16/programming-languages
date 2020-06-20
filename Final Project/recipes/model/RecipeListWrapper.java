// this class holds the list of recipes that will be saved in the XML
package recipes.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "recipes")   // to define the root element name
public class RecipeListWrapper {    // helper class to wrap the list of recipes
    private List<Recipe> recipes;

    @XmlElement(name = "recipe")    // this will be the optional name of the element
    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}
