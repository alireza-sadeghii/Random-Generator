package ir.ac.kntu.sequence;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import ir.ac.kntu.Main;


public class SequenceGenerate {

    private float first;
    private float last;
    private float distance;
    @FXML
    private TextField start;
    @FXML
    private TextField end;
    @FXML
    private TextField seqStep;
    @FXML
    private ListView<String> list;
    @FXML
    private Label alert;


    public void generate(){
        hideAlert();
        changeList();
        readFields();
        list.getItems().clear();
        madeSequence();
    }

    private void readFields(){
        readDistance();
        readFirst();
        readLast();
    }

    private void madeSequence(){
        int count = 1;
        if (distance==0 || (last-first)/distance <= 0){
            return;
        }
        if (distance< 0.5 && distance>-0.5){
            alertMessage();
            return;
        }
        while(first <= last){
            list.getItems().add(count+ ")        -----→" + "            " + first);
            first += distance;
            count++;
        }
    }

    private void changeList(){
        list.setCellFactory(str -> new ListCell<>(){
            @Override
            protected void updateItem(String s, boolean b) {
                super.updateItem(s,b);
                if (b || s == null) {
                    setText("");
                } else {
                    setText(s);
                    if (!s.isEmpty()) {
                        setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 119),
                                CornerRadii.EMPTY, Insets.EMPTY)));
                    }
                }
            }
        });
    }

    private void alertMessage(){
        list.setVisible(false);
        alert.setVisible(true);
    }

    private void hideAlert(){
        list.setVisible(true);
        alert.setVisible(false);
    }

    private void readDistance(){
        try {
            distance = Float.parseFloat(seqStep.getText());
        }catch (Exception e){
            distance = 0;
            setFieldText(seqStep);
        }
    }

    private void readFirst(){
        try {
            first = Float.parseFloat(start.getText());
        }catch (Exception e){
            first = 0;
            setFieldText(start);
        }
    }

    private void readLast(){
        try {
            last = Float.parseFloat(end.getText());
        }catch (Exception e){
            last = 0;
            setFieldText(end);
        }
    }

    private void setFieldText(TextField txtFld){
        txtFld.setText("0");
    }

    public void goHome(){
        Main.hideIt(4);
        Main.visibleIt(0);
        list.getItems().clear();
        alert.setVisible(false);
        list.setVisible(true);
        start.clear();
        end.clear();
        seqStep.clear();
    }

}
