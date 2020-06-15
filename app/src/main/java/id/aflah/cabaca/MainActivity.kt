package id.aflah.cabaca

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.genreFragment, R.id.newBookFragment))

        navController.addOnDestinationChangedListener { nc: NavController, nd: NavDestination, bundle: Bundle? ->
            when(nd.id) {
                R.id.genreFragment -> showBottomNavigation(navView)
                R.id.newBookFragment -> showBottomNavigation(navView)
                else -> hideBottomNavigation(navView)
            }
        }
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun hideBottomNavigation(navigation: BottomNavigationView) {
        with(navigation) {
            if (visibility == View.VISIBLE && alpha == 1f) {
                animate()
                    .alpha(0f)
                    .withEndAction { visibility = View.GONE }
                    .duration = 100
            }
        }
    }

    private fun showBottomNavigation(navigation: BottomNavigationView) {
        with(navigation) {
            visibility = View.VISIBLE
            animate()
                .alpha(1f)
                .duration = 100
        }
    }
}