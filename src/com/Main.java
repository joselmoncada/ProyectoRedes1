package com;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.game.Bingo;
import com.game.Game;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../layouts/sample.fxml"));
        primaryStage.setTitle("Proyecto Redes 1");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        Game gameApp = new Bingo();
        gameApp.init();
        gameApp.gameLoop();
    }
}
