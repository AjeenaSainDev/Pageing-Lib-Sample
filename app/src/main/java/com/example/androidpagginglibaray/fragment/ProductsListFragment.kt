package com.example.androidpagginglibaray.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androidpagginglibaray.R
import kotlinx.android.synthetic.main.product_list.*
import kotlinx.android.synthetic.main.product_list.view.*

/**
 * Created by Ajeena on 18-12-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 *
 */
class ProductsListFragment : Fragment() {
    lateinit var click_navm : Button;
     override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         var view = inflater.inflate(R.layout.product_list, container, false)
          view.click_nav.setOnClickListener {
              findNavController().navigate(
                  R.id.action_list_details,
                 null
              )
          }
        return view
    }
}