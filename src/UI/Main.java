package UI;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
        primaryStage.setMaximized(false);  // 起動時に最大化しておくにはここをTrueに
        primaryStage.setMinHeight(750);
        primaryStage.setMinWidth(1000);

        // ウィンドウサイズのリスナー
        // primaryStage.getScene().widthProperty().addListener((observableValue, oldWidth, newWidth) -> System.out.println("Width: " + newWidth));
        // primaryStage.getScene().heightProperty().addListener((observableValue, oldHeight, newHeight) -> System.out.println("Height: " + newHeight));

        // アイコン設定
        final Image image = new Image(getClass().getClassLoader().getResourceAsStream("UI/img/icon.png"));
        primaryStage.getIcons().add(image);

        // コントローラ初期化


        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
