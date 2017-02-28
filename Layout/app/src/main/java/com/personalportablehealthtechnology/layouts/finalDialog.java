package com.personalportablehealthtechnology.layouts;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import com.personalportablehealthtechnology.layouts.R;

/**
 * Created by gurei on 28/02/2017.
 */

public class finalDialog extends DialogFragment {

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.alert);

        return builder.create();

    }
}
