package com.droidmentor.checkoutflow.Utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Jaison on 28/05/17.
 */

public class CreditCardExpiryTextWatcher implements TextWatcher {

    private EditText etCard;
    private TextView tvCard;
    private boolean isDelete;

    public CreditCardExpiryTextWatcher(EditText etcard,TextView tvcard) {
        this.etCard=etcard;
        this.tvCard=tvcard;
    }

    public CreditCardExpiryTextWatcher(EditText etcard) {
        this.etCard=etcard;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if(before==0)
            isDelete=false;
        else
            isDelete=true;
    }

    @Override
    public void afterTextChanged(Editable s) {
        String source = s.toString();
        int length=source.length();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(source);

        if(length>0 && length==3)
        {
            if(isDelete)
                stringBuilder.deleteCharAt(length-1);
            else
                stringBuilder.insert(length-1,"/");

            etCard.setText(stringBuilder);
            etCard.setSelection(etCard.getText().length());

            // Log.d("test"+s.toString(), "afterTextChanged: append "+length);
        }

        if(tvCard!=null)
        {
            if(length==0)
                tvCard.setText("MM/YY");
            else
               tvCard.setText(stringBuilder);
        }

    }

}