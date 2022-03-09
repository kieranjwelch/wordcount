# Word Count
 
## Overview

Word Count is a simple tool written in Java, used to scan any supplied text file and return a list of words sorted by number of occurrences. It's the first Java application I have written, so any comments/feedback greatly received.

## Table of Contents

- [Requirements](#requirements)
- [Build](#build)
- [Usage](#usage)
- [Support](#support)

## Requirements

Word Count will run on any platform that supports Java.

To compile Word Count, you will require Java JDK 11+, ensuring ```JAVA_HOME``` is correctly configured in your environment variables.

## Build

### Windows
1. Clone this wordcount repository to your machine
2. Open command prompt, and navigate to the wordcount repository
3. Begin compiling with Maven -  ```mvnw.cmd clean package```
4. Once the build successfully completes, you will find the compiled JAR in ```wordcount/target/wordcount-<version>.jar```

### macOS/Linux

Following the above instructions, but instead of mvnw.cmd, substitute this with the 'mvnw' binary located in the same directory.

For example:
```$ /home/user/wordcount/./mvnw clean package```

## Usage

To get started with Word Count, use the following example to run making sure you provide a path to your file as an argument.

```$ java -jar /home/user/wordcount/target/wordcount-<version>.jar /path/to/file.txt```

## Support

To raise any bugs or feature requests for Word Count, please submit these directly to me via [GitHub Issues](https://github.com/kieranjwelch/wordcount/issues)

For any other general support queries, you can reach me at kieranjwelch [at] gmail [dot] com.