package com.example.sber_app10_xogame;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class AlertDialogFragment extends DialogFragment {

    public static final String ARG_TEXT = "dialogText";

    public static AlertDialogFragment newInstance(String text) {

        Bundle args = new Bundle();

        args.putString(ARG_TEXT, text);

        AlertDialogFragment fragment = new AlertDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setMessage(getArguments().getString(ARG_TEXT));
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        return  builder.create();
    }
}
