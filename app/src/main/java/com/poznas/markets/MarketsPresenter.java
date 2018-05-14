package com.poznas.markets;


public class MarketsPresenter implements MarketsActivityMVP.Presenter {

    private MarketsActivityMVP.View view;
    private MarketsActivityMVP.Model model;

    public MarketsPresenter(MarketsActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void loadData() {
        if( view != null){
            view.initCountries(model.getCountries());
        }
    }

    @Override
    public void attachView(MarketsActivityMVP.View view) {
        this.view = view;
    }
}
