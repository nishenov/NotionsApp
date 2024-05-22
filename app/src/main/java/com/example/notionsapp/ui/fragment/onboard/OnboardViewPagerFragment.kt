package com.example.notionsapp.ui.fragment.onboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.airbnb.lottie.LottieDrawable
import com.example.notionsapp.R
import com.example.notionsapp.databinding.FragmentOnboardViewPagerBinding

class OnboardViewPagerFragment : Fragment() {
    private lateinit var binding: FragmentOnboardViewPagerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentOnboardViewPagerBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() = with(binding) {
        when(requireArguments().getInt(ARG_ONBOARD_POSITION)){
            0 -> {
                tvOnboard.text = getString(R.string.comfortable_funcionality)
                lottieOnboard.setAnimation("lottie1.json")
                lottieOnboard.repeatCount = LottieDrawable.INFINITE
                lottieOnboard.repeatMode = LottieDrawable.REVERSE
                lottieOnboard.playAnimation()

            }
            1 -> {
                tvOnboard.text= getString(R.string.good_product)
                lottieOnboard.setAnimation("lottie2.json")
                lottieOnboard.repeatCount = LottieDrawable.INFINITE
                lottieOnboard.repeatMode = LottieDrawable.REVERSE
                lottieOnboard.playAnimation()
            }
            2 -> {
                tvOnboard.text = getString(R.string.lot_of_features)
                lottieOnboard.setAnimation("lottie3.json")
                lottieOnboard.repeatCount = LottieDrawable.INFINITE
                lottieOnboard.repeatMode = LottieDrawable.REVERSE
                lottieOnboard.playAnimation()
            }
        }
    }

    companion object {
        const val ARG_ONBOARD_POSITION = "onboard"
    }
}