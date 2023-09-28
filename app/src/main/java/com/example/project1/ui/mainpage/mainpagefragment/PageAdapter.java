package com.example.project1.ui.mainpage.mainpagefragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.project1.ui.mainpage.mainpagefragment.MessageFragment;
import com.example.project1.ui.mainpage.mainpagefragment.ProgressFragment;
import com.example.project1.ui.mainpage.mainpagefragment.ScheduleFragment;

public class PageAdapter extends FragmentStateAdapter {
    ProgressFragment progressFragment;
    ScheduleFragment scheduleFragment;
    MessageFragment messageFragment;

    public PageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        //position當前ViewPage編號
        switch (position) {
            case 0:
                progressFragment = new ProgressFragment();
                return progressFragment;
            case 1:
                scheduleFragment = new ScheduleFragment();
                return scheduleFragment;
            case 2:
                messageFragment = new MessageFragment();
                return messageFragment;
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

}
