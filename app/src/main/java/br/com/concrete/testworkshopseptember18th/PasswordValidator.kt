package br.com.concrete.testworkshopseptember18th

class PasswordValidator {
    private val validations = listOf(
        "[A-Z]",
        "[0-9]",
        "[a-z]",
        "[^0-9a-zA-Z]",
        ".{8,}"
    ).map { it.toRegex() }

    fun isValid(password: String) = validations.all { validation ->
        password.contains(validation)
    }
}
