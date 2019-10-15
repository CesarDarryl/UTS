package com.example.uts.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.uts.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SnackFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SnackFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private OnFragmentInteractionListener mListener;

    // TODO: Rename and change types of parameters



    public SnackFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SnackFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SnackFragment newInstance(String param1, String param2) {
        SnackFragment fragment = new SnackFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_snack, container, false);

        Button snackButton = view.findViewById(R.id.ButtonSnack);
        snackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(mListener != null){
                    mListener.OnSnackClicked();
                }
            }
        });
        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SnackFragment.OnFragmentInteractionListener) {
            mListener = (SnackFragment.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        void OnSnackClicked();
    }

}
