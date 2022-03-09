package ir.ac.kntu.bool;

import ir.ac.kntu.Main;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;


public class GenerateBoolean{
    @FXML
    private ImageView trueImg;
    @FXML
    private ImageView falseImg;
    @FXML
    private Text result;
    private boolean randomBool;

    public void generate(){
        visibleImages();
        boolean[] boolList = {true,false};
        randomBool = boolList[randomizeIndex()];
        result.setText((randomBool+"").toUpperCase());
        setVisibilityOfImages();
    }

    private int randomizeIndex(){
        int index = (int)(Math.random()*10 + 1);
        return (index%2==0)? (0) : (1);
    }

    private void setVisibilityOfImages(){
        if (randomBool){
            falseImg.setVisible(false);
            return;
        }
        trueImg.setVisible(false);
    }

    public void goHome() {
        visibleImages();
        result.setText("");
        Main.hideIt(2);
        Main.visibleIt(0);
    }

    private void visibleImages(){
        trueImg.setVisible(true);
        falseImg.setVisible(true);
    }
}
