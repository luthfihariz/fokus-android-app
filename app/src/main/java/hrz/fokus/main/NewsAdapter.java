package hrz.fokus.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hrz.fokus.R;
import hrz.fokus.model.Topic;

/**
 * Created by Luthfi Haris on 02/10/2016.
 */

class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<Topic> mTopics;
    private Context mContext;

    public NewsAdapter(List<Topic> topics, Context context) {
        mTopics = topics;
        mContext = context;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsViewHolder
                (LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,
                        parent, false));
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        holder.mTitleView.setText(mTopics.get(position).getTitle());
        Picasso.with(mContext).load(mTopics.get(position).getImages().getCover())
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mTopics.size();
    }

    static class NewsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_news_image)
        ImageView mImageView;
        @BindView(R.id.item_news_title)
        TextView mTitleView;

        public NewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
