package com.emk.createpdfkotlin

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.fragment.app.Fragment
import com.github.gcacace.signaturepad.views.SignaturePad
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

/**
 * A simple [Fragment] subclass.
 */
class SignatureFragment : Fragment() {

    @Override
    override fun onPause() {
        try {

            super.onPause()
        }
        catch(e1: OutOfMemoryError)
        {
            Log.e("Memory exceptions", "exceptions" + e1)
            return
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_signature, container, false)

            writePermissionApproved()
            readPermissionApproved()

            val mClearButton = view.findViewById<View>(R.id.clear_button)
            val mSaveButton = view.findViewById<View>(R.id.save_button)

            val mSignaturePad = view.findViewById<View>(R.id.signature_pad) as SignaturePad

                //SignaturePad Listener
                mSignaturePad.setOnSignedListener(object : SignaturePad.OnSignedListener {
                        override fun onStartSigning() {
                            //Toast.makeText(activity, "OnStartSigning", Toast.LENGTH_SHORT).show()
                        }

                        override fun onSigned() {
                            mSaveButton.isEnabled = true
                            mClearButton.isEnabled = true
                        }

                        override fun onClear() {
                            mSaveButton?.isEnabled = false
                            mClearButton?.isEnabled = false
                        }
                    })

        @Throws(IOException::class)
        fun saveBitmapToJPG(bitmap: Bitmap, photo: File?) {
            val newBitmap =
                Bitmap.createBitmap(bitmap.width, bitmap.height, Bitmap.Config.ARGB_8888) // Image Size
            val canvas = Canvas(newBitmap)
            canvas.drawColor(Color.WHITE)
            canvas.drawBitmap(bitmap, 0f, 0f, null)
            val stream: OutputStream = FileOutputStream(photo)
            newBitmap.compress(Bitmap.CompressFormat.JPEG, 80, stream)
            stream.close()
        }

        fun scanMediaFile(photo: File) {
                val mediaScanIntent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
            val contentUri = Uri.fromFile(photo)
            mediaScanIntent.data = contentUri
            activity?.sendBroadcast(mediaScanIntent)
        }

        fun getAlbumStorageDir(albumName: String?): File? {
            // Get the directory for the user's public pictures directory.
            val file = File(
                Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_PICTURES
                ), albumName
            )
            val filePath = file.toString()
            Log.d("FileInputStreamDebugTag", "Value: $filePath")
            if (!file.mkdirs()) {
                Log.e("SignaturePad", "Directory not created")
            }
            return file
        }

        fun addJpgSignatureToGallery(signature: Bitmap): Boolean {
            var result = false
            try {
                    val photo = File(
                        getAlbumStorageDir("UserSignature"),
                        String.format("Signature.jpg")
                )//Image name and Location
                saveBitmapToJPG(signature, photo)
                scanMediaFile(photo)
                result = true
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return result
        }

            mClearButton.setOnClickListener { mSignaturePad.clear() }
            mSaveButton.setOnClickListener {
                val signatureBitmap = mSignaturePad.signatureBitmap
                if (addJpgSignatureToGallery(signatureBitmap)) {
                    Toast.makeText(
                        activity,
                        "İmzanız başarıyla kaydedildi.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        activity,
                        "İmza kaydı yapılamadı.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }



        return view
    }

    private fun writePermissionApproved(): Boolean {

        val context = context ?: return false

        return PackageManager.PERMISSION_GRANTED == checkSelfPermission(
            context,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
    }


    private fun readPermissionApproved(): Boolean {

        val context = context ?: return false

        return PackageManager.PERMISSION_GRANTED == checkSelfPermission(
            context,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
    }

}
