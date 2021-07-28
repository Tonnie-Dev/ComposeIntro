package com.uxstate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
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
            /*AppContainer is passed an empty function
            where we call the MyScreenContent composable*/
            AppContainer {MyScreenContent()}
        }
    }
}




@Composable
fun Greeting(name: String) {


    Text(text = "Hello $name!", modifier = Modifier.padding(8.dp))


}


@Composable
fun MyScreenContent(names: List<String> = listOf("GOAT", "Tonnie")) {

//wrap in Column for vertical orientation.
    Column {
        for (name in names) {

            Greeting(name)

            //add Divider and Spacer
            Divider(color = Color.Red, thickness = 2.dp)
            Spacer(Modifier.height(8.dp))

        }

        Counter()
    }
}





@Composable
fun Counter() {

//initialize count using remember 
    
    val count = remember{ mutableStateOf(0)}
    
    //use count.value to retrieve counter value
    Button(onClick = { count.value ++ }) {
        
        Text(text = "Have been clicked ${count.value} times")
    }
  
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeIntroTheme {
        AppContainer {
            MyScreenContent()
	}    }
}


@Composable
fun AppContainer(fxn: @Composable () -> Unit) {

    ComposeIntroTheme {

        Surface(color = Color.Yellow) {
            fxn()
        }
    }


}