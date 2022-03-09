package ir.ac.kntu.custom;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import ir.ac.kntu.Main;

public class GenerateCustom {

    private Action action;
    @FXML
    private Button submitKey;
    @FXML
    private TextField objText;
    @FXML
    private ListView<String> list;
    @FXML
    private Text result;
    private final Save save = new Save();


    public void generate(){
        String random = list.getItems().get((int) (Math.random() * list.getItems().size()));
        result.setText(random);
    }

    public void visibleSubmitSheet(){
        submitKey.setVisible(true);
        objText.setVisible(true);
    }

    public void submit(){
        readInput();
        submitKey.setVisible(false);
        objText.setVisible(false);
        objText.setText("");
    }

    public void save(){
        save.setList(list);
        save.saveData();
    }

    public void load(){
        save.setList(new ListView<>());
        save.loadData();
        writeLoadedList(save.getList());
    }

    private void readInput(){
        String input = objText.getText().trim();
        if (!input.isEmpty()) {
            if (action == Action.ADD) {
                addItemToList(input);
            }
            if (action == Action.REMOVE){
                removeItemFromList(input);
            }
        }
    }

    private void removeItemFromList(String input){
        list.getItems().remove(input);
    }

    private void addItemToList(String input){
        if (!list.getItems().contains(input)) {
            list.getItems().add(input);
        }
    }

    private void writeLoadedList(ListView<String> loaded){
        removeAll();
        for(String inp : loaded.getItems()){
            addItemToList(inp);
        }
    }

    public void addRequest(){
        action = Action.ADD;
    }

    public void removeRequest(){
        action = Action.REMOVE;
    }

    public void removeAll(){
        list.getItems().clear();
    }

    public void goHome(){
        Main.hideIt(5);
        Main.visibleIt(0);
        result.setText("");
    }
}
