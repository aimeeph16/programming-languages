package recipes.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import recipes.model.Recipe;

public class EditRecipeController {
    // to let the FXML access private classes
    @FXML
    private TextField dishnameField;
    @FXML
    private TextField dishtypeField;
    @FXML
    private TextField courseField;
    @FXML
    private TextField durationField;

    @FXML
    private TextArea ingredientsField;
    @FXML
    private TextArea proceduresField;

    private Stage dialogStage;
    private Recipe recipe;
    private boolean saveClick = false;

    @FXML
    private void initialize(){  // to initialize the controller
    }

    public void setDialogStage(Stage dialogStage) { // sets up the dialog stage
        this.dialogStage = dialogStage;
    }

    public void setRecipe(Recipe recipe){ // sets up the food to be put in the dialog, can be called from another class to set the dish to be edited
        this.recipe = recipe;

        dishnameField.setText(recipe.getDishname());
        dishtypeField.setText(recipe.getDishtype());
        courseField.setText(recipe.getCourse());
        durationField.setText(Integer.toString(recipe.getDuration()));

        ingredientsField.setText(recipe.getIngredients());
        proceduresField.setText(recipe.getProcedures());
        ingredientsField.setWrapText(true);
        proceduresField.setWrapText(true);
    }

    public boolean isSaveClick(){
        return saveClick;
    }

    private boolean isValid() { // to validate the user input for each field
        String error = "";

        if (dishnameField.getText() == null || dishnameField.getText().length() == 0) {
            error += "Dish Name invalid :( \n";
        }
        if (dishtypeField.getText() == null || dishtypeField.getText().length() == 0) {
            error += "Cuisine Type invalid :( \n";
        }
        if (courseField.getText() == null || courseField.getText().length() == 0) {
            error += "Course invalid :( \n";
        }
        if (durationField.getText() == null || durationField.getText().length() == 0) {
            error += "Duration invalid :( \n";
        } else {
            // try to parse the duration into an int
            try {
                Integer.parseInt(durationField.getText());
            } catch (NumberFormatException e) {
                error += "Duration must be an integer :( \n";
            }
        }

        if (error.length() == 0) {
            return true;    // will return true if the error message is empty
        } else {    // error message will be shown
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Is this some advanced language that I don't understand?");
            alert.setHeaderText("NOT SO FAST! I get that you're excited, but please enter the fields correctly.");
            alert.setContentText(error);
            alert.showAndWait();

            return false;
        }
    }

    public void saveButton() {  // for when the user wants to save the recipe
        if (isValid()) {
            recipe.setDishname(dishnameField.getText());
            recipe.setDishtype(dishtypeField.getText());
            recipe.setCourse(courseField.getText());
            recipe.setDuration(Integer.parseInt(durationField.getText()));

            recipe.setIngredients(ingredientsField.getText());
            recipe.setProcedures(proceduresField.getText());

            saveClick = true;
            dialogStage.close();
        }
    }

    public void cancelButton() {    // for when the user decides to cancel
        dialogStage.close();
    }


}
