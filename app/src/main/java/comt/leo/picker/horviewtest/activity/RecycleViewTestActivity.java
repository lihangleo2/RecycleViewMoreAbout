package comt.leo.picker.horviewtest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;

import comt.leo.picker.horviewtest.R;
import comt.leo.picker.horviewtest.adapter.FingerTouchAdapter;
import comt.leo.picker.horviewtest.adapter.RecycleAdapter;
import comt.leo.picker.horviewtest.bean.UserMessage;

/**
 * Created by leo
 * on 2018/12/3.
 * recycleView拖拽和侧滑
 */
public class RecycleViewTestActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recycleView;

    private FingerTouchAdapter adapter;
    private ArrayList<UserMessage> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        recycleView = findViewById(R.id.recycleView);

        for (int i = 0; i < 19; i++) {
            arrayList.add(new UserMessage(i + "", "我是" + i + "太子"));
        }
        adapter = new FingerTouchAdapter(this, this);
        adapter.setData(arrayList);

        LinearLayoutManager layoutManager11 = new LinearLayoutManager(this);
        layoutManager11.setOrientation(LinearLayoutManager.VERTICAL);
        recycleView.setLayoutManager(layoutManager11);
        recycleView.setAdapter(adapter);


        //为RecycleView绑定触摸事件
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                //首先回调的方法 返回int表示是否监听该方向
                int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;//拖拽
                int swipeFlags = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;//侧滑删除
                return makeMovementFlags(dragFlags, swipeFlags);
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                //滑动事件
                Collections.swap(arrayList, viewHolder.getAdapterPosition(), target.getAdapterPosition());
                adapter.notifyItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                //侧滑事件
                arrayList.remove(viewHolder.getAdapterPosition());
                adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }

            @Override
            public boolean isLongPressDragEnabled() {
                //是否可拖拽
                return true;
            }
        });
        helper.attachToRecyclerView(recycleView);

    }

    @Override
    public void onClick(View view) {

    }
}
