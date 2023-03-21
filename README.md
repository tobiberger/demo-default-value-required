# Reproducing bug introduced in springdoc-openapi v2.0.3

Until v2.0.2, a request parameter that's non-nullable in Kotlin code wasn't marked as required in the openapi docs if a
default value was provided in the `@RequestParameter` annotation.

Since v2.0.3, such parameters are marked as required, even though the SpringMVC endpoint works perfectly fine without
providing a value.

See [HelloController](./src/main/kotlin/com/example/demodefaultvaluerequired/demodefaultvaluerequired/HelloController.kt)
for an example.

[OpenApiTest](./src/test/kotlin/com/example/demodefaultvaluerequired/demodefaultvaluerequired/OpenApiTest.kt) checks
that the api docs didn't change from a documentation that was created with v2.0.2.

This refers to https://github.com/springdoc/springdoc-openapi/issues/2149