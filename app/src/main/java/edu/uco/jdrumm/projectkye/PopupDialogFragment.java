package edu.uco.jdrumm.projectkye;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import edu.uco.jdrumm.projectkye.R;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;


public class PopupDialogFragment extends DialogFragment
{
    private PopupDialogFragment us;
    private String message, name;

    private OnFragmentInteractionListener mListener;

    private TextView messageView, titleView;
    private Button quitButton, nextButton, okButton;

    private ButtonPress button;

    public PopupDialogFragment() {
        // Required empty public constructor
    }

    public static PopupDialogFragment newInstance() {
        PopupDialogFragment fragment = new PopupDialogFragment();
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
        return inflater.inflate(R.layout.fragment_dialog, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        us = this;
        titleView = (TextView) getView().findViewById(R.id.title);
        messageView = (TextView) getView().findViewById(R.id.message);
        message = getArguments().getString("Message");
        name = getArguments().getString("Name");
        messageView.setText(message);

        quitButton = (Button) getView().findViewById(R.id.quitButton);
        nextButton = (Button) getView().findViewById(R.id.nextButton);
        okButton = (Button) getView().findViewById(R.id.okButton);

        button = ButtonPress.QUIT;

        nextButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                quitButton.setVisibility(GONE);
                nextButton.setVisibility(GONE);
                okButton.setVisibility(VISIBLE);
                messageView.setText("Next Level: " + name);
                titleView.setText("Starting a New Level");
            }
        });

        okButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                pressButton(ButtonPress.NEXT);
                getActivity().getFragmentManager().beginTransaction().remove(us).commit();
            }
        });

        quitButton.setOnClickListener(new View.OnClickListener()
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
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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
        mListener.onFragmentInteraction(button);
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
    public interface OnFragmentInteractionListener
    {
        void onFragmentInteraction(ButtonPress b);
    }
}
