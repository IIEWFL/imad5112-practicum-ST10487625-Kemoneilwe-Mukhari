package vcmsa.ci.musicapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Initializing elements

        val addButton = findViewById<Button>(R.id.btnAddSong)
        val viewButton = findViewById<Button>(R.id.btnViewDetails)
        val exitButton = findViewById<Button>(R.id.btnExit)

        //Set Click listener for add button
        addButton.setOnClickListener {
            startActivity(Intent( this, AddSongActivity::class.java))
        }

        // Set Click Listener for view button
        viewButton.setOnClickListener {
            startActivity(Intent( this, DetailViewActivity::class.java))
        }

        // Set Click Listener for exit button
        exitButton.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }
    }
}