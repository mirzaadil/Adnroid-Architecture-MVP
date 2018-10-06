package com.mirzaadil.technicalassesmenttask;

import android.support.test.rule.ActivityTestRule;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mirzaadil.technicalassesmenttask.mvp.ui.activity.NYNewsActivity;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class NYTimesActivityTest {

    @Rule
    public ActivityTestRule<NYNewsActivity> rule = new ActivityTestRule<>(NYNewsActivity.class);

    @Test
    public void ensureRecyclerViewIsPresentAndNotNull() throws Exception {
        NYNewsActivity activity = rule.getActivity();
        View viewById = activity.findViewById(R.id.recycler_view_users);
        assertThat(viewById, notNullValue());
        assertThat(viewById, Matchers.<View>instanceOf(RecyclerView.class));

    }
    @Test
    public void ensureRecyclerViewISEnabled(){
        onView(withId(R.id.recycler_view_users)).check(matches((isEnabled())));
    }

    @Test
    public void ensureRecyclerViewItemIsClickable() {
        onView(withId(R.id.recycler_view_users)).check(matches(not(isClickable())));

    }

}
