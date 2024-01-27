package com.example.kisileruygulamasiv3.data.repo

import com.example.kisileruygulamasiv3.data.datasource.KisilerDataSource
import com.example.kisileruygulamasiv3.data.entity.Kisiler

// bu class datasoourceyi viewmodallara aktarımmı saglar
// hilt için @ınject de kullanılabilir burada ama gerek yok
class KisilerRepository(var kds:KisilerDataSource) {

    suspend fun kaydet(kisi_ad:String,kisi_tel:String)= kds.kaydet(kisi_ad,kisi_tel)

    suspend fun guncelle(kisi_id: Int,kisi_ad:String,kisi_tel:String)=kds.guncelle(kisi_id,kisi_ad,kisi_tel)

    suspend fun kisiSil(kisi_id:Int)=kds.kisiSil(kisi_id)

    suspend fun kisileriYukle():List<Kisiler> = kds.kisileriYukle()

    suspend fun ara(aramaKelimesi:String):List<Kisiler> = kds.ara(aramaKelimesi)
}