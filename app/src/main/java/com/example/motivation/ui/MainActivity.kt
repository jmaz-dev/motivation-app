package com.example.motivation.ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.motivation.R
import com.example.motivation.data.Mock
import com.example.motivation.data.Phrase
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPreferences
import com.example.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    private var categoryId = MotivationConstants.FILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    override fun onStart() {
        super.onStart()
        /*EventListener*/
        handleEvents()

        /*Get Name*/
        handleGetUserName()

        /*Set Default*/
        handleFilter(R.id.image_all)
        handleGeneratePhrase()

    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_new_phrase) {
            handleGeneratePhrase()
        } else if (v.id in listOf(R.id.image_all, R.id.image_emoji, R.id.image_sun)) {
            handleFilter(v.id)
        }
    }

    private fun handleEvents() {
        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageEmoji.setOnClickListener(this)
        binding.imageSun.setOnClickListener(this)
    }

    private fun handleGeneratePhrase() {
        binding.textPhrase.text = Mock().getPhrase(categoryId)
    }

    private fun handleGetUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        binding.textName.text = "Olá, $name!"
    }

    private fun handleFilter(id: Int) {

        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageEmoji.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageSun.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))


        when (id) {
            R.id.image_all -> {
                binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.ALL
            }

            R.id.image_emoji -> {
                binding.imageEmoji.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.EMOJI

            }

            R.id.image_sun -> {
                binding.imageSun.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.SUN

            }
        }
    }

}