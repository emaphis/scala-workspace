# Notes

## SBT

## Creating a new SBT project

- Giter8 templates

<https://www.foundweekends.org>

<https://github.com/foundweekends/giter8/wiki/giter8-templates>

$ sbt

> sbt new scala/scala3.g8
> sbt new scala/hello-world.g8
> DevInsideYou/scala-seed.g8
> DevInsideYou/scala3-seed.g8

- changing Scala version in SBT

> sbt> ++3.3.2!

### ./project

build.properties  -- sbt version
> sbt.version=1.9.6  -- .project/build.properties
plugins.sbt  - SBT plugins
> addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.6.1")
./target  -  SBT source code

> console
> :load .\src\main\scala\try_this.sc
>
## /src
