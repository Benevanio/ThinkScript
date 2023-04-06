package thinscript.com;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class VitrineApp extends Application {
    private AnchorPane pane;
    private TextField txPesquisa;
    private TableView<ItensProperty> tbVitrine;
    private TableColumn<ItensProperty, String> columnProduto;
    private TableColumn<ItensProperty, Double> columnPreco;
    private static ObservableList<ItensProperty> listItens = FXCollections
            .observableArrayList();
    private static Carrinho carrinho;

    public class ItensProperty {
        private SimpleStringProperty produto;
        private SimpleDoubleProperty preco;

        public ItensProperty(String produto, double preco) {
            this.produto = new SimpleStringProperty(produto);
            this.preco = new SimpleDoubleProperty(preco);
        }

        public String getProduto() {
            return produto.get();
        }

        public void setProduto(String produto) {
            this.produto.set(produto);
        }

        public double getPreco() {
            return preco.get();
        }

        public void setPreco(double preco) {
            this.preco.set(preco);
        }

    }

    public class Produto {
        private String nome;
        private String preco;

        public Produto(String nome, String preco) {
            this.nome = nome;
            this.preco = preco;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getPreco() {
            return preco;
        }

        public void setPreco(String preco) {
            this.preco = preco;
        }
    }

    public class Carrinho {
        private List<Produto> produtos = new ArrayList<Produto>();

        public List<Produto> getProdutos() {
            return produtos;
        }

        public void AddProduto(Produto produto) {
            produtos.add(produto);
        }

    }

    public class Vitrine {
        private List<Produto> produtos = new ArrayList<Produto>();

        public List<Produto> getProdutos() {
            return produtos;
        }

        public void AddProduto(Produto produto) {
            produtos.add(produto);
        }

    }

    /**
     * 
     */
    public void initComponents() {
        pane = new AnchorPane();
        pane.setPrefSize(800, 600);
        txPesquisa = new TextField();
        txPesquisa.setPromptText("Digite o item para pesquisa");
        tbVitrine = new TableView<ItensProperty>();
        tbVitrine.setPrefSize(780, 550);
        columnProduto = new TableColumn<ItensProperty, String>();
        columnPreco = new TableColumn<ItensProperty, Double>();
        tbVitrine.getColumns().addAll(columnProduto, columnPreco);
        pane.getChildren().addAll(txPesquisa, tbVitrine);
        carrinho = new Carrinho();
        columnProduto.setCellValueFactory(
                new PropertyValueFactory<ItensProperty, String>("produto"));
        columnPreco.setCellValueFactory(
                    new PropertyValueFactory<ItensProperty, Double>("preco"));

        columnProduto.setPrefWidth(600);
        columnPreco.setPrefWidth(180);
        columnProduto.setText("Produto");
        columnPreco.setText("Preço");
        tbVitrine.setItems(listItens);

        AnchorPane.setTopAnchor(txPesquisa, 10.0);
        AnchorPane.setLeftAnchor(txPesquisa, 10.0);
        AnchorPane.setRightAnchor(txPesquisa, 10.0);
        AnchorPane.setTopAnchor(tbVitrine, 40.0);
        AnchorPane.setLeftAnchor(tbVitrine, 10.0);
        AnchorPane.setRightAnchor(tbVitrine, 10.0);

        Vitrine vitrine = new Vitrine();
        vitrine.AddProduto(new Produto("No game No life", "R$ 19,90"));
        vitrine.AddProduto(new Produto("KonoSuba", "R$ 19,90"));
        vitrine.AddProduto(new Produto("Sword Art Online", "R$ 19,90"));
        vitrine.AddProduto(new Produto("Overlord", "R$ 19,90"));
        vitrine.AddProduto(new Produto("Re:Zero", "R$ 19,90"));
        vitrine.AddProduto(new Produto("Kimi no na wa", "R$ 19,90"));


        tbVitrine.setItems(listItens);
        for (Produto produto : vitrine.getProdutos()) {
            try {
                listItens.add(new ItensProperty(produto.getNome(),
                        Double.parseDouble(produto.getPreco().replace("R$ ", "")
                                .replace(",", "."))));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                tbVitrine.setItems(listItens);
            }}
        }
        private ObservableList<ItensProperty> findItems() {
            ObservableList<ItensProperty> itensEncontrados = FXCollections
                    .observableArrayList();
            for (ItensProperty itens : listItens) {
                if (itens.getProduto().contains(txPesquisa.getText())) {
                    itensEncontrados.add(itens);
    
                }
            }
            return itensEncontrados;
        }   


    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new Pane(), 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Vitrine");
        primaryStage.show();
        Pane pane = (Pane) scene.getRoot();
        pane.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, blue 0%, silver 100%);");
        initComponents();
        pane.getChildren().add(this.pane);
        txPesquisa.textProperty().addListener((observable, oldValue,
                newValue) -> {
            tbVitrine.setItems(findItems());
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
