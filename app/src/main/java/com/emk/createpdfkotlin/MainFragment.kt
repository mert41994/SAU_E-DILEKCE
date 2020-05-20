package com.emk.createpdfkotlin


import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
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
import com.itextpdf.text.pdf.PdfStamper
import com.itextpdf.text.pdf.PdfWriter
import com.itextpdf.text.pdf.draw.LineSeparator
import com.itextpdf.text.pdf.draw.VerticalPositionMark
import kotlinx.android.synthetic.main.fragment_main.view.*
import java.io.*
import java.text.SimpleDateFormat
import java.util.*


class MainFragment : Fragment() {
    private val sdf = SimpleDateFormat("dd/MM/yyyy")
    private val fileNameDate: String = SimpleDateFormat("yyyy.MM.dd'_'HH:mm:ss").toString()
    private val fileName: String = fileNameDate
    private var fileNameLocation: String = ""
    private val currentDate = sdf.format(Date())
    private var tempEditTextValue: String = "-"
    private var tempEditTextValue2: String = "-"
    private var tempEditTextValue3: String = "-"
    private var tempEditTextValue4: String = "-"
    private var tempEditTextValue5: String = "-"
    private var tempEditTextValue6: String = "-"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        //Setting the main fragment layout for this
        val view: View = inflater.inflate(R.layout.fragment_main, container, false)

            firstTimeAlert()

            view.btn_create_pdf.setOnClickListener {
                button1()

            }
            view.btn_create_pdf2.setOnClickListener {
                button2()

            }
            view.btn_create_pdf3.setOnClickListener {
                button3()

            }

            view.btn_create_pdf4.setOnClickListener {

                button4()
            }
            view.btn_create_pdf5.setOnClickListener {

                button5()

            }

            view.btn_create_pdf6.setOnClickListener {

                button6()

            }
            view.btn_create_pdf7.setOnClickListener {

                button7()

            }

            view.btn_create_pdf8.setOnClickListener {
                button8()

            }
            view.btn_create_pdf9.setOnClickListener {

                button9()
            }

            view.btn_create_pdf10?.setOnClickListener {

                button10()

            }

