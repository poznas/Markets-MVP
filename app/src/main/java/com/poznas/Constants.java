package com.poznas;

import com.poznas.markets.Country;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    public static final String BASE_URL = "https://api.ig.com/deal/samples/markets/ANDROID_PHONE/";

    public static final List<Country> countries = new ArrayList<Country>(){{
        add(new Country("UK","en_GB","igi"));
        add(new Country("Germany","de_DE","dem"));
        add(new Country("France","fr_FR","frm"));
    }};
}
