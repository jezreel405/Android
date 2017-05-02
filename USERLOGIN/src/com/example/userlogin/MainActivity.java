package com.example.userlogin;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener, OnItemSelectedListener {

    EditText txtIDNO,txtNAME;
    Spinner cboCourse;
    RadioGroup mygender;
    Button btnOkey;
	private String selected_course;
	private String selected_gender;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        this.txtIDNO=(EditText)this.findViewById(R.id.editText1);
        this.txtNAME=(EditText)this.findViewById(R.id.editText2);
        this.cboCourse=(Spinner) this.findViewById(R.id.spinner1);
        this.mygender=(RadioGroup) this.findViewById(R.id.radioGroup1);
        this.btnOkey=(Button) this.findViewById(R.id.button1);
        
        this.btnOkey.setOnClickListener(this);
        
        this.cboCourse.setOnItemSelectedListener(this);
        
        
    }

	@Override
	public void onClick(View arg0) {
		
		String IDNO = this.txtIDNO.getText().toString();
		String NAME = this.txtNAME.getText().toString();
        int genderindex = mygender.getCheckedRadioButtonId();
        RadioButton btnGender = (RadioButton) this.findViewById(genderindex);
        selected_gender = btnGender.getText().toString();
		if(!IDNO.equals("")&& !NAME.equals("")){
			
			String message="IDNO :"+ IDNO+"\n"+
							"NAME :"+ NAME+"\n"+
							"COURSE :"+selected_course+"\n"+
							"GENDER :"+selected_gender;
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Student Information");
		builder.setMessage(message);
		builder.setNeutralButton("Okey",null);
		
		AlertDialog dialog = builder.create();
		 dialog.show();
		 
		
		
		}
		else{
			Toast.makeText(this,"FILL ALL FIELDS", Toast.LENGTH_SHORT).show();
			
		}
		
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		selected_course = this.cboCourse.getItemAtPosition(arg2).toString();
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

    
}
