package com.example.contactinformation

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun SetupNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "contactList"
    ){
        composable("contactList"){
            ContactListScreen(navController = navController)
        }
        composable("contactDetails/{contact}"){ backStackEntry ->
            val contact = backStackEntry.arguments?.getString("contact")
            if(contact != null){
                ContactDetailsScreen(contact = contact, onBack = {
                    navController.popBackStack()
                })
            } else {
                Toast.makeText(LocalContext.current, "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }
}