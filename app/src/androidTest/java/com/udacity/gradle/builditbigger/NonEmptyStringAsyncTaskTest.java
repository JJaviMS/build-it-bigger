package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

/**
 * Created by JjaviMS on 24/05/2018.
 *
 * @author JJaviMS
 */
@RunWith(AndroidJUnit4.class)
public class NonEmptyStringAsyncTaskTest{
    private static EndpointAsyncTask sEndpointAsyncTask;

    @Rule
    public ActivityTestRule<MainActivity> mMainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);


    @Before
    public void initTask (){
        sEndpointAsyncTask = new EndpointAsyncTask();
    }

    @Test
    public void checkStringIsNotEmpty(){
        try {
            String result = sEndpointAsyncTask.execute(mMainActivityActivityTestRule.getActivity()).get();
            assert !result.isEmpty();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

}
