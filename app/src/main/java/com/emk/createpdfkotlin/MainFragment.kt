package com.emk.createpdfkotlin


import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.print.PrintAttributes
import android.print.PrintManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.itextpdf.text.*
import com.itextpdf.text.pdf.BaseFont
import com.itextpdf.text.pdf.PdfWriter
import com.itextpdf.text.pdf.draw.LineSeparator
import com.itextpdf.text.pdf.draw.VerticalPositionMark
import kotlinx.android.synthetic.main.fragment_main.view.*
import java.io.*


class MainFragment : Fragment() {
    private val file_name: String = "test_pdf.pdf"
    private val file_name_location: String = "/storage/emulated/0/CreatePDFKotlin/test_pdf.pdf"
    //private val sharedPrefs = activity?.getPreferences(Context.MODE_PRIVATE)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        //Setting the main fragment layout for this
        val view: View = inflater.inflate(R.layout.fragment_main, container, false)

        //val editor = sharedPrefs?.edit()

        view.btn_create_pdf?.setOnClickListener{
            createPDFFile(Common.getAppPath(this) + file_name)

        }
        view.btn_create_pdf2.setOnClickListener{
            createPDFFile2(Common.getAppPath(this) + file_name)

        }
        view.btn_create_pdf3.setOnClickListener{

            createPDFFile3(Common.getAppPath(this) + file_name)

        }

        view.btn_create_pdf4.setOnClickListener{

            Toast.makeText(activity,"Under Construction",Toast.LENGTH_SHORT).show()
        }
        view.btn_create_pdf5.setOnClickListener{

            Toast.makeText(activity,"Under Construction",Toast.LENGTH_SHORT).show()

        }

        view.btn_create_pdf6.setOnClickListener{

            popUpEditText()

        }
        view.btn_create_pdf7.setOnClickListener{

            Toast.makeText(activity,"Under Construction",Toast.LENGTH_SHORT).show()

        }

        view.btn_create_pdf8.setOnClickListener{

            createPDFFile8(Common.getAppPath(this) + file_name)
        }
        view.btn_create_pdf9.setOnClickListener{

            createPDFFile9(Common.getAppPath(this) + file_name)
        }

        view.btn_create_pdf10?.setOnClickListener{

            createPDFFile10(Common.getAppPath(this) + file_name)

        }

        // Inflate the layout for this fragment
        return view
    }

