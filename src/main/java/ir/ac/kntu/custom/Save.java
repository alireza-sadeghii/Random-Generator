package ir.ac.kntu.custom;

import javafx.scene.control.ListView;
import java.io.*;

public class Save {
    private final String fileAddress = "src\\main\\resources\\data\\data.txt";
    private ListView<String> list;

    public void saveData(){
        Thread thread = new SaveThread();
        thread.start();
        try {
            thread.join();
        }catch (Exception ignore){
        }
        writeInFile();
    }

    public void loadData(){
        readFile();
    }

    private void writeInFile(){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileAddress));
            for (String inp : list.getItems()){
                writer.write(inp);
                writer.newLine();
            }
            writer.flush();
            writer.close();
        }catch (FileNotFoundException e){
            //todo : need to implement a popup page for error
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void readFile(){
        String load;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileAddress));
            while((load = reader.readLine()) != null){
                list.getItems().add(load);
            }
            reader.close();
        }catch (Exception e){
            //todo : need to implement a popup page for error
        }
    }

    public void setList(ListView<String> list) {
        this.list = list;
    }

    public ListView<String> getList() {
        return list;
    }
}
