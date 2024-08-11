package com.msv.appfitplanmobile.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.msv.appfitplanmobile.R
import com.msv.appfitplanmobile.navigation.BottomNavigationBarScreen
import com.msv.appfitplanmobile.ui.theme.AppFitPlanMobileTheme


@Composable
fun ProfileScreen(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigationBarScreen(navController)}
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF3C3C3C))
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TopAppBar()

                Spacer(modifier = Modifier.height(8.dp))

                ProfilePicture()

                Spacer(modifier = Modifier.height(8.dp))

                InputField(label = "Username", placeholder = "Input your username", width = 200.dp)
                InputField(
                    label = "Gender",
                    placeholder = "Input your gender",
                    width = 200.dp,
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_down),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    })
                InputField(
                    label = "Email",
                    placeholder = "guest@srikandi.id",
                    readOnly = true,
                    width = 200.dp
                )
                InputField(
                    label = "Password",
                    placeholder = "Input your password",
                    visualTransformation = PasswordVisualTransformation(),
                    width = 200.dp
                )

                Spacer(modifier = Modifier.height(4.dp))

                SaveButton()

                Spacer(modifier = Modifier.height(4.dp))

                SettingsOption(
                    icon = painterResource(id = R.drawable.settings),
                    label = "Training Settings"
                )
                SettingsOption(
                    icon = painterResource(id = R.drawable.suggest),
                    label = "Suggest And Input"
                )
                SettingsOption(
                    icon = painterResource(id = R.drawable.duration),
                    label = "Training Duration"
                )
                SettingsOption(
                    icon = painterResource(id = R.drawable.count),
                    label = "Countdown Time"
                )
                SettingsOption(icon = painterResource(id = R.drawable.reset), label = "Reset Progress")

                Spacer(modifier = Modifier.height(8.dp))

                Divider(
                    color = Color(0xFF5F33FF),
                    thickness = 1.dp,
                    modifier = Modifier
                        .width(400.dp)
                        .padding(vertical = 8.dp)
                )

                SettingsOption(icon = painterResource(id = R.drawable.rate), label = "Rate us!")
                SettingsOption(
                    icon = painterResource(id = R.drawable.suggestions),
                    label = "Suggestions and Input"
                )

                Spacer(modifier = Modifier.weight(1f)) // Spacer to push LogoutButton to the bottom

                LogoutButton()

                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun TopAppBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.back1),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "Profile",
            color = Color.White,
            fontSize = 24.sp,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun ProfilePicture() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Gray, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_user),
            contentDescription = null,
            tint = Color(0xFF6A00FF),
            modifier = Modifier.size(70.dp)
        )
    }
}

@Composable
fun InputField(
    label: String,
    placeholder: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    readOnly: Boolean = false,
    width: Dp = 200.dp,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 2.dp)
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text(text = placeholder) },
            visualTransformation = visualTransformation,
            readOnly = readOnly,
            trailingIcon = trailingIcon,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 2.dp)
                .widthIn(max = width)
        )
    }
}

@Composable
fun SaveButton() {
    Button(
        onClick = { /* Save action */ },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6A00FF)),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .width(150.dp)
            .height(50.dp)
    ) {
        Text(text = "Save", color = Color.White, fontSize = 16.sp)
    }
}

@Composable
fun LogoutButton() {
    Button(
        onClick = { /* Logout action */ },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD29E17)),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .width(150.dp)
            .height(50.dp)
    ) {
        Text(text = "Logout", color = Color.White, fontSize = 16.sp)
    }
}

@Composable
fun SettingsOption(icon: Painter, label: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* Handle click */ }
            .padding(vertical = 8.dp)
            .background(Color(0xFF6A00FF), shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = label,
            color = Color.White,
            fontSize = 16.sp,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(1f)
        )
        Icon(
            painter = painterResource(id = R.drawable.arrow_forward),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    AppFitPlanMobileTheme {
        ProfileScreen(navController = rememberNavController())
    }
}