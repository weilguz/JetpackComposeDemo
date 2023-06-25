package com.example.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
                .size(40.dp)
                .clip(CircleShape), //设置图片的大小，形状
            contentDescription = "这是图片")
        Spacer(modifier = Modifier.width(8.dp))
        Column { //垂直排列元素
            Text(text = "Hello $name!")

            Spacer(modifier = Modifier.height(4.dp))

            Text(text = "Hello aaaaaaaaaaaaaaa!")
        }
    }
}
//Column 垂直排列
//Row 水平排列
//Box 堆叠元素
//Modifier 可以更改大小，布局，外观，还可以添加互动如点击

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