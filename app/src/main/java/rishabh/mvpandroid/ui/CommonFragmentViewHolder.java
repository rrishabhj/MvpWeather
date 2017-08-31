package rishabh.mvpandroid.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import rishabh.moviebuzz.R;
import rishabh.mvpandroid.Utils.Constants;
import rishabh.mvpandroid.data.Model.TvModel;

/**
 * 5/6/17.
 */

public class CommonFragmentViewHolder {

    @BindView(R.id.poster)
    ImageView imageView;

    public CommonFragmentViewHolder(View view) {
        ButterKnife.bind(this, view);
    }

    public void setUp(Context context, TvModel model) {

        Picasso.with(context).load(Constants.ImgUrl + model.getImgLink()).into(imageView);

    }
}
