package com.example.project.features.signup_activity

import android.content.Intent
import com.example.project.util.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.project.R
import com.example.project.databinding.ActivitySignUpBinding
import com.example.project.features.home_activity.HomeActivity
import com.example.project.features.signup_activity.domain.data.model.user.User
import com.example.project.features.signup_activity.presentation.viewmodel.SignUpViewModel
import com.example.project.features.signup_activity.presentation.viewmodel.SignUpViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.security.MessageDigest

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var signUpViewModel: SignUpViewModel
    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialBinding()
        initialViewModel()
        setupSubmitButton()
    }

    private fun initialBinding() {
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initialViewModel() {
        signUpViewModel =
            ViewModelProvider(this, SignUpViewModelFactory())[SignUpViewModel::class.java]
    }

    private fun setupSubmitButton() {
        binding.buttonSubmit.setOnClickListener {
            if (validateForm()) {
                val name = binding.editTextName.text.toString()
                val studentNumber = binding.editTextStudentNumber.text.toString()
                val email = binding.editTextEmail.text.toString()
                val password = binding.editTextPassword.text.toString()

                // Simulate an API call to get a user token
                val userToken = md5(password)// Replace with actual token received from API

                // Create User object
                val user = User(email, name, studentNumber, userToken)

                callAPI(user)

                // Save user info to SharedPreferences
                SharedPreferences.saveUser(this, user)

                Toast.makeText(this, "Sign-Up Successful", Toast.LENGTH_SHORT).show()

                // Navigate to HomeActivity
                navigateToHomeActivity()
            }
        }
    }

    private fun callAPI(user: User) {
        CoroutineScope(Dispatchers.Main).launch {
            signUpViewModel.setUser(user)
        }
    }

    private fun navigateToHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }

    private fun validateForm(): Boolean {
        var isValid = true

        if (binding.editTextName.text.isNullOrEmpty()) {
            binding.layoutName.error = getString(R.string.error_name_required)
            isValid = false
        } else {
            binding.layoutName.error = null
        }

        if (binding.editTextStudentNumber.text.isNullOrEmpty()) {
            binding.layoutStudentNumber.error = getString(R.string.error_student_number_required)
            isValid = false
        } else {
            binding.layoutStudentNumber.error = null
        }

        if (binding.editTextEmail.text.isNullOrEmpty()) {
            binding.layoutEmail.error = getString(R.string.error_email_required)
            isValid = false
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(binding.editTextEmail.text.toString())
                .matches()
        ) {
            binding.layoutEmail.error = getString(R.string.error_invalid_email)
            isValid = false
        } else {
            binding.layoutEmail.error = null
        }

        if (binding.editTextPassword.text.isNullOrEmpty()) {
            binding.layoutPassword.error = getString(R.string.error_password_required)
            isValid = false
        } else {
            binding.layoutPassword.error = null
        }

        return isValid
    }

    fun md5(input: String): String {
        // Create MD5 Hash instance
        val md = MessageDigest.getInstance("MD5")

        // Compute the hash
        val byteArray = md.digest(input.toByteArray())

        // Convert byte array to hexadecimal string
        val hexChars = StringBuilder()
        for (byte in byteArray) {
            hexChars.append(String.format("%02x", byte))
        }

        return hexChars.toString()
    }

}
