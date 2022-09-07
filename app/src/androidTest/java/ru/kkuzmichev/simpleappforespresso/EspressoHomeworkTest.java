package ru.kkuzmichev.simpleappforespresso;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import android.content.Intent;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class EspressoHomeworkTest {

    @Rule
//    public IntentsTestRule intentsTestRule = new IntentsTestRule(MainActivity.class);

    @Test
    public void testSimpleTask() {

        RecyclerView recycleList = onView(allOf(withId(R.id.toolbar)));
//        recycleList.check(isRecyclerView());
        recycleList.measure(0,0);
        recycleList.layout(0,0,100,1000);

        recycleList.findViewHolderForAdapterPosition(0).itemView.performClick();

        ViewInteraction element = onView(allOf(withId(R.id.toolbar), withText("Setting")));
        element.check(matches((isDisplayed())));
        Intents.init();
        element.perform(click());
        intended(allOf(hasData("https:/google.com"),
                hasAction(Intent.ACTION_VIEW)));
        Intents.release();
    }


}
