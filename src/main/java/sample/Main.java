package sample;

import data.DVHCDao;
import entity.DVHC;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox vBox = new VBox();
        List<String> all = new DVHCDao().findAll().stream()
                .map(DVHC::getName)
                .collect(Collectors.toList());
        TreeSet<String> strings = new TreeSet<>(all);
        AutoCompleteTextField<String> textField = new AutoCompleteTextField<>(strings);
        vBox.getChildren().add(textField);
        primaryStage.setScene(new Scene(vBox, 300, 300));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
