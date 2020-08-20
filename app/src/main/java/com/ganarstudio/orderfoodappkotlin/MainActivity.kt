package com.ganarstudio.orderfoodappkotlin

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ganarstudio.orderfoodappkotlin.Remote.ICloudFunctions
import com.google.firebase.auth.FirebaseAuth
import dmax.dialog.SpotsDialog
import io.reactivex.disposables.CompositeDisposable

class MainActivity : AppCompatActivity() {

    private lateinit var firebaseAuth:FirebaseAuth
    private lateinit var listener:FirebaseAuth.AuthStateListener
    private lateinit var dialog: AlertDialog
    private val compositionDisposable = CompositeDisposable()
    private lateinit var cloudFunctions:ICloudFunctions

    companion object{
        private val APP_REQUEST_CODE = 7171
    }

    override fun onStart() {
        super.onStart()
        firebaseAuth.addAuthStateListener { listener }
    }

    override fun onStop() {
        if (listener != null)
            firebaseAuth.removeAuthStateListener { listener }
        compositionDisposable.clear()
        super.onStop()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        firebaseAuth = FirebaseAuth.getInstance()
        dialog = SpotsDialog.Builder().setContext(this).setCancelable(false).build()
        //cloudFunctions = RetrofitCloudClient.
        listener = FirebaseAuth.AuthStateListener { firebaseAuth ->
            val user = firebaseAuth.currentUser
            if (user != null) {
                Toast.makeText(this@MainActivity, "Already login", Toast.LENGTH_SHORT).show()
            } else {
                //not login
                //val accesToken = AccesK
                //if (acce)
                phoneLogin()
            }

        }
    }

    private fun phoneLogin() {
        //12 20
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == APP_REQUEST_CODE){}
//            handelFacebookLoginResult

    }
}