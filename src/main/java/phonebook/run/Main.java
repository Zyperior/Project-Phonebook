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

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        Controller controller;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GUI.fxml"));
        Parent root = loader.load();

        controller = loader.getController();
        controller.init();
        primaryStage.setResizable(false);

        primaryStage.setTitle("PhoneBook");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    public static void main(String[] args) {

        launch(args);

    }

}