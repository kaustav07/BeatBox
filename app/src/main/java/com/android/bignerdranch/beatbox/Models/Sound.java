package com.android.bignerdranch.beatbox.Models;

/**
 * Created by Kaustav on 23-11-2017.
 */

public class Sound {

    String mAssesPath;
    String mName;
    Integer mSoundId;

    public Sound(String path){
        mAssesPath = path;
        String[] components = mAssesPath.split("/");
        String filename = components[components.length - 1];
        mName = filename.replace(".wav","");
    }

    public String getAssesPath() {
        return mAssesPath;
    }

    public String getName() {
        return mName;
    }

    public Integer getSoundId() {
        return mSoundId;
    }

    public void setSoundId(Integer soundId) {
        mSoundId = soundId;
    }
}
