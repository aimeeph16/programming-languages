package recipes.view;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import recipes.Main;
import recipes.model.*;

public class RecipePageController {
    // to let the FXML access private classes
    @FXML
    private TextField searchDish;
    @FXML
    private TableView<Recipe> dishlist;
    @FXML
    private TableColumn<Recipe, Integer> durationColumn;
    @FXML
    private TableColumn<Recipe, String> dishnameColumn;
    @FXML
    private TableColumn<Recipe, String> dishtypeColumn;
    @FXML
    private TableColumn<Recipe, String> courseColumn;

    @FXML
    private Label dishnameLabel;
    @FXML
    private TextArea ingredientsArea;
    @FXML
    private TextArea proceduresArea;

    // referencing the main application
    private recipes.Main Main;

    public RecipePageController() {
    }

    // for displaying the ingredients and procedures pages
    public void showRecipe(Recipe recipe) {
        if (recipe != null) {
            //fill the text with ingredients for that dish
            ingredientsArea.setText(recipe.getIngredients());
            proceduresArea.setText(recipe.getProcedures());
            dishnameLabel.setText(recipe.getDishname());

        } else {
            //field will be empty if the food is null
            ingredientsArea.setText("");
            proceduresArea.setText("");
            dishnameLabel.setText("no recipe selected...");
        }
    }

    public void setMain(Main main) {
        this.Main = main;

        // Add observable list data to the table
        dishlist.setItems(main.getRecipeData());

        //filter
        // 1. wrap the ObservableList in a FilteredList, display all the data initially
        FilteredList<Recipe> filteredData = new FilteredList<>(main.getRecipeData(), p -> true);
        //this indicates that the first predicate is always true
        // 2. set the predicate in the filter for whenever the filter changes
        searchDish.textProperty().addListener((observable, oldValue, newValue) -> { // ChangeListener is added to the filter text field
            filteredData.setPredicate(recipe -> {                                   // the predicate of the FilteredList is updated whenever
                                                                                    // the user changes the text
                if (newValue == null || newValue.isEmpty()) {
                    return true;    // display all recipes in the table if the filter is empty
                }

                // compare the dish details with the keyword entered in the filter
                String lowerCaseFilter = newValue.toLowerCase();

                if (recipe.getDishname().toLowerCase().contains(lowerCaseFilter)) {
                    return true;    // indicates that the filter matches the dish name
                    // repeat for the rest of the details
                } else if (recipe.getDishtype().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (recipe.getCourse().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;   // for when the filter keyword does not match any entry
            });
        });

        // 3. wrap the FilteredList in a SortedList
        SortedList<Recipe> sortedData = new SortedList<>(filteredData);
                // since FilteredList cannot be modified, it cannot be sorted.
                // therefore it needs to be wrapped in a sorted list

        // 4. bind the SortedList comparator to the TableView comparator
        sortedData.comparatorProperty().bind(dishlist.comparatorProperty());

        // 5. add the sorted and filtered data to the table
        dishlist.setItems(sortedData);
    }

    @FXML // delete function
    private void deleteDish(){
        int deleteIndex = dishlist.getSelectionModel().getSelectedIndex();

        if (deleteIndex >= 0) {
            Main.getRecipeData().remove(deleteIndex);
        } else {    // in case the user selects an empty dish
            Alert alert = new Alert(Alert.AlertType.WARNING);   // a pop-up alert will appear
            alert.initOwner(Main.getPrimaryStage());
            alert.setTitle("Empty Selection");
            alert.setHeaderText("Were you about to delete... Nothing? ");
            alert.setContentText("At least pick something from the list");
            alert.showAndWait();
        }
    }

    @FXML
    private void newDish() {    // for when the user wants to save a new recipe
        Recipe newRecipe = new Recipe();
        boolean saveClick = Main.show_EditRecipe(newRecipe);    // the Edit Recipe dialog will be shown
        if (saveClick) {
            Main.getRecipeData().add(newRecipe);
        }
    }

    @FXML
    private void editDish() {   // for when the user wants to edit an existing recipe
        Recipe chosenRecipe = dishlist.getSelectionModel().getSelectedItem();
        if (chosenRecipe != null) {
            boolean saveClick = Main.show_EditRecipe(chosenRecipe);   // the Edit Recipe dialog will be shown
            if (saveClick) {
                showRecipe(chosenRecipe);
            }
        } else {    // if no dish have been selected, an alert will pop up
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(Main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("I see no dish have been brought forth.");
            alert.setContentText("Please choose a dish from the list. It's really not that hard.");
            alert.showAndWait();
        }
    }

    @FXML
    public void initialize() {  //to initialize the food table with the columns
        // the following code ensures that the fields in the Food objects are used in their respective columns
        durationColumn.setCellValueFactory(cellData -> cellData.getValue().durationProperty().asObject());
        dishnameColumn.setCellValueFactory(cellData -> cellData.getValue().dishnameProperty());
        dishtypeColumn.setCellValueFactory(cellData -> cellData.getValue().dishtypeProperty());
        courseColumn.setCellValueFactory(cellData -> cellData.getValue().courseProperty());

        // set the ingredients and procedures Text Areas to be non-editable
        ingredientsArea.setEditable(false);
        ingredientsArea.setWrapText(true);
        proceduresArea.setEditable(false);
        proceduresArea.setWrapText(true);

        // empty the field for the details of the dish
        showRecipe(null);

        //detect the selection changes and display the ingredients and procedures once selected
        dishlist.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showRecipe(newValue));
    }
}
