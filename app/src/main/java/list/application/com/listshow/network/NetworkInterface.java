package list.application.com.listshow.network;


import io.reactivex.Observable;
import list.application.com.listshow.models.Response;
import retrofit2.http.GET;

/**
 * Created by Puspak on 30/07/18.
 */

public interface NetworkInterface {

    @GET("s/2iodh4vg0eortkl/facts.json")
    Observable<Response> getListItems();

}
