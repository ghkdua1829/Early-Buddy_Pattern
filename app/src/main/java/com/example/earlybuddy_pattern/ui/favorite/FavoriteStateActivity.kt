package com.example.earlybuddy_pattern.ui.favorite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.earlybuddy_pattern.R
import com.example.earlybuddy_pattern.databinding.ActivityFavoriteStateBinding

class FavoriteStateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityFavoriteStateBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_favorite_state)
    }
}
