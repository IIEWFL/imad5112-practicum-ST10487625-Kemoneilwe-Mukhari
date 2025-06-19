package vcmsa.ci.musicapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailViewActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_view)

        val tvDetails = findViewById<TextView>(R.id.tvSongDetails)
        val tvAverage = findViewById<TextView>(R.id.tvAverageRating)
        val backButton = findViewById<Button>(R.id.btnBack)

        tvDetails.text = getSongDetails()

        val avg = if (SongStorage.ratings.isNotEmpty())
            SongStorage.ratings.sum().toFloat() / SongStorage.ratings.size
        else 0f

        tvAverage.text = "Average rating: %.2f".format(avg)

        // Set a click Listener for back button
        backButton.setOnClickListener {
            startActivity(Intent( this, MainActivity::class.java))
        }

    }
    private fun getSongDetails(): String {
        val builder = StringBuilder()
        for (i in SongStorage.songTitles.indices) {
            builder.append("Title: ${SongStorage.songTitles[i]}\n")
            builder.append("Artist: ${SongStorage.artistNames[i]}\n")
            builder.append("Rating: ${SongStorage.ratings[i]}\n")
            builder.append("Comments: ${SongStorage.comments[i]}\n")

        }
        return if  (builder.isNotEmpty()) builder.toString() else "No songs added"


    }
}