package com.poznas.root;


import com.poznas.http.ApiModuleForMarkets;
import com.poznas.markets.MarketsActivity;
import com.poznas.markets.MarketsModule;
import com.poznas.markets.fragment.CountryFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        MarketsModule.class,
        ApiModuleForMarkets.class
})
public interface ApplicationComponent {

    void inject(MarketsActivity activity);
    void inject(CountryFragment fragment);

}
