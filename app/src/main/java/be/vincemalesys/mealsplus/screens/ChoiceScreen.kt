package be.vincemalesys.mealsplus.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.vincemalesys.mealsplus.Bar
import be.vincemalesys.mealsplus.MealScreen
import be.vincemalesys.mealsplus.MealsPlusAppBar
import be.vincemalesys.mealsplus.MealsPlusAppBarBottom
import be.vincemalesys.mealsplus.Title
import be.vincemalesys.mealsplus.ui.theme.MealsPlusTheme


@Composable
fun ChoiceScreen(modifier: Modifier = Modifier) {
Column {
    MealsPlusAppBar(currentScreen = MealScreen.Start, canNavigateBack = false, navigateUp = { /*TODO*/ })
    Column(
        modifier = modifier
            .height(630.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Title()
        Row {
            Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                containerColor = androidx.compose.ui.graphics.Color.Red,
                contentColor = androidx.compose.ui.graphics.Color.White)) {
                Text(text = "Bestellen")
            }
            Spacer(modifier = modifier.width(10.dp))
            Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                containerColor = androidx.compose.ui.graphics.Color.Red,
                contentColor = androidx.compose.ui.graphics.Color.White)) {
                    Text(text = "Bestellingen")
            }
        }
    }
    MealsPlusAppBarBottom()
}
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun ChoiceScreenPreview(modifier: Modifier = Modifier) {
    MealsPlusTheme {
        ChoiceScreen()
    }
}