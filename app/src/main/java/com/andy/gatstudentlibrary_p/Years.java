package com.andy.gatstudentlibrary_p;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Years extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView list;
    String Branch;
    TextView heading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_years);
        Intent intent = getIntent();
        if (intent != null) {
            Branch =intent.getStringExtra("branchName");

        }
        list= (ListView) findViewById(R.id.sem);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.sem_name));
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
        heading= (TextView) findViewById(R.id.heading);
        heading.setText(Branch);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent downloadBook = new Intent(Years.this,Subject.class);
        downloadBook.putExtra("Branch",Branch);
        downloadBook.putExtra("sem",position);
        startActivity(downloadBook);
    }
}
