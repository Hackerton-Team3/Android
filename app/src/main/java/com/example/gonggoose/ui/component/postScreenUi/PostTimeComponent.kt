package com.example.gonggoose.ui.component.postScreenUi

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gonggoose.R
import com.example.gonggoose.ui.theme.GongGooseTheme
import com.example.gonggoose.ui.theme.LightBlue
import com.example.gonggoose.ui.theme.MediumGray
import com.example.gonggoose.ui.theme.White
import java.util.Calendar

@Composable
fun PostTimeComponent(): Calendar {
    var selectedTime by remember { mutableStateOf(getInitialTime()) }

    var hour by remember {
        mutableIntStateOf(selectedTime.get(Calendar.HOUR_OF_DAY))
    }
    var minute by remember {
        mutableIntStateOf(selectedTime.get(Calendar.MINUTE))
    }
    var color by remember {
        mutableStateOf(MediumGray)
    }

    var check by remember {
        mutableStateOf(false)
    }

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 13.dp,
                end  =13.dp,
                top = 25.dp,
                bottom = 15.dp
//                horizontal = 13.dp,
//                vertical = 25.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(120.dp)
                .background(
                    color = color,
                    shape = RoundedCornerShape(15.dp)
                )
                .clickable {
                    check = true
                }
        ){
            Text(
                text = hour.toString(),
                fontFamily = FontFamily(Font(R.font.bmjua)),
                color = White,
                modifier = Modifier
                    .align(Alignment.Center),
                fontSize = 50.sp
            )
        }
        Text(
            text = ":",
            fontSize = 80.sp,
            fontFamily = FontFamily(Font(R.font.bmjua)),
            modifier = Modifier
                .padding(horizontal = 15.dp)
        )
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(120.dp)
                .background(
                    color = color,
                    shape = RoundedCornerShape(15.dp)
                )
                .clickable {
                    check = true
                }
        ){
            Text(
                text = minute.toString(),
                fontFamily = FontFamily(Font(R.font.bmjua)),
                color = White,
                modifier = Modifier
                    .align(Alignment.Center),
                fontSize = 50.sp
            )
        }
        Text(
            text = "PM",
            fontSize = 30.sp,
            fontFamily = FontFamily(Font(R.font.bmjua)),
            modifier = Modifier
                .padding(start = 20.dp)
                .align(Alignment.Bottom)
        )

        if(check){
            showTimePickerDialog(selectedTime) { newTime ->
                selectedTime = newTime
                // 사용자가 선택한 시간을 String state에 저장
                hour = newTime.get(Calendar.HOUR_OF_DAY)
                minute = newTime.get(Calendar.MINUTE)
                check = false
                color = LightBlue
            }
        }
    }
    return selectedTime
}

fun getInitialTime(): Calendar {
    val initialTime = Calendar.getInstance()
    initialTime.set(Calendar.HOUR_OF_DAY, 0)
    initialTime.set(Calendar.MINUTE, 0)
    return initialTime
}

@Composable
fun showTimePickerDialog(initialTime: Calendar, onTimeSelected: (Calendar) -> Unit) {
    val context = LocalContext.current

    val hour = initialTime.get(Calendar.HOUR_OF_DAY)
    val minute = initialTime.get(Calendar.MINUTE)

    val timePickerDialog = android.app.TimePickerDialog(
        context,
        { _, hourOfDay, minute ->
            val selectedTime = Calendar.getInstance()
            selectedTime.set(Calendar.HOUR_OF_DAY, hourOfDay)
            selectedTime.set(Calendar.MINUTE, minute)
            onTimeSelected(selectedTime)
        },
        hour,
        minute,
        true // true일 경우 24시간 형식, false일 경우 AM/PM 형식
    )

    timePickerDialog.show()
}

@Preview
@Composable
private fun Preview() {
    GongGooseTheme {
        PostTimeComponent()
    }
}