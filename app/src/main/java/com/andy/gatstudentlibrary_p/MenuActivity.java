package com.andy.gatstudentlibrary_p;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    GridView menuGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        menuGrid= (GridView) findViewById(R.id.grid);
        menuGrid.setAdapter(new MenuAdapter(this));
        menuGrid.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent =new Intent(this,Years.class);
        ViewHolder holder= (ViewHolder) view.getTag();
        SingleItem temp= (SingleItem) holder.image.getTag();
        intent.putExtra("branchName",temp.branchName);
        startActivity(intent);
    }

}

class SingleItem {
    int imageId;
    String branchName;

    SingleItem(int imageId,String branchName)
    {
        this.imageId=imageId;
        this.branchName =branchName;
    }
}

class MenuAdapter extends BaseAdapter {

    ArrayList<SingleItem> list;
    Context context;
    MenuAdapter(Context context)
    {
        this.context = context;
        list=new ArrayList<SingleItem>();
        Resources res=context.getResources();
        String[] tempBranchName=res.getStringArray(R.array.branch_names);
        int[] Image ={R.drawable.cs,R.drawable.isc,R.drawable.ece,R.drawable.eee,R.drawable.civil,R.drawable.mech,R.drawable.bs};
        for(int i=0;i<7;i++)
        {
            SingleItem tempBranch =new SingleItem(Image[i],tempBranchName[i]);
            list.add(tempBranch);
        }
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        ViewHolder holder =null;
        if(row ==null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.single_row,parent,false);
            holder =new ViewHolder(row);
            row.setTag(holder);
        }
        else{
            holder =(ViewHolder) row.getTag();

        }
        SingleItem temp = list.get(position);
        holder.image.setImageResource(temp.imageId);
        holder.image.setTag(temp);
        return row;
    }
}
class ViewHolder{
    ImageView image;
    ViewHolder(View v)
    {
        image =(ImageView)v.findViewById(R.id.image);

    }
}