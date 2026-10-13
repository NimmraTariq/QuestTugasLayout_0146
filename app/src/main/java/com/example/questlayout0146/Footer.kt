package com.example.questlayout0146

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp

/**
 * Reusable FooterSection displaying copyright information.
 */
@Composable
fun FooterSection(
    modifier: Modifier = Modifier,
) {
    val copyrightLabel = stringResource(id = R.string.copyright)
    val textColor = colorResource(id = R.color.text_dark)
    val textSize = dimensionResource(id = R.dimen.footer_text_size).value.sp
    val topPadding = dimensionResource(id = R.dimen.footer_top_spacing)
    val bottomPadding = dimensionResource(id = R.dimen.footer_bottom_spacing)

    Text(
        text = copyrightLabel,
        color = textColor,
        fontSize = textSize,
        modifier = modifier.padding(
            top = topPadding,
            bottom = bottomPadding,
        ),
    )
}

/**
 * Internal footer wrapper function.
 */
@Composable
internal fun Footer() = FooterSection()
