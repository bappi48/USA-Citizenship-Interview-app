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
    Resources resources;
    String[] database;
	
	CustomAdapter(Context ctx){
		mainContext = ctx;		
		resources = mainContext.getResources();
		inflater = (LayoutInflater) mainContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		database = resources.getStringArray(R.array.question_answer_list);
		
	}
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return (database.length/3);
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

		
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
						
		Holder holder = new Holder();
		View rowView = inflater.inflate(R.layout.listitem, null); 
		holder.txtNum = (TextView) rowView.findViewById(R.id.number);
		holder.txtQuestion = (TextView) rowView.findViewById(R.id.question);
		holder.txtAnswer = (TextView) rowView.findViewById(R.id.answer);
				
		holder.txtNum.setText(database[position*3 + 0]);
		holder.txtQuestion.setText(database[position*3 + 1]);
		holder.txtAnswer.setText(database[position*3 + 2]);
			
		return rowView;
	}

}
