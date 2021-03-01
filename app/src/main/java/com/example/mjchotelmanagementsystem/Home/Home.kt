package com.example.mjchotelmanagementsystem.Home

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.mjchotelmanagementsystem.R
import com.example.mjchotelmanagementsystem.helper.Utils
import com.google.android.material.navigation.NavigationView


class Home : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //Navigation Bar
        var drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.app_name)
        supportActionBar?.elevation = 0f

        var nav_view: NavigationView = findViewById(R.id.nav_view)
        nav_view.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_profile -> {
                    Utils.toast(this, "My Profile", 1)
                    drawerLayout.closeDrawer(GravityCompat.START, true)
                }
                R.id.nav_setting -> {
                    Utils.toast(this, "Setting", 1)
                    drawerLayout.closeDrawer(GravityCompat.START, true)
                }
                R.id.nav_help -> {
                    Utils.toast(this, "Help", 1)
                    drawerLayout.closeDrawer(GravityCompat.START, true)
                }
                R.id.nav_logout -> {
                    Utils.toast(this, "Logout", 1)
                    drawerLayout.closeDrawer(GravityCompat.START, true)
                }
            }
            true
        }
    }

    //Navigation Drawer
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}