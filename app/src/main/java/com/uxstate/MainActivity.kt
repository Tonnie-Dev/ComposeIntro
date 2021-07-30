package com.uxstate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    names: List<String> = List(27){ index -> "Hello Android #$index"} ) {

    Column(modifier = Modifier.fillMaxHeight()) {

        Column(modifier = Modifier.weight(1f)) {
 NameList(names)


        }

        // create internal count value making this Composable Stateful
        var count by remember { mutableStateOf(0) }

        //Call CounterHoisted pass in the count and modify/update the count
        CounterHoisted(count) { newCount -> count = newCount }

    }
}




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

        Surface(color = Color.Yellow) {
            fxn()
        }
    }


}


@Composable
fun CounterHoisted(count: Int, updateCounter: (Int) -> Unit) {

    Row {
        //invoke updateCounter fxn passing in the count value
        Button(
            onClick = { updateCounter(count + 1) },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (count > 3) Color.Green else Color.White
            )
        ) {

            //Display Text
            Text(text = "Button Clicked $count times")

        }
    }

}


@Composable
fun NameList(names: List<String>){

    LazyColumn{

        items(items =names){

            name ->

            Greeting(name)
            Divider(thickness = 3.dp, color = Color.Magenta)
        }
    }
}