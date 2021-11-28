package io.github.tuguzt.sql.presentation.viewmodel

import tornadofx.ViewModel
import tornadofx.getProperty
import tornadofx.property
import java.io.File

class GameAssetEditModel : ViewModel() {
    var selectedFile: File? by property()
    inline val selectedFileProperty get() = getProperty(GameAssetEditModel::selectedFile)
}
