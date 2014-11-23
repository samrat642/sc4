package com.sam.sc4;


import android.app.Activity;
import android.os.Bundle;
import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Smart_Complaints_4_Smart_City_Activity extends Activity {
    /** Called when the activity is first created. */
    Button reg;
    EditText name,mobile,email;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
     // Get References of Views
        name=(EditText)findViewById(R.id.name);
        mobile=(EditText)findViewById(R.id.mobile);
        email=(EditText)findViewById(R.id.email);
        reg=(Button)findViewById(R.id.reg);
        reg.setOnClickListener(new clicker1());
    }
    class clicker1 implements Button.OnClickListener
    {
    	public void onClick(View V)
    	{
    		Toast.makeText(getApplicationContext(),"Registering...",Toast.LENGTH_SHORT).show();
    		String mobile1 = mobile.getText().toString();
    		String name1 = name.getText().toString();
    		String email1 = email.getText().toString();
    		Intent intentSubmtAct=new Intent(getApplicationContext(),Problem_Submit_Activity.class);
    		intentSubmtAct.putExtra("mobile1",mobile1);
    		intentSubmtAct.putExtra("name1",name1);
    		intentSubmtAct.putExtra("email1",email1);
            startActivity(intentSubmtAct);
    	}
    }
}