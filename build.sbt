name := "ewtn-crawler"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "com.squareup.retrofit2" % "retrofit" % "2.2.0"

libraryDependencies += "com.squareup.retrofit2" % "adapter-rxjava" % "2.2.0"

libraryDependencies += "com.squareup.retrofit2" % "converter-jackson" % "2.2.0"

libraryDependencies += "io.reactivex" % "rxscala_2.11" % "0.26.5"

libraryDependencies += "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.8.7"

libraryDependencies += "org.mockito" % "mockito-core" % "2.7.17" % "test"

//libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"