package com.emk.createpdfkotlin

import android.Manifest
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val manager = supportFragmentManager

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {item->

        when(item.itemId){
            R.id.nav_home ->{
                //Toast.makeText(this,"Home",Toast.LENGTH_SHORT).show()
                createFragmentMain()
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_user ->{
                createFragmentUser()
                //Toast.makeText(this,"User",Toast.LENGTH_SHORT).show()
                return@OnNavigationItemSelectedListener true
            }
//            R.id.nav_history -> {
//                createFragmentHistory()
//                //Toast.makeText(this,"History",Toast.LENGTH_SHORT).show()
//
//                return@OnNavigationItemSelectedListener true
//            }
            R.id.nav_signature ->{
                createFragmentSignature()
                //Toast.makeText(this,"Signature",Toast.LENGTH_LONG).show()

                return@OnNavigationItemSelectedListener true
            }
            else ->
            {
                createFragmentMain()
                Toast.makeText(this,"ERROR",Toast.LENGTH_SHORT).show()
                return@OnNavigationItemSelectedListener true
            }

        }

    }

    override fun onBackPressed() {

        val alert = AlertDialog.Builder(this)
        alert.setTitle("Çıkış")
        alert.setMessage("Çıkış yapılacaktır.\nOnaylıyor musunuz?")
        alert.setIcon(R.drawable.ic_error_black_24dp)

        alert.setPositiveButton("Evet")
        { _, _ ->
            finish()
        }

        alert.setNegativeButton("Hayır")
        {dialog, _ ->
            dialog.dismiss()
        }
        alert.show()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.fragmentHolder, MainFragment(), "").commit()
        if(savedInstanceState == null)
        {

        }



        Dexter.withActivity(this)
            .withPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            .withListener(object: PermissionListener{
                override fun onPermissionGranted(response: PermissionGrantedResponse?) {

                }

                override fun onPermissionRationaleShouldBeShown(
                    permission: PermissionRequest?,
                    token: PermissionToken?
                ) {

                }

                override fun onPermissionDenied(response: PermissionDeniedResponse?) {
                }

            })
            .check()


        nav_menu.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }

    private fun createFragmentUser()
    {
        val transaction = manager.beginTransaction()
        val fragment = UserFragment()



        transaction.replace(R.id.fragmentHolder,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun createFragmentHistory()
    {
        val transaction = manager.beginTransaction()
        val fragment = HistoryFragment()

        transaction.replace(R.id.fragmentHolder,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun createFragmentMain()
    {
        val transaction = manager.beginTransaction()
        val fragment = MainFragment()

        transaction.replace(R.id.fragmentHolder,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun createFragmentSignature()
    {
        val transaction = manager.beginTransaction()
        val fragment = SignatureFragment()

        transaction.replace(R.id.fragmentHolder,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}