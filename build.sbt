lazy val commonSettings = Seq(
    organization := "com.mandubian"
  , version := "0.1.0-SNAPSHOT"
  , resolvers ++= Seq(
      Resolver.mavenLocal
    , Resolver.sonatypeRepo("releases")
    , Resolver.sonatypeRepo("snapshots")
    )
  , scalaVersion := "2.11.8"
  , bintrayOrganization := Some("mandubian")
  , licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))
  , addCompilerPlugin("com.milessabin"  %   "si2712fix-plugin"  % "1.2.0" cross CrossVersion.full)
  , addCompilerPlugin("org.spire-math"  %%  "kind-projector"    % "0.7.1")
  // , addCompilerPlugin("org.scalamacros" %%  "paradise"          % "2.1.0" cross CrossVersion.full)
  , libraryDependencies ++= Seq(
      "org.typelevel"         %%  "cats"                  % "0.6.1"
    , "com.milessabin"        %   "si2712fix-library"     % "1.2.0"           cross CrossVersion.full
    , "com.github.mpilquist"  %%  "simulacrum"            % "0.7.0"
    // , "org.typelevel"       %% "discipline"         % "0.4"               % "test"
    // , "org.typelevel"       %% "cats-laws"          % "0.6.1"
    , "org.scalatest"         %  "scalatest_2.11"         % "3.0.0"           % "test"
    )

)

lazy val root = project.in(file("."))
  .settings(commonSettings: _*)
  .settings(
    name := "khats",
    scalacOptions ++= Seq(
      "-feature"
    , "-language:higherKinds"
    )
  )
