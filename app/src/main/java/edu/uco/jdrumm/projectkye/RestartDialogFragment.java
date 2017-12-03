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

public class RestartDialogFragment extends DialogFragment
{
    private RestartDialogFragment us;

    private OnFragmentInteractionListenerRestart mListener;

    private TextView messageView, titleView;
    private Button saveButton, restartButton, continueButton;

    private ButtonPress button;

    public RestartDialogFragment() {
        // Required empty public constructor
    }

    public static RestartDialogFragment newInstance() {
        RestartDialogFragment fragment = new RestartDialogFragment();
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
        return inflater.inflate(R.layout.restart_fragment_dialog, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        us = this;
        titleView = (TextView) getView().findViewById(R.id.title);
        messageView = (TextView) getView().findViewById(R.id.message);

        saveButton = (Button) getView().findViewById(R.id.saveButton);
        restartButton = (Button) getView().findViewById(R.id.restartButton);
        continueButton = (Button) getView().findViewById(R.id.continueButton);

        button = ButtonPress.QUIT;

        restartButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                pressButton(ButtonPress.RESTART);
                getActivity().getFragmentManager().beginTransaction().remove(us).commit();
            }
        });

        continueButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                pressButton(ButtonPress.CONTINUE);
                getActivity().getFragmentManager().beginTransaction().remove(us).commit();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                getActivity().getFragmentManager().beginTransaction().remove(us).commit();
            }
        });
    }

    private void pressButton(ButtonPress bp)
    {
        button = bp;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListenerRestart) {
            mListener = (OnFragmentInteractionListenerRestart) context;
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
        mListener.onFragmentInteractionRestart(button);
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
    public interface OnFragmentInteractionListenerRestart
    {
        void onFragmentInteractionRestart(ButtonPress b);
    }
}
