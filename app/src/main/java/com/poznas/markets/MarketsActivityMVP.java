package com.poznas.markets;

import java.util.List;

public interface MarketsActivityMVP {

    interface View {

        void initCountries(List<Country> countries );

        void showSnackBar(String s);
    }

    interface Presenter {

        void loadData();

        void attachView(View view);

    }

    interface Model {

        List<Country> getCountries();
    }
}
