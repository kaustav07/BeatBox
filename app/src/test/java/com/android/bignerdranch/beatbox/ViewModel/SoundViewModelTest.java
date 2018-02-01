package com.android.bignerdranch.beatbox.ViewModel;

import android.util.Log;

import com.android.bignerdranch.beatbox.Models.BeatBox;
import com.android.bignerdranch.beatbox.Models.Sound;

import org.hamcrest.core.Is;
import org.hamcrest.junit.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Kaustav on 25-11-2017.
 */
public class SoundViewModelTest {

    BeatBox mBeatBox;
    SoundViewModel mSubject;
    Sound mSound;

    @Before
    public void setUp() throws Exception {
        mBeatBox = mock(BeatBox.class);
        mSubject = new SoundViewModel(mBeatBox);
        mSound = new Sound("assetPath");
        mSubject.setSound(mSound);
    }

    @Test
    public void firstTest(){
        MatcherAssert.assertThat(mSubject.getTitle(), Is.is(mSound.getName()));
    }

    @Test
    public void playSound(){
        mSubject.onBtnclk();
        verify(mBeatBox).play(mSound);
    }

}