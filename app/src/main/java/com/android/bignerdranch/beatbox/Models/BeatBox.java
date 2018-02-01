package com.android.bignerdranch.beatbox.Models;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.provider.MediaStore;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kaustav on 23-11-2017.
 */

public class BeatBox {

    private AssetManager mAssetManager;
    private List<Sound> mSounds;
    private SoundPool mSoundPool;

    private static final String TAG = "assesError";
    private static final String SOUNDS_FOLDER = "sounds";
    private static final int MAX_SOUNDS = 5;

    public BeatBox(Context context){
        mAssetManager = context.getAssets();
        mSoundPool = new SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC,0);
        loadSounds();
    }

    public void loadSounds(){
        try {
            String[] soundNames = mAssetManager.list(SOUNDS_FOLDER);
            mSounds = new ArrayList<>();
            for (String sound :
                    soundNames) {
                Sound newSound = new Sound(SOUNDS_FOLDER + "/" + sound);
                load(newSound);
                mSounds.add(newSound);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(TAG,e.getMessage());
        }
    }

    private void load(Sound sound) throws IOException {
       // InputStream inputStream = mAssetManager.open(sound.getAssesPath());
        AssetFileDescriptor assetFileDescriptor = mAssetManager.openFd(sound.getAssesPath());
        //int id = mSoundPool.load(sound.getAssesPath(),0);
        int soundId = mSoundPool.load(assetFileDescriptor,0);
        sound.setSoundId(soundId);
    }

    public void play(Sound sound){
        if(sound.getSoundId() != null){
            mSoundPool.play(sound.getSoundId(),1.0f,1.0f,0,0,1);
        }
    }

    public void release(){
        mSoundPool.release();
    }

    public List<Sound> getSounds() {
        return mSounds;
    }
}
