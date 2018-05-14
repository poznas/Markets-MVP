package com.poznas.markets;

import com.poznas.Constants;

import java.util.List;

public class MarketsModel implements MarketsActivityMVP.Model {

    @Override
    public List<Country> getCountries() {
        return Constants.countries;
    }
}
