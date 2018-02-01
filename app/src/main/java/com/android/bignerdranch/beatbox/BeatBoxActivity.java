package com.android.bignerdranch.beatbox;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.bignerdranch.beatbox.Fragments.BeatBoxFragment;

public class BeatBoxActivity extends SingleFragmentActivity {
    @Override
    public Fragment createFragment() {
        Fragment beatbox = BeatBoxFragment.newInstance();
        return beatbox;
    }
}
