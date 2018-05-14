package com.poznas.markets;

import com.poznas.http.IGGroupApiService;
import com.poznas.markets.fragment.CountryFragmentMVP;
import com.poznas.markets.fragment.CountryFragmentModel;
import com.poznas.markets.fragment.CountryFragmentPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MarketsModule  {

    @Provides
    public MarketsActivityMVP.Presenter provideMarketsActivityPresenter(MarketsActivityMVP.Model model){
        return new MarketsPresenter(model);
    }

    @Provides
    MarketsActivityMVP.Model provideMarketsActivityModel(){
        return new MarketsModel();
    }

    @Provides
    CountryFragmentMVP.Model providesCountryFragmentModel(IGGroupApiService service){
        return new CountryFragmentModel(service);
    }

    @Provides
    CountryFragmentMVP.Presenter providesCountryFragmentPresenter(CountryFragmentMVP.Model model){
        return new CountryFragmentPresenter(model);
    }
}
