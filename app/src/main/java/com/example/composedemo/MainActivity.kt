package com.example.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composedemo.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable //可组合函数
fun Greeting(name: String) {
    Row (modifier = Modifier.padding(all = 8.dp)) { //水平排列各项
        Image(painter = painterResource(id = R.drawable.ic_launcher_background),
            modifier = Modifier
                .size(40.dp)//设置图片的大小
                .clip(CircleShape)//设置图片的形状
                .border(1.5.dp, MaterialTheme.colors.primary, CircleShape),//设置图片的边框
            contentDescription = "这是图片")
        Spacer(modifier = Modifier.width(8.dp))
        Column { //垂直排列元素
            Text(text = "Hello $name!")

            Spacer(modifier = Modifier.height(4.dp))

            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Text(text = "Hello aaaaaaaaaaaaaaa!", modifier = Modifier.padding(all = 4.dp))
            }
        }
    }
}
//Column 垂直排列
//Row 水平排列
//Box 堆叠元素
//Modifier 可以更改大小，布局，外观，还可以添加互动如点击
//Surface 将Text封装在Surface中，可以自定义Text的形状和阴影等

@Preview(showBackground = true) //预览可组合函数
@Composable
fun DefaultPreview() {
    ComposeDemoTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Greeting("Android")
        }
    }
}