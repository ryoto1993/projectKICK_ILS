package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("Intelligent Lighting System ILS_Controller");
        primaryStage.setScene(new Scene(root, 1200, 700));
        primaryStage.setMinHeight(750);
        primaryStage.setMinWidth(1000);

        // アイコン設定
        final Image image = new Image(getClass().getClassLoader().getResourceAsStream("UI/img/icon.png"));
        primaryStage.getIcons().add(image);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
