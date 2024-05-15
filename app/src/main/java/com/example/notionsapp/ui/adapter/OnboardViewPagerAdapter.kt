package com.example.notionsapp.ui.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.notionsapp.ui.fragment.onboard.OnboardViewPagerFragment
import com.example.notionsapp.ui.fragment.onboard.OnboardViewPagerFragment.Companion.ARG_ONBOARD_POSITION

class OnboardViewPagerAdapter(fragment : Fragment) :FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int) = OnboardViewPagerFragment().apply {
        arguments = Bundle().apply {
            putInt(ARG_ONBOARD_POSITION, position)
        }
    }
}