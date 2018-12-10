/*
Date yy-mm-dd: 18-12-06
Author: Andreas Albihn
 */

package phonebook.run;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import phonebook.gui.Controller;

import java.io.IOException;

public class Main extends Application {

    private Parent root;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Controller controller;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/GUI.fxml"));
        root = loader.load();

        controller = loader.getController();
        controller.init();

        primaryStage.setTitle("PhoneBook");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    public static void main(String[] args) {

        launch(args);

    }

    public Parent getRoot() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/GUI.fxml"));
        root = loader.load();
        return root;
    }
}
