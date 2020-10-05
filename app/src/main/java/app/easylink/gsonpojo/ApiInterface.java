package app.easylink.gsonpojo;

import app.easylink.gsonpojo.model.DataItem;
import app.easylink.gsonpojo.model.Response;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/api/unknow")
    Call<Response> getValues();
  //  Call<Response<DataItem>> getUser();


}
