package com.example.assetfix.mobile.main
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.assetfix.R
import com.example.assetfix.mobile.dashboard.DashboardFragment
import com.example.assetfix.mobile.dashboard.adapter.ItemAdapter
import com.example.assetfix.mobile.dashboard.data.Datasource
import com.example.assetfix.mobile.workOrder.WorkOrderFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        replaceFragment(DashboardFragment())

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_Layout)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.background=null

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navView: NavigationView = findViewById(R.id.navView)
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.side_home_item -> {
                    replaceFragment(DashboardFragment())
                }
                R.id.messages_item -> {
                    Toast.makeText(applicationContext, "Clicked Mesages", Toast.LENGTH_SHORT).show()
                }
                R.id.notification_item -> {
                    Toast.makeText(applicationContext, "Clicked Notifications", Toast.LENGTH_SHORT).show()
                }
                R.id.profile_item -> {
                    Toast.makeText(applicationContext, "Clicked Profile`", Toast.LENGTH_SHORT).show()
                }
                R.id.work_order_item ->{
                    replaceFragment(WorkOrderFragment())
                }
                R.id.parts_inventory_item ->{
                    Toast.makeText(applicationContext, "Clicked Parts & Inventory`", Toast.LENGTH_SHORT).show()
                }
                R.id.assets_item ->{
                    Toast.makeText(applicationContext, "Clicked Assets`", Toast.LENGTH_SHORT).show()
                }
            }
            // Close the drawer after a menu item is selected
            val drawerLayout: DrawerLayout = findViewById(R.id.drawer_Layout)
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.assets_item -> {
                    replaceFragment(DashboardFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.work_order_item -> {
                    replaceFragment(WorkOrderFragment())
                    return@setOnItemSelectedListener true
                }
                // Add other menu item cases as needed
                else -> return@setOnItemSelectedListener false
            }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                val drawerLayout: DrawerLayout = findViewById(R.id.drawer_Layout)
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START)
                } else {
                    drawerLayout.openDrawer(GravityCompat.START)
                }
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main_frame_layout, fragment)
        fragmentTransaction.commit()
    }

}