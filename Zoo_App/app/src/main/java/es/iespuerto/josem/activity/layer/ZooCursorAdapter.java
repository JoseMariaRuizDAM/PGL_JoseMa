package es.iespuerto.josem.activity.layer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.graphics.drawable.RoundedBitmapDrawable;

import es.iespuerto.josem.R;
import es.iespuerto.josem.model.contract.ZooContract;

public class ZooCursorAdapter extends CursorAdapter {
    public ZooCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public void bindView(View view, final Context context, Cursor cursor) {

        // Referencias UI.
        TextView nameText = (TextView) view.findViewById(R.id.zoo_name);
        final ImageView avatarImage = (ImageView) view.findViewById(R.id.iv_avatar);

        // Get valores.
        @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(ZooContract.ZooEntry.NOMBRE));

        // Setup.
        nameText.setText(name);
        /**
         Glide
         .with(context)
         .load(Uri.parse("file:///android_asset/" + avatarUri))
         .asBitmap()
         .error(R.drawable.ic_account_circle)
         .centerCrop()
         .into(new BitmapImageViewTarget(avatarImage) {
        @Override
        protected void setResource(Bitmap resource) {
        RoundedBitmapDrawable drawable
        = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
        drawable.setCircular(true);
        avatarImage.setImageDrawable(drawable);
        }
        });
         **/
        /**
        Glide.with(context)
                .asBitmap()
                .load(Uri.parse("file:///android_asset/" + avatarUri))
                .into(new BitmapImageViewTarget(avatarImage) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable drawable
                                = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        drawable.setCircular(true);
                        avatarImage.setImageDrawable(drawable);
                    }
                });**/

    }
}
