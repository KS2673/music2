package com.example.musicproject2


import android.content.Intent
import android.media.MediaPlayer
import android.media.MediaPlayer.OnSeekCompleteListener
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.ActionMode
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import com.example.musicproject2.databinding.ActivityMainBinding
import com.example.musicproject2.databinding.FragmentFirstBinding
import kotlin.time.toDuration


open class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var seekBar: SeekBar
    private lateinit var nextbutton: Button
    private lateinit var music: TextView
    private lateinit var playButton: Button
    private lateinit var handler: Handler


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nextbutton = findViewById(R.id.nxtbtn)
        music = findViewById(R.id.txtmusic)

        // add the OnClickListener in sender button after clicked this button following Instruction will run
        //nextbutton.setOnClickListener {
            // get the value which input by user in EditText and convert it to string
          //  val str = music.text.toString()
            // Create the Intent object of this class Context() to Second_activity class
           // val intent = Intent(applicationContext, MainActivity2::class.java)
            // now by putExtra method put the value in key, value pair key is
            // message_key by this key we will receive the value, and put the string
           // intent.putExtra("message_key", str)
            // start the Intent
           // startActivity(intent)
        //}
        nextbutton.setOnClickListener {
            var intent = Intent(applicationContext,MainActivity2::class.java)

            startActivity(intent)
        }

        seekBar = findViewById(R.id.musicseek)
        playButton = findViewById(R.id.playPauseButton)
        mediaPlayer = MediaPlayer.create(this, R.raw.lakshya_song)
        handler = Handler(Looper.getMainLooper())

        seekBar.max = mediaPlayer.duration
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer.seekTo(2000)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                mediaPlayer.pause()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                mediaPlayer.start()
            }

        })


        mediaPlayer.setOnSeekCompleteListener(object : OnSeekCompleteListener {
            override fun onSeekComplete(mp: MediaPlayer) {
                // Handle seek complete event here
            }
        })


        mediaPlayer.isLooping = true

        playButton.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()


                playButton.setBackgroundResource(R.drawable.baseline_play_circle_24)
            } else {
                mediaPlayer.start()
                playButton.setBackgroundResource(R.drawable.baseline_pause_circle_24)
            }
        }
        handler.post(object : Runnable {
            override fun run() {
                seekBar.progress = mediaPlayer.currentPosition
                handler.postDelayed(this, 1000)
            }
        })
    }

}



