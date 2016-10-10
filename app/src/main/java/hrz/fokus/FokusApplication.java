package hrz.fokus;

import android.app.Application;

import hrz.fokus.network.NetworkApi;
import hrz.fokus.network.RetrofitServiceFactory;

/**
 * Created by Luthfi Haris on 02/10/2016.
 */

public class FokusApplication extends Application {

    public static NetworkApi getNetworkApi() {
        return RetrofitServiceFactory.createRetrofitService(NetworkApi.class,
                BuildConfig.SERVER_URL);
    }
}
