package comt.leo.picker.horviewtest.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import comt.leo.picker.horviewtest.R;


/**
 * Created by lihang on 2018/11/28.
 */
public class RecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private ArrayList<String> faceList;
    private Context context;
    private View.OnClickListener clickListener;


    public RecycleAdapter(Context context, View.OnClickListener clickListener) {
        this.context = context;
        this.clickListener = clickListener;
    }

    public void setData(ArrayList<String> faceList) {
        this.faceList = faceList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ietm_recycle, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.text.setText(position + "");
        myViewHolder.image_item.setTag(position);
        myViewHolder.image_item.setOnClickListener(clickListener);
    }


    @Override
    public int getItemCount() {
        return faceList == null ? 0 : faceList.size();

    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        ImageView image_item;

        public MyViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
            image_item = itemView.findViewById(R.id.image_item);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private OnItemClickListener mListener;

    public void onItemClick(OnItemClickListener listener) {
        mListener = listener;
    }


}
