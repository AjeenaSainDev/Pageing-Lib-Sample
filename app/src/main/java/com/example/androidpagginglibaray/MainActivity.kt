package com.example.androidpagginglibaray

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidpagginglibaray.adapter.UserAdapter
import com.example.androidpagginglibaray.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = UserAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        val itemViewModel = ViewModelProviders.of(this)
            .get(UserViewModel::class.java)
        itemViewModel.userPagedList.observe(this, Observer {
            adapter.submitList(it)
        })
        recyclerView.adapter = adapter
    }

}
