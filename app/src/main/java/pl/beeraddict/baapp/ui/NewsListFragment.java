package pl.beeraddict.baapp.ui;

import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;

import android.support.v4.content.Loader;
import android.view.View;
import android.widget.ListView;

import pl.beeraddict.baapp.BeerAddictApp;
import pl.beeraddict.baapp.BootstrapServiceProvider;
import pl.beeraddict.baapp.R;
import pl.beeraddict.baapp.core.News;
import pl.beeraddict.baapp.util.SingleTypeAdapter;


import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

public class NewsListFragment extends ItemListFragment<News> {

    @Inject protected BootstrapServiceProvider serviceProvider;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BeerAddictApp) getActivity().getApplication()).getComponent().inject(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setEmptyText(R.string.no_news);
    }

    @Override
    protected void configureList(Activity activity, ListView listView) {
        super.configureList(activity, listView);

        listView.setFastScrollEnabled(true);
        listView.setDividerHeight(0);

        getListAdapter()
                .addHeader(activity.getLayoutInflater()
                        .inflate(R.layout.news_list_item_labels, null));
    }

    @Override
    public void onDestroyView() {
        setListAdapter(null);

        super.onDestroyView();
    }

    @Override
    public Loader<List<News>> onCreateLoader(int id, Bundle args) {
        final List<News> initialItems = items;
        return new ThrowableLoader<List<News>>(getActivity(), items) {

            @Override
            public List<News> loadData() throws Exception {
                try {
                    if (getActivity() != null) {
                        return serviceProvider.getService(getActivity()).getNews();
                    } else {
                        return Collections.emptyList();
                    }

                } catch (OperationCanceledException e) {
                    Activity activity = getActivity();
                    if (activity != null)
                        activity.finish();
                    return initialItems;
                }
            }
        };
    }

    @Override
    protected SingleTypeAdapter<News> createAdapter(List<News> items) {
        return new NewsListAdapter(getActivity().getLayoutInflater(), items);
    }

    public void onListItemClick(ListView l, View v, int position, long id) {
        News news = ((News) l.getItemAtPosition(position));

        startActivity(new Intent(getActivity(), AleActivity.class));
    }

    @Override
    protected int getErrorMessage(Exception exception) {
        return R.string.error_loading_news;
    }
}
