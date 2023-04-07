package thinscript.com;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LogginApp extends Application {

    private AnchorPane pane;
    private TextField txLogin;
    private PasswordField txSenha;
    private Button btEntrar, btSair;
    private static Stage stage;

    public void initComponents() {
        pane = new AnchorPane();
        pane.setPrefSize(400, 300);
        pane.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, blue 0%, silver 100%);");
        txLogin = new TextField();
        txLogin.setPromptText("Digite seu login...");

        txLogin = new TextField();
        txLogin.setPromptText("Login");
        txLogin.setPrefSize(200, 20);
        txLogin.setLayoutX(50);
        txLogin.setLayoutY(50);

        txSenha = new PasswordField();
        txSenha.setPromptText("Senha");
        txSenha.setPrefSize(200, 20);
        txSenha.setLayoutX(50);
        txSenha.setLayoutY(80);

        btEntrar = new Button("Entrar");
        btEntrar.setPrefSize(90, 20);
        btEntrar.setLayoutX(50);
        btEntrar.setLayoutY(110);

        btSair = new Button("Sair");
        btSair.setPrefSize(90, 20);
        btSair.setLayoutX(150);
        btSair.setLayoutY(110);
        pane.getChildren().addAll(txLogin, txSenha, btEntrar, btSair);
    }

    private void initListeners() {
        btSair.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fecharAplicacao();
            }
        });

        btEntrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                logar();
            }
        });
    }

    private void logar() {
        if (txLogin.getText().equals("admin") && txSenha.getText().equals("admin")) {
            try {
                new VitrineApp().start(new Stage());
                LogginApp.stage.close();
                } catch (Exception e) {
                e.printStackTrace();
                }
        } else {
            System.out.println("Login ou senha inválidos!");          
        }
    }

    private void fecharAplicacao() {
        System.exit(0);
    }

    @Override
    public void start(Stage stage) throws Exception {
        initComponents();
        initListeners();
        Scene scene = new Scene(pane);
        stage.setScene(scene);        
        stage.setResizable(false);    
        stage.setTitle("Thinscript - Login");
        stage.show();
        LogginApp.stage = stage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}