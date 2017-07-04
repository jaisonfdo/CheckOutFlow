package com.droidmentor.checkoutflow.Utils;

import android.content.Context;
import android.graphics.Typeface;

public class FontTypeChange {

	private Context c;
	
	public FontTypeChange(Context s) {
		// TODO Auto-generated constructor stub
		this.c=s;
	}
	
	public Typeface get_fontface(int n)
	{
		Typeface tf;
		if(n==1)
		     tf=Typeface.createFromAsset(c.getAssets(), "fonts/kreditback.ttf");
		else if(n==2)
			tf=Typeface.createFromAsset(c.getAssets(), "fonts/kreditfront.ttf");
		else if(n==3)
			tf=Typeface.createFromAsset(c.getAssets(), "fonts/ocramedium.ttf");
        else
            tf=Typeface.createFromAsset(c.getAssets(), "fonts/kreditfront.ttf");
		return tf;
	}

}
