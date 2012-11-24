package eu.areamobile.android.apps.helloworld;

import eu.areamobile.android.apps.helloworld.ClearFragment.OnClearListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.TextView;

public class SecondActivity extends FragmentActivity implements OnClearListener{
	private final static String BUNDLE_KEY = "FULL_NAME";
	private TextView mHelloText;
	private String mFullName;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hello);
		
		if(savedInstanceState==null){
			Intent i=getIntent();
			mFullName =i.getStringExtra(HelloActivity.EXTRA_NAME);
		}else{
			mFullName = savedInstanceState.getString(BUNDLE_KEY);
		}

		mHelloText = (TextView)findViewById(R.id.tv_hello_message);
		
		setText(mHelloText, mFullName);
		
	}

	private static void setText(TextView view,String text){
		if(!TextUtils.isEmpty(text)){
			view.setText("Hello "+text+"!");
		}
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putString(BUNDLE_KEY, mFullName);
	}
	
	public void clear() {
		mFullName="World";
		setText(mHelloText, mFullName);
	}


	@Override
	public void onClear() {
		clear();
		
	}
}
