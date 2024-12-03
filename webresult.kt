package com.example.webresult

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.webresult.ui.theme.WebResultTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WebResultTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WebResultList()
                }
            }
        }
    }
}


@Composable
fun WebResultList() {

    val sampleWebResults = listOf(
        WebResult(
            favicon = "https://www.google.com/favicon.ico",
            title = "How to Learn Android Development in 2024",
            siteUrl = "developer.android.com",
            description = "Learn how to build Android apps using Kotlin and Jetpack Compose. This comprehensive guide covers everything from basics to advanced topics."
        ),
        WebResult(
            favicon = "https://github.com/favicon.ico",
            title = "Jetpack Compose Tutorial",
            siteUrl = "github.com/compose-samples",
            description = "Official samples for Jetpack Compose, Android's modern toolkit for building native UI. Includes examples and best practices."
        ),
        WebResult(
            favicon = "https://github.com/favicon.ico",
            title = "Kotlin Programming Language",
            siteUrl = "kotlinlang.org",
            description = "Kotlin is a modern programming language that makes developers happier. Concise, safe, interoperable with Java."
        )
    )

    LazyColumn {
        items(sampleWebResults) { webResult ->
            WebResultItem(webResult, modifier = Modifier)
        }
    }
}

@Composable
fun WebResultItem(
    webResult: WebResult,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Favicon in circle shape
            AsyncImage(
                model = webResult.favicon,
                contentDescription = "Site favicon",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Column {
                // Title
                Text(
                    text = webResult.title,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                // URL
                Text(
                    text = webResult.siteUrl,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        // Description
        Text(
            text = webResult.description,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

