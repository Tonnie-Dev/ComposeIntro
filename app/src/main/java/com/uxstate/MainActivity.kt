package com.uxstate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uxstate.ui.theme.ComposeIntroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp { MyScreenContent() }
        }
    }
}


@Composable
fun MyApp(content: @Composable () -> Unit) {
    ComposeIntroTheme {
        Surface(color = Color.Magenta) {


            content()
        }


    }

}

@Composable
fun Greeting(name: String) {


    Text(text = "Hello $name!", modifier = Modifier.padding(8.dp))


}


@Composable
fun MyScreenContent(names: List<String> = listOf("Tonnie", "GOAT", "Antony")) {


    Column {

        for (name in names) {
            Greeting(name)
            Spacer(modifier = Modifier.height(8.dp))
            Divider(color = Color.Red, thickness = 12.dp)

        }
        Spacer(modifier = Modifier.height(8.dp))
        Counter()
    }

}



@Composable
fun Counter(){


    val count = remember{ mutableStateOf(0)}


    Button(onClick = { count.value++ }) {

        Text("I've been clicked ${count.value} times")
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeIntroTheme {
        MyApp {
            MyScreenContent()
        }
    }
}