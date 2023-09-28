package com.example.project1.ui.plan;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.project1.ui.plan.planfragment.AssembleOrderFragment;
import com.example.project1.ui.plan.planfragment.BackOrderFragment;
import com.example.project1.ui.plan.planfragment.FrontOrderFragment;
import com.example.project1.ui.plan.planfragment.MainOrderFragment;
import com.example.project1.ui.plan.planfragment.SaleOrderFragment;

public class PlanPageAdapter extends FragmentStateAdapter {
    FrontOrderFragment frontOrderFragment;
    MainOrderFragment mainOrderFragment;
    BackOrderFragment backOrderFragment;
    AssembleOrderFragment assembleOrderFragment;
    SaleOrderFragment saleOrderFragment;

    public PlanPageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                frontOrderFragment = new FrontOrderFragment();
                return frontOrderFragment;
            case 1:
                mainOrderFragment = new MainOrderFragment();
                return mainOrderFragment;
            case 2:
                backOrderFragment = new BackOrderFragment();
                return backOrderFragment;
            case 3:
                assembleOrderFragment = new AssembleOrderFragment();
                return assembleOrderFragment;
            case 4:
                saleOrderFragment = new SaleOrderFragment();
                return saleOrderFragment;
            default:
                return null;
        }

    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
