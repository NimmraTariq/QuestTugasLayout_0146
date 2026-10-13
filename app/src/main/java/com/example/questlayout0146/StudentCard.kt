package com.example.questlayout0146

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun StudentCard(
    student: StudentUiModel,
    modifier: Modifier = Modifier,
) {
    val cardName = stringResource(id = student.nameRes)
    val cardContentDesc = stringResource(id = R.string.student_card_description, cardName)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.card_height))
            .semantics {
                contentDescription = cardContentDesc
            },
        shape = RoundedCornerShape(size = dimensionResource(id = R.dimen.card_corner_radius)),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = student.backgroundRes),
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = dimensionResource(id = R.dimen.card_padding)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                space = dimensionResource(id = R.dimen.card_content_spacing),
            ),
        ) {
            UniversityLogo()
            StudentInfoColumn(
                student = student,
                modifier = Modifier.weight(1f),
            )
            UniversityLogo()
        }
    }
}

@Composable
private fun StudentInfoColumn(
    student: StudentUiModel,
    modifier: Modifier = Modifier,
) {
    val fontStyle = if (student.useScriptName) FontFamily.Cursive else FontFamily.Default
    val nameFontWeight = if (student.useScriptName) FontWeight.Normal else FontWeight.Bold

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = stringResource(id = student.nameRes),
            color = colorResource(id = student.nameColorRes),
            fontFamily = fontStyle,
            fontSize = dimensionResource(id = R.dimen.student_name_size).value.sp,
            fontWeight = nameFontWeight,
            maxLines = 1,
        )
        student.phoneRes?.let { phoneResId ->
            Text(
                text = stringResource(id = phoneResId),
                color = colorResource(id = student.phoneColorRes),
                fontSize = dimensionResource(id = R.dimen.student_detail_size).value.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
            )
        }
        Text(
            text = stringResource(id = student.addressRes),
            color = colorResource(id = student.addressColorRes),
            fontSize = dimensionResource(id = R.dimen.student_detail_size).value.sp,
            maxLines = 1,
        )
    }
}

@Composable
private fun UniversityLogo(
    modifier: Modifier = Modifier,
    @DrawableRes drawableRes: Int = R.drawable.umy_seal,
) {
    Image(
        painter = painterResource(id = drawableRes),
        contentDescription = stringResource(id = R.string.umy_logo_description),
        modifier = modifier.size(size = dimensionResource(id = R.dimen.logo_size)),
    )
}
