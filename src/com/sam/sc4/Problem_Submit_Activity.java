package com.sam.sc4;
 
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
 
public class Problem_Submit_Activity extends Activity
{
   
    TextView test1;
    Button submt,chk_status;
    String output;
    EditText loc_det,prblm_type,authority,prblm_desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submit);
        
        test1=(TextView)findViewById(R.id.test1);
        submt=(Button)findViewById(R.id.submit);
        chk_status=(Button)findViewById(R.id.chk_status);
        loc_det=(EditText)findViewById(R.id.loc_det);
        prblm_type=(EditText)findViewById(R.id.prblm_type);
        authority=(EditText)findViewById(R.id.authority);
        prblm_desc=(EditText)findViewById(R.id.prblm_desc);
		submt.setOnClickListener(new clicker1());
		chk_status.setOnClickListener(new clicker2());
    }
    private void sendSMS(String phoneNumber, String message)
    {               
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);        
    }
    class clicker1 implements Button.OnClickListener
    {
    	public void onClick(View V)
    	{
    		    Toast.makeText(getApplicationContext(),"Submitting...",Toast.LENGTH_SHORT).show();
    		    String output1 = getIntent().getExtras().getString("mobile1");
    	        String output2 = getIntent().getExtras().getString("name1");
    	        String output3 = getIntent().getExtras().getString("email1");
    	        String auth,prblm_typ;
    	        auth = authority.getText().toString();
    	        prblm_typ = prblm_type.getText().toString();
    	        output = "Dear "+output2+", Your Complaint has been Registered to the "+auth+" for "+prblm_typ+".More Information will be available on email and registered number.Thank You!!";
    			test1.setText(output);
    			String msg = "Dear "+output2+", Your Complaint has been Registered to the "+auth+" for "+prblm_typ+".Reference number - constant.Thank You..!!";
    		    sendSMS(output1,msg);
    	}
    }
   
    class clicker2 implements Button.OnClickListener{
	public void onClick(View V)
	{
		Intent intentSubmtAct=new Intent(getApplicationContext(),Status_Check_Activity.class);
        startActivity(intentSubmtAct);
	}
}
}    

