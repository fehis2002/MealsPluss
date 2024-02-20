package be.vincemalesys.mealsplus

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import be.vincemalesys.mealsplus.screens.ChoiceScreen
import be.vincemalesys.mealsplus.screens.OrderScreen
import be.vincemalesys.mealsplus.screens.OverviewOrderScreen
import be.vincemalesys.mealsplus.screens.PaymentAcceptanceScreen
import be.vincemalesys.mealsplus.screens.QRCodeScreen
import be.vincemalesys.mealsplus.ui.Menu


enum class MealScreen(@StringRes val title: Int){
    Start(title = R.string.menu),
    Choice(title = R.string.Choice),
    Order(title = R.string.Order),
    Overview(title = R.string.Overview),
    Payment(title = R.string.Payment),
    Qr(title = R.string.QR)


}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealsPlusAppBar(
    currentScreen: MealScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
    title = {},
    colors = TopAppBarDefaults.mediumTopAppBarColors(
    containerColor = Color.Red,
    titleContentColor = Color.White
    ),
    modifier = modifier,
    navigationIcon = {
        Text(text = "Vives Plus", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)

    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealsPlusAppBarBottom(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {},
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.Red,
            titleContentColor = Color.White
        ),
        modifier = modifier,
        navigationIcon = {
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Column (horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painter = painterResource(id = R.drawable.ic_dashboard_8c8c8c_24dp), contentDescription = "dash", alignment = Alignment.Center)
                    Text(text = "Dashboard", color = Color.White)

                }
                Column (horizontalAlignment = Alignment.CenterHorizontally){
                    Image(painter = painterResource(id = R.drawable.ic_view_agenda_8c8c8c_24dp), contentDescription = "agenda")
                    Text(text = "Agenda", color = Color.White)
                }
                Column (horizontalAlignment = Alignment.CenterHorizontally){
                    Image(painter = painterResource(id = R.drawable.ic_baseline_menu_24), contentDescription = "menu")
                    Text(text = "Menu", color = Color.White)

                }
            }

        })
}


@Composable
fun MealsPlusApp(navController: NavHostController = rememberNavController()){
    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen = MealScreen.valueOf(
        backStackEntry?.destination?.route ?: MealScreen.Start.name
    )

    Scaffold(
        topBar = {
            MealsPlusAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = {
                    navController.navigateUp()
                }
            )
        },
        bottomBar = {
            MealsPlusAppBarBottom()
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = MealScreen.Start.name,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = MealScreen.Start.name){
                Menu(click = { navController.navigate(MealScreen.Choice.name)})
            }
            composable(route = MealScreen.Choice.name){
                ChoiceScreen(click = {navController.navigate(MealScreen.Order.name)}, clickBestellingen = {navController.navigate(MealScreen.Qr.name)})
            }
            composable(route = MealScreen.Order.name){
                OrderScreen(click = {navController.navigate(MealScreen.Overview.name)})
            }
            composable(route = MealScreen.Overview.name){
                OverviewOrderScreen(click = {navController.navigate(MealScreen.Payment.name)}, clickTerug = {navController.navigate(MealScreen.Order.name)})
            }
            composable(route = MealScreen.Payment.name){
                PaymentAcceptanceScreen()
            }
            composable(route = MealScreen.Qr.name){
                QRCodeScreen()
            }


        }

    }
}