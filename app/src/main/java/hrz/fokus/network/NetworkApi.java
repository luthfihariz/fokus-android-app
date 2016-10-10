package hrz.fokus.network;

import java.util.List;

import hrz.fokus.model.GenericResponse;
import hrz.fokus.model.Topic;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Luthfi Haris on 02/10/2016.
 */


public interface NetworkApi {

    @GET("fokus")
    Observable<GenericResponse<List<Topic>>> getTopicList();
}
