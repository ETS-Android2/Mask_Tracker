package mtirtapradja.project.huawei.masktracker.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import mtirtapradja.project.huawei.masktracker.CategoryOnMapActivity;
import mtirtapradja.project.huawei.masktracker.Model.Icon;
import mtirtapradja.project.huawei.masktracker.R;


public class IconAdapter extends RecyclerView.Adapter<IconAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Icon> iconList;

    public IconAdapter(Context context, ArrayList<Icon> iconList) {
        this.context = context;
        this.iconList = iconList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.home_icon_column,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.icon.setImageResource(iconList.get(position).getImage());
        holder.text.setText(iconList.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CategoryOnMapActivity.class);
                intent.putExtra("CATEGORY", iconList.get(position).getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return iconList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView icon;
        private TextView text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon_image);
            text = itemView.findViewById(R.id.home_icon_text);
        }
    }
}
