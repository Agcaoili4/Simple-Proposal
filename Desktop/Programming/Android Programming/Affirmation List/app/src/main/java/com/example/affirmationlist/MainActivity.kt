package com.example.affirmationlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.affirmationlist.data.Datasource
import com.example.affirmationlist.model.Affirmation
import com.example.affirmationlist.ui.theme.AffirmationListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AffirmationListTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(){
                        Spacer(modifier = Modifier.height(16.dp))
                        AffirmationApp(
                            modifier = Modifier.padding(innerPadding)
                        )
                        AffirmationApp()
                    }
                }
            }
        }
    }
}

@Composable
fun AffirmationApp( modifier: Modifier = Modifier) {
    AffirmationList(affirmationList = Datasource().loadAffirmation())
}
@Composable
fun AffirmationCard(affirmation: Affirmation, modifier:Modifier){
    Card(modifier = modifier) {
        Column() {
            Image(painter = painterResource(affirmation.imageResourceId),
                contentDescription = null,
                modifier=Modifier.fillMaxWidth().height(194.dp)
            , contentScale = ContentScale.Crop)
            Text(
                text = stringResource(affirmation.stringResourceId),
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun AffirmationList(affirmationList: List<Affirmation>){
    //Loads data or objects one at a time depending on where the screen goes
    LazyColumn(){
            items(items = affirmationList){
            affirmation-> AffirmationCard(affirmation = affirmation,
                modifier = Modifier.padding(8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AffirmationListTheme {
        AffirmationApp()
    }
}