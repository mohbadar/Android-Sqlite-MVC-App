package ku.edu.af.classapplication.service;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

public class Tools {

    public static void toast(Context context, String text)
    {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    public static void alert(Activity context, String title, String message)
    {
        FireAlertDialog fireAlertDialog = new FireAlertDialog(title, message);
        fireAlertDialog.show(context.getFragmentManager(), "Alert");
    }
}
