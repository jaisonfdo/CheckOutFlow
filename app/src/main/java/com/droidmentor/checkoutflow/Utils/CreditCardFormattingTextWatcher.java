package com.droidmentor.checkoutflow.Utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jaison on 27/05/17.
 */

public class CreditCardFormattingTextWatcher implements TextWatcher {

    private EditText etCard;
    private TextView tvCard;
    private ImageView ivType;
    private boolean isDelete;
    CreditCardType creditCardType;

    public CreditCardFormattingTextWatcher(EditText etcard,TextView tvcard) {
        this.etCard=etcard;
        this.tvCard=tvcard;
    }

    public CreditCardFormattingTextWatcher(EditText etcard,TextView tvcard,CreditCardType creditCardType) {
        this.etCard=etcard;
        this.tvCard=tvcard;
        this.creditCardType=creditCardType;
    }

    public CreditCardFormattingTextWatcher(EditText etcard, TextView tvcard, ImageView ivType,CreditCardType creditCardType) {
        this.etCard=etcard;
        this.tvCard=tvcard;
        this.ivType=ivType;
        this.creditCardType=creditCardType;
    }


    public CreditCardFormattingTextWatcher(EditText etcard) {
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

        if(length>0 && length%5==0)
        {
            if(isDelete)
                stringBuilder.deleteCharAt(length-1);
            else
                stringBuilder.insert(length-1," ");
            etCard.setText(stringBuilder);
            etCard.setSelection(etCard.getText().length());

        }

        if(length>=4&&creditCardType!=null)
            creditCardType.setCardType(CreditCardUtils.getCardType(source.trim()));

        if(tvCard!=null)
        {
            if(length==0)
                tvCard.setText("XXXX XXXX XXXX XXXX");
            else
                tvCard.setText(stringBuilder);
        }

        if(ivType!=null&&length==0)
            ivType.setImageResource(android.R.color.transparent);

    }

    public interface CreditCardType
    {
        public void setCardType(int type);
    }

}
