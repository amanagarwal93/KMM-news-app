package com.example.newsapp.domain.useCases.appEntry

import com.example.newsapp.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}