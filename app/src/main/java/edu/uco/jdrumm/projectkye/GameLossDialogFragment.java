package edu.uco.jdrumm.projectkye;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class GameLossDialogFragment extends DialogFragment
{
    private GameLossDialogFragment us;

    private OnFragmentInteractionListenerGameLoss mListener;

    private Button okayButton;

    public GameLossDialogFragment() {
        // Required empty public constructor
    }

    public static GameLossDialogFragment newInstance() {
        GameLossDialogFragment fragment = new GameLossDialogFragment();
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
        return inflater.inflate(R.layout.game_loss_fragment_dialog, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        us = this;
        okayButton = (Button) getView().findViewById(R.id.okayButton2);

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
        if (context instanceof OnFragmentInteractionListenerGameLoss) {
            mListener = (OnFragmentInteractionListenerGameLoss) context;
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
        mListener.onFragmentInteractionGameLoss();
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
    public interface OnFragmentInteractionListenerGameLoss
    {
        void onFragmentInteractionGameLoss();
    }
}
