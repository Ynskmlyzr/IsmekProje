package com.yunuskemalyazar.gidivee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.yunuskemalyazar.gidivee.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        binding.apply {

            bottomnavigation.setOnItemSelectedListener {
                when(it.itemId){
                    R.id.homeFragment -> replaceFragment(HomeFragment())
                    R.id.foodFragment -> replaceFragment(FoodFragment())
                    R.id.walkFragment -> replaceFragment(WalkFragment())
                    else -> {

                    }
                }
                true
            }
        }

        }

    private fun replaceFragment (fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView,fragment)
        fragmentTransaction.commit()
    }

    }