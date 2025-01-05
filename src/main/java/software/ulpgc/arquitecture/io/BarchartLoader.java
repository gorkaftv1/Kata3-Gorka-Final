package software.ulpgc.arquitecture.io;

import software.ulpgc.arquitecture.model.Barchart;
import software.ulpgc.arquitecture.model.Wood;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BarchartLoader {
    private final List<Wood> list;

    public BarchartLoader(WoodLoader loader) {
        try {
            list = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Barchart load(int id){
        return switch (id) {
            case 0 -> quality();
            case 1-> export();
            default-> null;
        };
    }

    private Barchart quality() {
        Barchart barchart = new Barchart("Quality", "quality", "count");
        Map<String, Integer> map = list.stream().map(Wood::quality).map(Enum::name).collect(Collectors.toMap(w -> w, _ -> 1, Integer::sum));
        insertMap(map, barchart);
        return barchart;
    }

    private Barchart export() {
        Barchart barchart = new Barchart("Export", "country", "count");
        Map<String, Integer> map = list.stream().flatMap(cw -> cw.importers().stream()).map(Enum::name).
                collect(Collectors.toMap(w -> w, _ -> 1, Integer::sum));
        insertMap(map, barchart);
        return barchart;
    }

    private static void insertMap(Map<String, Integer> map, Barchart barchart) {
        for(String n: map.keySet()) barchart.add(n, map.get(n));
    }
}
