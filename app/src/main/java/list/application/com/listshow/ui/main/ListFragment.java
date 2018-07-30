package list.application.com.listshow.ui.main;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import list.application.com.listshow.R;
import list.application.com.listshow.adapters.ItemsAdapter;
import list.application.com.listshow.models.Response;

import static android.support.v7.widget.LinearLayoutCompat.VERTICAL;
import static android.widget.LinearLayout.HORIZONTAL;

/**
 * Created by Puspak on 30/07/18.
 */

public class ListFragment extends Fragment implements MainViewInterface,SwipeRefreshLayout.OnRefreshListener {
    private View view;
    @BindView(R.id.item_list)
    RecyclerView itemList;
    private String responseTitle;
    private String TAG = "MainActivity";
    RecyclerView.Adapter adapter;
    MainPresenter mainPresenter;
    @BindView(R.id.swipe_container)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.frame_fragment, container, false);

        ButterKnife.bind(this,view);
        swipeRefreshLayout.setOnRefreshListener(this);

       //Setting Presenter Class
        setupMVP();
        //Setting View Class
        setupViews();
        //Getting MovieList with  Class
        getMovieList();
        return view;
    }

    private void getMovieList() {
        mainPresenter.getItems(swipeRefreshLayout);

    }

    private void setupViews() {
        DividerItemDecoration itemDecor = new DividerItemDecoration(getActivity(), VERTICAL);

        itemList.addItemDecoration(itemDecor);
        itemList.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void setupMVP() {
        mainPresenter = new MainPresenter(this);

    }

    @Override
    public void onRefresh() {
        getMovieList();
        swipeRefreshLayout.setRefreshing(true);

    }

    @Override
    public void showToast(String s) {
        Toast.makeText(getActivity(),s,Toast.LENGTH_LONG).show();

    }


    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }



    @Override
    public void displayItems(Response response) {
        if(response!=null) {
            adapter = new ItemsAdapter(getActivity(),response.getRows());
            responseTitle=response.getTitle();
            getActivity().setTitle(responseTitle);

            itemList.setAdapter(adapter);
        }else{
            Log.d(TAG," response null");
        }
    }

    @Override
    public void displayError(String e) {

        showToast(e);

    }

}
