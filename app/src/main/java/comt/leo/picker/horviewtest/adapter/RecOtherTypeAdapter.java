package comt.leo.picker.horviewtest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import comt.leo.picker.horviewtest.R;
import comt.leo.picker.horviewtest.swipviewabout.Extension;

/**
 * Created by WANG on 18/4/24.
 */

public class RecOtherTypeAdapter extends RecyclerView.Adapter<RecOtherTypeAdapter.RecViewholder> {


    private Context context;
    private List<String> data;
    private LayoutInflater layoutInflater;
    private View.OnClickListener onClickListener;

    public RecOtherTypeAdapter(Context context, View.OnClickListener onClickListener) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.onClickListener = onClickListener;
    }

    public void setList(List<String> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public RecViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.layout_item, parent, false);
        return new RecViewholder(view);
    }

    @Override
    public void onBindViewHolder(RecViewholder holder, final int position) {
        holder.textView.setText(data.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "s  " + position, Toast.LENGTH_SHORT).show();
            }
        });
        holder.slide.setTag(R.id.item_slide,position);
        holder.slide.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    /**
     * view.getWidth()获取的是屏幕中可以看到的大小.
     */
    public class RecViewholder extends RecyclerView.ViewHolder implements Extension {
        public TextView textView;
        public TextView slide;

        public RecViewholder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_text);
            slide = itemView.findViewById(R.id.item_slide);

        }

        @Override
        public float getActionWidth() {
            return slide.getWidth();
        }

    }

    /**
     * 根据手机分辨率从DP转成PX
     *
     * @param context
     * @param dpValue
     * @return
     */
    public static int dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
