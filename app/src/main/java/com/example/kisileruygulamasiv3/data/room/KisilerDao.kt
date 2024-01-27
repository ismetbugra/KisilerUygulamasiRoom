package com.example.kisileruygulamasiv3.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.kisileruygulamasiv3.data.entity.Kisiler

@Dao
interface KisilerDao {

    @Query("SELECT*FROM kisiler")
    suspend fun kisileriYukle():List<Kisiler>

    @Insert
    suspend fun kisiKaydet(kisi:Kisiler)

    @Update
    suspend fun kisiGuncelle(kisi: Kisiler)

    @Delete
    suspend fun kisiSil(kisi: Kisiler)

    @Query("SELECT*FROM kisiler WHERE kisi_ad like '%' || :aramaKelimesi || '%' ")
    suspend fun kisiAra(aramaKelimesi:String):List<Kisiler>
}