package jp.project.fab.util;

import jp.project.fab.model.City;
import jp.project.fab.model.CityModified;
import jp.project.fab.model.Forecast;
import jp.project.fab.model.ForecastModified;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {

    public static List<String>  searchIndices(String commande){
        List<String> indic = new ArrayList<>();
        List<String> mots = Arrays.asList(commande.split(" "));
        mots.stream().forEach(m ->{
            if(m.equals("email")) indic.add("email");
            if(m.equals("history")) indic.add("history");
            if(m.equals("weather")) indic.add("weather");
        });
        return indic;
    }

    public static CityModified transformToCityModified(City city){
        CityModified modified = new CityModified();
        modified.setCp(city.getCp());
        modified.setName(city.getName());
        return modified;
    }

    public static ForecastModified transformToCityModified(Forecast forecast){
        ForecastModified modified = new ForecastModified();
        modified.setDatetime(forecast.getDatetime());
        modified.setDay(forecast.getDay());
        modified.setDirwind10m(forecast.getDirwind10m());
        modified.setGust10m(forecast.getGust10m());
        modified.setLatitude(forecast.getLatitude());
        modified.setLongitude(forecast.getLongitude());
        modified.setProbarain(forecast.getProbarain());
        modified.setWind10m(forecast.getWind10m());
        modified.setTmin(forecast.getTmin());
        modified.setTmax(forecast.getTmax());
        modified.setRr10(forecast.getRr10());
        modified.setRr1(forecast.getRr1());

        return modified;
    }
}
