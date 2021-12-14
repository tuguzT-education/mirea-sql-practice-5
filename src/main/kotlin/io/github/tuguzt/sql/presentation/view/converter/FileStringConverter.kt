package io.github.tuguzt.sql.presentation.view.converter

import javafx.util.StringConverter
import java.io.File
import java.net.URI

object FileStringConverter : StringConverter<File?>() {
    override fun toString(file: File?) = file?.name.orEmpty()

    override fun fromString(string: String): File {
        val uri = URI(string)
        return File(uri)
    }
}
