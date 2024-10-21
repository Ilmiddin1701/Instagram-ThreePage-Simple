package com.example.instagramcopy.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.instagramcopy.R
import com.example.instagramcopy.adapters.PostAdapter
import com.example.instagramcopy.adapters.StoryAdapter
import com.example.instagramcopy.databinding.ActivityMainBinding
import com.example.instagramcopy.databinding.FragmentHomeBinding
import com.example.instagramcopy.utils.PosObj
import com.example.instagramcopy.utils.StoryObj

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {
    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }
    lateinit var storyAdapter: StoryAdapter
    lateinit var postAdapter: PostAdapter

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.rvStory.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        StoryObj.storyAdd()
        storyAdapter = StoryAdapter(StoryObj.list)
        binding.rvStory.adapter = storyAdapter

        PosObj.postAdd()
        postAdapter = PostAdapter(PosObj.list)
        binding.rvPosts.adapter = postAdapter

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}