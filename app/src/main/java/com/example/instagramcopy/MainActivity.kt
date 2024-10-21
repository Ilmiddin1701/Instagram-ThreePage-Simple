package com.example.instagramcopy

import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.example.instagramcopy.databinding.ActivityMainBinding
import com.example.instagramcopy.db.MyDbHelper
import com.example.instagramcopy.fragment.HomeFragment
import com.example.instagramcopy.fragment.ProfileFragment
import com.example.instagramcopy.models.Data2
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.abs

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var myDbHelper: MyDbHelper
    lateinit var videoUri: Uri
    private var absolutPath = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, HomeFragment())
            .commit()

        myDbHelper = MyDbHelper(this)
        binding.apply {
            btnHome.setOnClickListener {
                btnProfile.setImageResource(R.drawable.ic_profile)
                btnHome.setImageResource(R.drawable.ic_home)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, HomeFragment())
                    .addToBackStack(HomeFragment().toString())
                    .commit()
            }

            btnAdd.setOnClickListener {
                val videoFile = createVideoFile()
                videoUri = FileProvider.getUriForFile(
                    this@MainActivity,
                    "com.example.instagramcopy",
                    videoFile
                )
                getTakeVideoContent.launch(videoUri)
                myDbHelper.addVideo(Data2(absolutPath))
            }

            btnProfile.setOnClickListener {
                btnProfile.setImageResource(R.drawable.ic_profile1)
                btnHome.setImageResource(R.drawable.ic_home1)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ProfileFragment())
                    .addToBackStack(ProfileFragment().toString())
                    .commit()
            }
        }
    }

    private fun createVideoFile(): File {
        val format = SimpleDateFormat("ddMMyyyyHHmmss", Locale.getDefault()).format(Date())
        val externalFilesDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile("JPEG_$format", ".mp4", externalFilesDir).apply {
            absolutPath = absolutePath
        }
    }

    private val getTakeVideoContent =
        registerForActivityResult(ActivityResultContracts.TakeVideo()) {
            val format = SimpleDateFormat("ddMMyyyyHHmmss", Locale.getDefault()).format(Date())
            val inputStream = contentResolver?.openInputStream(videoUri)
            val file = File(filesDir, "IMG_$format.mp4")
            val fileOutputStream = FileOutputStream(file)
            inputStream?.copyTo(fileOutputStream)
            inputStream?.close()
            fileOutputStream.close()
        }

    override fun onBackPressed() {
        super.onBackPressed()
        binding.bottomNavigationView1.visibility = View.VISIBLE
    }
}