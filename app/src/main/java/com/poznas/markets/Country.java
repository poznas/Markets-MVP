package com.poznas.markets;

import java.util.Objects;

public class Country {

    private String displayName;
    private String locale;
    private String countryCode;

    public Country(String displayName, String locale, String countryCode) {
        this.displayName = displayName;
        this.locale = locale;
        this.countryCode = countryCode;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country = (Country) o;
        return Objects.equals(displayName, country.displayName) &&
                Objects.equals(locale, country.locale) &&
                Objects.equals(countryCode, country.countryCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(displayName, locale, countryCode);
    }
}
