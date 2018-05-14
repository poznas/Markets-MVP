package com.poznas.markets.fragment;

import com.poznas.http.IGGroupApiService;
import com.poznas.http.apimodel.MarketsResponse;

import io.reactivex.Observable;

public class CountryFragmentModel implements CountryFragmentMVP.Model {

    private IGGroupApiService service;

    public CountryFragmentModel(IGGroupApiService service) {
        this.service = service;
    }

    @Override
    public Observable<MarketsResponse> getCountryMarkets(String locale, String countryCode) {
        return service.getCountryMarkets(locale, countryCode);
    }
}
