package be.vincemalesys.mealsplus.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import be.vincemalesys.mealsplus.MealScreen
import be.vincemalesys.mealsplus.MealsPlusAppBar
import be.vincemalesys.mealsplus.MealsPlusAppBarBottom
import be.vincemalesys.mealsplus.R
import be.vincemalesys.mealsplus.Title
import be.vincemalesys.mealsplus.ui.theme.MealsPlusTheme

@Composable
fun QRCodeScreen(modifier: Modifier = Modifier) {
    Column {
        MealsPlusAppBar(currentScreen = MealScreen.Start, canNavigateBack = false, navigateUp = { /*TODO*/ })
        Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.padding(10.dp).fillMaxWidth().height(610.dp)) {
            Title()
            Text(text = "Bestellingsnummer", fontSize = 30.sp)
            Text(text = "0235456871353", fontSize = 25.sp)
            Text(text = "Uw bestelling is gereed")
            Image(painter = painterResource(id = R.drawable.qrcode), contentDescription = null)
            Text(text = "In vak 10 om 13:00", fontSize = 30.sp)
        }
        MealsPlusAppBarBottom()
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun QRCodeScreenPreview(modifier: Modifier = Modifier) {
    MealsPlusTheme {
        QRCodeScreen(modifier = modifier)
    }
}
