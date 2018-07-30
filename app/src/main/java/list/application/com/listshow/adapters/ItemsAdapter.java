package list.application.com.listshow.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import list.application.com.listshow.R;
import list.application.com.listshow.models.Row;


/**
 * Created by Puspak on 30/07/18.
 */


public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ListItemHolder> {

    private List<Row> listItem;
    Context context;

    public ItemsAdapter(Context context,List<Row> listItem) {
        this.context = context;
        this.listItem = listItem;

    }



    @Override
    public ListItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_layout,parent,false);
        ListItemHolder mh = new ListItemHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(ListItemHolder holder, int position) {

        holder.listItemTitle.setText(listItem.get(position).getTitle());
        holder.listItemDescription.setText(listItem.get(position).getDescription());
        Glide.with(context).load(listItem.get(position).getImageHref()).into(holder.listItemImage);
    }

    @Override
    public int getItemCount() {

        return listItem.size();
    }

    public class ListItemHolder extends RecyclerView.ViewHolder {

       private TextView listItemTitle;
        private TextView listItemDescription;
        private ImageView listItemImage;

        public ListItemHolder(View v) {
            super(v);
            listItemTitle = (TextView) v.findViewById(R.id.list_item_title);
            listItemDescription = (TextView) v.findViewById(R.id.list_item_description);
            listItemImage = (ImageView) v.findViewById(R.id.list_item_image);
        }
    }
}
