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
import static org.junit.Assert.assertNotNull;

/**
 * Created by Thibaut on 1/12/2017.
 */
public class HomeActivityTestRegister {
    @Rule
    public ActivityTestRule<HomeActivity> mActivityTestRule = new ActivityTestRule<HomeActivity>(HomeActivity.class);
    private HomeActivity mActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(RegisterActivity.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunchOfLoginActivityOnButtonClick(){
        assertNotNull(mActivity.findViewById(R.id.buttonSignUP));

        onView(withId(R.id.buttonSignUP)).perform(click());

        Activity registerActivity = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);

        assertNotNull(registerActivity);

        registerActivity.finish();
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }

}