package com.u3coding.mvvmtest.view;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.u3coding.mvvmtest.R;
import com.u3coding.mvvmtest.view.NewUserActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class NewUserActivityTest {
    @Rule
    public ActivityTestRule<NewUserActivity> mActivityRule = new ActivityTestRule(NewUserActivity.class);
    @Test
    public void checkButtonIsShow(){
        onView(ViewMatchers.withId(R.id.edit_word)).check(matches(isDisplayed()));
    }
}
