package com.example.notionsapp.ui.fragment.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.notionsapp.R
import com.example.notionsapp.databinding.FragmentOnboardBinding
import com.example.notionsapp.ui.adapter.OnboardViewPagerAdapter
import com.example.notionsapp.ui.fragment.note.NoteFragment

class OnboardFragment : Fragment() {
    private lateinit var binding: FragmentOnboardBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOnboardBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
    }

    private fun initialize() {
        binding.viewPager2.adapter = OnboardViewPagerAdapter(this@OnboardFragment)
    }

    private fun setupListener() = with(binding.viewPager2) {
        binding.viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 2){
                    binding.tvSkip.visibility = View.INVISIBLE
                    binding.tvStart.visibility = View.VISIBLE
                }
                else {
                    binding.tvSkip.visibility = View.VISIBLE
                    binding.tvStart.visibility = View.INVISIBLE
                }
                when(position){
                    0 -> {
                        binding.imgEllipse4.visibility = View.VISIBLE
                        binding.imgEllipse5.visibility = View.INVISIBLE
                        binding.imgEllipse6.visibility = View.INVISIBLE
                    }
                    1 -> {
                        binding.imgEllipse4.visibility = View.INVISIBLE
                        binding.imgEllipse5.visibility = View.VISIBLE
                        binding.imgEllipse6.visibility = View.INVISIBLE
                    }
                    2 -> {
                        binding.imgEllipse4.visibility = View.INVISIBLE
                        binding.imgEllipse5.visibility = View.INVISIBLE
                        binding.imgEllipse6.visibility = View.VISIBLE
                    }
                }
            }
        })
        binding.tvSkip.setOnClickListener(){
            if (currentItem < 2){
                setCurrentItem(currentItem + 2, true)
            }
        }
        binding.tvStart.setOnClickListener {
            findNavController().navigate(OnboardFragmentDirections.actionOnboardFragmentToNoteFragment())
        }
    }

}
