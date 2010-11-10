package org.neo.mvc.utils;

import org.neo.mvc.control.BaseControl;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;

/**
 * This class manages showing and closing all dialogs in the application.
 *
 */
public class FDADialog {
	/**
	 * The dialog is created when calling showListDialog() function.
	 */
	private static ProgressDialog dialog;
	/**
	 * This function to show a list of string row in a dialog. Users can select item in this list.
	 * @param target The Activity calls showing a dialog.
	 * @param title The title text of dialog.
	 * @param array An array of string of title elements in the list.
	 * @param listener The listener listens when the elements in the list is selected.
	 * @param icon ID of icon image to appear when appearance. Ex: R.drawable.icon.
	 * @return <code>AlertDialog.Builder</code> when showing dialog successfully.
	 */
	public static AlertDialog.Builder showList(BaseControl context, String title,int icon, String[]arrayList, DialogInterface.OnClickListener listener) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);		
		builder.setTitle(title)	
		    	.setIcon(icon)
				.setItems(arrayList, listener)
				.show();
		return builder;
	}
	/**
	 * This function to show a warning dialog to send to users a message.
	 * Users can close the dialog by pressing the OK button in dialog.
	 * @param target The Activity calls showing a dialog.
	 * @param message The message is used to warn users
	 * @param icon ID of icon image to appear when appearance. Ex: R.drawable.icon.
	 * @return <code>AlertDialog.Builder</code> after showing the dialog completely.
	 */
	public static AlertDialog.Builder showWarning(BaseControl context, String message, int icon, DialogInterface.OnClickListener listener) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setCancelable(false)
		       .setTitle(message)
		       .setIcon(icon)
		       .setNegativeButton("OK", listener)
		       .show();
		return builder;
	}
	/**
	 * This function to show a loading dialog to alert users for waiting to load data.
	 * @param target The Activity calls showing a dialog.
	 * @param message The message is used to warn users	.
	 */
	public static void showLoading(BaseControl context, String message) {
		dialog = ProgressDialog.show(context, "", message, true);
	}
	/**
	 * This function to close the dialog when loading completely.
	 */
	public static void close() {
		if(dialog != null)
			dialog.dismiss();
	}
}
