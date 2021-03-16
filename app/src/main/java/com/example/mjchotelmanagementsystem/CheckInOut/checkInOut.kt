package com.example.mjchotelmanagementsystem.CheckInOut

import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.mjchotelmanagementsystem.R
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException


class checkInOut : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val root=inflater.inflate(R.layout.fragment_check_in_out, container, false)
        val button: Button =root.findViewById(R.id.button)
        val et="testing"

        button.setOnClickListener {
            val text=et
            val progressBar: ProgressBar = requireActivity().findViewById(R.id.progressBar_chkInOut)
            val textView: TextView =requireActivity().findViewById(R.id.textView)
            val textView2: TextView =requireActivity().findViewById(R.id.textView2)
            val textView_chkInOut_roomPw: TextView =requireActivity().findViewById(R.id.textView_chkInOut_roomPw)

            progressBar.visibility = View.VISIBLE
            if (text.isNotEmpty()){

                val imageView: ImageView =requireActivity().findViewById(R.id.imageView)
                val bitmap = generateQRCode("Sample Text")

                imageView.setImageBitmap(bitmap)
                progressBar.visibility = View.GONE
                textView.text="You're Checked In"
                button.visibility = View.INVISIBLE
                textView2.visibility = View.VISIBLE
                textView_chkInOut_roomPw.visibility=View.VISIBLE
            }
        }


        return root
    }

    private fun generateQRCode(text: String): Bitmap {
        val width = 700
        val height = 700
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val codeWriter = MultiFormatWriter()
        try {
            val bitMatrix = codeWriter.encode(text, BarcodeFormat.QR_CODE, width, height)
            for (x in 0 until width) {
                for (y in 0 until height) {
                    bitmap.setPixel(x, y, if (bitMatrix[x, y]) Color.BLACK else Color.WHITE)
                }
            }
        } catch (e: WriterException) {
            Log.d("checkInOut", "generateQRCode: ${e.message}")
        }
        return bitmap
    }

    override fun onDestroyView() {
        super.onDestroyView()

    }
}