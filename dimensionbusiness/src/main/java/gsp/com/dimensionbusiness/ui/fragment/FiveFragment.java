package gsp.com.dimensionbusiness.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gsp.com.dimensionbusiness.R;

public class FiveFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view=View.inflate(getActivity(),R.layout.fragment_five,null);

        return view;
    }

}
