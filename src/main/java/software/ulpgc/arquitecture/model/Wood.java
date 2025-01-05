package software.ulpgc.arquitecture.model;

import java.util.List;

public record Wood(String id, String Name, Continent OriginContinent, Tone tone, Country OriginCountry, Quality quality, Float pricePerSquareM, List<Country> importers) {
    public enum Continent {
        NorthAmerica,
        Europe,
        SouthAsia,
        Asia,
        CentralAmerica
    }
    public enum Country {
        USA,
        Brazil,
        Germany,
        SouthAfrica,
        Finland,
        Australia,
        Sweden,
        Netherlands,
        Canada,
        France,
        Portugal,
        Nepal,
        Morocco,
        Lebanon,
        Honduras,
        Spain,
        India,
        Japan,
        Italy,
        Poland,
        SouthKorea
    }
    public enum Tone {
        White,
        DarkBrown,
        LightBrown,
        GoldenBrown,
        ReddishBrown,
        RedBrown,
        Yellow,
        LightYellow,
        Pale
    }
    public enum Quality {
        Standard,Medium,High,Premium
    }
}
