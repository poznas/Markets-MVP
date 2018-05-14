
package com.poznas.http.apimodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Market {

    @SerializedName("instrumentName")
    @Expose
    private String instrumentName;
    @SerializedName("instrumentVersion")
    @Expose
    private String instrumentVersion;
    @SerializedName("displayPeriod")
    @Expose
    private String displayPeriod;
    @SerializedName("epic")
    @Expose
    private String epic;
    @SerializedName("exchangeId")
    @Expose
    private String exchangeId;
    @SerializedName("displayBid")
    @Expose
    private String displayBid;
    @SerializedName("displayOffer")
    @Expose
    private String displayOffer;
    @SerializedName("updateTime")
    @Expose
    private Integer updateTime;
    @SerializedName("netChange")
    @Expose
    private String netChange;
    @SerializedName("scaled")
    @Expose
    private Boolean scaled;
    @SerializedName("timezoneOffset")
    @Expose
    private Integer timezoneOffset;

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public String getInstrumentVersion() {
        return instrumentVersion;
    }

    public void setInstrumentVersion(String instrumentVersion) {
        this.instrumentVersion = instrumentVersion;
    }

    public String getDisplayPeriod() {
        return displayPeriod;
    }

    public void setDisplayPeriod(String displayPeriod) {
        this.displayPeriod = displayPeriod;
    }

    public String getEpic() {
        return epic;
    }

    public void setEpic(String epic) {
        this.epic = epic;
    }

    public String getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(String exchangeId) {
        this.exchangeId = exchangeId;
    }

    public String getDisplayBid() {
        return displayBid;
    }

    public void setDisplayBid(String displayBid) {
        this.displayBid = displayBid;
    }

    public String getDisplayOffer() {
        return displayOffer;
    }

    public void setDisplayOffer(String displayOffer) {
        this.displayOffer = displayOffer;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public String getNetChange() {
        return netChange;
    }

    public void setNetChange(String netChange) {
        this.netChange = netChange;
    }

    public Boolean getScaled() {
        return scaled;
    }

    public void setScaled(Boolean scaled) {
        this.scaled = scaled;
    }

    public Integer getTimezoneOffset() {
        return timezoneOffset;
    }

    public void setTimezoneOffset(Integer timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
    }

}
