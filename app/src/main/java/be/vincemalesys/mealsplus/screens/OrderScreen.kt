package be.vincemalesys.mealsplus.screens

import android.graphics.Color
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import be.vincemalesys.mealsplus.Bar
import be.vincemalesys.mealsplus.Dropdown
import be.vincemalesys.mealsplus.MealScreen
import be.vincemalesys.mealsplus.MealsPlusAppBar
import be.vincemalesys.mealsplus.MealsPlusAppBarBottom
import be.vincemalesys.mealsplus.Textarea
import be.vincemalesys.mealsplus.Title
import be.vincemalesys.mealsplus.ui.theme.MealsPlusTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderScreen(modifier: Modifier = Modifier) {

    var broodjes = listOf<String>(
        "Ham - SMART - €3,15",
        "Kippenwit - SMART - €3,15",
        "Kaas (veggie) - SMART - €3,15",
        "Tonijnsalade - CLASSIC - €3,40",
        "Surimisalade- CLASSIC - €3,40",
        "Martino- CLASSIC - €3,40",
        "Smokey chicken - NOBLE - €3,75",
        "Geitenkaas (veggie) - NOBLE - €3,75",
        "Ham Boursin - NOBLE - €3,75",
        "Geitenkaas & gerookte ham - LUXE - €4,60",
        "Tijgergeranalen - LUXE - €4,60",
        "3 kazen (veggie) - LUXE - €4,60",
        )

    var tijdstippen = listOf<String>(
        "12:00",
        "13:00"
    )

    var restaurants = listOf<String>(
        "Deli"
    )

    var typen = listOf<String>(
        "Wit",
        "Bruin"
    )

    Column {
        MealsPlusAppBar(currentScreen = MealScreen.Start, canNavigateBack = false, navigateUp = { /*TODO*/ })
        Column (
            modifier = modifier
                .height(630.dp)
                .fillMaxWidth()
                .padding(10.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Title()
            Row {
                Dropdown(placeholder = "kies een restaurant", lijst = restaurants)
            }
            Row {
                Dropdown(placeholder = "Kies uw broodje", lijst = broodjes)
            }
            Row {
                Dropdown(placeholder = "Kies het type brood", lijst = typen)
            }
            Row {
                Textarea()
            }
            Row {
                Dropdown(placeholder = "kies een tijdstip", lijst = tijdstippen)
            }
            Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                containerColor = androidx.compose.ui.graphics.Color.Red,
                contentColor = androidx.compose.ui.graphics.Color.White))
            {
                Text(text = "Bestellen")
            }
        }
        MealsPlusAppBarBottom()
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun OrderScreenPreview(modifier: Modifier = Modifier) {

    MealsPlusTheme {
        OrderScreen()
    }
}