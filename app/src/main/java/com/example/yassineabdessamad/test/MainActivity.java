package com.example.yassineabdessamad.test;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.yassineabdessamad.test.data.DataValuesGenerate;
import com.example.yassineabdessamad.test.data.RowData;

import java.util.ArrayList;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.IFlexible;

public class MainActivity extends AppCompatActivity {
    private FlexibleAdapter<IFlexible> adapter;
    private RecyclerView recyclerView;
    LinearLayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new FlexibleAdapter<IFlexible>(null);
        adapter.setDisplayHeadersAtStartUp(true);
        adapter.setStickyHeaders(true);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);

        recyclerView.setAdapter(adapter);
        llm = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(llm);
        initAdapter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_delete:
                if (adapter.getItemCount() > 0) {
                    adapter.removeItem(0);
                } else
                    Toast.makeText(getApplicationContext(), "" + getResources().getText(R.string.no), Toast.LENGTH_LONG).show();
                break;
            case R.id.action_add: {
                adapter.addItem(1, new DataItem(DataValuesGenerate.getRow()));
                recyclerView.smoothScrollToPosition(1);
            }
            break;
            default:
                break;
        }

        return true;
    }

    public void initAdapter() {
        ArrayList<RowData> allData = DataValuesGenerate.getAll();
        for (int i = 0; i < allData.size(); i++)
            adapter.addItem(new DataItem(allData.get(i)));
    }
}
