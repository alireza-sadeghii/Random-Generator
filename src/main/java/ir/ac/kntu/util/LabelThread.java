package ir.ac.kntu.util;

import javafx.scene.control.Label;

public class LabelThread extends Thread{
    private final int duration;
    private Label label;

    public LabelThread(Label label) {
        this.duration = 5;
        this.label = label;
    }

    @Override
    public void run() {
        super.run();
        this.label.setVisible(true);
        try {
            join(duration * 1000L);
        }catch (Exception ignored){
        }
        this.label.setVisible(false);
    }
}
