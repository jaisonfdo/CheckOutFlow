package com.droidmentor.checkoutflow;


import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.droidmentor.checkoutflow.CCFragment.CCSecureCodeFragment;
import com.droidmentor.checkoutflow.Utils.FontTypeChange;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class CardBackFragment extends Fragment {

    @BindView(R.id.tv_cvv)TextView tv_cvv;
    FontTypeChange fontTypeChange;

    CheckOutActivity activity;
    CCSecureCodeFragment securecode;

    public CardBackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Log.d("BF", "onCreateView: ");
        View view=inflater.inflate(R.layout.fragment_card_back, container, false);
        ButterKnife.bind(this, view);

        fontTypeChange=new FontTypeChange(getActivity());
        tv_cvv.setTypeface(fontTypeChange.get_fontface(1));

        activity = (CheckOutActivity) getActivity();
        securecode = activity.secureCodeFragment;
        securecode.setCvv(tv_cvv);

        if(!TextUtils.isEmpty(securecode.getValue()))
            tv_cvv.setText(securecode.getValue());

        return view;
    }

}
