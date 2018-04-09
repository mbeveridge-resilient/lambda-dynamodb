javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")

libraryDependencies += "com.amazonaws" % "aws-lambda-java-core" % "1.2.0"
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.9.5"
libraryDependencies += "com.amazonaws" % "aws-lambda-java-events" % "2.1.0"
libraryDependencies += "com.amazonaws" % "aws-java-sdk-dynamodb" % "1.11.308"

lazy val root = (project in file(".")).
  settings(
    name := "lambda-dynamodb",
    version := "1.0",
    scalaVersion := "2.12.5",
    retrieveManaged := true,
    libraryDependencies += "com.amazonaws" % "aws-lambda-java-core" % "1.2.0",
    libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.9.5",
    libraryDependencies += "com.amazonaws" % "aws-lambda-java-events" % "2.1.0",
    libraryDependencies += "com.amazonaws" % "aws-java-sdk-dynamodb" % "1.11.308"
)

assemblyMergeStrategy in assembly :=
  {
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case x => MergeStrategy.first
  }
