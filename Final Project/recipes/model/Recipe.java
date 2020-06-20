package recipes.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Recipe {

    private final StringProperty dishname;
    private final StringProperty dishtype;
    private final StringProperty course;
    private final IntegerProperty duration;

    private String ingredients;
    private String procedures;

    public Recipe() {
        this(null, 0, null, null, null, null);
    }

    public Recipe(String dishname, int duration, String dishtype, String course, String ingredients, String procedures){
        this.dishname = new SimpleStringProperty(dishname);
        this.duration = new SimpleIntegerProperty(duration);
        this.dishtype = new SimpleStringProperty(dishtype);
        this.course = new SimpleStringProperty(course);

        this.ingredients = ingredients;
        this.procedures = procedures;
    }

    public int getDuration() {
        return duration.get();
    }

    public IntegerProperty durationProperty() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration.set(duration);
    }

    public String getDishname() {
        return dishname.get();
    }

    public StringProperty dishnameProperty() {
        return dishname;
    }

    public void setDishname(String dishname) {
        this.dishname.set(dishname);
    }

    public String getDishtype() {
        return dishtype.get();
    }

    public StringProperty dishtypeProperty() {
        return dishtype;
    }

    public void setDishtype(String dishtype) {
        this.dishtype.set(dishtype);
    }

    public String getCourse() {
        return course.get();
    }

    public StringProperty courseProperty() {
        return course;
    }

    public void setCourse(String course) {
        this.course.set(course);
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getProcedures() {
        return procedures;
    }

    public void setProcedures(String procedures) {
        this.procedures = procedures;
    }
}
