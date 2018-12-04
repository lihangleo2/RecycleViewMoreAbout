package comt.leo.picker.horviewtest.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import comt.leo.picker.horviewtest.R;
import comt.leo.picker.horviewtest.bean.UserMessage;


/**
 * Created by lihang on 2018/11/28.
 */
public class FingerTouchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private ArrayList<UserMessage> faceList;
    private Context context;
    private View.OnClickListener clickListener;


    public FingerTouchAdapter(Context context, View.OnClickListener clickListener) {
        this.context = context;
        this.clickListener = clickListener;
    }

    public void setData(ArrayList<UserMessage> faceList) {
        this.faceList = faceList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ietm_finger_touch, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        UserMessage item = faceList.get(position);

        final MyViewHolder myViewHolder = (MyViewHolder) holder;

        myViewHolder.text.setText(item.getId() + "");
        myViewHolder.text_name.setText("名字叫做" + item.getName() + "个");

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
        TextView text_name;

        public MyViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
            image_item = itemView.findViewById(R.id.image_item);
            text_name = itemView.findViewById(R.id.text_name);

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
