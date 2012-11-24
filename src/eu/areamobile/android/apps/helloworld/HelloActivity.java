package eu.areamobile.android.apps.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

// we must extends FragmentActivity to use fragments
public class HelloActivity extends FragmentActivity implements OnClickListener{
	public final static String EXTRA_NAME = "eu.areamobile.extras.FULL_NAME";
	
	private Button mButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_layout);
		
		mButton=(Button)findViewById(R.id.btn_click_me);
		mButton.setOnClickListener(this);
		
	}

	
	@Override
	public void onClick(View v) {
		Log.d("TEST", "Clicked!!!");
		
		// we use getFragmentManager to obtain the fragment reference;
		// getSupportFragmentManager is used for compatibility with older Android API
		FragmentManager m=getSupportFragmentManager();
		InputFragment f=(InputFragment)m.findFragmentById(R.id.InputFragment);
		String fullName = f.getFullName();
		
		Log.d("TEST", "Input was: "+fullName);
		
		// Intent is used to start a second activity and pass the fullName string 
		final Intent intent = new Intent(this,SecondActivity.class);
		intent.putExtra(EXTRA_NAME, fullName);
		startActivity(intent);
	}

}
