package recipes;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import recipes.model.Recipe;
import recipes.model.RecipeListWrapper;
import recipes.view.EditRecipeController;
import recipes.view.RecipePageController;
import recipes.view.RootLayoutController;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane root_layout;

    private ObservableList<Recipe> dishData = FXCollections.observableArrayList();

    public Main() {
    }

    public ObservableList<Recipe> getRecipeData() {
        return dishData;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Recipe App");

        // sets the icon of the application
        this.primaryStage.getIcons().add(new Image("file: icon/chef.png"));

        rootLayout_init();
        show_recipePage();

    }

    // initializing the root layout and loading the last opened recipe file
    public void rootLayout_init() {
        try {
            // loading the root layout from the FXML file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            root_layout = loader.load();

            // showing the root layout scene
            Scene scene = new Scene(root_layout);
            primaryStage.setScene(scene);

            // allowing access for the root layout controller
            RootLayoutController controller = loader.getController();
            controller.setMain(this);

            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

        // load the last opened file
        File file = getRecipePath();
        if (file != null) {
            loadRecipeDataFromFile(file);
        }

    }

    public void show_recipePage() {
        try {
            // loading the recipe page from the FXML file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RecipePage.fxml"));
            AnchorPane RecipePage = loader.load();

            // setting the recipe page in the center of the root layout
            root_layout.setCenter(RecipePage);

            // allowing the controller access to the main application
            RecipePageController controller = loader.getController();
            controller.setMain(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean show_EditRecipe(Recipe recipe) { // load and display the Edit Recipe dialog in the main application
        try{
            // a new pop-up stage will be created
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/EditRecipe.fxml"));
            AnchorPane page = loader.load();

            //the dialog stage
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Recipe");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // sets the icon of the application
            //dialogStage.getIcons().add(new Image("file: icon/edit.png"));

            //set the food into the controller
            EditRecipeController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setRecipe(recipe);

            // dialog will be shown until the user closes it
            dialogStage.showAndWait();

            return controller.isSaveClick();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    // for saving the data saved by the user, the data will be persisted using an XML file instead of a database
    // this is because the data to be saved are objects,
    // which are not the type of relational data that are commonly used for databases
    // the library used for generating the XML output is JAXB(Java Architecture for XML Binding)
    public File getRecipePath() {   // returns the last preference of the app(last file opened)
        Preferences preferences = Preferences.userNodeForPackage(Main.class);
        String path = preferences.get("path", null);
        if (path != null) {
            return new File(path);
        } else {
            return null;    // null is returned if the preferences cannot be found
        }
    }

    public void setRecipePath(File file) {
        // sets the file path of the current file(will be persisted in the OS specific registry)
        Preferences preferences = Preferences.userNodeForPackage(Main.class);
        if (file != null) {
            preferences.put("path", file.getPath());

            // stage title will be updated
            primaryStage.setTitle("Recipe App - " + file.getName());
        } else {
            preferences.remove("path");

            // stage title will be updated
            primaryStage.setTitle("Recipe App");
        }
    }

    public void loadRecipeDataFromFile(File file) {
        //loads the dish data from the specified file and replace the current one
        try {
            JAXBContext context = JAXBContext.newInstance(RecipeListWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // XML will be read from the file and unmarshalling occurs
            RecipeListWrapper wrapper = (RecipeListWrapper) um.unmarshal(file);

            dishData.clear();
            dishData.addAll(wrapper.getRecipes());

            // saving the file to the path registry
            setRecipePath(file);
        } catch (Exception e) { // for any exception
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Houston, we have a problem.");
            alert.setContentText("hmm... it seems we can't load from file:\n" + file.getPath());
            alert.showAndWait();
        }
    }

    public void saveRecipeDataToFile (File file) {
        // the recipe data will be saved to the given file
        try {
            JAXBContext context = JAXBContext.newInstance(RecipeListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // dish data is wrapped
            RecipeListWrapper wrapper = new RecipeListWrapper();
            wrapper.setRecipes(dishData);

            // marshalling and saving the XML to the file
            m.marshal(wrapper, file);

            // file path is saved to the registry
            setRecipePath(file);
        } catch (Exception e) { // for every exception
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Uh-oh, we've found ourselves an error.");
            alert.setContentText("hmm... it seems we can't save to file:\n" + file.getPath());
            alert.showAndWait();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
