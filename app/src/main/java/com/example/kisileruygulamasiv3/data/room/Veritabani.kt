package com.example.kisileruygulamasiv3.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kisileruygulamasiv3.data.entity.Kisiler

@Database(entities = [Kisiler::class], version = 1)
abstract class Veritabani:RoomDatabase() {

    // kaç tane tablom varsa onlara erişmek için o kafar dao olusturulur ayrı ayrı
    abstract fun getKisilerDao():KisilerDao

}