package com.uxstate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
            Divider(color = Color.Red)
            Spacer(modifier = Modifier.height(8.dp))

        }
    }

}

@Preview(showBackground = true)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeIntroTheme {
        MyApp {
            MyScreenContent()
        }
    }
}