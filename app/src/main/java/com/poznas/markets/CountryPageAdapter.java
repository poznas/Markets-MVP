package com.poznas.markets;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.poznas.markets.fragment.CountryFragment;

import java.util.ArrayList;
import java.util.List;


public class CountryPageAdapter extends FragmentStatePagerAdapter {


    private List<Fragment> fragments = new ArrayList<>();
    private List<Country> countries = new ArrayList<>();

    public CountryPageAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return countries.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return countries.get(position).getDisplayName();
    }

    public void initCountries(List<Country> newCountries) {
        countries.addAll(newCountries);
        for (Country country : countries) {
            CountryFragment fragment = new CountryFragment();
            fragment.setCountry(country);
            fragments.add(fragment);
        }
        notifyDataSetChanged();
    }
}
