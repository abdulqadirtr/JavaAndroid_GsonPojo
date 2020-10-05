package app.easylink.gsonpojo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import app.easylink.gsonpojo.adapter.PostAdapter;
import app.easylink.gsonpojo.model.DataItem;
import app.easylink.gsonpojo.model.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =(RecyclerView)findViewById(R.id.postView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager( this));
        fetchDat();
              /**
         GET List Resources
         **/


    }

    private void fetchDat() {

        //calliing Retrofit Api
        Retrofit retrofit=APIClient.getClient();

        apiInterface = retrofit.create(ApiInterface.class);

        Call<Response> call = apiInterface.getValues();
        //  Call<DataItem> call = apiInterface.getUser();
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
              //  Toast.makeText(getApplicationContext(), response.body().getData().get(1).getName(),Toast.LENGTH_LONG).show();
                List<DataItem> mD = response.body().getData();
                Display(mD);
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
t.getMessage();
            }
        });
    }

    private void Display(List<DataItem> post) {
        PostAdapter adapter = new PostAdapter(this, post);
        recyclerView.setAdapter(adapter);
    }
}