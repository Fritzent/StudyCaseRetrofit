package com.example.studycaseretrofit.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studycaseretrofit.R
import com.example.studycaseretrofit.add.AddPerson
import com.example.studycaseretrofit.network.ApiClient
import com.example.studycaseretrofit.pojo.GetPersonsResponse
import com.example.studycaseretrofit.update.Edit
import kotlinx.android.synthetic.main.activity_main.*
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity(), MainPresenter.Listener {

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter(this)
        presenter.getPersonList()

        //ini bagian untuk fab tambah itemnya
        fabAddActivity.setOnClickListener {
            presenter.goToAddActivity()
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.getPersonList()
    }
    fun setUpRecyclerView(listPerson : List<GetPersonsResponse.Result>){
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter =
            PersonAdapter(listPerson, presenter)
    }

    override fun onPersonListSuccess(personList: MutableList<GetPersonsResponse.Result>) {
        setUpRecyclerView(personList)
    }

    override fun onGetPersonListFailure(errMessage: String) {
        Toast.makeText(this,"Error : $errMessage", Toast.LENGTH_LONG).show()
    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    override fun goToAddActivity() {
        val goToAddActivity = Intent(this, AddPerson::class.java)
        startActivity(goToAddActivity)
    }

    override fun goToUpdateActivity(result: GetPersonsResponse.Result) {
        val goToUpdateActivity = Intent(this, Edit::class.java)
        goToUpdateActivity.putExtra("PERSON",result)
        startActivity(goToUpdateActivity)
    }

    override fun onPersonDeleteSuccess(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
        presenter.getPersonList()
    }

    override fun onPersonDeleteFailed(errMessage: String) {
        Toast.makeText(this,"Error : $errMessage",Toast.LENGTH_LONG).show()
    }
}

//        val objectJson = JSONObject()
//        val jsonArray = JSONArray()
//
//        jsonArray.put(JSONObject()
//                .put("nama", "SamsungA10")
//                .put("harga", 15000)
//        )
//        jsonArray.put(JSONObject()
//                .put("nama", "SamsungA20")
//                .put("harga", 20000)
//        )
//        jsonArray.put(JSONObject()
//                .put("nama", "SamsungA30")
//                .put("harga", 25000)
//        )
//
//        objectJson.put("merkBarang", "Samsung")
//        objectJson.put("jumlahBarang", 3)
//        objectJson.put("typeBarang", "Elektronik")
//        objectJson.put("isNew", true)
//        objectJson.put("detailBarang", jsonArray)
//
//        val getNamaBarang = objectJson.getJSONArray("detailBarang").getJSONObject(1).getString("nama")
//        val getHargaBarang = objectJson.getJSONArray("detailBarang").getJSONObject(1).getInt("harga")
//
//        detail_barang_nama.text = getNamaBarang
//        detail_barang_harga.text = getHargaBarang.toString()