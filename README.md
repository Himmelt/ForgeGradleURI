ForgeGradle
===========

[![Join the chat at https://gitter.im/MinecraftForge/ForgeGradle](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/MinecraftForge/ForgeGradle?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

Minecraft mod development framework used by Forge and FML for the gradle build system

-----------

ForgeGradleURI
===========
Add URI request listener (redirector) with [GradleURI](https://github.com/Himmelt/GradleURI)

为国内小伙伴提供URI重定向帮助

![ForgeGradleURI](https://github.com/Himmelt/ForgeGradleURI/workflows/ForgeGradleURI/badge.svg)

1. 添加 各类资源/依赖下载链接的重定向监听器.
2. 添加 项目属性 `mcpRenameJavadoc` 以解决1.13.2报错.

### ForgeGradleURI 使用
```groovy
// build.gradle
buildscript {
    repositories {
        maven { url 'https://oss.jfrog.org/artifactory/oss-snapshot-local' }
        maven { url 'https://maven.aliyun.com/repository/public/' }
        maven { url 'https://files.minecraftforge.net/maven' }
    }
    dependencies {
        classpath group: 'org.soraworld', name: 'ForgeGradleURI', version: '3.+', changing: true
    }
}

apply plugin: 'net.minecraftforge.gradle'
```

### URI监听器使用
启用 URI监听器 必须使用 [GradleURI](https://github.com/Himmelt/GradleURI)
可以通过以下方式使用 GradleURI
+ 下载解压，使用方式和官方下载完全一致
+ IDEA 可在 Gradle 选项卡指定 Gradle 目录
+ 使用wrapper时，可修改项目目录下`gradle/wrapper/gradle-wrapper.properties` (具体版本见: [GradleURI](https://github.com/Himmelt/GradleURI))
```properties
distributionBase=GRADLE_USER_HOME
distributionPath=wrapper/dists
distributionUrl=https\://oss.jfrog.org/artifactory/oss-snapshot-local/org/soraworld/gradle-uri/4.9-SNAPSHOT/gradle-uri-4.9-SNAPSHOT-all.zip
zipStoreBase=GRADLE_USER_HOME
zipStorePath=wrapper/dists
```
```groovy
// build.gradle
gradle.addURIListener {
    // it -> URI源，String 类型
    return it.replaceAll('xxx','xxx')
}
```

### mcpRenameJavadoc
```groovy
// build.gradle
ext {
    mcpRenameJavadoc = false
}
```
