package be.vincemalesys.mealsplus

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Bar(modifier: Modifier = Modifier) {
    Column {
        Row(
            modifier = modifier
                .height(100.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Dashboard", modifier.weight(0.3f), textAlign = TextAlign.Center)
            Text(text = "Timetable", modifier.weight(0.3f), textAlign = TextAlign.Center)
            Text(text = "Menu", modifier.weight(0.3f), textAlign = TextAlign.Center)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dropdown(modifier: Modifier = Modifier, placeholder: String, lijst: List<String>) {
    var isExpanded by remember {
        mutableStateOf(false)
    }

    var item by remember {
        mutableStateOf("")
    }
    var selectedOptionText by remember {
        mutableStateOf(lijst[0])
    }

    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = { newValue ->
            isExpanded = newValue
        }
    ) {
        TextField(
            value = item,
            onValueChange = {},
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
            },
            placeholder = {
                Text(text = placeholder)
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
            modifier = Modifier.menuAnchor()
        )
        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = {
                isExpanded = false
            }
        ) {
            lijst.forEach {
                    selectionOption ->
                DropdownMenuItem(
                    text = { Text(selectionOption) },
                    onClick = {
                        selectedOptionText = selectionOption
                        isExpanded = false
                        item = selectedOptionText
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                )
            }
            }
        }
}

@Composable
fun Textarea(modifier: Modifier = Modifier) {
    val text = rememberSaveable { mutableStateOf("") }
    TextField(
        value = text.value,
        onValueChange = { text.value = it }, modifier = modifier
            .height(100.dp)
            .padding(10.dp)
            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp)),
        placeholder = {
            Text(text = "Details")
        }
    )
}

@Composable
fun Title(modifier: Modifier = Modifier) {
    Text(text = "Meals Plus", fontSize = 60.sp, color = Color.Red, fontFamily = FontFamily.Cursive, fontWeight = FontWeight.Bold)
}