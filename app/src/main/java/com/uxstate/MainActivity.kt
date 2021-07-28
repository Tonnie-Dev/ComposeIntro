package com.uxstate

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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
            AppContainer { MyScreenContent() }
        }
    }
}


@Composable
fun Greeting(name: String) {


    Text(text = "Hello $name!", modifier = Modifier.padding(8.dp))


}





@Composable
fun MyScreenContent(
    cities: List<String> = listOf(
        "Tokyo",
        "London",
        "Conakry",
        "Nairobi",
        "Pretoria",
        "Brasilia"
    )
) {

    Column {
        for (city in cities) {


            Text(text = city, modifier = Modifier.padding(8.dp))
            Divider(color = Color.Green, thickness = 2.dp)

        }

        Spacer(Modifier.height(8.dp))


        // create internal count value making this Composable Stateful
        var count by remember { mutableStateOf(0) }

        //Call CounterHoisted pass in the count and modify/update the count
        CounterHoisted(count) { newCount -> count = newCount }
    }
}


/*
@Composable
fun Counter() {

//initialize count using remember 
    
    val count = remember{ mutableStateOf(0)}
    
    //use count.value to retrieve counter value
    Button(onClick = { count.value ++ }) {
        
        Text(text = "Have been clicked ${count.value} times")
    }
  
}*/

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeIntroTheme {
        AppContainer {
            MyScreenContent()
        }
    }
}


@Composable
fun AppContainer(fxn: @Composable () -> Unit) {

    ComposeIntroTheme {

        Surface(color = Color.Yellow, modifier = Modifier.fillMaxHeight()) {
            fxn()
        }
    }


}


@Composable
fun CounterHoisted(count: Int, updateCounter: (Int) -> Unit) {

    Row {
        //invoke updateCounter fxn passing in the count value
        Button(onClick = { updateCounter(count + 1) }) {

            //Display Text
            Text(text = "Button Clicked $count times")

        }
    }

}