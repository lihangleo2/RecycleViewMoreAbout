package comt.leo.picker.horviewtest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import comt.leo.picker.horviewtest.R;
import comt.leo.picker.horviewtest.adapter.RecAdapter;
import comt.leo.picker.horviewtest.adapter.RecOtherTypeAdapter;
import comt.leo.picker.horviewtest.swipviewabout.PlusItemSlideCallback;
import comt.leo.picker.horviewtest.swipviewabout.WItemTouchHelperPlus;

/**
 * Created by leo
 * on 2018/12/3.
 */
public class RecycleViewSwipActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
//    private RecOtherTypeAdapter recAdapter;
        private RecAdapter recAdapter;
    ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        recyclerView = findViewById(R.id.recycleView);
        initView();
        initData();
    }


    private void initData() {

        for (int i = 0; i < 30; i++) {
            arrayList.add("Item  " + i);
        }
        recAdapter.setList(arrayList);
    }

    private void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recAdapter = new RecAdapter(this);
//        recAdapter = new RecOtherTypeAdapter(this, this);
        recyclerView.setAdapter(recAdapter);

        PlusItemSlideCallback callback = new PlusItemSlideCallback(WItemTouchHelperPlus.SLIDE_ITEM_TYPE_SLIDECONTAINER);
        WItemTouchHelperPlus extension = new WItemTouchHelperPlus(callback);
        extension.attachToRecyclerView(recyclerView);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.item_slide:
                int position = (int) view.getTag(R.id.item_slide);
                Toast.makeText(RecycleViewSwipActivity.this, "删除====" + position, Toast.LENGTH_SHORT).show();
                arrayList.remove(position);
                recAdapter.notifyItemRemoved(position);
                recAdapter.notifyItemRangeChanged(position, arrayList.size() - position);
                break;
        }
    }
}
