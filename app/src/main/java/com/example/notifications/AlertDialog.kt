package com.example.notifications
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_alert_dialog.*

class AlertDialog : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)
        button.setOnClickListener (){
            onAlert();
        }
    }

    fun onAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("New Update Found")
        builder.setMessage("Update your App")

        builder.setPositiveButton("Update Now") { dialog, id ->
            Toast.makeText(this, "Update your app", Toast.LENGTH_LONG).show()
        }
        builder.setNegativeButton("Cancel") { dialog, id ->
            Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
        }
        builder.setNeutralButton(("Remind me Later")) { dialog, id ->
            Toast.makeText(this, "Remind me Later", Toast.LENGTH_LONG).show()
        }
        builder.create()
        builder.show()
    }

    override fun onBackPressed() {
        val builder2 = AlertDialog.Builder(this)
        builder2.setTitle("Qutting from App")
        builder2.setMessage("Do you want to exit?")
        builder2.setPositiveButton("Continue"){
            dialog,id-> Toast.makeText(this,"Continued",Toast.LENGTH_LONG).show()
        }
        builder2.setNegativeButton("Quit"){
            dialog,id->Toast.makeText(this,"Quited",Toast.LENGTH_LONG).show()
        }
        builder2.create()
        builder2.show()
    }
}