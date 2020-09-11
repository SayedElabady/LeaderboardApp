package com.gads.practiceproject.shared.store.models

data class SubmitProjectPayload(
    val firstName: String, val secondName: String, val email: String, val githubLink: String
) {
    companion object {
        fun create(
            firstName: String,
            lastName: String,
            email: String,
            githubLink: String
        ): SubmitProjectPayload {
            return SubmitProjectPayload(firstName, lastName, email, githubLink)
        }
    }
}