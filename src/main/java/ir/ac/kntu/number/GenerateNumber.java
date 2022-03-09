package ir.ac.kntu.number;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.text.Text;
import ir.ac.kntu.Main;


public class GenerateNumber {

    @FXML
    private Spinner<Integer> min;
    @FXML
    private Spinner<Integer> max;
    @FXML
    private Text result;
    @FXML
    private RadioButton intKey;
    @FXML
    private RadioButton floatKey;


    public void generate(){
        int minNum = min.getValue();
        int maxNum = max.getValue();
        if (!intKey.isSelected() && !floatKey.isSelected()){
            return;
        }
        String randomNum = floatKey.isSelected() ? generateFloat(minNum, maxNum) : generateInt(minNum, maxNum);
        result.setText(randomNum);
    }

    private String generateFloat(int minNum,int maxNum){
        String randomNum = (int)(minNum + Math.random() * (maxNum - minNum)) + "";
        return randomNum + "." + (int)(Math.random()*10);
    }

    private String generateInt(int minNum,int maxNum){
        return (int)(minNum + Math.random() * (maxNum - minNum + 1)) + "";
    }

    public void spinnerEdit(){
        addListener(min);
        addListener(max);
    }

    private void addListener(Spinner<Integer> spinner){
        spinner.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue.matches("\\d*")){
                spinner.getEditor().setText(oldValue);
            }else {
                try {
                    if(inIntegerBound(Double.parseDouble(newValue))){
                        spinner.getEditor().setText(oldValue);
                    }
                }catch (Exception ignored){}
            }
        });
    }

    private Boolean inIntegerBound(double value){
        return Integer.MIN_VALUE > value || value > Integer.MAX_VALUE;
    }

    public void intButtonCheck(){
        if (floatKey.isSelected()){
            intKey.setSelected(false);
        }
    }

    public void floatButtonCheck(){
        if (intKey.isSelected()){
            floatKey.setSelected(false);
        }
    }

    public void goHome(){
        Main.hideIt(3);
        Main.visibleIt(0);
        min.getEditor().setText("0");
        min.getValueFactory().setValue(0);
        max.getEditor().setText("0");
        max.getValueFactory().setValue(0);
        result.setText("");
    }

}
