package com.poznas.http;

import com.poznas.http.apimodel.MarketsResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IGGroupApiService {

    @GET("{locale}/{countryCode}")
    Observable<MarketsResponse> getCountryMarkets(
            @Path("locale") String locale,
            @Path("countryCode") String countryCode);
}
