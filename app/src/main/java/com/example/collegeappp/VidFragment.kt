package com.example.collegeappp

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_vid.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [VidFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VidFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var playbackPosition = 0
    private val sUrl = "https://firebasestorage.googleapis.com/v0/b/college-app-c07ad.appspot.com/o/Distributed%20Database.mp4?alt=media&token=59862bcd-b191-4891-8804-7594cc77b390"
    private lateinit var mediaController: MediaController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }





    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mediaController = MediaController(this@VidFragment.context)

        videoView1.setOnPreparedListener{
            mediaController.setAnchorView(videoContainer)
            videoView1.setMediaController(mediaController)
            videoView1.seekTo(playbackPosition)
            videoView1.start()
        }

        videoView1.setOnInfoListener { player, what, extras ->
            if (what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START)
                progbar1.visibility = View.INVISIBLE
            true
        }


    }

    override fun onStart(){
        super.onStart()

        val uri = Uri.parse(sUrl)
        videoView1.setVideoURI(uri)
        videoView1.setZOrderOnTop(true)
        progbar1.visibility = View.VISIBLE

    }

    override fun onPause() {
        super.onPause()

        videoView1.pause()
        playbackPosition = videoView1.currentPosition
    }

    override fun onStop(){
        videoView1.stopPlayback()

        super.onStop()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vid, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment VidFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VidFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}