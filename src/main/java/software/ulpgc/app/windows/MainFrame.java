package software.ulpgc.app.windows;

import software.ulpgc.arquitecture.control.Command;
import software.ulpgc.arquitecture.view.BarchartDisplay;
import software.ulpgc.arquitecture.view.SelectDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private final BarchartDisplay display;
    private Map<String, Command> commands = new HashMap<>();
    private SelectDialog dialog;

    public MainFrame(){
        setLayout(new BorderLayout());
        setSize(800, 600);
        setTitle("Kata3");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add((Component) (display = createDisplay()));
        add(selector(), BorderLayout.SOUTH);
    }

    private Component selector() {
        JComboBox<String> combo = new JComboBox<>();
        combo.addItem("Quality");
        combo.addItem("Imports");
        combo.addItemListener(e -> {
            if (e.getStateChange() != ItemEvent.SELECTED) return;
            commands.get("Select").execute();
                }
        );
        dialog = combo::getSelectedIndex;
        return combo;
    }

    private BarchartDisplay createDisplay() {
        return new JFreeBarchartDisplay();
    }

    public BarchartDisplay display(){
        return display;
    }
    public SelectDialog dialog(){
        return dialog;
    }
    public void put(String name , Command command){
        this.commands.put(name, command);
    }
}
