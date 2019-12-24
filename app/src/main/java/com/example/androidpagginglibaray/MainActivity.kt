package com.example.androidpagginglibaray

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidpagginglibaray.adapter.UserAdapter
import com.example.androidpagginglibaray.factorydesign.FactoryClass
import com.example.androidpagginglibaray.model.UserResponse
import com.example.androidpagginglibaray.repository.ProductRepository
import com.example.androidpagginglibaray.viewmodel.UserViewModel
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.navigation_main_layout.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var productRepository: ProductRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setupNavigation()
        (application as PagingApp).appComponent.inject(this)
        var factoryClass = FactoryClass()
        var plan = factoryClass.getRate("DOMESTICPLAN")

        plan.calculateBill(5)

       // getUser()

         val adapter = UserAdapter()
         recyclerView.layoutManager = LinearLayoutManager(this)
         val itemViewModel = ViewModelProviders.of(this)
             .get(UserViewModel::class.java)
         itemViewModel.userPagedList.observe(this, Observer {
             adapter.submitList(it)
         })
         recyclerView.adapter = adapter
    }

    private fun getUser() {
       val observable = productRepository.getRemoteSource().getUserDate(1)
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(Consumer { userresponse ->
                System.out.println("page_rx"+ userresponse.users!!.get(2).avatar)
            })



    }

    private fun setupNavigation() {
        val navController = findNavController(this, R.id.nav_host_fragment)

        // Update action bar to reflect navigation
        setupActionBarWithNavController(this, navController, drawerLayout)

        // Handle nav drawer item clicks
        navigationView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            drawerLayout.closeDrawers()
            true
        }

        // Tie nav graph to items in nav drawer
        setupWithNavController(navigationView, navController)
    }

   /* override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.nav_host_fragment).navigateUp()
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }*/



}
