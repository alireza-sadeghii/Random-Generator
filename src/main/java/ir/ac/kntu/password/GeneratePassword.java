package ir.ac.kntu.password;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import ir.ac.kntu.Main;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class GeneratePassword {
    @FXML
    private TextField passName;
    @FXML
    private TextField passYear;
    @FXML
    private Text generate;
    @FXML
    private Button copy;
    private String name;
    private String birthYear;
    private final String[] symbols = new String[]{"@","#","$","&"};
    private String password;


    public void generating(){
        setName();
        setBirthYear();
        processingPassword();
        generate.setText(password);
    }

    public void setName() {
        this.name = passName.getText();
    }

    public void setBirthYear() {
        this.birthYear = passYear.getText();
    }

    private void processingPassword(){
        if (name.isEmpty() || birthYear.isEmpty()){
            return;
        }
        changeName();
        int randomLength = (int) (Math.random() * birthYear.length());
        password = birthYear.substring(0,randomLength);
        password += name;
        password += birthYear.substring(randomLength);
        copy.setVisible(true);
    }

    private void changeName(){
        if (name.length() > 2) {
            int capitalNum = (int) Math.sqrt(name.length());
            for (int i = 0; i < capitalNum; i++) {
                int random = (int) (Math.random() * name.length());
                name = name.replace(name.charAt(random), toCapital(name.charAt(random)));
            }
        }
        int cutNum = (int) (Math.random()*name.length());
        name = name.substring(0,cutNum) + symbols[(int) (Math.random()*4)] + name.substring(cutNum);
    }

    private char toCapital(char inp){
        if (inp>=97 && inp<=122){
            return (char) ((int)inp - 32);
        }
        return inp;
    }

    public void copyAction(){
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents (new StringSelection(password), null);
    }

    public void goHome(){
        generate.setText("");
        copy.setVisible(false);
        passName.setText("");
        passYear.setText("");
        Main.hideIt(1);
        Main.visibleIt(0);
    }
}
