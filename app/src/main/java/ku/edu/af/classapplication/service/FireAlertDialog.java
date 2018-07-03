package ku.edu.af.classapplication.service;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class FireAlertDialog extends DialogFragment {
    private String title;
    private String content;

    public FireAlertDialog()
    {

    }

    @SuppressLint("ValidFragment")
    public FireAlertDialog(String title, String content)
    {
        this.title= title;
        this.content =content;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(this.title).setMessage(this.content)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        return builder.create();
    }
}
