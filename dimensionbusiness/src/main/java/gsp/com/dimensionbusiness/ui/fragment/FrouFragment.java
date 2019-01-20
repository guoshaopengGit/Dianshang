package gsp.com.dimensionbusiness.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gsp.com.dimensionbusiness.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FrouFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view=View.inflate(getActivity(),R.layout.fragment_frou,null);

        return view;
    }

}
