package edu.vt.cs.cs5254.criminalintent

import android.app.Application

class CrimalIntentApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        CrimeRepository.initialize(this)
    }
}