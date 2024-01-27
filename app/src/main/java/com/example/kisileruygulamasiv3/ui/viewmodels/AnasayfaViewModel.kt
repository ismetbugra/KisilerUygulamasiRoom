package com.example.kisileruygulamasiv3.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasiv3.data.entity.Kisiler
import com.example.kisileruygulamasiv3.data.repo.KisilerRepository
import com.example.kisileruygulamasiv3.ui.adapters.KisilerAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var krepo:KisilerRepository):ViewModel() {
    var kisilerListesi=MutableLiveData<List<Kisiler>>()

    // ansayfa viewmodel olusturuldugu anda kisileriYukle fonksiyonu calıstırılacak
    init {
        kisileriYukle()
    }

    fun kisiSil(kisi_id:Int){
        CoroutineScope(Dispatchers.IO).launch {
            krepo.kisiSil(kisi_id)
            kisileriYukle() //arayuzde silme işlemi yapıldıktan sonra kişileri güncellicek
        }
    }

    fun kisileriYukle(){
        CoroutineScope(Dispatchers.Main).launch{
            kisilerListesi.value=krepo.kisileriYukle()
        }
    }

    fun ara(aramaKelimesi:String){
        CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value=krepo.ara(aramaKelimesi)
        }
    }
}