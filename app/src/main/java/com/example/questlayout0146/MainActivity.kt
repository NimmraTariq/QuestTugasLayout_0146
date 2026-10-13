package com.example.questlayout0146

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.questlayout0146.ui.theme.QuestTugasLayout0146Theme

/**
 * Main activity hosting the student list screen view.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        applySystemBarColors()

        setContent {
            QuestTugasLayout0146Theme {
                StudentListScreen()
            }
        }
    }

    /**
     * Sets status bar and navigation bar background colors to match app background.
     */
    private fun applySystemBarColors() {
        val backgroundColor = getColor(R.color.screen_background)
        window.statusBarColor = backgroundColor
        window.navigationBarColor = backgroundColor
    }
}

/**
 * Top-level screen composable assembling Header, Student Cards list, and Footer.
 */
@Composable
fun StudentListScreen(
    modifier: Modifier = Modifier,
    students: List<StudentUiModel> = studentUiModels(),
) {
    val screenBackground = colorResource(id = R.color.screen_background)
    val horizontalPadding = dimensionResource(id = R.dimen.screen_horizontal_padding)
    val cardSpacing = dimensionResource(id = R.dimen.card_spacing)

    Column(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .background(color = screenBackground)
            .padding(horizontal = horizontalPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Header()

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(space = cardSpacing),
        ) {
            items(
                items = students,
                key = { student -> student.nameRes },
            ) { studentData ->
                StudentCard(student = studentData)
            }
        }

        Footer()
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
private fun StudentListPreview() {
    QuestTugasLayout0146Theme {
        StudentListScreen()
    }
}
