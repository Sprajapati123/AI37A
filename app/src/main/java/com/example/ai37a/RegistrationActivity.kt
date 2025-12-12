package com.example.ai37a

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ai37a.model.UserModel
import com.example.ai37a.repository.UserRepoImpl
import com.example.ai37a.ui.theme.AI37ATheme
import com.example.ai37a.ui.theme.Blue
import com.example.ai37a.ui.theme.Green
import com.example.ai37a.ui.theme.PurpleGrey80
import com.example.ai37a.ui.theme.White
import com.example.ai37a.viewmodel.UserViewModel
import java.util.Calendar

class RegistrationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RegisterBody()
        }
    }
}

@Composable
fun RegisterBody() {

    var userViewModel = remember { UserViewModel(UserRepoImpl()) }


    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var visibility by remember { mutableStateOf(false) }
    var terms by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val activity = context as Activity

    val sharedPreference = context
        .getSharedPreferences(
            "User",
            Context.MODE_PRIVATE
        )

    val editor = sharedPreference.edit()

    var selectedDate by remember { mutableStateOf("") }


    var calendar = Calendar.getInstance()

    var year = calendar.get(Calendar.YEAR)
    var month = calendar.get(Calendar.MONTH)
    var day = calendar.get(Calendar.DAY_OF_MONTH)

    var datePicker = DatePickerDialog(
        context, { _, y, m, d ->
            selectedDate = "$d/${m + 1}/$y"

        }, year, month, day
    )


//    var email : String = ""

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(White)
        ) {
            Spacer(modifier = Modifier.height(60.dp))
            Text(
                "Sign Up",
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(
                    color = Blue,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp
                )
            )


            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { data ->
                    email = data
                },
                shape = RoundedCornerShape(12.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                placeholder = {
                    Text("abc@gmail.com")
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = PurpleGrey80,
                    unfocusedContainerColor = PurpleGrey80,
                    focusedIndicatorColor = Blue,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = selectedDate,
                onValueChange = { data ->
                    selectedDate = data
                },
                shape = RoundedCornerShape(12.dp),
                enabled = false,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        datePicker.show()
                    }
                    .padding(horizontal = 15.dp),
                placeholder = {
                    Text("dd/mm/yyyy")
                },
                colors = TextFieldDefaults.colors(
                    disabledContainerColor = PurpleGrey80,
                    disabledIndicatorColor = Color.Transparent,
                    focusedContainerColor = PurpleGrey80,
                    unfocusedContainerColor = PurpleGrey80,
                    focusedIndicatorColor = Blue,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                },

                shape = RoundedCornerShape(12.dp),
                visualTransformation = if (!visibility) PasswordVisualTransformation() else VisualTransformation.None,
                trailingIcon = {
                    IconButton(onClick = {
                        visibility = !visibility
                    }) {
                        Icon(
                            painter = if (visibility)
                                painterResource(R.drawable.baseline_visibility_off_24)
                            else
                                painterResource(
                                    R.drawable.baseline_visibility_24
                                ),
                            contentDescription = null
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                placeholder = {
                    Text("*********")
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = PurpleGrey80,
                    unfocusedContainerColor = PurpleGrey80,
                    focusedIndicatorColor = Blue,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(20.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = terms,
                    onCheckedChange = { data ->
                        terms = data
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Green,
                        checkmarkColor = White
                    )
                )
                Text("I agree to terms & Conditions")
            }

            Button(
                onClick = {
                    if (!terms) {
                        Toast.makeText(
                            context,
                            "Please agree to terms & conditions",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {

                        userViewModel.register(email, password) { success, message, userId ->
                            if (success) {
                                var model = UserModel(
                                    userId = userId,
                                    firstName = "",
                                    lastName = "",
                                    gender = "",
                                    dob = selectedDate
                                )
                                userViewModel.addUserTODatabase(userId, model) { success, msg ->
                                    if (success) {
                                        activity.finish()
                                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                                    } else {
                                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

                                    }
                                }
                            } else {
                                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                            }
                        }
//                       editor.putString("email",email)
//                       editor.putString("password",password)
//                       editor.putString("date",selectedDate)
//
//                       editor.apply()
//                       activity.finish()
//
//                       Toast.makeText(context,"Registered Successfully", Toast.LENGTH_SHORT).show()
                    }

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Blue
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 6.dp
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(horizontal = 15.dp, vertical = 20.dp),
            ) {
                Text("Sign Up")
            }

            Text(
                buildAnnotatedString {
                    append("Already have an account?")

                    withStyle(style = SpanStyle(color = Blue)) {
                        append(" Sign In")
                    }
                }, modifier = Modifier.padding(horizontal = 15.dp),
                style = TextStyle(fontSize = 16.sp)
            )
        }
    }

}

@Preview
@Composable
fun RegisterPreview() {
    RegisterBody()
}