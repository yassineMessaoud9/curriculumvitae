package tn.esprit.curriculumvitae

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.util.Patterns.EMAIL_ADDRESS
import android.widget.*
import android.widget.SeekBar.OnSeekBarChangeListener
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val nextBut = findViewById<Button>(R.id.next)
        val reset = findViewById<Button>(R.id.reset)
        val fullname = findViewById<EditText>(R.id.fulname)
        val age = findViewById<EditText>(R.id.age)
        val email = findViewById<EditText>(R.id.email)
        val seekandroid = findViewById<SeekBar>(R.id.android)
        val seekios = findViewById<SeekBar>(R.id.ios)
        val seekFlutter = findViewById<SeekBar>(R.id.flutter)

        val seekandval = findViewById<TextView>(R.id.androidval)
        var progandVal = 0
        val seekiosVal = findViewById<TextView>(R.id.iosval)
        var progiosval = 0
        val seekFlutterVal = findViewById<TextView>(R.id.flutterval)
        var progflutterval = 0

        seekandroid.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // Write code to perform some action when progress is changed.
                seekandval.setText(progress.toString())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is started.

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is stopped.
                progandVal = seekBar.progress
                Toast.makeText(
                    this@MainActivity,
                    "Android Progress is " + seekBar.progress + "%",
                    Toast.LENGTH_SHORT
                ).show()
            }

        })

        seekios.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // Write code to perform some action when progress is changed.
                seekiosVal.setText(progress.toString())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is started.

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is stopped.
                progiosval = seekBar.progress
                Toast.makeText(
                    this@MainActivity,
                    "Ios Progress is " + seekBar.progress + "%",
                    Toast.LENGTH_SHORT
                ).show()
            }

        })

        seekFlutter.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // Write code to perform some action when progress is changed.
                seekFlutterVal.setText(progress.toString())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is started.

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is stopped.
                progflutterval = seekBar.progress
                Toast.makeText(
                    this@MainActivity,
                    "Flutter Progress is " + seekBar.progress + "%",
                    Toast.LENGTH_SHORT
                ).show()
            }

        })
        nextBut.setOnClickListener {


            if (fullname.text.toString().trim().isNotEmpty() && age.text.toString().trim()
                    .isNotEmpty() && email.text.toString().trim().isNotEmpty()
            ) {
                if (!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()) {
                    Toast.makeText(this@MainActivity, "Verifier Votre mail", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    if (seekandroid.progress >= 80) {
                        Toast.makeText(
                            this@MainActivity,
                            "Vous êtes excellent en ANDROID !",
                            Toast.LENGTH_SHORT
                        ).show()

                    };  if (seekios.progress >= 80) {
                        Toast.makeText(
                            this@MainActivity,
                            "Vous êtes excellent en IOS !",
                            Toast.LENGTH_SHORT
                        ).show()

                    }; if (seekFlutter.progress >= 80) {
                        Toast.makeText(
                            this@MainActivity,
                            "Vous êtes excellent en Flutter !",
                            Toast.LENGTH_SHORT
                        ).show()

                    };
                     if(((seekandroid.progress)+(seekios.progress)+(seekFlutter.progress))<=90){
                        Toast.makeText(this@MainActivity, "Vous devez" +
                                "travailler vos skills !", Toast.LENGTH_SHORT).show()

                    }
                    else{
                        Toast.makeText(this@MainActivity,
                                "Vous avez de bons skills !", Toast.LENGTH_SHORT).show()
                    }
                    Toast.makeText(this@MainActivity, "Success !", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this@MainActivity, "Verifier vos champs !!", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        reset.setOnClickListener {
            fullname.setText(null)
            age.setText(null)
            email.setText(null)
            seekandroid.progress=0
            seekFlutter.progress=0
            seekios.progress=0
            Toast.makeText(this@MainActivity, "tous les champs sont vide", Toast.LENGTH_SHORT)
                .show()
        }

    }
}