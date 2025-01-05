package software.ulpgc.arquitecture.io;

import software.ulpgc.arquitecture.model.Wood;

import java.io.IOException;
import java.util.List;

public interface WoodLoader {
    List<Wood> load() throws IOException;
}
