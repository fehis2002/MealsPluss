package be.vincemalesys.mealsplus.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.vincemalesys.mealsplus.Bar
import be.vincemalesys.mealsplus.MealScreen
import be.vincemalesys.mealsplus.MealsPlusAppBar
import be.vincemalesys.mealsplus.MealsPlusAppBarBottom
import be.vincemalesys.mealsplus.Title
import be.vincemalesys.mealsplus.ui.theme.MealsPlusTheme


@Composable
fun OverviewOrderScreen(modifier: Modifier = Modifier) {
    Column {
        MealsPlusAppBar(currentScreen = MealScreen.Start, canNavigateBack = false, navigateUp = { /*TODO*/ })
        Column (modifier = modifier
            .fillMaxWidth()
            .height(630.dp)
            .padding(10.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
            Title()
            Text(text = "Een broodje Kaas - Smart - €3,15")
            Text(text = "Totaalprijs : €3,15")
            Text(text = "Locatie: Deli")
            Row {
                Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                    containerColor = androidx.compose.ui.graphics.Color.Red,
                    contentColor = androidx.compose.ui.graphics.Color.White)) {
                    Text(text = "Terug")
                }
                Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                    containerColor = androidx.compose.ui.graphics.Color.Red,
                    contentColor = androidx.compose.ui.graphics.Color.White)) {
                    Text(text = "Betalen")
                }
            }
        }
        MealsPlusAppBarBottom()
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun OverviewOrderScreenPreview() {
    MealsPlusTheme {
        OverviewOrderScreen()
    }
}