package comt.leo.picker.horviewtest.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import comt.leo.picker.horviewtest.R;
import comt.leo.picker.horviewtest.adapter.RecycleAdapter;

/**
 * luck with me 11:30  ,9:54
 * 横向滑动 果冻效果实现
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recycleView;
    private RecycleAdapter adapter;
    private ArrayList<String> arrayList = new ArrayList<>();

    private Button buttonScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycleView = findViewById(R.id.recycleView);
        recycleView.setNestedScrollingEnabled(false);
        buttonScroll = findViewById(R.id.buttonScroll);
        buttonScroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                recycleView.scrollToPosition(0);
                recycleView.smoothScrollToPosition(0);
                Toast.makeText(MainActivity.this, "运行了", Toast.LENGTH_SHORT).show();
            }
        });

        for (int i =0;i<50;i++){
            arrayList.add("1");
        }
        adapter = new RecycleAdapter(this, this);
        adapter.setData(arrayList);

        LinearLayoutManager layoutManager11 = new LinearLayoutManager(this);
        layoutManager11.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycleView.setLayoutManager(layoutManager11);
        recycleView.setAdapter(adapter);


        recycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                //判断是当前layoutManager是否为LinearLayoutManager
                // 只有LinearLayoutManager才有查找第一个和最后一个可见view位置的方法
                if (layoutManager instanceof LinearLayoutManager) {
                    LinearLayoutManager linearManager = (LinearLayoutManager) layoutManager;
                    //获取最后一个可见view的位置
                    int lastItemPosition = linearManager.findLastVisibleItemPosition();
                    //获取第一个可见view的位置
                    int firstItemPosition = linearManager.findFirstVisibleItemPosition();
                    Log.e("这个是什么子东西啊", lastItemPosition + "   " + firstItemPosition);

                    if (linearManager.findViewByPosition(linearManager.findFirstVisibleItemPosition()).getLeft() == 0
                            && linearManager.findFirstVisibleItemPosition() == 0) {
                        Log.e("滑动到了最边界", "最左边=============");

                    }

                }


            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_item:
                int clickPosition = (int) view.getTag();
                Toast.makeText(MainActivity.this, "当前position==" + clickPosition, Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
