package eu.areamobile.android.apps.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class ClearFragment extends Fragment implements OnClickListener{

	public static interface OnClearListener{
		public void onClear();
	}
	
	private OnClearListener mListener;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try{
			mListener=(OnClearListener)activity;
		}catch(ClassCastException e){
			throw new ClassCastException("Containg activity should implement OnClearListener");
		}
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.clear_layout, container,false);
		v.findViewById(R.id.btn_clear).setOnClickListener(this);
		return v;
	}

	@Override
	public void onClick(View v) {
		//TODO parlare con l'activity
		// SBAGLIATO!!!!
		//SecondActivity a  = (SecondActivity)getActivity();
		//a.clear();
		if(mListener!=null){
			mListener.onClear();
		}
	}
}
