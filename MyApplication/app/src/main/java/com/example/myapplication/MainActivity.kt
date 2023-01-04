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

    val monsieur = Person("matthieu", 21)
    val madame = Person("Flavie", 22)
    val robot = Person("Dalle", 1)

    val list = listOf(monsieur, madame, robot)
    val sorted = list.sortedBy{it.age}



    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    fun regular()
    {
        // Regex to match any string starting with 'a'
        val pattern = Regex("^a")
        val testTrue = pattern.containsMatchIn("abc")
        val testFalse = pattern.containsMatchIn("bac")
        Log.d("REGX", testTrue.toString())
        Log.d("REGX", testFalse.toString())
    }

    fun chiffre()
    {
        // Regex to match any string starting with 'a'
        val pattern = Regex("[0-9]")
        val testTrue = pattern.matches("8")
        val testFalse = pattern.matches("127")
        Log.d("REGX", testTrue.toString())
        Log.d("REGX", testFalse.toString())
    }

    fun alphanumerique()
    {
        // Regex to match any string starting with 'a'
        val pattern = Regex("[:alnum:]+")
        val testTrue = pattern.matches("pokemon128")
        val testFalse = pattern.matches("pokemon*%")
        Log.d("REGX", testTrue.toString())
        Log.d("REGX", testFalse.toString())
    }

    fun telephone()
    {
        // Regex to match any string starting with 'a'
        val pattern = Regex("[:0-9]{10}")
        val testTrue = pattern.matches("0661262319")
        val testFalse = pattern.matches("+33661262319")
        Log.d("REGX", testTrue.toString())
        Log.d("REGX", testFalse.toString())
    }

    fun mail()
    {
        // Regex to match any string starting with 'a'
        val pattern = Regex("^[\\w\\-\\.]+@(|\\w-]+\\.)+.([\\w\\-\\.])+")
        val testTrue = pattern.matches("matmoz63@gmail.com")
        val testFalse = pattern.matches("matmoz63gmail.com")
        Log.d("REGX", testTrue.toString())
        Log.d("REGX", testFalse.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mail()

        for (item in list){
            Log.d("agedumonsieur", item.age.toString())
        }
        for (person in sorted){
            Log.d("agedumonsieur", person.age.toString())
        }


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