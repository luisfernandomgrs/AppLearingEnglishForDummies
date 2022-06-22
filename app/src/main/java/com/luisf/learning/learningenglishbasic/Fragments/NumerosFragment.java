package com.luisf.learning.learningenglishbasic.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.luisf.learning.learningenglishbasic.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NumerosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NumerosFragment extends Fragment implements View.OnClickListener {
    private ImageButton numberOne, numberTwo, numberThree, numberFour, numberFive, numberSix;
    private MediaPlayer mediaPlayer;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NumerosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NumerosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NumerosFragment newInstance(String param1, String param2) {
        NumerosFragment fragment = new NumerosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_numeros, container, false);

        numberOne = view.findViewById(R.id.numberOne);
        numberTwo = view.findViewById(R.id.numberTwo);
        numberThree = view.findViewById(R.id.numberThree);
        numberFour = view.findViewById(R.id.numberFour);
        numberFive = view.findViewById(R.id.numberFive);
        numberSix = view.findViewById(R.id.numberSix);

        numberOne.setOnClickListener(this);
        numberTwo.setOnClickListener(this);
        numberThree.setOnClickListener(this);
        numberFour.setOnClickListener(this);
        numberFive.setOnClickListener(this);
        numberSix.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.numberOne:
                this.playSound(R.raw.one);
                break;
            case R.id.numberTwo:
                this.playSound(R.raw.two);
                break;
            case R.id.numberThree:
                this.playSound(R.raw.three);
                break;
            case R.id.numberFour:
                this.playSound(R.raw.four);
                break;
            case R.id.numberFive:
                this.playSound(R.raw.five);
                break;
            case R.id.numberSix:
                this.playSound(R.raw.six);
                break;
        }
    }

    private void playSound(int id) {
        mediaPlayer = MediaPlayer.create(getActivity(), id);

        if (mediaPlayer != null) {
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.release();
                }
            });
        }
    }
}