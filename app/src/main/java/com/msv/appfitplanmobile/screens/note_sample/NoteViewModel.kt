package com.msv.appfitplanmobile.screens.note_sample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msv.appfitplanmobile.data.local.room.dao.NoteDao
import com.msv.appfitplanmobile.data.local.room.entity.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel
@Inject constructor(
    private val noteDao: NoteDao
) : ViewModel() {

    private val _listNote = MutableStateFlow(emptyList<Note>())
    val listNote:StateFlow<List<Note>> = _listNote
    fun getListNote(){
        viewModelScope.launch {
            noteDao.getAllNotes().collect{
                _listNote.value = it
            }
        }
    }

    fun setNote(note: Note){
        viewModelScope.launch {
            noteDao.insert(note)
        }
    }

    init {
        getListNote()
    }
}