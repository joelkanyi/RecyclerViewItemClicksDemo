package com.kanyideveloper.recyclerviewitemclicksdemo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kanyideveloper.recyclerviewitemclicksdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }
    private lateinit var adapter: MemesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MemesAdapter(MemesAdapter.OnClickListener { photo ->
            Toast.makeText(applicationContext, "${photo.name}", Toast.LENGTH_SHORT).show()
        })

        viewModel.response.observe(this, Observer { meme ->
            val list = meme.data?.memes
            adapter.submitList(list)
            binding.recyclerView.adapter = adapter
        })

        viewModel.loading.observe(this, Observer { loading ->
            binding.progressBar.isVisible = loading
        })

        viewModel.failed.observe(this, Observer { failed ->
            binding.textViewFailed.text = failed
            binding.textViewFailed.isVisible = true
        })
    }
}