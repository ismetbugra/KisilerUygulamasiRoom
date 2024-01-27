package com.example.kisileruygulamasiv3.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasiv3.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KisiDetayViewModel @Inject constructor(var krepo:KisilerRepository):ViewModel() {

    fun guncelle(kisi_id:Int,kisi_ad:String,kisi_tel:String){
        CoroutineScope(Dispatchers.IO).launch {
            krepo.guncelle(kisi_id,kisi_ad,kisi_tel)
        }
    }
}