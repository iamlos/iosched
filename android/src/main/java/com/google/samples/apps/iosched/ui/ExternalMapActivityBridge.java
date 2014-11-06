package com.google.samples.apps.iosched.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.google.samples.apps.iosched.BuildConfig;

/**
 * The IOsched Activities weren't designed to persist between call-outs to other applications. This
 * activity is designed to call out to the external Maps app and then re-start the previous activity
 * when the user returns.
 */
public class ExternalMapActivityBridge extends AbstractExternalActivityBridge {

    @Override
    protected Uri getDataUri() {
        return ExternalMapActivityBridge.constructExternalMappingAppUri();
    }

    public static boolean isAvailable(final Context context) {
        Intent mapIntent =
                new Intent(
                        Intent.ACTION_VIEW,
                        ExternalMapActivityBridge.constructExternalMappingAppUri()
                );
        return !context.
                    getPackageManager().
                        queryIntentActivities(mapIntent, PackageManager.MATCH_DEFAULT_ONLY).
                         isEmpty();

    }

    public static Uri constructExternalMappingAppUri() {
        String uri = "geo:0,0?q="
                + BuildConfig.VENUE_LATITUDE + "," + BuildConfig.VENUE_LONGITUDE
                + "("+BuildConfig.CONFERENCE_NAME+")";
        return Uri.parse(uri);
    }

}
