package com.determinator.determitator;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by admin on 17.11.2015.
 */
public class AssetHelper {
    private static AssetHelper instance;
    private  Context context;

    private AssetHelper(Context context) {
        this.context = context;
    }

    public static AssetHelper getInstance(Context context) {
        if (instance == null) {
            instance = new AssetHelper(context);
        }
        return instance;
    }

    public  ArrayList<Drawable> getDrawableFromAsstets() {
        AssetManager assetManager = context.getAssets();
        ArrayList<Drawable> drawables = new ArrayList<>();
        try {
            String files[] = assetManager.list("toolbars");

            for (String file : files) {
                InputStream istr = assetManager.open("toolbars/" + file);
                Log.d("MyLogs", "File = " + file);
                Drawable drawable = Drawable.createFromStream(istr, null);
                drawables.add(drawable);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return drawables;
    }
}
