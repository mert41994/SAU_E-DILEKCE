package com.emk.createpdfkotlin

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_user.*
import kotlinx.android.synthetic.main.fragment_user.view.*


class UserFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        //Setting this layout view
        val view: View = inflater.inflate(R.layout.fragment_user, container, false)

        val pref = activity!!.getPreferences(Context.MODE_PRIVATE)
        val name = pref.getString("NAME", "DEFAULT_NAME")
        val facility = pref.getString("FACILITY", "DEFAULT_FACILITY")
        val branch = pref.getString("BRANCH", "DEFAULT_BRANCH")
        val telNumber = pref.getString("TELNUMBER", "DEFAULT_TELNUMBER")
        val tcNo = pref.getString("TCNUMBER", "DEFAULT_TCNO")
        val schoolNumber = pref.getString("SCHOOLNUMBER","DEFAULT_SCHOOLNUMBER")

        if (name != "DEFAULT_NAME"
            && schoolNumber != "DEFAULT_SCHOOLNUMBER"
            && facility != "DEFAULT_FACILITY"
            && branch != "DEFAULT_BRANCH"
            && telNumber != "DEFAULT_TELNUMBER"
            && tcNo !="DEFAULT_TCNO")
        {
            view.etUserName.setText(name)
            view.etBranch.setText(branch)
            view.etFacility.setText(facility)
            view.etTcNumber.setText(tcNo)
            view.etTelNumber.setText(telNumber)
            view.etSchoolNumber.setText(schoolNumber)
        }
        //Save Button Functionality
        view.btnSave.setOnClickListener{

            try {
                //Create SharedPreferences file
                try {

                    val pref = this.activity!!.getPreferences(Context.MODE_PRIVATE)
                }
                catch (e: Exception)
                {
                    Toast.makeText(
                        activity,
                        "SharedPreferences dosyası oluşturulamadı.",
                        Toast.LENGTH_LONG
                    ).show()

                }
                val editor = pref.edit()

                //save name

                editor.putString("NAME", etUserName.text.toString())
                editor.putString("FACILITY", etFacility.text.toString())
                editor.putString("BRANCH", etBranch.text.toString())
                editor.putString("TELNUMBER", etTelNumber.text.toString())
                editor.putString("TCNUMBER", etTcNumber.text.toString())
                editor.putString("SCHOOLNUMBER", etSchoolNumber.text.toString())
                //commit changes
                editor.apply()

                val name = pref.getString("NAME", "DEFAULT_VALUE")
                val facility = pref.getString("FACILITY", "DEFAULT_VALUE")
                val branch = pref.getString("BRANCH", "DEFAULT_VALUE")
                val telNumber = pref.getString("TELNUMBER", "DEFAULT_VALUE")
                val tcNo = pref.getString("TCNUMBER", "DEFAULT_VALUE")
                val schoolNumber = pref.getString("SCHOOLNUMBER", "DEFAULT_VALUE")

                if(
                    name.toString() == "DEFAULT_VALUE" &&
                    schoolNumber.toString() == "DEFAULT_VALUE" &&
                    facility.toString() == "DEFAULT_VALUE" &&
                    branch.toString() == "DEFAULT_VALUE" &&
                    telNumber.toString() == "DEFAULT_VALUE" &&
                    tcNo.toString() == "DEFAULT_VALUE")
                {
                    Toast.makeText(activity,
                        "Herhangi bir bilgi girilmemiştir. Lütfen bilgilerinizi tekrar giriniz.",
                        Toast.LENGTH_SHORT).show()
                }

                if(name.toString() == "" ||
                    schoolNumber.toString() == "" ||
                    facility.toString() == "" ||
                    branch.toString() == "" ||
                    telNumber.toString() == "" ||
                    tcNo.toString() == "")
                {
                    Toast.makeText(activity,
                        "Eksik bilgi bulunmaktadır.\nLütfen bilgilerinizi eksiksiz giriniz.",
                        Toast.LENGTH_SHORT).show()
                }

                else
                {
                        Toast.makeText(activity,
                            "Bilgiler başarıyla kaydedildi.",
                        Toast.LENGTH_LONG ).show()
                            view.etUserName.setText(name)
                            view.etBranch.setText(branch)
                            view.etFacility.setText(facility)
                            view.etTcNumber.setText(tcNo)
                            view.etTelNumber.setText(telNumber)
                            view.etSchoolNumber.setText(schoolNumber)
                }


            }
            catch (e: Exception)
            {
                Toast.makeText(
                    activity,
                    "Bilgilerin kaydedilmesinde hata oluştu.",
                    Toast.LENGTH_LONG
                ).show()

            }
        }

        view.etUserName.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable)
            {
                view.btnSave.isEnabled =
                            (view.etUserName != null) &&
                            (view.etSchoolNumber != null) &&
                            (view.etBranch != null) &&
                            (view.etFacility != null) &&
                            (view.etTcNumber != null) &&
                            (view.etTelNumber != null)

            }


            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {

                //Toast.makeText(activity, "Kayıt Butonu Etkinleştirildi.", Toast.LENGTH_SHORT).show()

            }
        })


        //CheckInfo Button Functionality
//        view.btnCheckInfo.setOnClickListener{
//
//
//            val pref = activity!!.getPreferences(Context.MODE_PRIVATE)
//
//            val name = pref.getString("NAME", "DEFAULT_VALUE")
//            val facility = pref.getString("FACILITY", "DEFAULT_VALUE")
//            val branch = pref.getString("BRANCH", "DEFAULT_VALUE")
//            val telNumber = pref.getString("TELNUMBER", "DEFAULT_VALUE")
//            val tcNo = pref.getString("TCNUMBER", "DEFAULT_VALUE")
//            val schoolNumber = pref.getString("SCHOOLNUMBER", "DEFAULT_VALUE")
//
//                    if(
//                name.toString() == "DEFAULT_VALUE" &&
//                schoolNumber.toString() == "DEFAULT_VALUE" &&
//                facility.toString() == "DEFAULT_VALUE" &&
//                branch.toString() == "DEFAULT_VALUE" &&
//                telNumber.toString() == "DEFAULT_VALUE" &&
//                tcNo.toString() == "DEFAULT_VALUE")
//                    {
//                        Toast.makeText(activity,
//                            "Herhangi bir bilgi girilmemiştir. Lütfen bilgilerinizi tekrar giriniz.",
//                            Toast.LENGTH_SHORT).show()
//                    }
//
//                if(name.toString() == "" ||
//                    facility.toString() == "" ||
//                    schoolNumber.toString() == "" ||
//                    branch.toString() == "" ||
//                    telNumber.toString() == "" ||
//                    tcNo.toString() == "")
//                {
//                    Toast.makeText(activity,
//                        "Eksik bilgi bulunmaktadır. Lütfen bilgilerinizi tekrar giriniz.",
//                        Toast.LENGTH_SHORT).show()
//                }
//                else
//                {
//                    Toast.makeText(activity,
//                        "İsim : ${pref.getString("NAME","DEFAULT_VALUE")}\n" +
//                                "Fakülte : ${pref.getString("FACILITY","DEFAULT_VALUE")}\n" +
//                                "Branş : ${pref.getString("BRANCH","DEFAULT_VALUE")}\n"+
//                                "Telefon No : ${pref.getString("TELNUMBER","DEFAULT_VALUE")}\n"+
//                                "TC Kimlik No : ${pref.getString("TCNUMBER","DEFAULT_VALUE")}\n",
//                        Toast.LENGTH_LONG ).show()
//                }
//
//            }


        return view
    }


}
