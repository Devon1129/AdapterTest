package com.example.baseadapertest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends  BaseAdapter{
	private CharSequence[] list;
	LayoutInflater myInflater;
	private Context myContext;
	private CheckBox CheckBox_cb;
	

	public MyAdapter(Context ctxt,CharSequence[] list)
	 {
		myInflater = (LayoutInflater) ctxt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.list = list;
		this.myContext = ctxt;

	 }
	@Override
	public int getCount() {
		return list.length;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewTag viewTag;
		if(convertView == null){
			convertView = myInflater.inflate(R.layout.adapter, null);
			viewTag = new ViewTag(
					(CheckBox)convertView.findViewById(R.id.cb),
					(ImageView)convertView.findViewById(R.id.iv), 
					(TextView)convertView.findViewById(R.id.tv));
			 
			CheckBox_cb = (CheckBox)convertView.findViewById(R.id.cb);
			CheckBox_cb.setText("NO. " + position);
			CheckBox_cb.setOnCheckedChangeListener(cbListener);
			
			
			convertView.setTag(viewTag);
		}else{
			viewTag =(ViewTag)convertView.getTag();
		}
		
		switch(position){
			case 0:
				viewTag.iv.setBackgroundResource(R.drawable.edu1);
				break;
			case 1:
				viewTag.iv.setBackgroundResource(R.drawable.edu2);
				break;
			case 2:
				viewTag.iv.setBackgroundResource(R.drawable.edu3);
				break;
		}
		viewTag.tv.setText(list[position]);
		return convertView;
	}
	
	private OnCheckedChangeListener cbListener = new OnCheckedChangeListener(){

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			if(isChecked){
//				buttonView.getText();
				Toast.makeText(myContext, "Check " + buttonView.getText(), Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(myContext, "UNCheck!!! "  + buttonView.getText(), Toast.LENGTH_SHORT).show();
			}
			
		}
		
	};
	
	public class ViewTag{
		ImageView iv;
		TextView tv;
		CheckBox cb;
		
		public ViewTag(CheckBox cb, ImageView iv, TextView tv){
			this.iv = iv;
			this.tv = tv;
			this.cb = cb;
		}
	}

}
