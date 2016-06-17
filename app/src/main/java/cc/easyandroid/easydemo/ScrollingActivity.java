package cc.easyandroid.easydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import cc.easyandroid.easydemo.dummy.DummyContent;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyItemRecyclerViewAdapter(DummyContent.ITEMS, new ItemFragment.OnListFragmentInteractionListener() {
            @Override
            public void onListFragmentInteraction(DummyContent.DummyItem item) {

            }
        }));
    }


}
