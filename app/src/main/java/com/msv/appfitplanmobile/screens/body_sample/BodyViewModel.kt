package com.msv.appfitplanmobile.screens.body_sample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msv.appfitplanmobile.data.local.room.dao.BodyDao
import com.msv.appfitplanmobile.data.local.room.dao.NoteDao
import com.msv.appfitplanmobile.data.local.room.entity.Body
import com.msv.appfitplanmobile.data.local.room.entity.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BodyViewModel @Inject constructor(
    private val bodyDao: BodyDao
) : ViewModel() {

    private val _listBody = MutableStateFlow(emptyList<Body>())
    val listBody: StateFlow<List<Body>> = _listBody

    init {
        getListBody()
    }

    private fun getListBody() {
        viewModelScope.launch {
            bodyDao.getAllBodies().collect {
                _listBody.value = it
            }
        }
    }

    fun setBody(body: Body) {
        viewModelScope.launch {
            bodyDao.insert(body)
        }
    }
}
