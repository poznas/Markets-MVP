package com.poznas.markets.fragment;

import android.support.v7.util.DiffUtil;

import com.poznas.http.apimodel.Market;

import java.util.List;

public class CountryMarketsDiffUtil extends DiffUtil.Callback {

    private List<Market> oldList;
    private List<Market> newList;

    public CountryMarketsDiffUtil(List<Market> oldList, List<Market> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getInstrumentName()
                .equals(newList.get(newItemPosition).getInstrumentName());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
    }

}
