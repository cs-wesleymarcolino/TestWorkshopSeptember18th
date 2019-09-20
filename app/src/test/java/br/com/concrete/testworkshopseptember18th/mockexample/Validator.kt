package br.com.concrete.testworkshopseptember18th.mockexample

import br.com.concrete.testworkshopseptember18th.PasswordValidator

class Validator(
    private val passwordValidator: PasswordValidator
) {
    fun validate(name: String, password: String) =
        name.length > 8 && passwordValidator.isValid(password)
}

