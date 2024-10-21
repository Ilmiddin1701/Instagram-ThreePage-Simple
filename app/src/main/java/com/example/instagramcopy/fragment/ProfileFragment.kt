package com.example.instagramcopy.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.instagramcopy.R
import com.example.instagramcopy.adapters.Adapter1
import com.example.instagramcopy.adapters.Adapter2
import com.example.instagramcopy.databinding.FragmentProfileBinding
import com.example.instagramcopy.db.MyDbHelper
import com.example.instagramcopy.models.Data2
import com.example.instagramcopy.utils.Obj1

class ProfileFragment : Fragment() {
    private val binding by lazy { FragmentProfileBinding.inflate(layoutInflater) }
    lateinit var myDbHelper: MyDbHelper
    lateinit var adapter1: Adapter1
    lateinit var adapter2: Adapter2
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.apply {
            myDbHelper = MyDbHelper(requireContext())
            rv1.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

            Obj1.add()
            adapter1 = Adapter1(Obj1.list)
            rv1.adapter = adapter1

            val bottom = requireActivity().findViewById<LinearLayout>(R.id.bottomNavigationView1)
            val videoViewFragment = VideoViewFragment()
            adapter2 = Adapter2(object : Adapter2.RvAction{
                override fun itemClick(data2: Data2) {
                    val bundle = bundleOf("keyVideoUri" to data2.video.toString())
                    videoViewFragment.arguments = bundle
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.container, videoViewFragment)
                        .addToBackStack(videoViewFragment.toString())
                        .commit()
                    bottom.visibility = View.GONE
                }
            }, myDbHelper.showVideos() as ArrayList)
            rv2.adapter = adapter2
            rv2.setHasFixedSize(true)
        }
        return binding.root
    }
}