package software.ulpgc.arquitecture.control;

import software.ulpgc.arquitecture.io.BarchartLoader;
import software.ulpgc.arquitecture.view.BarchartDisplay;
import software.ulpgc.arquitecture.view.SelectDialog;

public class SelectCommand implements Command{
    private final SelectDialog dialog;
    private final BarchartDisplay display;
    private final BarchartLoader loader;

    public SelectCommand(SelectDialog dialog, BarchartDisplay display, BarchartLoader loader) {
        this.dialog = dialog;
        this.display = display;
        this.loader = loader;
    }

    @Override
    public void execute() {
        display.show(loader.load(dialog.getSelection()));
    }
}
