package com.kanyideveloper.recyclerviewitemclicksdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kanyideveloper.recyclerviewitemclicksdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }
    private lateinit var adapter: RecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = RecyclerAdapter(RecyclerAdapter.OnClickListener{photo ->
            //Navigate to details of clicked item
            Toast.makeText(applicationContext, "${photo.id}", Toast.LENGTH_SHORT).show()
        })

        viewModel.response.observe(this, Observer { photo ->
            adapter.submitList(photo)
            binding.recyclerView.adapter = adapter
        })
    }
}