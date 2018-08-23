Zero Install Java Model
=======================

The Zero Install [XSD model](https://0install.de/schema/injector/interface/interface.xsd) transformed to Java source code by [Apache XMLBeans](https://xmlbeans.apache.org/).

This is **NOT** a full implementation of Zero Install in Java!

[![zeroinstall-model](https://img.shields.io/maven-central/v/net.zeroinstall/zeroinstall-model.svg)](https://mvnrepository.com/artifact/net.zeroinstall/zeroinstall-model)

[![Build status](https://img.shields.io/appveyor/ci/0install/0install-java.svg)](https://ci.appveyor.com/project/0install/0install-java)

**Important:** XMLBeans does not support Java 9 or newer as a build environment. However, the resulting artifact will work fine on current Java versions.

Useful if you want to parse or generate Zero Install feeds in your Java applications. Not required if you simply want to call Zero Install from your application.

Include this in your Maven ```pom.xml``` to use the library:
```xml
<dependency>
    <groupId>net.zeroinstall</groupId>
    <artifactId>zeroinstall-model</artifactId>
    <version>2.2.1</version>
</dependency>
```
