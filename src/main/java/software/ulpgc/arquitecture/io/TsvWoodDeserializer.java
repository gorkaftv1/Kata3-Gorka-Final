package software.ulpgc.arquitecture.io;

import software.ulpgc.arquitecture.model.Wood;

import java.util.ArrayList;
import java.util.List;

public class TsvWoodDeserializer implements WoodDesrializer{
    @Override
    public Wood deserialize(String line) {
        String[] split = line.split("\t");
        return new Wood(
                split[0],
                split[1],
                getContinentOf(split[2]),
                getToneOf(split[3]),
                getCountryOf(split[4]),
                getQualityOf(split[5]),
                getPriceOf(split[6]),
                getImportersOf(split[7])
        );
    }

    private List<Wood.Country> getImportersOf(String s) {
        String[] countrys = s.split(",");
        List<Wood.Country> countryList = new ArrayList<>();
        for (String country : countrys) {
            countryList.add(getCountryOf(country));
        }
        return countryList;
    }

    private Float getPriceOf(String s) {
        return Float.valueOf(s);
    }

    private Wood.Quality getQualityOf(String s) {
        return Wood.Quality.valueOf(s);
    }

    private Wood.Country getCountryOf(String s) {
        return Wood.Country.valueOf(normalize(s));
    }

    private Wood.Tone getToneOf(String s) {
        return Wood.Tone.valueOf(normalize(s));
    }

    private Wood.Continent getContinentOf(String value) {
        return Wood.Continent.valueOf(normalize(value));
    }

    private String normalize(String value) {
        return value.replace(" ", "");
    }
}
