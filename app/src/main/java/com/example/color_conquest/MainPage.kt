package com.example.color_conquest

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MainPage(navController: NavController) {
    //The background

    val fontFamily = FontFamily(
        Font(R.font.lackeral, FontWeight.ExtraBold)
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xffffc271),
                        Color(0xffff5f6d)
                    )
                )
            )
    ){

        //tri-state toggle
        Box(
            modifier = Modifier
                .padding(top = 8.dp, start = 20.dp)
                .background(Color.Transparent)
        ){
            Box(
                modifier = Modifier
                    .background(Color.Black)
                    .align(Alignment.Center)
                    .height(20.dp)
                    .width(200.dp)
            )
            Row {
                Box(
                    modifier = Modifier.background(Color.Transparent)
                ){
                    val color by animateColorAsState(
                        targetValue = if(mode.intValue == 0) Color(0xffff5f6d) else Color.Black,
                        label = "green and black"
                    )
                    Button(
                        onClick = { mode.intValue = 0 },
                        modifier = Modifier
                            .size(50.dp),
                        shape = RoundedCornerShape(100),
                        colors = ButtonDefaults.buttonColors(containerColor = color)
                    ){
                    }
                }

                Spacer(modifier = Modifier.size(50.dp))

                Box(modifier = Modifier.background(Color.Transparent)){
                    val color by animateColorAsState(
                        targetValue = if(mode.intValue == 1) Color(0xffff5f6d) else Color.Black,
                        label = "green and black"
                    )
                    Button(
                        onClick = { mode.intValue = 1 },
                        modifier = Modifier
                            .size(50.dp),
                        shape = RoundedCornerShape(100),
                        colors = ButtonDefaults.buttonColors(containerColor = color)
                    ){}
                    Image(
                        modifier = Modifier
                            .size(30.dp)
                            .align(Alignment.Center),
                        painter = painterResource(id = R.drawable.hacker),
                        contentDescription = "hacker"
                    )
                }

                Spacer(modifier = Modifier.size(50.dp))

                Box(modifier = Modifier.background(Color.Transparent)){
                    val color by animateColorAsState(
                        targetValue = if(mode.intValue == 2) Color(0xffff5f6d) else Color.Black,
                        label = "green and black"
                    )
                    Button(
                        onClick = { mode.intValue = 2 },
                        modifier = Modifier
                            .size(50.dp),
                        shape = RoundedCornerShape(100),
                        colors = ButtonDefaults.buttonColors(containerColor = color)
                    ){}
                    Image(
                        modifier = Modifier
                            .size(30.dp)
                            .align(Alignment.Center),
                        painter = painterResource(id = R.drawable.skull),
                        contentDescription = "skull"
                    )
                }
            }
        }

        Button(
            onClick = { pageFlag.intValue = 4 },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(5.dp)
        ) {
            Text(text = "WIN")
        }
        //COLOR CONQUEST TITLE
        Text(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 72.dp),
            style = TextStyle(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xff1b1010),
                        Color(0xff744a3e)
                    )
                )
            ),
            text = "COLOR",
            fontSize = 72.sp,
            fontFamily = fontFamily
        )
        Text(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 160.dp),
            style = TextStyle(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xff925956),
                        Color(0xffdc8681)
                    )
                )
            ),
            text = "CONQUEST",
            fontSize = 72.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = fontFamily
        )

        //PLAY BUTTON
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Transparent)
        ){
            val nav: String
            if (mode.intValue == 1){
                nav = Screen.HackerSelection.route
            }else{
                nav = Screen.PlayerInformation.route
            }
            Button(
                onClick = {navController.navigate(nav)},
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .offset(x = (-18).dp)
                    .padding(bottom = 96.dp)
                    .shadow(5.dp, RoundedCornerShape(36.dp)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff2fb6f0)
                )
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 38.dp, end = 38.dp, top = 6.dp, bottom = 6.dp),
                    text = "PLAY",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        //INFO BUTTON
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Transparent)
        ){
            OutlinedButton(onClick = { pageFlag.intValue = 1 },
                modifier= Modifier
                    .size(78.dp)
                    .align(Alignment.BottomEnd)
                    .offset(y = (-96).dp, x = (-12).dp)
                    .shadow(5.dp, shape = CircleShape),  //avoid the oval shape
                shape = CircleShape,
                contentPadding = PaddingValues(0.dp),  //avoid the little icon
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor =  Color.White,
                    containerColor = Color(0XFF3b4276)
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.question),
                    contentDescription = "Know more",
                    modifier = Modifier
                        .size(54.dp)
                )
            }
        }

        //VERSUS ICON
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Transparent),
            contentAlignment = Alignment.Center
        ){
            Image(
                modifier = Modifier
                    .size(380.dp)
                    .offset(y = 75.dp),
                painter = painterResource(id = R.drawable.versus),
                contentDescription = "versus",
            )
        }
    }
}