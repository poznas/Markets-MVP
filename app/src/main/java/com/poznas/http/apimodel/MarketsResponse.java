
package com.poznas.http.apimodel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MarketsResponse {

    @SerializedName("markets")
    @Expose
    private List<Market> markets = null;
    @SerializedName("chartFormat")
    @Expose
    private String chartFormat;
    @SerializedName("lightstreamerEndpoint")
    @Expose
    private String lightstreamerEndpoint;
    @SerializedName("configuration")
    @Expose
    private Object configuration;

    public List<Market> getMarkets() {
        return markets;
    }

    public void setMarkets(List<Market> markets) {
        this.markets = markets;
    }

    public String getChartFormat() {
        return chartFormat;
    }

    public void setChartFormat(String chartFormat) {
        this.chartFormat = chartFormat;
    }

    public String getLightstreamerEndpoint() {
        return lightstreamerEndpoint;
    }

    public void setLightstreamerEndpoint(String lightstreamerEndpoint) {
        this.lightstreamerEndpoint = lightstreamerEndpoint;
    }

    public Object getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Object configuration) {
        this.configuration = configuration;
    }

}
