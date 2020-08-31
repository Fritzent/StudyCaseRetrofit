package com.example.studycaseretrofit.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.studycaseretrofit.R
import kotlinx.android.synthetic.main.activity_add_person.*

class AddPerson : AppCompatActivity(), AddPersonPresenter.Listener {

    private lateinit var presenter: AddPersonPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_person)
        presenter = AddPersonPresenter(this)

        btnAddPerson.setOnClickListener {
            presenter.addPerson(etFirstName.text.toString(), etLastName.text.toString())
        }
    }
    override fun onAddPersonSuccess(successMessage: String) {
        Toast.makeText(this, successMessage, Toast.LENGTH_LONG).show()
        finish()
    }

    override fun onAddPersonFailure(failureMessage: String) {
        Toast.makeText(this, failureMessage, Toast.LENGTH_LONG).show()
        finish()
    }
}