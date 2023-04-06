package thinscript.com;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import thinscript.com.VitrineApp.Produto;

public class ItemApp extends Application {
    private AnchorPane pane;
    private ImageView imgItem;
    private Label lblPreco, lblDescricao;
    private Button AddCarrinho;
    private static Stage stage;
    private static Produto produto;
    private static int index;

    private static String[] images = {
            "https://images-americanas.b2w.io/produtos/01/00/img/132000/0/132000000_1GG.jpg",
            "https://images-americanas.b2w.io/produtos/01/00/img/132000/0/132000000_1GG.jpg",
            "https://images-americanas.b2w.io/produtos/01/00/img/132000/0/132000000_1GG.jpg",
            "https://images-americanas.b2w.io/produtos/01/00/img/132000/0/132000000_1GG.jpg",
            "https://images-americanas.b2w.io/produtos/01/00/img/132000/0/132000000_1GG.jpg",
            "https://images-americanas.b2w.io/produtos/01/00/img/132000/0/132000000_1GG.jpg",
            "https://images-americanas.b2w.io/produtos/01/00/img/132000/0/132000000_1GG.jpg",
            "https://images-americanas.b2w.io/produtos/01/00/img/132000/0/132000000_1GG.jpg",
            "https://images-americanas.b2w.io/produtos/01/00/img/132000/0/132000000_1GG.jpg",
            "https://images-americanas.b2w.io/produtos/01/00/img/132000/0/132000000_1GG.jpg",
            "https://images-americanas.b2w.io/produtos/01/00/img/132000/0/132000000_1GG.jpg",
            "https://images-americanas.b2w.io/produtos/01/00/img/132000/0/132000000_1GG.jpg",
            "https://images-americanas.b2w.io/produtos/01/00/img/132000/0/132000000_1GG.jpg",
            "https://images-americanas.b2w.io/produtos/01/00/img/132000/0/132000000_1GG.jpg",

    };

    // descrição
    private static String[] descricao = {
            "Descrição do produto 1",
            "Descrição do produto 2",
            "Descrição do produto 3",
            "Descrição do produto 4",
            "Descrição do produto 5",
            "Descrição do produto 6",
            "Descrição do produto 7",
            "Descrição do produto 8",
            "Descrição do produto 9",
            "Descrição do produto 10",
            "Descrição do produto 11",
            "Descrição do produto 12",
            "Descrição do produto 13",
            "Descrição do produto 14",

    };

    // preço
    private static double[] preco = {
            10.00,
            20.00,
            30.00,
            40.00,
            50.00,
            60.00,
            70.00,
            80.00,
            90.00,
            100.00,
            110.00,
            120.00,
            130.00,
            140.00,

    };

    public static String[] getImages() {
        return images;
    }

    public static void setImages(String[] images) {
        ItemApp.images = images;
    }

    public static String[] getDescricao() {
        return descricao;
    }

    public static void setDescricao(String[] descricao) {
        ItemApp.descricao = descricao;
    }

    public static double[] getPreco() {
        return preco;
    }

    public static void setPreco(double[] preco) {
        ItemApp.preco = preco;
    }

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        ItemApp.index = index;
    }

    public static Stage getStage() {
        return stage;
    }

    public static Produto getProduto() {
        return produto;
    }

    public static void setProduto(Produto produto) {
        ItemApp.produto = produto;
    }

    @Override
    public void start(Stage stage) throws Exception {
        pane = new AnchorPane();
        pane.setPrefSize(400, 300);
        pane.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, blue 0%, silver 100%);");
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Item");
        stage.setResizable(false);
        stage.show();
        ItemApp.stage = stage;

        imgItem = new ImageView();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
