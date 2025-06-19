package vcmsa.ci.musicapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddSongActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_song)

        val titleField = findViewById<EditText>(R.id.etTitle)
        val artistField = findViewById<EditText>(R.id.etArtist)
        val ratingField = findViewById<EditText>(R.id.etRating)
        val commentsField = findViewById<EditText>(R.id.etComments)
        val saveButton = findViewById<Button>(R.id.btnSaveSong)

        saveButton.setOnClickListener {

            val songTitle = titleField.text.toString()
            val artist = artistField.text.toString()
            val ratingText = ratingField.text.toString()
            val comments = commentsField.text.toString()

            val rating = ratingText.toIntOrNull()

            if (songTitle.isBlank() || artist.isBlank() || rating == null || rating !in 1..5) {
                Toast.makeText(this, "Enter all fields correctly.", Toast.LENGTH_SHORT).show()
            } else {
                SongStorage.songTitles.add(songTitle)
                SongStorage.artistNames.add(artist)
                SongStorage.ratings.add(rating)
                SongStorage.comments.add(comments)
                Toast.makeText(this, "Song Added!", Toast.LENGTH_SHORT).show()
                finish()

            }


        }


        }



        }

