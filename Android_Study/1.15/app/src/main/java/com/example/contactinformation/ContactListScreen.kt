package com.example.contactinformation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ContactListScreen(navController: NavController? = null){
    val contactList = listOf("OOO", "OoO", "oOo")

    LazyColumn{
        items(contactList) {contact ->
            ContactListItem(contact, navController)
        }
    }
}

@Composable
fun ContactListItem(contact: String, navController: NavController? = null) {
    Row(
        modifier = Modifier
            .clickable {
                navController?.navigate("contactDetails/$contact")
            }
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(imageVector = Icons.Default.Person, contentDescription = "Contact Icon")
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = contact)
    }
}

@Preview(showBackground = true)
@Composable
fun ContactListPreview() {
    ContactListScreen()
}
