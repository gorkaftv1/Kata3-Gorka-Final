package software.ulpgc.app.windows;

import software.ulpgc.arquitecture.control.SelectCommand;
import software.ulpgc.arquitecture.io.BarchartLoader;
import software.ulpgc.arquitecture.io.FileWoodLoader;
import software.ulpgc.arquitecture.io.TsvWoodDeserializer;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        try {
            mainFrame.put("Select", getSelectCommand(mainFrame));
            mainFrame.display().show(getBarchartLoader().load(0));
            mainFrame.setVisible(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static SelectCommand getSelectCommand(MainFrame mainFrame) throws IOException {
        return new SelectCommand(mainFrame.dialog(), mainFrame.display(), getBarchartLoader());
    }

    private static BarchartLoader getBarchartLoader() throws IOException {
        return new BarchartLoader(getFileLoader());
    }

    private static FileWoodLoader getFileLoader() throws IOException {
        File file = new File("C:/Users/gorka/Downloads/WoodsData.tsv");
        return new FileWoodLoader(file, new TsvWoodDeserializer());
    }
}
