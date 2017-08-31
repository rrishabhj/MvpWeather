package rishabh.mvpandroid.ui.Base;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rishabh.moviebuzz.R;
import rishabh.mvpandroid.Utils.Constants;
import rishabh.mvpandroid.data.Model.TvModel;
import rishabh.mvpandroid.di.components.ActivityComponent;
import rishabh.mvpandroid.ui.CommonFragmentAdapter;


/**
 * 13/5/17.
 */

/**
 * A simple {@link Fragment} subclass.
 **/

public abstract class BaseFragment extends Fragment implements BaseMvpView, SwipeRefreshLayout.OnRefreshListener, CommonFragmentAdapter.ImageClickListener {


    private OnFragmentInteractionListener mListener;

    /* refer to ButterKnife docs */
    private Unbinder unbinder;

    public BaseFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


    @BindView(R.id.grid_view)
    public GridView gridView;

    @BindView(R.id.fetch_once_progress)
    public ProgressBar progressBar;

    @BindView(R.id.bottom_progress_bar)
    public ProgressBar bottomprogressBar;

    @BindView(R.id.swipeRefresh)
    public SwipeRefreshLayout swipeRefreshLayout;

    int scrollCounter = 1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.common_fragment_layout, container, false);
        setUnBinder(ButterKnife.bind(this, view));

        swipeRefreshLayout.setRefreshing(false);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent, R.color.colorPrimaryDark);
        swipeRefreshLayout.setOnRefreshListener(this);


        gridView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScroll(AbsListView list, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                if (list.getAdapter() != null && list.getLastVisiblePosition() == list.getAdapter().getCount() - 1
                        && list.getChildAt(list.getChildCount() - 1) != null && list.getChildAt(list.getChildCount() - 1).getBottom() <= list.getHeight()) {

                    /*scroll end reached*/
                    if (bottomprogressBar.getVisibility() == View.GONE) {
                        scrollCounter += 1;
                        update(scrollCounter);
                    }

                }
            }

            @Override
            public void onScrollStateChanged(AbsListView list, int scrollState) {


            }
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public void setUnBinder(Unbinder unbinder) {
        this.unbinder = unbinder;
    }

    @Override
    public void onDestroy() {
        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroy();
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {

        void showErrorCallback(@StringRes int error_message);

        boolean isNetworkAvailableCallback();

        ActivityComponent getActivityComponentCallback();

    }


    @Override
    public void showError(@StringRes int error_message) {
        mListener.showErrorCallback(error_message);
    }

    @Override
    public boolean isNetworkAvailable() {
        return mListener.isNetworkAvailableCallback();
    }

    public ActivityComponent getActivityComponent() {
        return mListener.getActivityComponentCallback();
    }

    @Override
    public void showLoading(boolean bottomProgress) {

        if (bottomProgress)
            bottomprogressBar.setVisibility(View.VISIBLE);
        else
            progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading(boolean bottomProgress) {

        if (bottomProgress)
            bottomprogressBar.setVisibility(View.GONE);
        else
            progressBar.setVisibility(View.GONE);
    }

    @Override
    public void imageClicked(TvModel model, ImageView imageView) {

//        Intent intent = new Intent(getActivity(), DetailActivity.class);
//        intent.putExtra(Constants.SHOW_ID, model.getTvId());
//        intent.putExtra(Constants.SHOW_IMG, model.getImgLink());
//
//        if (Build.VERSION.SDK_INT >= 21) {
//
//            ActivityOptionsCompat options = ActivityOptionsCompat.
//                    makeSceneTransitionAnimation(getActivity(), imageView, getString(R.string.transition));
//            startActivity(intent, options.toBundle());
//
//
//        } else
//            startActivity(intent);
    }

    public abstract void update(int scroll);
}
