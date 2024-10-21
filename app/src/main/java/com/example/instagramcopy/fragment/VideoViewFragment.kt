package com.example.instagramcopy.fragment

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instagramcopy.R
import com.example.instagramcopy.databinding.FragmentVideoViewBinding

class VideoViewFragment : Fragment() {
    private val binding by lazy { FragmentVideoViewBinding.inflate(layoutInflater) }
    private var startStop = true
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val videoUri = arguments?.getString("keyVideoUri")
        binding.apply {
            videoView.setVideoURI(Uri.parse(videoUri))
            videoView.start()

            videoView.setOnPreparedListener {
                it.isLooping = true
            }

            videoView.setOnClickListener {
                if (startStop) {
                    btnStop.visibility = View.VISIBLE
                    videoView.pause()
                    startStop = false
                } else {
                    btnStop.visibility = View.INVISIBLE
                    videoView.start()
                    startStop = true
                }
            }
        }
        return binding.root
    }
}