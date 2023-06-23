package id.my.notewhy.myscoreboard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.github.kittinunf.fuel.Fuel
import id.my.notewhy.myscoreboard.R
import android.app.AlertDialog
import android.content.DialogInterface


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val hlp: Button = findViewById(R.id.hlp)
        val powerScoreboard: Button = findViewById(R.id.powerScoreboard)
        val switchPosition: Button = findViewById(R.id.switchPosition)
        val addPointLeft: Button = findViewById(R.id.addPointLeft)
        val addPointRight: Button = findViewById(R.id.addPointRight)
        val resetPoint: Button = findViewById(R.id.resetPoint)
        val minusPointLeft: Button = findViewById(R.id.minusPointLeft)
        val minusPointRight: Button = findViewById(R.id.minusPointRight)
        val addScoreLeft: Button = findViewById(R.id.addScoreLeft)
        val addScoreRight: Button = findViewById(R.id.addScoreRight)
        val resetScore: Button = findViewById(R.id.resetScore)
        val minusScoreLeft: Button = findViewById(R.id.minusScoreLeft)
        val minusScoreRight: Button = findViewById(R.id.minusScoreRight)

        hlp.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        powerScoreboard.setOnClickListener {
                // build alert dialog
                val dialogBuilder = AlertDialog.Builder(this)

                // set message of alert dialog
                dialogBuilder.setMessage("Apakah anda ingin mematikan/menyalakan scoreboard?")
                    // if the dialog is cancelable
                    .setCancelable(false)
                    // positive button text and action
                    .setPositiveButton("Ya", DialogInterface.OnClickListener {
                            dialog, id -> Fuel.post("http://192.168.4.1/powerscoreboard")
                            .response{request, response, result ->
                            println(request)
                            println(response)
                            val (bytes, error) = result
                            if (bytes != null) {
                                println("[response bytes ${String(bytes)}")
                            }
                        }
                    })
                    // negative button text and action
                    .setNegativeButton("Tidak", DialogInterface.OnClickListener {
                            dialog, id -> dialog.cancel()
                    })

                // create dialog box
                val alert = dialogBuilder.create()
                // set title for alert dialog box
                alert.setTitle("Power")
                // show alert dialog
                alert.show()
        }
        switchPosition.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this)

            // set message of alert dialog
            dialogBuilder.setMessage("Apakah anda ingin merubah posisi skor dan poin?")
                // if the dialog is cancelable
                .setCancelable(false)
                // positive button text and action
                .setPositiveButton("Ya", DialogInterface.OnClickListener {
                        dialog, id -> Fuel.post("http://192.168.4.1/switchposition")
                    .response{request, response, result ->
                        println(request)
                        println(response)
                        val (bytes, error) = result
                        if (bytes != null) {
                            println("[response bytes ${String(bytes)}")
                        }
                    }
                })
                // negative button text and action
                .setNegativeButton("Tidakk", DialogInterface.OnClickListener {
                        dialog, id -> dialog.cancel()
                })

            // create dialog box
            val alert = dialogBuilder.create()
            // set title for alert dialog box
            alert.setTitle("Switch")
            // show alert dialog
            alert.show()

        }
        addPointLeft.setOnClickListener {
            Fuel.post("http://192.168.4.1/addpointleft")
                .response{request, response, result ->
                    println(request)
                    println(response)
                    val (bytes, error) = result
                    if (bytes != null) {
                        println("[response bytes ${String(bytes)}")
                    }
                }
        }
        addPointRight.setOnClickListener {
            Fuel.post("http://192.168.4.1/addpointright")
                .response{request, response, result ->
                    println(request)
                    println(response)
                    val (bytes, error) = result
                    if (bytes != null) {
                        println("[response bytes ${String(bytes)}")
                    }
                }
        }
        resetPoint.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this)

            // set message of alert dialog
            dialogBuilder.setMessage("Apakah anda ingin mereset skor dan poin untuk memulai permainan baru?")
                // if the dialog is cancelable
                .setCancelable(false)
                // positive button text and action
                .setPositiveButton("Iya", DialogInterface.OnClickListener {
                        dialog, id -> Fuel.post("http://192.168.4.1/resetpoint")
                    .response{request, response, result ->
                        println(request)
                        println(response)
                        val (bytes, error) = result
                        if (bytes != null) {
                            println("[response bytes ${String(bytes)}")
                        }
                    }
                })
                // negative button text and action
                .setNegativeButton("Ga dulu", DialogInterface.OnClickListener {
                        dialog, id -> dialog.cancel()
                })

            // create dialog box
            val alert = dialogBuilder.create()
            // set title for alert dialog box
            alert.setTitle("Reset Point")
            // show alert dialog
            alert.show()

        }
        minusPointLeft.setOnClickListener {
            Fuel.post("http://192.168.4.1/minuspointleft")
                .response{request, response, result ->
                    println(request)
                    println(response)
                    val (bytes, error) = result
                    if (bytes != null) {
                        println("[response bytes ${String(bytes)}")
                    }
                }
        }
        minusPointRight.setOnClickListener {
            Fuel.post("http://192.168.4.1/minuspointright")
                .response{request, response, result ->
                    println(request)
                    println(response)
                    val (bytes, error) = result
                    if (bytes != null) {
                        println("[response bytes ${String(bytes)}")
                    }
                }
        }
        addScoreLeft.setOnClickListener {
            Fuel.post("http://192.168.4.1/addscoreleft")
                .response{request, response, result ->
                    println(request)
                    println(response)
                    val (bytes, error) = result
                    if (bytes != null) {
                        println("[response bytes ${String(bytes)}")
                    }
                }
        }
        addScoreRight.setOnClickListener {
            Fuel.post("http://192.168.4.1/addscoreright")
                .response { request, response, result ->
                    println(request)
                    println(response)
                    val (bytes, error) = result
                    if (bytes != null) {
                        println("[response bytes] ${String(bytes)}")
                    }
                }

        }
        resetScore.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this)

            // set message of alert dialog
            dialogBuilder.setMessage("Apakah anda ingin mereset skor?")
                // if the dialog is cancelable
                .setCancelable(false)
                // positive button text and action
                .setPositiveButton("Iye", DialogInterface.OnClickListener {
                        dialog, id -> Fuel.post("http://192.168.4.1/resetscore")
                    .response{request, response, result ->
                        println(request)
                        println(response)
                        val (bytes, error) = result
                        if (bytes != null) {
                            println("[response bytes ${String(bytes)}")
                        }
                    }
                })
                // negative button text and action
                .setNegativeButton("Tidakk", DialogInterface.OnClickListener {
                        dialog, id -> dialog.cancel()
                })

            // create dialog box
            val alert = dialogBuilder.create()
            // set title for alert dialog box
            alert.setTitle("Reset Score")
            // show alert dialog
            alert.show()
        }
        minusScoreLeft.setOnClickListener {
            Fuel.post("http://192.168.4.1/minusscoreleft")
                .response{request, response, result ->
                    println(request)
                    println(response)
                    val (bytes, error) = result
                    if (bytes != null) {
                        println("[response bytes ${String(bytes)}")
                    }
                }
        }
        minusScoreRight.setOnClickListener {
            Fuel.post("http://192.168.4.1/minusscoreright")
                .response{request, response, result ->
                    println(request)
                    println(response)
                    val (bytes, error) = result
                    if (bytes != null) {
                        println("[response bytes ${String(bytes)}")
                    }
                }
        }
    }
}