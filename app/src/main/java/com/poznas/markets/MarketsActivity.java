package com.poznas.markets;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.poznas.root.App;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MarketsActivity extends AppCompatActivity implements MarketsActivityMVP.View {


    @BindView(R.id.rootView)
    ViewGroup rootView;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.container)
    ViewPager viewPager;

    CountryPageAdapter countryPageAdapter;

    @Inject
    MarketsActivityMVP.Presenter presenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        ((App) getApplication()).getComponent().inject(this);
        ButterKnife.bind(this);

        initializeViewPager();

        presenter.attachView(this);
        presenter.loadData();
    }

    private void initializeViewPager() {
        countryPageAdapter = new CountryPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(countryPageAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void initCountries(List<Country> countries) {
        countryPageAdapter.initCountries(countries);
    }

    @Override
    public void showSnackBar(String msg) {
        Snackbar.make(rootView, msg, Snackbar.LENGTH_SHORT).show();
    }
}
