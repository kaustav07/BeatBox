package com.android.bignerdranch.beatbox.Fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.bignerdranch.beatbox.Models.BeatBox;
import com.android.bignerdranch.beatbox.Models.Sound;
import com.android.bignerdranch.beatbox.R;
import com.android.bignerdranch.beatbox.ViewModel.SoundViewModel;
import com.android.bignerdranch.beatbox.databinding.FragmentBeatBoxBinding;
import com.android.bignerdranch.beatbox.databinding.SoundButtonBinding;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BeatBoxFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BeatBoxFragment extends Fragment {

    BeatBox mBeatBox;

    public BeatBoxFragment() {
        // Required empty public constructor
    }

    public static BeatBoxFragment newInstance() {
        BeatBoxFragment fragment = new BeatBoxFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentBeatBoxBinding fragmentBeatBoxBinding  = DataBindingUtil.inflate(inflater,R.layout.fragment_beat_box,container,false);
        mBeatBox = new BeatBox(getActivity().getApplicationContext());
        fragmentBeatBoxBinding.soundgridview.setLayoutManager(new GridLayoutManager(getActivity(),3));
        SoundAdapter soundAdapter = new SoundAdapter();
        soundAdapter.setSounds(mBeatBox.getSounds());
        fragmentBeatBoxBinding.soundgridview.setAdapter(soundAdapter);
        return fragmentBeatBoxBinding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBeatBox.release();
    }

    private class SoundHolder extends RecyclerView.ViewHolder{
        private SoundButtonBinding mSoundButtonBinding;

        public SoundHolder(SoundButtonBinding soundButtonBinding) {
            super(soundButtonBinding.getRoot());
            mSoundButtonBinding = soundButtonBinding;
            mSoundButtonBinding.setMSoundViewModel(new SoundViewModel(new BeatBox(getActivity())));
        }

        public void bindSound(Sound sound){
            mSoundButtonBinding.getMSoundViewModel().setSound(sound);
        }
    }

    private class SoundAdapter extends RecyclerView.Adapter<SoundHolder>{

        List<Sound> mSounds;

        @Override
        public SoundHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            SoundButtonBinding soundButton = DataBindingUtil.inflate(getLayoutInflater(),R.layout.sound_button,parent,false);
            SoundHolder soundHolder = new SoundHolder(soundButton);
            return soundHolder;
        }

        @Override
        public void onBindViewHolder(SoundHolder holder, int position) {
                holder.bindSound(mSounds.get(position));
        }

        @Override
        public int getItemCount() {
            return mSounds.size();
        }

        public void setSounds(List<Sound> sounds) {
            mSounds = sounds;
        }
    }

}
