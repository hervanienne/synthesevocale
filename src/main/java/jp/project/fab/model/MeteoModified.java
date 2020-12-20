package jp.project.fab.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeteoModified {
    private CityModified city;
    private ForecastModified foreCast;
}
