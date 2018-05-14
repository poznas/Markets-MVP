package com.poznas.markets.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.poznas.http.apimodel.Market;
import com.poznas.markets.Country;
import com.poznas.markets.R;
import com.poznas.root.App;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CountryFragment extends android.support.v4.app.Fragment implements CountryFragmentMVP.View{

    private Country country;
    private List<Market> markets = new ArrayList<>();

    @BindView(R.id.fragment_root)
    ViewGroup rootView;
    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.market_recycler)
    RecyclerView marketRecyclerView;
    CountryMarketsAdapter marketsAdapter;

    @Inject
    CountryFragmentMVP.Presenter presenter;

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public void onAttach(Context context) {
        ((App) context.getApplicationContext()).getComponent().inject(this);
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_country, container, false);
        ButterKnife.bind(this, view);

        initializeMarketRecycler();
        presenter.loadData(this, country);
        swipeRefreshLayout.setOnRefreshListener(() ->
                presenter.loadData(this, country));

        return view;
    }

    private void initializeMarketRecycler() {
        marketsAdapter = new CountryMarketsAdapter(markets);
        marketRecyclerView.setAdapter(marketsAdapter);
        marketRecyclerView.setItemAnimator(new DefaultItemAnimator());
        marketRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView(country);
    }

    @Override
    public void updateData(List<Market> results) {
        marketsAdapter.updateData(results);
    }

    @Override
    public void showSnackBar(String msg) {
        Snackbar.make(rootView, msg, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void setLoading(boolean isLoading) {
        swipeRefreshLayout.setRefreshing(isLoading);
    }
}
