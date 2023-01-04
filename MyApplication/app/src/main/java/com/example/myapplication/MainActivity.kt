package com.example.myapplication

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    fun regular()
    {
        // Regex to match any string starting with 'a'
        val pattern = Regex("^a")
        var testTrue = pattern.containsMatchIn("abc")
        var testFalse = pattern.containsMatchIn("bac")
        Log.d("REGX", testTrue.toString())
        Log.d("REGX", testFalse.toString())
    }

    fun chiffre()
    {
        // Regex to match any string starting with 'a'
        val pattern = Regex("[0-9]")
        var testTrue = pattern.matches("8")
        var testFalse = pattern.matches("127")
        Log.d("REGX", testTrue.toString())
        Log.d("REGX", testFalse.toString())
    }

    fun alphanumerique()
    {
        // Regex to match any string starting with 'a'
        val pattern = Regex("[:alnum:]+")
        var testTrue = pattern.matches("pokemon128")
        var testFalse = pattern.matches("pokemon*%")
        Log.d("REGX", testTrue.toString())
        Log.d("REGX", testFalse.toString())
    }

    fun telephone()
    {
        // Regex to match any string starting with 'a'
        val pattern = Regex("[:0-9]{10}")
        var testTrue = pattern.matches("0661262319")
        var testFalse = pattern.matches("+33661262319")
        Log.d("REGX", testTrue.toString())
        Log.d("REGX", testFalse.toString())
    }

    fun mail()
    {
        // Regex to match any string starting with 'a'
        val pattern = Regex("^[\\w\\-\\.]+@(|\\w-]+\\.)+.([\\w\\-\\.])+")
        var testTrue = pattern.matches("matmoz63@gmail.com")
        var testFalse = pattern.matches("matmoz63gmail.com")
        Log.d("REGX", testTrue.toString())
        Log.d("REGX", testFalse.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mail()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}