        // Inflate the layout for this fragment
        return view
    }


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
            val headingFontSize = 18.0f
            val valueFontSize = 26.0f
            val rightAndLeftFontSize = 15.0f


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
            val schoolNumber = pref.getString("SCHOOLNUMBER", "DEFAULT_VALUE")


            //Title

            val titleStyle = Font(fontName, 30.0f, Font.NORMAL, BaseColor.BLACK)
            addNewItem(document, "Sakarya Üniversitesi Sınav Not İtiraz Formu", Element.ALIGN_CENTER, titleStyle)
            addLineSeperator(document)
            addBlankLineSeperator(document)
            addBlankLineSeperator(document)
            addBlankLineSeperator(document)

            val headingStyle = Font(fontName, headingFontSize, Font.NORMAL, BaseColor.BLACK)
            val valueStyle = Font(fontName, valueFontSize, Font.NORMAL, BaseColor.BLACK)
            val leftAndRightStyle = Font(fontName, rightAndLeftFontSize, Font.NORMAL, BaseColor.BLACK)

            //addLineSeperator(document)
            addNewItem(document, facility.toString() + " ," + branch.toString() + " ," + schoolNumber.toString() +" numaralı öğrencisiyim. "+ tempEditTextValue + " isimli dersin " + tempEditTextValue2 + " sınav kağıdının tekrar incelenmmesini istiyorum.\nGereğini arz ederim.", Element.ALIGN_CENTER, headingStyle)
            addBlankLineSeperator(document)
            addBlankLineSeperator(document)
            addLineSeperator(document)

            //ITEMS
            addNewItemWithLeftAndRight(document, "Tarih:", currentDate.toString(), leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "Adı Soyadı:", name.toString(), leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "TC Kimlik No:", tcNo.toString(), leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "Telefon No:", telNumber.toString(), leftAndRightStyle, leftAndRightStyle)

            addImageFromGallery(document)

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
            val headingFontSize = 18.0f
            val valueFontSize = 26.0f
            val rightAndLeftFontSize = 15.0f


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
            val schoolNumber = pref.getString("SCHOOLNUMBER", "DEFAULT_VALUE")


            //Title

            val titleStyle = Font(fontName, 30.0f, Font.NORMAL, BaseColor.BLACK)
            addNewItem(document, "Sakarya Üniversitesi Kayıt Dondurma Formu", Element.ALIGN_CENTER, titleStyle)
            addLineSeperator(document)
            addBlankLineSeperator(document)
            addBlankLineSeperator(document)
            addBlankLineSeperator(document)

            val headingStyle = Font(fontName, headingFontSize, Font.NORMAL, BaseColor.BLACK)
            val valueStyle = Font(fontName, valueFontSize, Font.NORMAL, BaseColor.BLACK)
            val leftAndRightStyle = Font(fontName, rightAndLeftFontSize, Font.NORMAL, BaseColor.BLACK)

            //addLineSeperator(document)
            addNewItem(document, facility.toString() + " ," + branch.toString() + " ," + schoolNumber.toString() +" numaralı öğrencisiyim. "+ tempEditTextValue + " sebebinden dolayı " + tempEditTextValue2 + " döneminde kaydımı dondurmak istiyorum.\nGereğini arz ederim.", Element.ALIGN_CENTER, headingStyle)
            addBlankLineSeperator(document)
            addBlankLineSeperator(document)
            addLineSeperator(document)

            //ITEMS
            addNewItemWithLeftAndRight(document, "Tarih:", currentDate.toString(), leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "Adı Soyadı:", name.toString(), leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "TC Kimlik No:", tcNo.toString(), leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "Telefon No:", telNumber.toString(), leftAndRightStyle, leftAndRightStyle)

            addImageFromGallery(document)

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
            val headingFontSize = 18.0f
            val valueFontSize = 26.0f
            val rightAndLeftFontSize = 15.0f


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
            val schoolNumber = pref.getString("SCHOOLNUMBER", "DEFAULT_VALUE")


            //Title

            val titleStyle = Font(fontName, 30.0f, Font.NORMAL, BaseColor.BLACK)
            addNewItem(document, "Sakarya Üniversitesi Mezun Olmama İsteği Formu", Element.ALIGN_CENTER, titleStyle)
            addLineSeperator(document)
            addBlankLineSeperator(document)
            addBlankLineSeperator(document)
            addBlankLineSeperator(document)

            val headingStyle = Font(fontName, headingFontSize, Font.NORMAL, BaseColor.BLACK)
            val valueStyle = Font(fontName, valueFontSize, Font.NORMAL, BaseColor.BLACK)
            val leftAndRightStyle = Font(fontName, rightAndLeftFontSize, Font.NORMAL, BaseColor.BLACK)

            //addLineSeperator(document)
            addNewItem(document, facility.toString() + " ," + branch.toString() + " ," + schoolNumber.toString() +" numaralı öğrencisiyim. " + tempEditTextValue2 + " döneminde " + tempEditTextValue + " sebebinden dolayı mezun olmak istemiyorum.\nGereğini arz ederim.", Element.ALIGN_CENTER, headingStyle)
            addBlankLineSeperator(document)
            addBlankLineSeperator(document)
            addLineSeperator(document)

            //ITEMS
            addNewItemWithLeftAndRight(document, "Tarih:", currentDate.toString(), leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "Adı Soyadı:", name.toString(), leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "TC Kimlik No:", tcNo.toString(), leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "Telefon No:", telNumber.toString(), leftAndRightStyle, leftAndRightStyle)

            addImageFromGallery(document)

            //close

            document.close()
            Toast.makeText(activity, "BAŞARILI!", Toast.LENGTH_LONG).show()

            printPDF()




        } catch (e: Exception) {
            Log.e("ERROR", "" + e.message)

        }
    }

    private fun createPDFFile4(path: String) {
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
            val headingFontSize = 18.0f
            val valueFontSize = 26.0f
            val rightAndLeftFontSize = 15.0f


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
            val schoolNumber = pref.getString("SCHOOLNUMBER", "DEFAULT_VALUE")


            //Title

            val titleStyle = Font(fontName, 30.0f, Font.NORMAL, BaseColor.BLACK)
            addNewItem(document, "Sakarya Üniversitesi Öğretim Türü Değişikliği Formu", Element.ALIGN_CENTER, titleStyle)
            addLineSeperator(document)
            addBlankLineSeperator(document)
            addBlankLineSeperator(document)
            addBlankLineSeperator(document)

            val headingStyle = Font(fontName, headingFontSize, Font.NORMAL, BaseColor.BLACK)
            val valueStyle = Font(fontName, valueFontSize, Font.NORMAL, BaseColor.BLACK)
            val leftAndRightStyle = Font(fontName, rightAndLeftFontSize, Font.NORMAL, BaseColor.BLACK)

            //addLineSeperator(document)
            addNewItem(document, facility.toString() + " ," + branch.toString() + " ," + schoolNumber.toString() +" numaralı öğrencisiyim. "+ tempEditTextValue + " sebebinden dolayı 1. Öğretimden, 2. Öğretime geçiş yapmak istiyorum.\nGereğini arz ederim.", Element.ALIGN_CENTER, headingStyle)
            addBlankLineSeperator(document)
            addBlankLineSeperator(document)
            addLineSeperator(document)

            //ITEMS
            addNewItemWithLeftAndRight(document, "Tarih:", currentDate.toString(), leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "Adı Soyadı:", name.toString(), leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "TC Kimlik No:", tcNo.toString(), leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "Telefon No:", telNumber.toString(), leftAndRightStyle, leftAndRightStyle)

            addImageFromGallery(document)

            //close

            document.close()
            Toast.makeText(activity, "BAŞARILI!", Toast.LENGTH_LONG).show()

            printPDF()




        } catch (e: Exception) {
            Log.e("ERROR", "" + e.message)

        }
    }

    private fun createPDFFile5(path: String) {
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
            val headingFontSize = 18.0f
            val valueFontSize = 26.0f
            val rightAndLeftFontSize = 15.0f


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
            val schoolNumber = pref.getString("SCHOOLNUMBER", "DEFAULT_VALUE")


            //Title

            val titleStyle = Font(fontName, 30.0f, Font.NORMAL, BaseColor.BLACK)
            addNewItem(document, "Sakarya Üniversitesi Ders Sildirme Formu", Element.ALIGN_CENTER, titleStyle)
            addLineSeperator(document)
            addBlankLineSeperator(document)
            addBlankLineSeperator(document)
            addBlankLineSeperator(document)

            val headingStyle = Font(fontName, headingFontSize, Font.NORMAL, BaseColor.BLACK)
            val valueStyle = Font(fontName, valueFontSize, Font.NORMAL, BaseColor.BLACK)
            val leftAndRightStyle = Font(fontName, rightAndLeftFontSize, Font.NORMAL, BaseColor.BLACK)

            //addLineSeperator(document)
            addNewItem(document, facility.toString() + " ," + branch.toString() +"'nin " + schoolNumber.toString() + " numaralı öğrencisiyim. AKTS fazlalığından dolayı aşağıda belirttiğim ders/derslerin silinmesini arz ederim.", Element.ALIGN_CENTER, headingStyle)
            addBlankLineSeperator(document)
            addBlankLineSeperator(document)

            addNewItemWithLeftAndRight(document, "Silinecek Ders 1:", tempEditTextValue , leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "Silinecek Ders 2:", tempEditTextValue2 , leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "Silinecek Ders 3:", tempEditTextValue3 , leftAndRightStyle, leftAndRightStyle)
            addLineSeperator(document)

            //ITEMS
            addNewItemWithLeftAndRight(document, "Tarih:", currentDate.toString(), leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "Adı Soyadı:", name.toString(), leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "TC Kimlik No:", tcNo.toString(), leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "Telefon No:", telNumber.toString(), leftAndRightStyle, leftAndRightStyle)

            addImageFromGallery(document)

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
            val headingFontSize = 18.0f
            val valueFontSize = 26.0f
            val rightAndLeftFontSize = 15.0f


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
            val schoolNumber = pref.getString("SCHOOLNUMBER", "DEFAULT_VALUE")


            //Title

            val titleStyle = Font(fontName, 30.0f, Font.NORMAL, BaseColor.BLACK)
            addNewItem(document, "Sakarya Üniversitesi ÇAP Ders Saydırma Formu", Element.ALIGN_CENTER, titleStyle)
            addLineSeperator(document)
            addBlankLineSeperator(document)
            addBlankLineSeperator(document)
            addBlankLineSeperator(document)

            val headingStyle = Font(fontName, headingFontSize, Font.NORMAL, BaseColor.BLACK)
            val valueStyle = Font(fontName, valueFontSize, Font.NORMAL, BaseColor.BLACK)
            val leftAndRightStyle = Font(fontName, rightAndLeftFontSize, Font.NORMAL, BaseColor.BLACK)

            //addLineSeperator(document)
            addNewItem(document, facility.toString() + " ," + branch.toString() +"'nin " + schoolNumber.toString() + " numaralı öğrencisiyim. " + tempEditTextValue + " bölümünde ÇAP yapmaktayım." + tempEditTextValue + " bölümünde aldığım " + tempEditTextValue2 + " dersinin bölümümüzde verilen " + tempEditTextValue3 + " dersinin yerine sayılması hususunda gereğini arz ederim."  , Element.ALIGN_CENTER, headingStyle)
            addBlankLineSeperator(document)
            addBlankLineSeperator(document)

            addLineSeperator(document)

            //ITEMS
            addNewItemWithLeftAndRight(document, "Tarih:", currentDate.toString(), leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "Adı Soyadı:", name.toString(), leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "TC Kimlik No:", tcNo.toString(), leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "Telefon No:", telNumber.toString(), leftAndRightStyle, leftAndRightStyle)

            addImageFromGallery(document)

            //close

            document.close()
            Toast.makeText(activity, "BAŞARILI!", Toast.LENGTH_LONG).show()

            printPDF()




        } catch (e: Exception) {
            Log.e("ERROR", "" + e.message)

        }
    }

    private fun createPDFFile7(path: String) {
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
            val headingFontSize = 18.0f
            val valueFontSize = 26.0f
            val rightAndLeftFontSize = 15.0f


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
            val schoolNumber = pref.getString("SCHOOLNUMBER", "DEFAULT_VALUE")


            //Title

            val titleStyle = Font(fontName, 30.0f, Font.NORMAL, BaseColor.BLACK)
            addNewItem(document, "Sakarya Üniversitesi Tek Ders Kabul Formu", Element.ALIGN_CENTER, titleStyle)
            addLineSeperator(document)
            addBlankLineSeperator(document)
            addBlankLineSeperator(document)
            addBlankLineSeperator(document)

            val headingStyle = Font(fontName, headingFontSize, Font.NORMAL, BaseColor.BLACK)
            val valueStyle = Font(fontName, valueFontSize, Font.NORMAL, BaseColor.BLACK)
            val leftAndRightStyle = Font(fontName, rightAndLeftFontSize, Font.NORMAL, BaseColor.BLACK)

            //addLineSeperator(document)
            addNewItem(document, facility.toString() + " ," + branch.toString() +"'nin " + schoolNumber.toString() + " numaralı öğrencisiyim. Belirtmiş olduğum tek ders sınavına kabulüm konusunda gerekeni saygılarımla arz ederim.", Element.ALIGN_CENTER, headingStyle)
            addBlankLineSeperator(document)
            addBlankLineSeperator(document)

            addNewItemWithLeftAndRight(document, "Ders Adı:", tempEditTextValue , valueStyle, valueStyle)
            addLineSeperator(document)

            //ITEMS
            addNewItemWithLeftAndRight(document, "Tarih:", currentDate.toString(), leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "Adı Soyadı:", name.toString(), leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "TC Kimlik No:", tcNo.toString(), leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "Telefon No:", telNumber.toString(), leftAndRightStyle, leftAndRightStyle)

            addImageFromGallery(document)

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
            val headingFontSize = 18.0f
            val valueFontSize = 26.0f
            val rightAndLeftFontSize = 15.0f


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
            val schoolNumber = pref.getString("SCHOOLNUMBER", "DEFAULT_VALUE")


            //Title

            val titleStyle = Font(fontName, 30.0f, Font.NORMAL, BaseColor.BLACK)
            addNewItem(document, "Sakarya Üniversitesi Çakışan Ders Formu", Element.ALIGN_CENTER, titleStyle)
            addLineSeperator(document)
            addBlankLineSeperator(document)
            addBlankLineSeperator(document)
            addBlankLineSeperator(document)

            val headingStyle = Font(fontName, headingFontSize, Font.NORMAL, BaseColor.BLACK)
            val valueStyle = Font(fontName, valueFontSize, Font.NORMAL, BaseColor.BLACK)
            val leftAndRightStyle = Font(fontName, rightAndLeftFontSize, Font.NORMAL, BaseColor.BLACK)

            //addLineSeperator(document)
            addNewItem(document, facility.toString() + " ," + branch.toString() +"'nin " + schoolNumber.toString() + " numaralı öğrencisiyim. " + tempEditTextValue + " şubesi ile " + tempEditTextValue2 + " şubesi çakıştığından dolayı " + tempEditTextValue3 + " şubesiyle dersi almak istiyorum.\nGereğini arz ederim."  , Element.ALIGN_CENTER, headingStyle)
            addBlankLineSeperator(document)
            addBlankLineSeperator(document)

            addLineSeperator(document)

            //ITEMS
            addNewItemWithLeftAndRight(document, "Tarih:", currentDate.toString(), leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "Adı Soyadı:", name.toString(), leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "TC Kimlik No:", tcNo.toString(), leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "Telefon No:", telNumber.toString(), leftAndRightStyle, leftAndRightStyle)

            addImageFromGallery(document)

            //close

            document.close()
            Toast.makeText(activity, "BAŞARILI!", Toast.LENGTH_LONG).show()

            printPDF()




        } catch (e: Exception) {
            Log.e("ERROR", "" + e.message)

        }
    }

    private fun createPDFFile9(path: String) {
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
            val headingFontSize = 12.0f
            val valueFontSize = 26.0f
            val rightAndLeftFontSize = 12.0f


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
            val schoolNumber = pref.getString("SCHOOLNUMBER", "DEFAULT_VALUE")


            //Title

            val titleStyle = Font(fontName, 30.0f, Font.NORMAL, BaseColor.BLACK)
            addNewItem(document, "Sakarya Üniversitesi Doktora Yeterlik Sınav Jürisi Öneri Formu", Element.ALIGN_CENTER, titleStyle)
            addLineSeperator(document)
            addBlankLineSeperator(document)
            addBlankLineSeperator(document)
            addBlankLineSeperator(document)

            val headingStyle = Font(fontName, headingFontSize, Font.NORMAL, BaseColor.BLACK)
            val valueStyle = Font(fontName, valueFontSize, Font.NORMAL, BaseColor.BLACK)
            val leftAndRightStyle = Font(fontName, rightAndLeftFontSize, Font.NORMAL, BaseColor.BLACK)

            //addLineSeperator(document)
            addNewItem(document, "Fen Bilimleri Enstitüsü Müdürlüğüne,\nSAÜ LEOY 40(1) ve 42(1) uyarınca doktora yeterlilik sınavına girmek için gerekli koşulu sağlayan aşağıda bilgileri yer alan doktora programı öğrencisine ait doktora yeterlik sınav jüri önerileri SAÜ LEOY 42 amddesinin (6). bendi uyarınca aşağıda sunulmuştur.\nBilgilerinizi ve gereğini arz ederim.", Element.ALIGN_LEFT, headingStyle)
            addBlankLineSeperator(document)
            addBlankLineSeperator(document)

            addNewItemWithLeftAndRight(document, "Öğretim Üyesi Adı 1:", tempEditTextValue3 , leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "Öğretim Üyesi Adı 2:", tempEditTextValue4 , leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "Öğretim Üyesi Adı 3:", tempEditTextValue5 , leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "Öğretim Üyesi Adı 4:", tempEditTextValue6 , leftAndRightStyle, leftAndRightStyle)
            addLineSeperator(document)

            //ITEMS
            addNewItemWithLeftAndRight(document, "Tarih:", currentDate.toString(), leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "Adı Soyadı:", name.toString(), leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "TC Kimlik No:", tcNo.toString(), leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "Telefon No:", telNumber.toString(), leftAndRightStyle, leftAndRightStyle)
            addBlankLineSeperator(document)
            addNewItemWithLeftAndRight(document, "Yeterlik Lisanı:", tempEditTextValue, leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "Dönem:", tempEditTextValue2, leftAndRightStyle, leftAndRightStyle)

            addImageFromGallery(document)

            //close

            document.close()
            Toast.makeText(activity, "BAŞARILI!", Toast.LENGTH_LONG).show()

            printPDF()




        } catch (e: Exception) {
            Log.e("ERROR", "" + e.message)

        }
    }

    private fun createPDFFile10(path: String) {
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
            val headingFontSize = 18.0f
            val valueFontSize = 26.0f
            val rightAndLeftFontSize = 15.0f


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
            val schoolNumber = pref.getString("SCHOOLNUMBER", "DEFAULT_VALUE")


            //Title

            val titleStyle = Font(fontName, 30.0f, Font.NORMAL, BaseColor.BLACK)
            addNewItem(document, "Sakarya Üniversitesi Askerlik İşlemleri Başvuru Formu", Element.ALIGN_CENTER, titleStyle)
            addLineSeperator(document)
            addBlankLineSeperator(document)
            addBlankLineSeperator(document)
            addBlankLineSeperator(document)

            val headingStyle = Font(fontName, headingFontSize, Font.NORMAL, BaseColor.BLACK)
            val valueStyle = Font(fontName, valueFontSize, Font.NORMAL, BaseColor.BLACK)
            val leftAndRightStyle = Font(fontName, rightAndLeftFontSize, Font.NORMAL, BaseColor.BLACK)

            //addLineSeperator(document)
            addNewItem(document, facility.toString() + " ," + branch.toString() + " ," + schoolNumber.toString() + " numaralı öğrencinizim. Askerlik işlemlerimin yapılması için gereğini arz ederim."  , Element.ALIGN_CENTER, headingStyle)
            addBlankLineSeperator(document)
            addBlankLineSeperator(document)

            addLineSeperator(document)

            //ITEMS
            addNewItemWithLeftAndRight(document, "Tarih:", currentDate.toString(), leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "Adı Soyadı:", name.toString(), leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "TC Kimlik No:", tcNo.toString(), leftAndRightStyle, leftAndRightStyle)
            addNewItemWithLeftAndRight(document, "Telefon No:", telNumber.toString(), leftAndRightStyle, leftAndRightStyle)
            addLineSeperator(document)
            addBlankLineSeperator(document)
            addNewItemWithLeftAndRight(document, "Gereken İşlem:", tempEditTextValue, leftAndRightStyle, leftAndRightStyle)

            addImageFromGallery(document)

            //close

            document.close()
            Toast.makeText(activity, "BAŞARILI!", Toast.LENGTH_LONG).show()

            printPDF()



        } catch (e: Exception) {
            Log.e("ERROR", "" + e.message)

        }
    }

    @Throws(IOException::class, DocumentException::class)
    private fun savePDF()
    {

    }
    private fun sendPDF()
    {
        try
        {
            val fileLocation = Common.getAppPath(this) + fileName
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT, "deneme_subject")
            intent.putExtra(Intent.EXTRA_TEXT, "deneme_text")
            intent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://$fileLocation"))
            intent.data = Uri.parse("mailto:")
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            activity?.startActivity(intent)

        }catch (e:Exception)
        {
            Log.e("SENDING ERROR", e.message)
        }

    }

    private fun printPDF() {
        val printManager = activity?.getSystemService(Context.PRINT_SERVICE) as PrintManager
        try {
            val printAdapter = activity?.let { PdfDocumentAdapter(it,Common.getAppPath(this)+fileName) }
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
    private fun addBlankLineSeperator(document: Document) {
        val lineSeparator = LineSeparator()
        lineSeparator.lineColor = BaseColor(255,255,255,68)
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

//    USELESS FUNCTION
//    @Throws(DocumentException::class , IOException::class)
//    private fun addImage(document: Document)
//    {
//        try {
//            val rectDoc = document.pageSize
//            val width = rectDoc.width
//            val height = rectDoc.height
//            val imageStartX = width - document.rightMargin() - 300f//Absolute Position X
//            val imageStartY = height - document.topMargin() - 500f//Absolute Position Y
//            System.gc()
//
//            val ims: InputStream? = activity?.assets?.open("imageAssets/cat.jpg")//File Location
//            val bmp = BitmapFactory.decodeStream(ims)
//            val stream = ByteArrayOutputStream()
//            bmp.compress(Bitmap.CompressFormat.JPEG, 100, stream)
//            val byteArray: ByteArray = stream.toByteArray()
//
//            val img = Image.getInstance(byteArray) // img.scalePercent(50);
//            img.alignment = Image.TEXTWRAP
//            img.scaleAbsolute(200f, 200f) // ReAdjusting the JPG
//            img.setAbsolutePosition(imageStartX, imageStartY) // Adding Image
//            document.add(img)
//        } catch (e: Exception)
//        {
//            e.printStackTrace()
//            Log.e("JPG ERROR", e.message)
//        }
//    }

    @Throws(DocumentException::class , IOException::class)
    private fun addImageFromGallery(document: Document)
    {
        try {
            val rectDoc = document.pageSize
            val width = rectDoc.width
            val height = rectDoc.height
            val imageStartX = width - document.rightMargin() - 150f//Absolute Position X
            val imageStartY = height - document.topMargin() - 780f//Absolute Position Y
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





    private fun button1() {
        val alert = AlertDialog.Builder(activity)
        val layout = R.layout.button1_alert_dialog
        val customLayout: View = layoutInflater.inflate(layout, null)
        alert.setView(customLayout)
        val etCourse1 = customLayout.findViewById<EditText>(R.id.etCourse1)
        val etCourse2 = customLayout.findViewById<EditText>(R.id.etCourse2)
        //val btnCancel = customLayout?.findViewById<Button>(R.id.btnCancel)
        //val btnConfirm = customLayout?.findViewById<Button>(R.id.btnConfirm)


        alert.setPositiveButton("Onayla")
        {
                dialog, _ -> //What ever you want to do with the value
            tempEditTextValue = etCourse1?.text.toString()
            tempEditTextValue2 = etCourse2?.text.toString()
            if(tempEditTextValue.isEmpty() && tempEditTextValue2.isEmpty())
            {
                Toast.makeText(activity,"Alan boş bırakılamaz.", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            else
            {

                createPDFFile(Common.getAppPath(this) + fileName)
            }

        }
        alert.setNegativeButton("İptal Et")
        {
                dialog, _ ->
            dialog.dismiss()
        }

        alert.setCancelable(false)


        alert.show()

    }

    private fun button2() {
        val alert = AlertDialog.Builder(activity)
        val layout = R.layout.button2_alert_dialog
        val customLayout: View = layoutInflater.inflate(layout, null)
        alert.setView(customLayout)
        val etCourse1 = customLayout.findViewById<EditText>(R.id.etCourse1)
        val etCourse2 = customLayout.findViewById<EditText>(R.id.etCourse2)
        //val btnCancel = customLayout?.findViewById<Button>(R.id.btnCancel)
        //val btnConfirm = customLayout?.findViewById<Button>(R.id.btnConfirm)


        alert.setPositiveButton("Onayla")
        {
                dialog, _ -> //What ever you want to do with the value
            tempEditTextValue = etCourse1?.text.toString()
            tempEditTextValue2 = etCourse2?.text.toString()
            if(tempEditTextValue.isEmpty())
            {
                Toast.makeText(activity,"Alan boş bırakılamaz.", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            else
            {

                createPDFFile2(Common.getAppPath(this) + fileName)
            }

        }
        alert.setNegativeButton("İptal Et")
        {
                dialog, _ ->
            dialog.dismiss()
        }

        alert.setCancelable(false)


        alert.show()

    }

    private fun button3() {
        val alert = AlertDialog.Builder(activity)
        val layout = R.layout.button3_alert_dialog
        val customLayout: View = layoutInflater.inflate(layout, null)
        alert.setView(customLayout)
        val etCourse1 = customLayout.findViewById<EditText>(R.id.etCourse1)
        val etCourse2 = customLayout.findViewById<EditText>(R.id.etCourse2)
        //val btnCancel = customLayout?.findViewById<Button>(R.id.btnCancel)
        //val btnConfirm = customLayout?.findViewById<Button>(R.id.btnConfirm)


        alert.setPositiveButton("Onayla")
        {
                dialog, _ -> //What ever you want to do with the value
            tempEditTextValue = etCourse1?.text.toString()
            tempEditTextValue2 = etCourse2?.text.toString()
            if(tempEditTextValue.isEmpty() && tempEditTextValue2.isEmpty())
            {
                Toast.makeText(activity,"Alan boş bırakılamaz.", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            else
            {

                createPDFFile3(Common.getAppPath(this) + fileName)
            }

        }
        alert.setNegativeButton("İptal Et")
        {
                dialog, _ ->
            dialog.dismiss()
        }

        alert.setCancelable(false)


        alert.show()

    }

    private fun button4() {
        val alert = AlertDialog.Builder(activity)
        val layout = R.layout.button4_alert_dialog
        val customLayout: View = layoutInflater.inflate(layout, null)
        alert.setView(customLayout)
        val etCourse1 = customLayout.findViewById<EditText>(R.id.etCourse1)
        //val btnCancel = customLayout?.findViewById<Button>(R.id.btnCancel)
        //val btnConfirm = customLayout?.findViewById<Button>(R.id.btnConfirm)


        alert.setPositiveButton("Onayla")
        {
                dialog, _ -> //What ever you want to do with the value
            tempEditTextValue = etCourse1?.text.toString()
            if(tempEditTextValue.isEmpty())
            {
                Toast.makeText(activity,"Alan boş bırakılamaz.", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            else
            {

                createPDFFile4(Common.getAppPath(this) + fileName)
            }

        }
        alert.setNegativeButton("İptal Et")
        {
                dialog, _ ->
            dialog.dismiss()
        }

        alert.setCancelable(false)


        alert.show()

    }

    private fun button5() {
        val alert = AlertDialog.Builder(activity)
        val layout = R.layout.button5_alert_dialog
        val customLayout: View = layoutInflater.inflate(layout, null)
        alert.setView(customLayout)
        val etCourse1 = customLayout.findViewById<EditText>(R.id.etCourse1)
        val etCourse2 = customLayout.findViewById<EditText>(R.id.etCourse2)
        val etCourse3 = customLayout.findViewById<EditText>(R.id.etCourse3)
        //val btnCancel = customLayout?.findViewById<Button>(R.id.btnCancel)
        //val btnConfirm = customLayout?.findViewById<Button>(R.id.btnConfirm)


        alert.setPositiveButton("Onayla")
        {
                dialog, _ -> //What ever you want to do with the value
            tempEditTextValue = etCourse1?.text.toString()
            tempEditTextValue2 = etCourse2?.text.toString()
            tempEditTextValue3 = etCourse3?.text.toString()
            if(tempEditTextValue.isEmpty())
            {
                Toast.makeText(activity,"Alan boş bırakılamaz.", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            else
            {

                createPDFFile5(Common.getAppPath(this) + fileName)
            }

        }
        alert.setNegativeButton("İptal Et")
        {
                dialog, _ ->
            dialog.dismiss()
        }

        alert.setCancelable(false)


        alert.show()

    }

    private fun button6() {

        val alert = AlertDialog.Builder(activity)
        val layout = R.layout.button6_alert_dialog
        val customLayout: View = layoutInflater.inflate(layout, null)
        alert.setView(customLayout)
        val etCourse1 = customLayout.findViewById<EditText>(R.id.etCourse1)
        val etCourse2 = customLayout.findViewById<EditText>(R.id.etCourse2)
        val etCourse3 = customLayout.findViewById<EditText>(R.id.etCourse3)
        //val btnCancel = customLayout?.findViewById<Button>(R.id.btnCancel)
        //val btnConfirm = customLayout?.findViewById<Button>(R.id.btnConfirm)


        alert.setPositiveButton("Onayla")
        {
                dialog, _ -> //What ever you want to do with the value
            tempEditTextValue = etCourse1?.text.toString()
            tempEditTextValue2 = etCourse2?.text.toString()
            tempEditTextValue3 = etCourse3?.text.toString()
            if(tempEditTextValue.isEmpty())
            {
                Toast.makeText(activity,"Alan boş bırakılamaz.", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            else
            {

                createPDFFile6(Common.getAppPath(this) + fileName)
            }

        }
        alert.setNegativeButton("İptal Et")
        {
                dialog, _ ->
            dialog.dismiss()
        }

        alert.setCancelable(false)


        alert.show()
    }

    private fun button7() {
        val alert = AlertDialog.Builder(activity)
        val layout = R.layout.button7_alert_dialog
        val customLayout: View = layoutInflater.inflate(layout, null)
        alert.setView(customLayout)
        val etCourse1 = customLayout.findViewById<EditText>(R.id.etCourse1)
        //val btnCancel = customLayout?.findViewById<Button>(R.id.btnCancel)
        //val btnConfirm = customLayout?.findViewById<Button>(R.id.btnConfirm)


        alert.setPositiveButton("Onayla")
        {
                dialog, _ -> //What ever you want to do with the value
            tempEditTextValue = etCourse1?.text.toString()

            if(tempEditTextValue.isEmpty())
            {
                Toast.makeText(activity,"Alan boş bırakılamaz.", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            else
            {

                createPDFFile7(Common.getAppPath(this) + fileName)
            }

        }
        alert.setNegativeButton("İptal Et")
        {
                dialog, _ ->
            dialog.dismiss()
        }

        alert.setCancelable(false)


        alert.show()

    }

    private fun button8() {

        val alert = AlertDialog.Builder(activity)
        val layout = R.layout.button8_alert_dialog
        val customLayout: View = layoutInflater.inflate(layout, null)
        alert.setView(customLayout)
        val etCourse1 = customLayout.findViewById<EditText>(R.id.etCourse1)
        val etCourse2 = customLayout.findViewById<EditText>(R.id.etCourse2)
        val etCourse3 = customLayout.findViewById<EditText>(R.id.etCourse3)
        //val btnCancel = customLayout?.findViewById<Button>(R.id.btnCancel)
        //val btnConfirm = customLayout?.findViewById<Button>(R.id.btnConfirm)


        alert.setPositiveButton("Onayla")
        {
                dialog, _ -> //What ever you want to do with the value
            tempEditTextValue = etCourse1?.text.toString()
            tempEditTextValue2 = etCourse2?.text.toString()
            tempEditTextValue3 = etCourse3?.text.toString()

            if(tempEditTextValue.isEmpty() &&
                tempEditTextValue2.isEmpty() &&
                tempEditTextValue3.isEmpty()
            )
            {
                Toast.makeText(activity,"Alan boş bırakılamaz.", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            else
            {

                createPDFFile8(Common.getAppPath(this) + fileName)
            }

        }
        alert.setNegativeButton("İptal Et")
        {
                dialog, _ ->
            dialog.dismiss()
        }

        alert.setCancelable(false)


        alert.show()
    }

    private fun button9() {

        val alert = AlertDialog.Builder(activity)
        val layout = R.layout.button9_alert_dialog
        val customLayout: View = layoutInflater.inflate(layout, null)
        alert.setView(customLayout)
        val etCourse1 = customLayout.findViewById<EditText>(R.id.etCourse1)
        val etCourse2 = customLayout.findViewById<EditText>(R.id.etCourse2)
        val etCourse3 = customLayout.findViewById<EditText>(R.id.etCourse3)
        val etCourse4 = customLayout.findViewById<EditText>(R.id.etCourse4)
        val etCourse5 = customLayout.findViewById<EditText>(R.id.etCourse5)
        val etCourse6 = customLayout.findViewById<EditText>(R.id.etCourse6)
        //val btnCancel = customLayout?.findViewById<Button>(R.id.btnCancel)
        //val btnConfirm = customLayout?.findViewById<Button>(R.id.btnConfirm)


        alert.setPositiveButton("Onayla")
        {
                dialog, _ -> //What ever you want to do with the value
            tempEditTextValue = etCourse1?.text.toString()
            tempEditTextValue2 = etCourse2?.text.toString()
            tempEditTextValue3 = etCourse3?.text.toString()
            tempEditTextValue4 = etCourse4?.text.toString()
            tempEditTextValue5 = etCourse5?.text.toString()
            tempEditTextValue6 = etCourse6?.text.toString()

            if(tempEditTextValue.isEmpty() &&
                tempEditTextValue2.isEmpty() &&
                tempEditTextValue3.isEmpty() &&
                tempEditTextValue4.isEmpty() &&
                tempEditTextValue5.isEmpty() &&
                tempEditTextValue6.isEmpty()
            )
            {
                Toast.makeText(activity,"Alan boş bırakılamaz.", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            else
            {

                createPDFFile9(Common.getAppPath(this) + fileName)
            }

        }
        alert.setNegativeButton("İptal Et")
        {
                dialog, _ ->
            dialog.dismiss()
        }

        alert.setCancelable(false)


        alert.show()
    }

    private fun button10() {

        val alert = AlertDialog.Builder(activity)
        val layout = R.layout.button10_alert_dialog
        val customLayout: View = layoutInflater.inflate(layout, null)
        alert.setView(customLayout)
        val etCourse1 = customLayout.findViewById<EditText>(R.id.etCourse1)
        //val btnCancel = customLayout?.findViewById<Button>(R.id.btnCancel)
        //val btnConfirm = customLayout?.findViewById<Button>(R.id.btnConfirm)

        alert.setPositiveButton("Onayla")
        {
                dialog, _ -> //What ever you want to do with the value
            tempEditTextValue = etCourse1?.text.toString()

            if(tempEditTextValue.isEmpty()
            )
            {
                Toast.makeText(activity,"Alan boş bırakılamaz.", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            else
            {

                createPDFFile10(Common.getAppPath(this) + fileName)

            }

        }
        alert.setNegativeButton("İptal Et")
        {
                dialog, _ ->
            dialog.dismiss()
        }

        alert.setCancelable(false)


        alert.show()
    }

    private fun firstTimeAlert()
    {
        //Checking the First Run
        val pref = activity!!.getPreferences(Context.MODE_PRIVATE)
        val name = pref.getString("NAME", "DEFAULT_NAME")
        val fileLocation = "/storage/emulated/0/Pictures/UserSignature/Signature.jpg"
        val file = File(fileLocation)

        if (name == "DEFAULT_NAME" || !file.exists()) {


            val alert = AlertDialog.Builder(activity)
            val layout = R.layout.firsttime_alert_dialog
            val customLayout: View = layoutInflater.inflate(layout, null)
            alert.setView(customLayout)
                alert.setPositiveButton("Onayla")
                { dialog, _ -> //What ever you want to do with the value
                    dialog.dismiss()

                }
                alert.setCancelable(false)


                alert.show()
        }

        else
        {

        }
    }



}
