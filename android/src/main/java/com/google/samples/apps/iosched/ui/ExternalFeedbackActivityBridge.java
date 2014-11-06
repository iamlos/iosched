package com.google.samples.apps.iosched.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import com.google.samples.apps.iosched.BuildConfig;

/**
 * The IOsched Activities weren't designed to persist between call-outs to other applications. This
 * activity is designed to call out to the external Maps app and then re-start the previous activity
 * when the user returns.
 */
public class ExternalFeedbackActivityBridge extends AbstractExternalActivityBridge {

    @Override
    protected Uri getDataUri() {
        return Uri.parse(BuildConfig.CONFERENCE_FEEDBACK_URL);
    }

}
