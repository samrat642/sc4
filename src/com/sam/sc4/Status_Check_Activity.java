package com.sam.sc4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
 
public class Status_Check_Activity extends Activity
{
    EditText ref_num;
    Button check;
    TextView tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status);
        ref_num=(EditText)findViewById(R.id.ref_num);
        check=(Button)findViewById(R.id.check);
        tv2=(TextView)findViewById(R.id.tv2);
        check.setOnClickListener(new clicker1());
    }
    class clicker1 implements Button.OnClickListener
    {
    	public void onClick(View V)
    	{
    	        String r_num;
    	        r_num = ref_num.getText().toString();
    			tv2.setText("Status : "+r_num);
    	}
    }
}   