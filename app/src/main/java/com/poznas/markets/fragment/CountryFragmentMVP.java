package com.poznas.markets.fragment;

import com.poznas.http.apimodel.Market;
import com.poznas.http.apimodel.MarketsResponse;
import com.poznas.markets.Country;

import java.util.List;

import io.reactivex.Observable;

public interface CountryFragmentMVP {

    interface View {

        void updateData(List<Market> results);

        void showSnackBar(String msg);

        void setLoading(boolean isLoading);

    }

    interface Presenter {

        void loadData(View view, Country country);

        void detachView(Country country);

    }

    interface Model {

        Observable<MarketsResponse> getCountryMarkets(String locale, String countryCode);
    }
}
