package jp.project.fab.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForecastModified {
    private Double latitude;
    private Double longitude;
    private Integer day;
    private String datetime;
    private Integer wind10m;
    private Integer gust10m;
    private Integer dirwind10m;
    private Double rr10;
    private Double rr1;
    private Integer probarain;
    private Integer weather;
    private Integer tmin;
    private Integer tmax;
}
