package edu.uco.jdrumm.projectkye;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class GameWonDialogFragment extends DialogFragment
{
    private GameWonDialogFragment us;

    private OnFragmentInteractionListenerGameWon mListener;

    private Button okayButton;

    public GameWonDialogFragment() {
        // Required empty public constructor
    }

    public static GameWonDialogFragment newInstance() {
        GameWonDialogFragment fragment = new GameWonDialogFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.game_won_fragment_dialog, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        us = this;
        okayButton = (Button) getView().findViewById(R.id.okayButton);

        okayButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                getActivity().getFragmentManager().beginTransaction().remove(us).commit();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListenerGameWon) {
            mListener = (OnFragmentInteractionListenerGameWon) context;
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

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        mListener.onFragmentInteractionGameWon();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListenerGameWon
    {
        void onFragmentInteractionGameWon();
    }
}
