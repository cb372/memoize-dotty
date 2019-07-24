scalaVersion in ThisBuild := "0.17.0-RC1"

val scalacache = project.in(file("scalacache"))

val example = project.in(file("example")).dependsOn(scalacache)
