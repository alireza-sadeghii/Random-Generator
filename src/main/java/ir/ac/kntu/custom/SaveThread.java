package ir.ac.kntu.custom;

public class SaveThread extends Thread{
    private final int duration;

    public SaveThread() {
        this.duration = 4;
    }

    @Override
    public void run() {
        super.run();
        try {
            join(duration * 1000L);
        }catch (Exception ignored){
        }
    }

}
