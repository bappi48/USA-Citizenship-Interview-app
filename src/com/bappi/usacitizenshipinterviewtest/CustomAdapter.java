package com.bappi.usacitizenshipinterviewtest;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

	Context mainContext;
	LayoutInflater inflater = null;
	String strNum;
	String strQuestion;
	String strAnswer;
	String packageName;
    Resources resources;

	
	CustomAdapter(Context ctx){
		mainContext = ctx;
		packageName = mainContext.getPackageName();
		resources = mainContext.getResources();
		inflater = (LayoutInflater) mainContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
	}
	
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}
	
	public class Holder{
		TextView txtNum;
		TextView txtQuestion;
		TextView txtAnswer;
	}

	//int resId = getResources().getIdentifier(aString, "string", packageName);
	
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
		
				
		Holder holder = new Holder();
		View rowView = inflater.inflate(R.layout.listitem, null); 
		holder.txtNum = (TextView) rowView.findViewById(R.id.number);
		holder.txtQuestion = (TextView) rowView.findViewById(R.id.question);
		holder.txtAnswer = (TextView) rowView.findViewById(R.id.answer);
		
		//position++;
		if(position==0){			
			holder.txtQuestion.setText(R.string.only_study);
			return rowView;
		}
		
		strNum = "number" + position;
		strQuestion = "question"+position;
		strAnswer = "answer"+position;
		
		holder.txtNum.setText(resources.getIdentifier(strNum, "string", packageName));
		holder.txtQuestion.setText(resources.getIdentifier(strQuestion, "string", packageName));
		holder.txtAnswer.setText(resources.getIdentifier(strAnswer, "string", packageName));
		
		
		return rowView;
	}

}
