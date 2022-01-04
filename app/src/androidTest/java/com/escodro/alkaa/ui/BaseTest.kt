package com.escodro.alkaa.ui

import android.app.Activity
import android.content.ComponentName
import android.content.Intent
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
open class BaseTest {

    @get:Rule
    var mActivityRule = ActivityScenarioRule<Activity>(
        Intent().setComponent(
            ComponentName(
                "com.escodro.alkaa",
                "com.escodro.alkaa.presentation.MainActivity"
            )
        )
    )
}
