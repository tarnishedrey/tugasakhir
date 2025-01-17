package com.example.tugasakhir

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.tugasakhir.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(home())

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(home())
                R.id.promo -> replaceFragment(promo())
                R.id.chat -> replaceFragment(chat())
                R.id.profile -> replaceFragment(profile())


                else ->{

                }

            }
            true
        }


    }

    fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)

        // Check if the selected fragment is profile, if yes, hide the bottom navigation bar
        if (fragment is profile) {
            binding.bottomNavigation.visibility = View.GONE
        } else {
            binding.bottomNavigation.visibility = View.VISIBLE
        }

        fragmentTransaction.commit()

    }





}