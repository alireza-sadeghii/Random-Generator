package ir.ac.kntu.util;


import ir.ac.kntu.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.net.URI;

public class MyInfo {

    private URI linkedIn;
    private URI gitHub;
    @FXML
    private Label copied;

    public MyInfo() {
        try {
            this.linkedIn = new URI("https://www.linkedin.com/in/alireza-as-051467201/");
            this.gitHub = new URI("https://github.com/alirezasad");
        }catch (Exception ignore){

        }
    }

    public void openLinkedIn(){
        openWebPage(linkedIn);
    }

    public void openGitHub(){
        openWebPage(gitHub);
    }

    public void emailClick(){
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new StringSelection("alireza.sproject@gmail.com"), null);
        Thread thread = new LabelThread(copied);
        thread.start();
    }

    private void openWebPage(URI address){
        try {
            Desktop.getDesktop().browse(address);
        }catch (Exception ignore){

        }
    }

    public void goHome(){
        Main.hideIt(6);
        Main.visibleIt(0);
    }
}
