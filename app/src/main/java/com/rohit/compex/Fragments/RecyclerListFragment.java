package com.rohit.compex.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rohit.compex.Managers.AccountsDao;
import com.rohit.compex.R;
import com.rohit.compex.models.Account;

import java.util.List;

/**
 * Created by rohik on 12/11/16.
 */
public abstract class RecyclerListFragment<T> extends Fragment {

    private RecyclerView mRecyclerListView;
    private RecyclerListAdapter mRecyclerListAdapter;


    public abstract List<T> getListData();
    public abstract RecyclerListViewHolder<T> getViewHolder(ViewGroup parent, int viewType);

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler_list, container, false);
        mRecyclerListView = (RecyclerView) view.findViewById(R.id.recycler_list_view);
        mRecyclerListView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mRecyclerListAdapter = new RecyclerListAdapter(getListData());
        mRecyclerListView.setAdapter(mRecyclerListAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mRecyclerListAdapter.setDataList(getListData());
        mRecyclerListAdapter.notifyDataSetChanged();
    }

    protected abstract class RecyclerListViewHolder<T> extends RecyclerView.ViewHolder {

        public RecyclerListViewHolder(final View itemView) {
            super(itemView);
            initializeViews(itemView);
        }

        public abstract void initializeViews(View view);
        public abstract void bind(T dataObject);
    }

    private class RecyclerListAdapter<T> extends RecyclerView.Adapter<RecyclerListViewHolder> {

        private List<T> mDataList;

        public RecyclerListAdapter(List<T> dataList) {
            mDataList = dataList;
        }

        public void setDataList(List<T> dataList) {
            mDataList = dataList;
        }

        @Override
        public RecyclerListViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
            return getViewHolder(parent, viewType);
        }

        @Override
        public void onBindViewHolder(final RecyclerListViewHolder holder, final int position) {
            holder.bind(mDataList.get(position));
        }

        @Override
        public int getItemCount() {
            return mDataList.size();
        }
    }
}
