package com.vehiclecompanion.composables.textfields

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import kotlin.collections.joinToString
import kotlin.text.chunked
import kotlin.text.filter
import kotlin.text.isDigit
import kotlin.text.substring
import kotlin.text.take

interface MaskFormatter {
    val maxChars: Int
    fun format(text: String): String
}

fun MaskFormatter.toVisualTransformation(): VisualTransformation =
    VisualTransformation {
        val output = format(it.text)
        TransformedText(
            text = AnnotatedString(output),
            offsetMapping = object : OffsetMapping {
                override fun originalToTransformed(offset: Int): Int = output.length
                override fun transformedToOriginal(offset: Int): Int = it.text.length
            }
        )
    }

object CardNumberFormatter : MaskFormatter {
    override val maxChars = 19

    override fun format(text: String) = text
        .chunked(4)
        .joinToString(" ")
}

object MMYYFormatter : MaskFormatter {
    override val maxChars = 4

    override fun format(text: String): String {
        val digits = text.filter { it.isDigit() }
        return when (digits.length) {
            in (0..1) -> digits
            2 -> "$digits/"
            in (3..4) -> digits.take(2) + "/" + digits.substring(2)
            else -> digits.take(2) + "/" + digits.substring(2, maxChars)
        }
    }
}

object CVVFormatter : MaskFormatter {
    override val maxChars = 7

    override fun format(text: String) = text
        .filter { it.isDigit() }
        .take(maxChars)
}
