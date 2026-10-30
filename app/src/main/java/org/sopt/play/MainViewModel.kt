package org.sopt.play

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainViewModel : ViewModel() {
    var selectedMenu by mutableStateOf("홈")
        private set

    var selectedChip by mutableStateOf("전체")
        private set

    var likedProducts by mutableStateOf(setOf<Int>())
        private set

    fun onLikeClick(index: Int) {
        likedProducts = if (index in likedProducts) {
            likedProducts - index
        } else {
            likedProducts + index
        }
    }


    fun onMenuClick(menu: String) {
        selectedMenu=menu
    }

    fun onChipClick(chip: String) {
        selectedChip = chip
    }


}
