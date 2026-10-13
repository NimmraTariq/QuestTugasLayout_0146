package com.example.questlayout0146

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * Reusable HeaderSection displaying screen title and university subtitle.
 */
@Composable
fun HeaderSection(
    modifier: Modifier = Modifier,
) {
    val screenTitle = stringResource(id = R.string.screen_title)
    val subtitleLabel = stringResource(id = R.string.university_subtitle)
    val darkTextColor = colorResource(id = R.color.text_dark)

    val titleSize = dimensionResource(id = R.dimen.header_title_size).value.sp
    val subtitleSize = dimensionResource(id = R.dimen.header_subtitle_size).value.sp
    val topSpacing = dimensionResource(id = R.dimen.header_top_spacing)
    val bottomSpacing = dimensionResource(id = R.dimen.header_bottom_spacing)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = topSpacing),
    ) {
        Text(
            text = screenTitle,
            color = darkTextColor,
            fontSize = titleSize,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = subtitleLabel,
            color = darkTextColor,
            fontSize = subtitleSize,
            fontWeight = FontWeight.SemiBold,
        )
        Spacer(modifier = Modifier.height(bottomSpacing))
    }
}

/**
 * Internal header wrapper.
 */
@Composable
internal fun Header() {
    HeaderSection()
}
