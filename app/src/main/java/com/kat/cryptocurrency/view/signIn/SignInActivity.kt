package com.kat.cryptocurrency.view.signIn

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.kat.cryptocurrency.R
import com.kat.cryptocurrency.deps.provider.CoinProvider
import com.kat.cryptocurrency.view.home.MainActivity
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.sign_up.view.*
import org.jetbrains.anko.startActivity




class SignInActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        (application as CoinProvider).providesCoinComponent().inject(this)
        mAuth = FirebaseAuth.getInstance()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)


        fun initView() {

            supportActionBar?.title = "Sign In"

            btnSignUp.setOnClickListener {
                dialogSignUp()
            }

            btnLogin.setOnClickListener {
                signIn()
            }
        }

        initView()

    }

    fun signIn() {

        if (email.text.toString() == "") Toast.makeText(this@SignInActivity, "Email tidak boleh kosong", Toast.LENGTH_SHORT)
        if (pass.text.toString() == "") Toast.makeText(this@SignInActivity, "Pass tidak boleh kosong", Toast.LENGTH_SHORT)

        if (email.text.toString() != "" && pass.text.toString() != "") {
            progress_dialog.visibility = View.VISIBLE
            mAuth?.signInWithEmailAndPassword(email.text.toString(), pass.text.toString())
                    ?.addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            progress_dialog.visibility = View.GONE
                            Toast.makeText(this@SignInActivity, "Login Success", Toast.LENGTH_SHORT)
                            val user = mAuth!!.currentUser

                            startActivity<MainActivity>()

                        } else {
                            progress_dialog.visibility = View.GONE
                            Log.e(this@SignInActivity.toString(), "signInWithEmail:failure", task.exception)
                        }
                    }
        }

    }


    fun dialogSignUp() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Sign Up")

        val inflater = layoutInflater.inflate(R.layout.sign_up, null)

        builder.setView(inflater)
        val dialog = builder.create()

        inflater.btn_done.setOnClickListener {

            mAuth?.createUserWithEmailAndPassword(inflater.username.text.toString(), inflater.password.text.toString())
                    ?.addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {

                            val user = mAuth?.currentUser
                            Toast.makeText(this@SignInActivity, "Sign Up Success", Toast.LENGTH_SHORT)
                            dialog.dismiss()
                        } else {

                            Log.e(this@SignInActivity.toString(), "createUserWithEmail:failure", task.exception)
                        }
                    }
        }

        inflater.btnCancel.setOnClickListener {
            dialog.dismiss()

        }

        dialog.window.addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL)
        dialog.setCanceledOnTouchOutside(true)
        dialog.show()
    }


}
