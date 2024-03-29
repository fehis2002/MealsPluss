package be.vincemalesys.mealsplus.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import be.vincemalesys.mealsplus.MealScreen
import be.vincemalesys.mealsplus.MealsPlusApp
import be.vincemalesys.mealsplus.MealsPlusAppBar
import be.vincemalesys.mealsplus.MealsPlusAppBarBottom
import be.vincemalesys.mealsplus.Title
import be.vincemalesys.mealsplus.ui.theme.MealsPlusTheme

@Composable
fun PaymentAcceptanceScreen(modifier: Modifier = Modifier) {
    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier
            .height(630.dp)
            .padding(10.dp)
            .fillMaxWidth()){
            Title()
            Text(text = "Uw bestelling is geregistreerd.", fontSize = 25.sp, lineHeight = 50.sp, fontWeight = FontWeight.Bold)
            Text(text = "Van zodra deze klaar is kunt u deze afhalen met uw QR-code", fontSize = 20.sp, textAlign = TextAlign.Center)
        }
}