//    fun getSharedPrefsData()
//    {
//
//        val pref = activity!!.getPreferences(Context.MODE_PRIVATE)
//        val name = pref.getString("NAME", "DEFAULT_VALUE")
//        val facility = pref.getString("FACILITY", "DEFAULT_VALUE")
//        val branch = pref.getString("BRANCH", "DEFAULT_VALUE")
//        val telNumber = pref.getString("TELNUMBER", "DEFAULT_VALUE")
//        val tcNo = pref.getString("TCNUMBER", "DEFAULT_VALUE")
//    }

    private fun createPDFFile(path: String) {
        if(File(path).exists())
            File(path).delete()
        try {
            val document = Document()
            //Save
            PdfWriter.getInstance(document, FileOutputStream(path))
            //Open to Write
            document.open()
            //Settings
            document.pageSize = PageSize.A4
            document.addCreationDate()
            document.addAuthor("AUTHOR_NAME")
            document.addCreator("CREATOR_NAME")



            //Font Settings
            val colorAccent = BaseColor(0, 153, 204, 255)
            val headingFontSize = 20.0f
            val valueFontSize = 26.0f


            //Custom Font
            //Turkish Language support now live. BaseFont.IDENTITIY_H grants the Turkish Language Support
            val fontName =
                BaseFont.createFont(
                    "assets/fonts/roboto_medium.ttf",
                    BaseFont.IDENTITY_H,
                    BaseFont.EMBEDDED
                )
            val pref = activity!!.getPreferences(Context.MODE_PRIVATE)
            val name = pref.getString("NAME", "DEFAULT_VALUE")
            val facility = pref.getString("FACILITY", "DEFAULT_VALUE")
            val branch = pref.getString("BRANCH", "DEFAULT_VALUE")
            val telNumber = pref.getString("TELNUMBER", "DEFAULT_VALUE")
            val tcNo = pref.getString("TCNUMBER", "DEFAULT_VALUE")

            //Title

            val titleStyle = Font(fontName, 36.0f, Font.NORMAL, BaseColor.BLACK)
            addNewItem(document, "Başlık", Element.ALIGN_CENTER, titleStyle)

            val headingStyle = Font(fontName, headingFontSize, Font.NORMAL, colorAccent)
            addNewItem(document, "Header", Element.ALIGN_LEFT, headingStyle)

            val valueStyle = Font(fontName, valueFontSize, Font.NORMAL, BaseColor.BLACK)
            addNewItem(document, "Value Style", Element.ALIGN_LEFT, valueStyle)

            addLineSeperator(document)

            addNewItem(document, "TEMEL", Element.ALIGN_LEFT, headingStyle)
            addNewItem(document, "DURSUN", Element.ALIGN_LEFT, valueStyle)
            addNewItem(document, name.toString(), Element.ALIGN_LEFT, valueStyle)

            addLineSeperator(document)

            addNewItem(document, "IDRIS", Element.ALIGN_LEFT, headingStyle)
            addNewItem(document, "ELBA", Element.ALIGN_LEFT, valueStyle)

            //ITEMS
            addNewItemWithLeftAndRight(document, "Hamsi", "(0.0%)", titleStyle, valueStyle)
            addNewItemWithLeftAndRight(document, "Hamsi2", "20", titleStyle, valueStyle)

            addLineSeperator(document)

            //TOTAL
            addLineSpace(document)
            addLineSpace(document)

            addNewItemWithLeftAndRight(document, "TOTAL", "20", titleStyle, valueStyle)

            //close

            document.close()
            Toast.makeText(activity, "BAŞARILI!", Toast.LENGTH_LONG).show()

            printPDF()




        } catch (e: Exception) {
            Log.e("ERROR", "" + e.message)

        }
    }

    private fun createPDFFile2(path: String) {
        if(File(path).exists())
            File(path).delete()
        try {
            val document = Document()
            //Save
            PdfWriter.getInstance(document, FileOutputStream(path))
            //Open to Write
            document.open()
            //Settings
            document.pageSize = PageSize.A4
            document.addCreationDate()
            document.addAuthor("AUTHOR_NAME")
            document.addCreator("CREATOR_NAME")



            //Font Settings
            val colorAccent = BaseColor(0, 153, 204, 255)
            val headingFontSize = 20.0f
            val valueFontSize = 26.0f


            //Custom Font
            //Turkish Language support now live. BaseFont.IDENTITIY_H grants the Turkish Language Support
            val fontName =
                BaseFont.createFont(
                    "assets/fonts/roboto_medium.ttf",
                    BaseFont.IDENTITY_H,
                    BaseFont.EMBEDDED
                )

            //Getting data from UserFragment using SharedPreferences
            val pref = activity!!.getPreferences(Context.MODE_PRIVATE)
            val name = pref.getString("NAME", "DEFAULT_NAME")
            val facility = pref.getString("FACILITY", "DEFAULT_FACILITY")
            val branch = pref.getString("BRANCH", "DEFAULT_BRANCH")
            val telNumber = pref.getString("TELNUMBER", "DEFAULT_TELNUMBER")
            val tcNo = pref.getString("TCNUMBER", "DEFAULT_TCNO")

            //Title

            val titleStyle = Font(fontName, 36.0f, Font.NORMAL, BaseColor.BLACK)
            addNewItem(document, "SAKARYA ÜNİVERSİTESİ DENEME FORMU", Element.ALIGN_CENTER, titleStyle)

            val headingStyle = Font(fontName, headingFontSize, Font.NORMAL, colorAccent)
            addNewItem(document, "İsim", Element.ALIGN_LEFT, headingStyle)

            val valueStyle = Font(fontName, valueFontSize, Font.NORMAL, BaseColor.BLACK)
            addNewItem(document, name.toString(), Element.ALIGN_LEFT, valueStyle)

            addLineSeperator(document)

            addNewItem(document, "Fakülte", Element.ALIGN_LEFT, headingStyle)
            addNewItem(document, facility.toString(), Element.ALIGN_LEFT, valueStyle)

            addNewItem(document, "Branş", Element.ALIGN_LEFT, headingStyle)
            addNewItem(document, branch.toString(), Element.ALIGN_LEFT, valueStyle)

            addLineSeperator(document)

            addNewItem(document, "Telefon No ve TC No", Element.ALIGN_LEFT, headingStyle)

            //ITEMS
            addNewItemWithLeftAndRight(document, "Telefon No", telNumber.toString(), titleStyle, valueStyle)
            addNewItemWithLeftAndRight(document, "TC Kimlik No", tcNo.toString(), titleStyle, valueStyle)

            addLineSeperator(document)

            //close

            document.close()
            Toast.makeText(activity, "BAŞARILI!", Toast.LENGTH_LONG).show()

            printPDF()




        } catch (e: Exception) {
            Log.e("ERROR", "" + e.message)

        }
    }

    private fun createPDFFile3(path: String) {
        if(File(path).exists())
            File(path).delete()
        try {
          val document = Document()
            //Save
            PdfWriter.getInstance(document, FileOutputStream(path))
            //Open to Write
            document.open()
            //Settings
            document.pageSize = PageSize.A4
            document.addCreationDate()
            document.addAuthor("AUTHOR_NAME")
            document.addCreator("CREATOR_NAME")



            //Font Settings
            val colorAccent = BaseColor(0, 153, 204, 255)
            val headingFontSize = 20.0f
            val valueFontSize = 26.0f


            //Custom Font
            //Turkish Language support now live. BaseFont.IDENTITIY_H grants the Turkish Language Support
            val fontName =
                BaseFont.createFont(
                    "assets/fonts/roboto_medium.ttf",
                    BaseFont.IDENTITY_H,
                    BaseFont.EMBEDDED
                )

            //Getting data from UserFragment using SharedPreferences
            val pref = activity!!.getPreferences(Context.MODE_PRIVATE)
            val name = pref.getString("NAME", "DEFAULT_NAME")
            val facility = pref.getString("FACILITY", "DEFAULT_FACILITY")
            val branch = pref.getString("BRANCH", "DEFAULT_BRANCH")
            val telNumber = pref.getString("TELNUMBER", "DEFAULT_TELNUMBER")
            val tcNo = pref.getString("TCNUMBER", "DEFAULT_TCNO")

            //Title

            val titleStyle = Font(fontName, 36.0f, Font.NORMAL, BaseColor.BLACK)
            addNewItem(document, "SAKARYA ÜNİVERSİTESİ DENEME FORMU", Element.ALIGN_CENTER, titleStyle)

            val headingStyle = Font(fontName, headingFontSize, Font.NORMAL, colorAccent)
            addNewItem(document, "İsim", Element.ALIGN_LEFT, headingStyle)

            val valueStyle = Font(fontName, valueFontSize, Font.NORMAL, BaseColor.BLACK)
            addNewItem(document, name.toString(), Element.ALIGN_LEFT, valueStyle)

            addLineSeperator(document)

            addNewItem(document, "Fakülte", Element.ALIGN_LEFT, headingStyle)
            addNewItem(document, facility.toString(), Element.ALIGN_LEFT, valueStyle)

            addNewItem(document, "Branş", Element.ALIGN_LEFT, headingStyle)
            addNewItem(document, branch.toString(), Element.ALIGN_LEFT, valueStyle)

            addLineSeperator(document)

            addNewItem(document, "Telefon No ve TC No", Element.ALIGN_LEFT, headingStyle)

            //ITEMS
            addNewItemWithLeftAndRight(document, "Telefon No", telNumber.toString(), titleStyle, valueStyle)
            addNewItemWithLeftAndRight(document, "TC Kimlik No", tcNo.toString(), titleStyle, valueStyle)

            addLineSeperator(document)

//            addNewItem(document, "Alert Value: ", Element.ALIGN_LEFT, headingStyle)
//            addNewItem(document, editTextValue.toString(), Element.ALIGN_LEFT, valueStyle)

            //close

            document.close()
            Toast.makeText(activity, "BAŞARILI!", Toast.LENGTH_LONG).show()

            printPDF()




        } catch (e: Exception) {
            Log.e("ERROR", "" + e.message)

        }
    }

    private fun createPDFFile6(path: String) {
        if(File(path).exists())
            File(path).delete()
        try {
            val document = Document()
            //Save
            PdfWriter.getInstance(document, FileOutputStream(path))
            //Open to Write
            document.open()
            //Settings
            document.pageSize = PageSize.A4
            document.addCreationDate()
            document.addAuthor("AUTHOR_NAME")
            document.addCreator("CREATOR_NAME")



            //Font Settings
            val colorAccent = BaseColor(0, 153, 204, 255)
            val headingFontSize = 20.0f
            val valueFontSize = 26.0f


            //Custom Font
            //Turkish Language support now live. BaseFont.IDENTITIY_H grants the Turkish Language Support
            val fontName =
                BaseFont.createFont(
                    "assets/fonts/roboto_medium.ttf",
                    BaseFont.IDENTITY_H,
                    BaseFont.EMBEDDED
                )

            //Getting data from UserFragment using SharedPreferences
            val pref = activity!!.getPreferences(Context.MODE_PRIVATE)
            val name = pref.getString("NAME", "DEFAULT_NAME")
            val facility = pref.getString("FACILITY", "DEFAULT_FACILITY")
            val branch = pref.getString("BRANCH", "DEFAULT_BRANCH")
            val telNumber = pref.getString("TELNUMBER", "DEFAULT_TELNUMBER")
            val tcNo = pref.getString("TCNUMBER", "DEFAULT_TCNO")

            //Title

            val titleStyle = Font(fontName, 36.0f, Font.NORMAL, BaseColor.BLACK)
            addNewItem(document, "SAKARYA ÜNİVERSİTESİ DENEME FORMU", Element.ALIGN_CENTER, titleStyle)

            val headingStyle = Font(fontName, headingFontSize, Font.NORMAL, colorAccent)
            addNewItem(document, "İsim", Element.ALIGN_LEFT, headingStyle)

            val valueStyle = Font(fontName, valueFontSize, Font.NORMAL, BaseColor.BLACK)
            addNewItem(document, name.toString(), Element.ALIGN_LEFT, valueStyle)

            addLineSeperator(document)

            addNewItem(document, "Fakülte", Element.ALIGN_LEFT, headingStyle)
            addNewItem(document, facility.toString(), Element.ALIGN_LEFT, valueStyle)

            addNewItem(document, "Branş", Element.ALIGN_LEFT, headingStyle)
            addNewItem(document, branch.toString(), Element.ALIGN_LEFT, valueStyle)

            addLineSeperator(document)

            addNewItem(document, "Telefon No ve TC No", Element.ALIGN_LEFT, headingStyle)

            //ITEMS
            addNewItemWithLeftAndRight(document, "Telefon No", telNumber.toString(), titleStyle, valueStyle)
            addNewItemWithLeftAndRight(document, "TC Kimlik No", tcNo.toString(), titleStyle, valueStyle)

            addLineSeperator(document)

            //close

            document.close()
            Toast.makeText(activity, "BAŞARILI!", Toast.LENGTH_LONG).show()

            printPDF()




        } catch (e: Exception) {
            Log.e("ERROR", "" + e.message)

        }
    }


    private fun createPDFFile8(path: String) {
        if(File(path).exists())
            File(path).delete()
        val any = try {
            val document = Document()
            //Save
            PdfWriter.getInstance(document, FileOutputStream(path))
            //Open to Write
            document.open()
            //Settings
            document.pageSize = PageSize.A4
            document.addCreationDate()
            document.addAuthor("AUTHOR_NAME")
            document.addCreator("CREATOR_NAME")



            //Font Settings
            val colorAccent = BaseColor(0, 153, 204, 255)
            val headingFontSize = 20.0f
            val valueFontSize = 26.0f


            //Custom Font
            //Turkish Language support now live. BaseFont.IDENTITIY_H grants the Turkish Language Support
            val fontName =
                BaseFont.createFont(
                    "assets/fonts/roboto_medium.ttf",
                    BaseFont.IDENTITY_H,
                    BaseFont.EMBEDDED
                )

            //Getting data from UserFragment using SharedPreferences
            val pref = activity!!.getPreferences(Context.MODE_PRIVATE)
            val name = pref.getString("NAME", "DEFAULT_NAME")
            val facility = pref.getString("FACILITY", "DEFAULT_FACILITY")
            val branch = pref.getString("BRANCH", "DEFAULT_BRANCH")
            val telNumber = pref.getString("TELNUMBER", "DEFAULT_TELNUMBER")
            val tcNo = pref.getString("TCNUMBER", "DEFAULT_TCNO")

            //Title

            val titleStyle = Font(fontName, 36.0f, Font.NORMAL, BaseColor.BLACK)
            addNewItem(document, "SAKARYA ÜNİVERSİTESİ DENEME FORMU", Element.ALIGN_CENTER, titleStyle)

            val headingStyle = Font(fontName, headingFontSize, Font.NORMAL, colorAccent)
            addNewItem(document, "İsim", Element.ALIGN_LEFT, headingStyle)

            val valueStyle = Font(fontName, valueFontSize, Font.NORMAL, BaseColor.BLACK)
            addNewItem(document, name.toString(), Element.ALIGN_LEFT, valueStyle)

            addLineSeperator(document)

            addNewItem(document, "Fakülte", Element.ALIGN_LEFT, headingStyle)
            addNewItem(document, facility.toString(), Element.ALIGN_LEFT, valueStyle)

            addNewItem(document, "Branş", Element.ALIGN_LEFT, headingStyle)
            addNewItem(document, branch.toString(), Element.ALIGN_LEFT, valueStyle)

            addLineSeperator(document)

            addNewItem(document, "Telefon No ve TC No", Element.ALIGN_LEFT, headingStyle)

            //ITEMS
            addNewItemWithLeftAndRight(document, "Telefon No", telNumber.toString(), titleStyle, valueStyle)
            addNewItemWithLeftAndRight(document, "TC Kimlik No", tcNo.toString(), titleStyle, valueStyle)

            addLineSeperator(document)

            //close

            document.close()
//            val file: File = File.createTempFile("test","pdf")
//            var writer = PdfWriter.getInstance(document, FileOutputStream(file.path))

            sendPDF()




        } catch (e: Exception) {
            Log.e("ERROR", "" + e.message)

        }
    }

    private fun createPDFFile9(path: String) {
        if(File(path).exists())
            File(path).delete()
        val any = try {
            val document = Document()
            //Save
            PdfWriter.getInstance(document, FileOutputStream(path))
            //Open to Write
            document.open()
            //Settings
            document.pageSize = PageSize.A4
            document.addCreationDate()
            document.addAuthor("AUTHOR_NAME")
            document.addCreator("CREATOR_NAME")



            //Font Settings
            val colorAccent = BaseColor(0, 153, 204, 255)
            val headingFontSize = 20.0f
            val valueFontSize = 26.0f


            //Custom Font
            //Turkish Language support now live. BaseFont.IDENTITIY_H grants the Turkish Language Support
            val fontName =
                BaseFont.createFont(
                    "assets/fonts/roboto_medium.ttf",
                    BaseFont.IDENTITY_H,
                    BaseFont.EMBEDDED
                )

            val titleStyle = Font(fontName, 36.0f, Font.NORMAL, BaseColor.BLACK)
            addNewItem(document, "JPG DENEME", Element.ALIGN_CENTER, titleStyle)


            addImage(document)

            //close

            document.close()
            Toast.makeText(activity, "BAŞARILI!", Toast.LENGTH_LONG).show()

            printPDF()




        } catch (e: Exception) {
            Log.e("ERROR", "" + e.message)
            Toast.makeText(activity, e.message, Toast.LENGTH_LONG).show()

        }
    }

    private fun createPDFFile10(path: String) {
        if(File(path).exists())
            File(path).delete()
        val any = try {
            val document = Document()
            //Save
            PdfWriter.getInstance(document, FileOutputStream(path))
            //Open to Write
            document.open()
            //Settings
            document.pageSize = PageSize.A4
            document.addCreationDate()
            document.addAuthor("AUTHOR_NAME")
            document.addCreator("CREATOR_NAME")



            //Font Settings
            val colorAccent = BaseColor(0, 153, 204, 255)
            val headingFontSize = 20.0f
            val valueFontSize = 26.0f


            //Custom Font
            //Turkish Language support now live. BaseFont.IDENTITIY_H grants the Turkish Language Support
            val fontName =
                BaseFont.createFont(
                    "assets/fonts/roboto_medium.ttf",
                    BaseFont.IDENTITY_H,
                    BaseFont.EMBEDDED
                )

            val titleStyle = Font(fontName, 36.0f, Font.NORMAL, BaseColor.BLACK)
            addNewItem(document, "JPG DENEME", Element.ALIGN_CENTER, titleStyle)


            addImageFromGallery(document)

            //close

            document.close()
            Toast.makeText(activity, "BAŞARILI!", Toast.LENGTH_LONG).show()

            printPDF()




        } catch (e: Exception) {
            Log.e("ERROR", "" + e.message)
            Toast.makeText(activity, e.message, Toast.LENGTH_LONG).show()

        }
    }

    private fun sendPDF() {
        try {
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
            val eMailIntent = Intent(Intent.ACTION_SEND, Uri.parse("mailto:MAILADRESS")).apply {
                putExtra(Intent.EXTRA_SUBJECT, "DENEME")
                putExtra(Intent.EXTRA_TEXT, "DENEME")
                putExtra(Intent.EXTRA_STREAM, file_name_location)
            }
            eMailIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            eMailIntent.type = "text/plain"
            startActivity(eMailIntent)
        }
        catch (e:Exception)
        {
            Log.e("PRINTING ERROR", e.message)
        }


    }

    private fun printPDF() {
        val printManager = activity?.getSystemService(Context.PRINT_SERVICE) as PrintManager
        try {
            val printAdapter = activity?.let { PdfDocumentAdapter(it,Common.getAppPath(this)+file_name) }
            if (printAdapter != null) {
                printManager.print("Document",printAdapter, PrintAttributes.Builder().build())
            }

        }catch (e:Exception)
        {
            Log.e("PRINTING ERROR", e.message)
        }
    }


    @Throws(DocumentException::class)
    private fun addNewItemWithLeftAndRight(
        document: Document,
        textLeft: String,
        textRight: String,
        leftStyle: Font,
        rightStyle: Font
    ) {
        val chunkTextLeft = Chunk(textLeft,leftStyle)
        val chunkTextRight = Chunk(textRight,rightStyle)
        val p = Paragraph(chunkTextLeft)
        p.add(Chunk(VerticalPositionMark()))
        p.add(chunkTextRight)
        document.add(p)

    }

    @Throws(DocumentException::class)
    private fun addLineSeperator(document: Document) {
        val lineSeparator = LineSeparator()
        lineSeparator.lineColor = BaseColor(0,0,0,68)
        addLineSpace(document)
        document.add(Chunk(lineSeparator))
        addLineSpace(document)
    }

    @Throws(DocumentException::class)
    private fun addLineSpace(document: Document) {
        document.add(Paragraph(""))

    }

    @Throws(DocumentException::class)
    private fun addNewItem(document: Document, text: String, align: Int, style: Font) {
        val chunk = Chunk(text,style)
        val p = Paragraph(chunk)
        p.alignment = align
        document.add(p)

    }

    @Throws(DocumentException::class , IOException::class)
    private fun addImage(document: Document)
    {
        try {
            val rectDoc = document.pageSize
            val width = rectDoc.width
            val height = rectDoc.height
            val imageStartX = width - document.rightMargin() - 300f//Absolute Position X
            val imageStartY = height - document.topMargin() - 500f//Absolute Position Y
            System.gc()

            val ims: InputStream? = activity?.assets?.open("imageAssets/cat.jpg")//File Location
            val bmp = BitmapFactory.decodeStream(ims)
            val stream = ByteArrayOutputStream()
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, stream)
            val byteArray: ByteArray = stream.toByteArray()

            val img = Image.getInstance(byteArray) // img.scalePercent(50);
            img.alignment = Image.TEXTWRAP
            img.scaleAbsolute(200f, 200f) // ReAdjusting the JPG
            img.setAbsolutePosition(imageStartX, imageStartY) // Adding Image
            document.add(img)
        } catch (e: Exception)
        {
            e.printStackTrace()
            Log.e("JPG ERROR", e.message)
        }
    }

    @Throws(DocumentException::class , IOException::class)
    private fun addImageFromGallery(document: Document)
    {
        try {
            val rectDoc = document.pageSize
            val width = rectDoc.width
            val height = rectDoc.height
            val imageStartX = width - document.rightMargin() - 300f//Absolute Position X
            val imageStartY = height - document.topMargin() - 500f//Absolute Position Y
            System.gc()

            val fileLocation = "/storage/emulated/0/Pictures/UserSignature/Signature.jpg"
            val ims = FileInputStream(fileLocation)
            Log.d("FileInputStreamDebugTag", "Value: $ims")

            val bmp = BitmapFactory.decodeStream(ims)
            val stream = ByteArrayOutputStream()
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, stream)
            val byteArray: ByteArray = stream.toByteArray()

            val img = Image.getInstance(byteArray) // img.scalePercent(50);
            img.alignment = Image.TEXTWRAP
            img.scaleAbsolute(200f, 200f) // ReAdjusting the JPG
            img.setAbsolutePosition(imageStartX, imageStartY) // Adding Image
            document.add(img)
        } catch (e: Exception)
        {
            e.printStackTrace()
            Log.e("JPG ERROR", e.message)
        }
    }

    fun popUpEditText() {

        val alert = AlertDialog.Builder(activity)

        val editText = EditText(activity)
        alert.setMessage("Sebep")
        alert.setTitle("Gereken bilgiyi giriniz.")
        alert.setView(editText)
        alert.setPositiveButton("Onayla"
        ) { dialog, whichButton -> //What ever you want to do with the value
            //OR
//            val editTextValue = editText.text.toString()
//            Log.d("editTextValue", "Value: $editTextValue")
            val editTextValue = editText.text.toString()
            createPDFFile6(Common.getAppPath(this) + file_name)

        }
        alert.show()
        
    }

}
