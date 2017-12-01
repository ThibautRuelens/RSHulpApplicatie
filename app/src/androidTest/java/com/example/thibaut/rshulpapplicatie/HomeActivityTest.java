package com.example.thibaut.rshulpapplicatie;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by Thibaut on 1/12/2017.
 */
public class HomeActivityTest {
    @Rule
    public ActivityTestRule<HomeActivity> mActivityTestRule = new ActivityTestRule<HomeActivity>(HomeActivity.class);
    private HomeActivity mActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(LoginActivity.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunchOfLoginActivityOnButtonClick(){
        assertNotNull(mActivity.findViewById(R.id.buttonSignIN));

        onView(withId(R.id.buttonSignIN)).perform(click());

        Activity loginActivity = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);

        assertNotNull(loginActivity);

        loginActivity.finish();
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }

}