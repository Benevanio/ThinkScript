package thinscript.com;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
public class LogginApp extends Application {
   
    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane pane = new AnchorPane();
        pane.setPrefSize(400, 300);
        TextField txLogin = new TextField();
        txLogin.setPromptText("Digite aqui seu login");
        PasswordField txSenha = new PasswordField();
        txSenha.setPromptText("Digite aqui sua senha");
        Button btEntrar = new Button("Entrar");
        Button btSair = new Button("Sair");
        pane.getChildren().addAll(txLogin, txSenha, btEntrar, btSair);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
        // estilos
        pane.setStyle("-fx-background-color: linear-gradient( from 0% 0% to 100% 100%, #000000, #0000FF);");
        txLogin.setLayoutX((pane.getWidth() - txLogin.getWidth()) / 2);
        txLogin.setLayoutY(50);
        txSenha.setLayoutX((pane.getWidth() - txSenha.getWidth()) / 2);
        txSenha.setLayoutY(100);
        btEntrar.setLayoutX((pane.getWidth() - btEntrar.getWidth()) / 2);
        btEntrar.setLayoutY(150);
        btSair.setLayoutX((pane.getWidth() - btSair.getWidth()) / 2);
        btSair.setLayoutY(200);

        btSair.setOnAction(e -> {
            System.exit(0);
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}