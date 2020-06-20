// controller for the main application layout, containing the menubar and the space for the rest of the application elements

package recipes.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import recipes.Main;

import java.io.File;

public class RootLayoutController {
    // reference to the main application
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    public void selectNew() {   // creates a new recipe book
        main.getRecipeData().clear();
        main.setRecipePath(null);
    }

    @FXML
    private void selectOpen() {  // allows user to load an existing recipe book
        FileChooser fileChooser = new FileChooser();

        // extension filter is set so that only files ending with .xml are displayed
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*xml");
        fileChooser.getExtensionFilters().add(extensionFilter);

        // show dialog for when Open is selected
        File file = fileChooser.showOpenDialog(main.getPrimaryStage());

        if (file != null) {
            main.loadRecipeDataFromFile(file);
        }   // null is returned if the user closes the dialog without choosing a file
    }

    @FXML
    private void selectSave() { // saves the file to the currently opened one,
                                // will show the "Save As" dialog if no file is opened
        File recipeFile = main.getRecipePath();
        if (recipeFile != null) {
            main.saveRecipeDataToFile(recipeFile);
        } else {
            selectSaveAs();
        }
    }

    @FXML
    private void selectSaveAs() {   // allows user to select a file to save to
        FileChooser fileChooser = new FileChooser();

        // extension filter is set
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extensionFilter);

        // save file dialog is shown
        File file = fileChooser.showSaveDialog(main.getPrimaryStage());

        if (file != null) { // null is returned if the user closes the dialog without choosing a file
            // ensure that the file extension is correct
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            main.saveRecipeDataToFile(file);
        }
    }

    @FXML
    private void selectAbout() {    // open the About dialog
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Recipe App");
        alert.setHeaderText("About This App");
        alert.setContentText("Author: Aimee\n Inspired by: http://code.makery.ch");
        alert.showAndWait();
    }

    @FXML
    private void selectClose() {    //close the application
        System.exit(0);
    }

}
