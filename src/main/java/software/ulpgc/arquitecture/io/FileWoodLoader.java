package software.ulpgc.arquitecture.io;

import software.ulpgc.arquitecture.model.Wood;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWoodLoader implements WoodLoader {
    private final BufferedReader reader;
    private final WoodDesrializer desrializer;

    public FileWoodLoader(File file, WoodDesrializer desrializer) throws IOException {
        this.reader = new BufferedReader(new FileReader(file));
        this.desrializer = desrializer;
        skipHeader();
    }

    private void skipHeader() throws IOException {
        reader.readLine();
    }

    @Override
    public List<Wood> load() throws IOException {
        List<Wood> woodList = new ArrayList<>();
        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            woodList.add(desrializer.deserialize(line));
        }
        return woodList;
    }
}
