package com.poznas.markets.fragment;

import com.poznas.markets.Country;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CountryFragmentPresenter implements CountryFragmentMVP.Presenter {

    private final HashMap<Country, Disposable> countryDisposableHashMap;
    private CountryFragmentMVP.Model model;

    public CountryFragmentPresenter(CountryFragmentMVP.Model model) {
        this.model = model;
        countryDisposableHashMap = new HashMap<>();
    }

    @Override
    public void loadData(CountryFragmentMVP.View view, Country country) {
        view.setLoading(true);

        Disposable subscription = model.getCountryMarkets(country.getLocale(), country.getCountryCode())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate(()-> view.setLoading(false))
                .subscribe(
                        marketsResponse ->
                                view.updateData(marketsResponse.getMarkets()),
                        error ->
                                view.showSnackBar(error.getLocalizedMessage())
                );

        synchronized (countryDisposableHashMap){
            countryDisposableHashMap.put(country, subscription);
        }
    }

    @Override
    public synchronized void detachView(Country country) {
        Disposable disposable = countryDisposableHashMap.get(country);
        if( disposable != null ){
            disposable.dispose();
            countryDisposableHashMap.remove(country);
        }
    }
}
