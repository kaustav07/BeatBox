package com.android.bignerdranch.beatbox;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static org.hamcrest.CoreMatchers.anything;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<BeatBoxActivity> mActivityTestRule = new ActivityTestRule<BeatBoxActivity>(BeatBoxActivity.class);
    Context appContext = InstrumentationRegistry.getTargetContext();

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.

        assertEquals("com.android.bignerdranch.beatbox", appContext.getPackageName());
    }

    @Test
    public void firstTest() throws IOException {
        String[] files = appContext.getAssets().list("sounds");

        for(String name: files){
            onView(ViewMatchers.withText(name.replace(".wav",""))).check(matches(anything()));
        }

    }
}
