package com.example.kisileruygulamasiv3.data.datasource

import com.example.kisileruygulamasiv3.data.entity.Kisiler
import com.example.kisileruygulamasiv3.data.room.KisilerDao
import com.example.kisileruygulamasiv3.data.room.Veritabani
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.math.log

class KisilerDataSource(var kdao:KisilerDao) {



    suspend fun kaydet(kisi_ad:String,kisi_tel:String){
        val yeniKisi=Kisiler(0,kisi_ad,kisi_tel)
        kdao.kisiKaydet(yeniKisi)
    }

    suspend fun guncelle(kisi_id: Int,kisi_ad:String,kisi_tel:String){
        val kisiGuncelle=Kisiler(kisi_id,kisi_ad,kisi_tel)
        kdao.kisiGuncelle(kisiGuncelle)
    }
    suspend fun kisiSil(kisi_id:Int){
        val silinenKisi=Kisiler(kisi_id,"","")
        kdao.kisiSil(silinenKisi)
    }

    suspend fun kisileriYukle():List<Kisiler> =
        withContext(Dispatchers.IO){

            var kisilerList=kdao.kisileriYukle()
            return@withContext kisilerList
        }

    suspend fun ara(aramaKelimesi:String):List<Kisiler> =
        withContext(Dispatchers.IO){
            val kisilerList=kdao.kisiAra(aramaKelimesi)
            return@withContext kisilerList
        }





}