package com.andy.gatstudentlibrary_p;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Subject extends AppCompatActivity implements AdapterView.OnItemClickListener {
    TextView branch_name;
    ListView subject;
    int semi;
    String branch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        Intent intent= getIntent();
        if(intent != null)
        {
            branch =intent.getStringExtra("Branch");
            semi = intent.getIntExtra("sem",0);
            semi =semi+1;
            branch_name= (TextView) findViewById(R.id.branch);
            branch_name.setText(branch+" Semister "+semi);
            
        }


        subject= (ListView) findViewById(R.id.subjects);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.css_sem_1));
        subject.setAdapter(adapter);
        subject.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String[] link = getResources().getStringArray(R.array.css_sem_1_link);
        String url=link[position];
        Intent abc =new Intent(Intent.ACTION_VIEW);
        abc.setData(Uri.parse(url));
        startActivity(abc);

    }
}
