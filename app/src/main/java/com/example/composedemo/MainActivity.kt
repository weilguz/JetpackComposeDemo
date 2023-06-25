package com.example.composedemo

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composedemo.bean.Message
import com.example.composedemo.ui.theme.ComposeDemoTheme
import com.example.composedemo.util.SampleData

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
                    MsgList(SampleData.conversationSample())
                }
            }
        }
    }
}

@Composable //可组合函数
fun Greeting(msg: Message) {
    Row (modifier = Modifier.padding(all = 8.dp)) { //水平排列各项
        Image(painter = painterResource(id = R.drawable.ic_launcher_background),
            modifier = Modifier
                .size(40.dp)//设置图片的大小
                .clip(CircleShape)//设置图片的形状
                .border(1.5.dp, MaterialTheme.colors.primary, CircleShape),//设置图片的边框
            contentDescription = "这是图片")
        Spacer(modifier = Modifier.width(8.dp))
        var isExpanded by remember { mutableStateOf(false) }
        Column (modifier = Modifier.clickable { isExpanded = !isExpanded }){ //垂直排列元素
            Text(text = msg.name)

            Spacer(modifier = Modifier.height(4.dp))

            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Text(text = msg.msg, modifier = Modifier.padding(all = 4.dp), maxLines = if (isExpanded) Int.MAX_VALUE else 1)
            }
        }
    }
}

//Column 垂直排列
//Row 水平排列
//Box 堆叠元素
//Modifier 可以更改大小，布局，外观，还可以添加互动如点击
//Surface 将Text封装在Surface中，可以自定义Text的形状和阴影等
//LazyColumn 垂直列表
//LazyRow 水平列表
//使用remember和mutableStateOf函数 remember将本地状态存储在内存中，并跟踪传递给mutableStateOf的值的变化

@Preview(showBackground = true) //浅色主题预览可组合函数
@Preview( //浅色主题预览可组合函数
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "1234"
)
@Composable
fun DefaultPreview() {
    ComposeDemoTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            MsgList(SampleData.conversationSample())
        }
    }
}

@Composable
fun MsgList(messageList: List<Message>){
    LazyColumn {
        items(messageList) {msg ->
            Greeting(msg)
        }
    }
}