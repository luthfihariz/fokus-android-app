package hrz.fokus.main;

import android.util.Log;

import java.util.List;

import hrz.fokus.FokusApplication;
import hrz.fokus.model.GenericResponse;
import hrz.fokus.model.Topic;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Luthfi Haris on 02/10/2016.
 */

public class MainPresenter {

    MainActivity mView;

    public MainPresenter(MainActivity view) {
        mView = view;
    }

    public void loadTopics() {
        FokusApplication.getNetworkApi()
                .getTopicList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GenericResponse<List<Topic>>>() {
                    @Override
                    public void onCompleted() {
                        Log.e(MainPresenter.class.getSimpleName(), "Load topic completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(MainPresenter.class.getSimpleName(), e.getMessage());
                    }

                    @Override
                    public void onNext(GenericResponse<List<Topic>> response) {
                        mView.displayPost(response.getItems());
                    }
                });
    }

}
