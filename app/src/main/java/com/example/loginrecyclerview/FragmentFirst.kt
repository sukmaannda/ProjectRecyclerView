package com.example.loginrecyclerview

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.*

class FragmentFirst:Fragment() {
    private var db: AppDatabase? = null
    private var myFriendDao: MyFriendDao? = null

    private var namaInput: String = ""
    private var emailInput: String = ""
    private var telpInput: String = ""
    private var dateInput: String = ""

    private var edtName: TextInputEditText? = null
    private var edtEmail: TextInputEditText? = null
    private var edtTelp: EditText? = null
    private var btnSave: Button? = null
    private var btnDate: Button? = null

    lateinit var pickDate: Button

    companion object {
        fun newInstance(): FragmentFirst {
            return FragmentFirst()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLocalDB()
        initView()

        pickDate = view.findViewById(R.id.btnDate)
        pickDate.setOnClickListener {
            val c = Calendar.getInstance()

            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                requireActivity(),
                { view, year, monthOfYear, dayOfMonth ->
                    pickDate.text =
                        (dayOfMonth.toString() + "\t-\t" + (monthOfYear + 1) + "\t-\t" + year)
                },
                year, month, day
            )
            datePickerDialog.show()
        }
    }

    private fun initLocalDB() {
        db = AppDatabase.getAppDataBase(requireActivity())
        myFriendDao = db?.myFriendDao()
    }

    private fun initView() {
        edtName = activity?.findViewById(R.id.textInputTextName)
        edtEmail = activity?.findViewById(R.id.textInputTextEmail)
        edtTelp = activity?.findViewById(R.id.textInputTextNoTelp)

        btnSave = activity?.findViewById(R.id.btnSave)
        btnSave?.setOnClickListener {
//            (activity as MainActivity).tampilMyFriendsFragment()
            validasiInput()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        db?.close()
        edtName = null
        edtEmail = null
        edtTelp = null
        btnSave = null
    }

    private fun validasiInput() {
        namaInput = edtName?.text.toString()
        emailInput = edtEmail?.text.toString()
        telpInput = edtTelp?.text.toString()
        dateInput = pickDate?.text.toString()

        when {
            namaInput.isEmpty() -> edtName?.error = "Nama tidak boleh kosong"

            emailInput.isEmpty() -> edtEmail?.error = "Email tidak boleh kosong"

            telpInput.isEmpty() -> edtTelp?.error = "Telp tidak boleh kosong"

            dateInput.isEmpty() -> pickDate?.error = "Tanggal Kosong"
            else -> {
                val teman = MyFriend(
                    nama = namaInput, email = emailInput, telp = telpInput, date = dateInput
                )
                tambahDataTeman(teman)
                Toast.makeText(requireActivity(),"Data Di Simpan",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun tambahDataTeman(teman: MyFriend) : Job {
        return GlobalScope.launch {
            myFriendDao?.tambahTeman(teman)
           (activity as MainActivityFragment).tampilMyFriendsFragment()
        }
    }
}