package com.example.gonggoose.ui.component.postScreenUi

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gonggoose.R
import com.example.gonggoose.ui.theme.Black
import com.example.gonggoose.ui.theme.LightBlue
import com.example.gonggoose.ui.theme.MediumGray
import com.example.gonggoose.ui.theme.White
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun PostDateComponent() {
    var selectedDate by remember { mutableStateOf(Calendar.getInstance()) }
    var showDialog by remember { mutableStateOf(false) }

    var dataText by remember {
        mutableStateOf("날짜를 선택하세요")
    }

    var color by remember {
        mutableStateOf(MediumGray)
    }

    Box(
        modifier = Modifier
            .clickable {
                showDialog = true
            }
            .background(
                color = White,
                shape = RoundedCornerShape(15.dp)
            )
            .border(3.dp, LightBlue, shape = RoundedCornerShape(15.dp))
            .fillMaxWidth()
            .height(50.dp),
    ) {
        Text(
            text = dataText,
            color = color,
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.bmjua)),
            modifier = Modifier
                .align(Alignment.Center)
        )
        if(showDialog){
            ShowDatePickerDialog(selectedDate) { newDate ->
                selectedDate = newDate
                showDialog = false
                dataText = newDate.getFormattedDateString() +  " (" + (selectedDate.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.KOREAN)
                    ?.get(0) ?: "?") + ")"
                color = Black
            }
        }
    }
}

fun Calendar.getFormattedDateString(): String {
    val dateFormat = SimpleDateFormat("yyyy.MM.dd", Locale.getDefault())
    return dateFormat.format(time)
}

@Composable
fun ShowDatePickerDialog(initialDate: Calendar, onDateSelected: (Calendar) -> Unit) {
    val year = initialDate.get(Calendar.YEAR)
    val month = initialDate.get(Calendar.MONTH)
    val day = initialDate.get(Calendar.DAY_OF_MONTH)

    val datePickerDialog = DatePickerDialog(
        LocalContext.current,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            val selectedDate = Calendar.getInstance()
            selectedDate.set(Calendar.YEAR, year)
            selectedDate.set(Calendar.MONTH, month)
            selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            onDateSelected(selectedDate)
        },
        year,
        month,
        day
    )

    datePickerDialog.show()
}