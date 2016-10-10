package hrz.fokus.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.android.gms.ads.AdView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hrz.fokus.R;
import hrz.fokus.model.Topic;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_rv)
    RecyclerView mainRv;

    MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        LinearLayoutManager llm = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        mainRv.setLayoutManager(llm);

        // attach presenter
        mMainPresenter = new MainPresenter(this);
        mMainPresenter.loadTopics();
    }

    public void displayPost(List<Topic> topicList) {
        NewsAdapter adapter = new NewsAdapter(topicList, this);
        mainRv.setAdapter(adapter);
    }


}
