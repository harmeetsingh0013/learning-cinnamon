credentials += Credentials(Path.userHome / ".lightbend" / "commercial.credentials")

resolvers += Resolver.url("lightbend-commercial",
  url("https://repo.lightbend.com/commercial-releases"))(Resolver.ivyStylePatterns)

addSbtPlugin("com.lightbend.cinnamon" % "sbt-cinnamon" % "2.4.2")

addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.0.0-RC6")