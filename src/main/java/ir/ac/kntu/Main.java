package ir.ac.kntu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.Objects;
import java.util.stream.IntStream;

public class Main extends Application {
    public static StackPane root = new StackPane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        mainFxml(); // -----> 0
        passwordGenerate(); // ------> 1
        booleanGenerate(); // ------> 2
        numberGenerate(); // ------> 3
        sequenceGenerate(); // ------> 4
        customGenerate(); // ------> 5
        informationPage(); // -------> 6

        visibleIt(0);

        Scene scene = new Scene(root);

        stage.getIcons().add(new Image("icon/icon.jpg"));
        stage.setTitle("Random Generator");
        ((Button) root.lookup("#passKey")).setOnAction(e -> visibleIt(1));
        ((Button) root.lookup("#boolKey")).setOnAction(e -> visibleIt(2));
        ((Button) root.lookup("#numKey")).setOnAction(e -> visibleIt(3));
        ((Button) root.lookup("#seqKey")).setOnAction(e -> visibleIt(4));
        ((Button) root.lookup("#customKey")).setOnAction(e -> visibleIt(5));
        ((Button) root.lookup("#about")).setOnAction(e -> visibleIt(6));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void mainFxml(){
        try{
            root.getChildren().add(FXMLLoader.load
                    (Objects.requireNonNull(getClass().getResource("/fxml/interface.fxml"))));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void passwordGenerate(){
        try{
            root.getChildren().add(FXMLLoader.load(
                    Objects.requireNonNull(getClass().getResource("/fxml/passwordGenerate.fxml"))));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void booleanGenerate(){
        try {
            root.getChildren().add(FXMLLoader.load(
                    Objects.requireNonNull(getClass().getResource("/fxml/booleanGenerate.fxml"))));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void numberGenerate(){
        try {
            root.getChildren().add(FXMLLoader.load(
                    Objects.requireNonNull(getClass().getResource("/fxml/numberGenerate.fxml"))));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void sequenceGenerate(){
        try {
            root.getChildren().add(FXMLLoader.load(
                    Objects.requireNonNull(getClass().getResource("/fxml/sequenceGenerate.fxml"))));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void customGenerate(){
        try {
            root.getChildren().add(FXMLLoader.load(
                    Objects.requireNonNull(getClass().getResource("/fxml/customGenerate.fxml"))));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void informationPage(){
        try {
            root.getChildren().add(FXMLLoader.load(
                    Objects.requireNonNull(getClass().getResource("/fxml/personalData.fxml"))));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void visibleIt(int index){
        hideAll();
        root.getChildren().get(index).setVisible(true);
    }

    public static void hideAll(){
        IntStream.rangeClosed(0,6).forEach(n -> root.getChildren().get(n).setVisible(false));
    }

    public static void hideIt(int index){
        root.getChildren().get(index).setVisible(false);
    }

}
