package com.poznas.markets.fragment;

import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.poznas.http.apimodel.Market;
import com.poznas.markets.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CountryMarketsAdapter extends RecyclerView.Adapter<CountryMarketsAdapter.MarketViewHolder>{

    private List<Market> records;

    public CountryMarketsAdapter(List<Market> markets) {
        records = markets;
    }


    @Override
    public MarketViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_market, parent, false);

        return new MarketViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MarketViewHolder holder, int position) {
        Market currentRecord = records.get(position);

        holder.setMarketData(currentRecord);
    }

    @Override
    public int getItemCount() {
        return records.size();
    }

    public void updateData(List<Market> newRecords) {
        CountryMarketsDiffUtil diffUtil = new CountryMarketsDiffUtil(records, newRecords);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffUtil);
        records.clear();
        records.addAll(newRecords);
        diffResult.dispatchUpdatesTo(this);
    }

    public class MarketViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.inst_name_view)
        TextView instrumentNameView;
        @BindView(R.id.display_offer_view)
        TextView displayOfferView;

        public MarketViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setMarketData(Market currentRecord) {
            instrumentNameView.setText(currentRecord.getInstrumentName());
            displayOfferView.setText(currentRecord.getDisplayOffer());
        }
    }
}
