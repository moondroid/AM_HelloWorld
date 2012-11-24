package eu.areamobile.android.apps.helloworld;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class InputFragment extends Fragment{
	
	private View mContent;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		final View v = inflater.inflate(R.layout.input_layout, container,false);
		
		mContent = v;
		return v;
	}
	
	public String getFullName(){
		EditText etName = (EditText)mContent.findViewById(R.id.et_name);
		EditText etSurname = (EditText)mContent.findViewById(R.id.et_surname);
		
		StringBuilder sb = new StringBuilder();
		sb.append(etName.getText().toString()).append(' ').append(etSurname.getText().toString());
		return sb.toString();
	}
}
