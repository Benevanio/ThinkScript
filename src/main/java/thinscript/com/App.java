package thinscript.com;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;
import javafx.geometry.Insets;

/**
 * JavaFX App
 */
public class App extends Application {
    /*
     * O primaryStage é a janela principal da aplicação
     * ou seja ele é o container principal da aplicação
     */
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Label label = new Label("Listagem de Produtos");
        root.getChildren().add(label);
        label.setFont(Font .font(
            "Lucida Sans Unicode", FontPosture.REGULAR, 20
        ));
        label.setLayoutX(10);
        label.setLayoutY(10);
        label.setPadding(new Insets(10, 10, 10, 10));
        Scene scene = new Scene(root, 940, 680);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Thinscript");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}