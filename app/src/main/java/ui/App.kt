package ui

import android.app.Application
import data.AppDatabase
import data.BusinessCardRepository

class App : Application() {

    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }

}