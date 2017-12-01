package com.example.thibaut.rshulpapplicatie;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Thibaut on 1/12/2017.
 */
public class LoginActivityTest {
    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<LoginActivity>(LoginActivity.class);

    private LoginActivity mActivity = null;

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch() {
        View user = mActivity.findViewById(R.id.editTextUserNameToLogin);
               assertNotNull(user);
    }
    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }

}