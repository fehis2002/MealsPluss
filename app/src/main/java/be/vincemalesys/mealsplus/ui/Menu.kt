package be.vincemalesys.mealsplus.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import be.vincemalesys.mealsplus.R

@Composable
fun Menu(click: () -> Unit){
    LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .padding(0.dp, 20.dp, 0.dp, 0.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(20.dp)){
        item{ Personal()}
        item{ ItemBox(id = R.drawable.ic_directions_bus_8c8c8c_21dp, value = "Bus & Train")}
        item{ MealsPlusBox(id = R.drawable.restaurant_foreground, click = click) }
        item{ ItemBox(id = R.drawable.ic_qr_code, value = "Identity QR")}
        item{ ItemBox(id = R.drawable.baseline_shopping_basket_24, value = "Vives web-shop")}
        item{ ItemBox(id = R.drawable.ic_baseline_support_agent_24, value = "Support")}

    }
}

@Composable
fun Personal(){
    Box(modifier = Modifier
        .clip(shape = RoundedCornerShape(10.dp))
        .background(color = Color.LightGray)
        .padding(10.dp, 5.dp, 10.dp, 5.dp)
        .fillMaxWidth(0.85f),

    ){
        Row(verticalAlignment = Alignment.CenterVertically)  {
            Column(modifier = Modifier.padding(0.dp,0.dp, 5.dp, 0.dp)) {
                Image(painter = painterResource(id = R.drawable.ic_person_8c8c8c_48dp), contentDescription = "person")
            }
            Column(modifier = Modifier.padding(0.dp,0.dp, 5.dp, 0.dp)) {
                Text(text = "Vince Malesys", color = Color.Gray, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text(text = "r0887669", color = Color.Gray)
            }
            Row(horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically) {
                Column(
                    modifier = Modifier.padding(0.dp, 0.dp, 5.dp, 0.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_settings_8c8c8c_24dp),
                        contentDescription = "settings"
                    )
                }
                Column(verticalArrangement = Arrangement.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_baseline_login_24),
                        contentDescription = "login"
                    )
                }
            }
        }

    }
}

@Composable
fun ItemBox(id : Int, value: String){
    Box(modifier = Modifier
        .clip(shape = RoundedCornerShape(10.dp))
        .padding(10.dp, 5.dp, 10.dp, 5.dp)
        .fillMaxWidth(0.85f)
        .border(2.dp, Color.LightGray, shape = RoundedCornerShape(10.dp)),
        ){
        Row(verticalAlignment = Alignment.CenterVertically)  {
            Column{
                Image(painter = painterResource(id = id), contentDescription = "")
            }
            Column(Modifier.padding(20.dp)){
                Text(text = value, fontSize = 28.sp, color = Color.Gray)
            }
        }
    }
}

@Composable
fun MealsPlusBox(id : Int, click: () -> Unit){
    Box(modifier = Modifier
        .clip(shape = RoundedCornerShape(10.dp))
        .padding(10.dp, 5.dp, 10.dp, 5.dp)
        .fillMaxWidth(0.85f)
        .border(2.dp, Color.LightGray, shape = RoundedCornerShape(10.dp))
        .clickable(onClick = click),
    ){
        Row(verticalAlignment = Alignment.CenterVertically)  {
            Column{
                Image(painter = painterResource(id = id), contentDescription = "")
            }
            Column(Modifier.padding(20.dp)){
                Text(text = "Meals Plus", fontSize = 32.sp, color = Color.Gray, fontFamily = FontFamily.Cursive, fontWeight = FontWeight.Bold)

            }
        }
    }
}