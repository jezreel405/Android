package com.example.customlistview;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnItemClickListener {
	
	ListView lv;
	ItemAdapter adapter;
	ArrayList<Student> list=new ArrayList<Student>();
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        list.add(new Student(R.drawable.img1,"Jez","BSIT"));
        list.add(new Student(R.drawable.img2,"Jez","BSIT"));
        list.add(new Student(R.drawable.img3,"Jez","BSIT"));
        list.add(new Student(R.drawable.img4,"Jez","BSIT"));
        list.add(new Student(R.drawable.img5,"","BSIT"));
        list.add(new Student(R.drawable.img5,"","BSIT"));
        list.add(new Student(R.drawable.img5,"","BSIT"));
        list.add(new Student(R.drawable.img5,"","BSIT"));
        list.add(new Student(R.drawable.img5,"","BSIT"));
        
        
        
        
        this.lv=(ListView) this.findViewById(R.id.listView1);
        adapter = new ItemAdapter(this,list);
        this.lv.setAdapter(adapter);
        
        this.lv.setOnItemClickListener(this);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
		LinearLayout dialoglayout=new LinearLayout(this);
		 dialoglayout.setOrientation(LinearLayout.HORIZONTAL);
		 
	ImageView iv=new ImageView(this);
	TextView name_course=new TextView(this);
	
		iv.setImageResource(list.get(arg2).getImage());
		String namecourse = list.get(arg2).getName()+""+list.get(arg2).getCourse();
		
		name_course.setText(namecourse);
		
		dialoglayout.addView(iv);
		dialoglayout.addView(name_course);
		
	
		AlertDialog.Builder builder =new AlertDialog.Builder(this);
			builder.setTitle("Selected Item");
			builder.setView(dialoglayout);
			builder.setNeutralButton("Okey",null);
			
		AlertDialog	dialog = builder.create();
			dialog.show();
			
		
	}
	
}
