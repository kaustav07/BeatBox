package com.android.bignerdranch.beatbox.ViewModel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;
import android.widget.Toast;

import com.android.bignerdranch.beatbox.BR;
import com.android.bignerdranch.beatbox.Models.BeatBox;
import com.android.bignerdranch.beatbox.Models.Sound;

/**
 * Created by Kaustav on 23-11-2017.
 */

public class SoundViewModel extends BaseObservable{

    private Sound mSound;
    private BeatBox mBeatBox;

    public SoundViewModel(BeatBox beatBox) {
        mBeatBox = beatBox;
    }

    public Sound getSound() {
        return mSound;
    }

    public void setSound(Sound sound) {
        mSound = sound;
        notifyChange();
    }

    @Bindable
    public String getTitle(){
       return mSound.getName();
    }

    public void onBtnclk(){
        //Log.d("testclk","its clicked");
        mBeatBox.play(mSound);
    }
}
