package app.easylink.gsonpojo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;
import java.util.List;

import app.easylink.gsonpojo.R;
import app.easylink.gsonpojo.model.DataItem;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    Context context;
    List<DataItem> postList;

    public PostAdapter(Context context, List<DataItem> postList) {
        this.context = context;
        this.postList = postList;
      //  Toast.makeText(context, postList.get(1).getName(),Toast.LENGTH_LONG).show();
    }

    @NonNull
    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_layout, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.txt_id.setText(String.valueOf(postList.get(position).getId()));
        holder.txt_name.setText(String.valueOf(postList.get(position).getName()));
        holder.txt_color.setText(new StringBuilder(postList.get(position).getColor()));
        holder.yxt_year.setText(new StringBuilder(postList.get(position).getYear()));
        Toast.makeText(context, postList.get(position).getName(),Toast.LENGTH_LONG).show();

    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView txt_id, txt_name,txt_color, yxt_year;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_id=(TextView)itemView.findViewById(R.id.textView);
            txt_name=(TextView)itemView.findViewById(R.id.textView2);
            txt_color=(TextView)itemView.findViewById(R.id.textView3);
            yxt_year=(TextView)itemView.findViewById(R.id.textView4);
        }
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}
