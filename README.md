# Gradle Example (Multi Project & JMH) #

A very simple gradle example which has multi project and jmh project.

## How to run JMH ##

```
 ./gradlew jmh:clean jmh:build jmh:jmh
``` 

This task use [jmh-gradle-plugin](https://github.com/blackboard/jmh-gradle-plugin)

The JMH API see [openjdk jmh](http://openjdk.java.net/projects/code-tools/jmh/)

If you use maven, you can create by archetype

```
mvn archetype:generate \
          -DinteractiveMode=false \
          -DarchetypeGroupId=org.openjdk.jmh \
          -DarchetypeArtifactId=jmh-java-benchmark-archetype \
          -DgroupId=com.yao \
          -DartifactId=jmh-demo \
          -Dversion=1.0
```

