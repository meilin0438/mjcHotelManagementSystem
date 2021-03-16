package com.example.mjchotelmanagementsystem

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       /* val intent = Intent(this, Home::class.java)
        startActivity(intent)
        finish()*/

        //Home Button
        val button_chkinout: Button =findViewById(R.id.button_check_in_out)
        val button_mybooking: Button =findViewById(R.id.button_my_booking)
        val button_order: Button =findViewById(R.id.button_order)

       /*
       //replace fragement
       val homeFragment:Fragment=HomeFragment()
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_home, homeFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()*/

            // Retrieve NavController from the NavHostFragment
            val navHostFragment = supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            navController = navHostFragment.navController

        // Set up the action bar for use with the NavController
        setupActionBarWithNavController(navController)

    //    val navController=Navigation.findNavController(this,R.id.homeFragment)
        setupSideNavigationMenu(navController)


      /*  //Navigation Bar
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
                    Utils.toast(this, "My Profile", 0)
                    drawerLayout.closeDrawer(GravityCompat.START, true)
                }
                R.id.nav_setting -> {
                    Utils.toast(this, "Setting", 0)
                    drawerLayout.closeDrawer(GravityCompat.START, true)
                }
                R.id.nav_help -> {
                    Utils.toast(this, "Help", 0)
                    drawerLayout.closeDrawer(GravityCompat.START, true)
                }
                R.id.nav_logout -> {
                    Utils.toast(this, "Logout", 0)
                    drawerLayout.closeDrawer(GravityCompat.START, true)
                }
            }
            true
        }*/
    }

    fun setupSideNavigationMenu(navController: NavController){
        var nav_view: NavigationView = findViewById(R.id.nav_view)
        nav_view?.let{
            NavigationUI.setupWithNavController(it,navController)
        }
    }

    /*
       //Navigation Drawer
       override fun onOptionsItemSelected(item: MenuItem): Boolean {
           if (toggle.onOptionsItemSelected(item)) {
               return true
           }
           return super.onOptionsItemSelected(item)
       }*/

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}