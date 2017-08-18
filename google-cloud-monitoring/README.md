Google Cloud Java Client for Stackdriver Monitoring
======================================

Java idiomatic client for [Stackdriver Monitoring][stackdriver-monitoring].

[![Build Status](https://travis-ci.org/GoogleCloudPlatform/google-cloud-java.svg?branch=master)](https://travis-ci.org/GoogleCloudPlatform/google-cloud-java)
[![Coverage Status](https://coveralls.io/repos/GoogleCloudPlatform/google-cloud-java/badge.svg?branch=master)](https://coveralls.io/r/GoogleCloudPlatform/google-cloud-java?branch=master)
[![Maven](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-monitoring.svg)](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-monitoring.svg)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/9da006ad7c3a4fe1abd142e77c003917)](https://www.codacy.com/app/mziccard/google-cloud-java)
[![Dependency Status](https://www.versioneye.com/user/projects/58fe4c8d6ac171426c414772/badge.svg?style=flat)](https://www.versioneye.com/user/projects/58fe4c8d6ac171426c414772)

- [Product Documentation][monitoring-product-docs]
- [Client Library Documentation][monitoring-client-lib-docs]

> Note: This client is a work-in-progress, and may occasionally
> make backwards-incompatible changes.

Quickstart
----------
If you are using Maven, add this to your pom.xml file
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-monitoring</artifactId>
  <version>0.21.1-alpha</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-monitoring:0.21.1-alpha'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-monitoring" % "0.21.1-alpha"
```

Authentication
--------------

See the [Authentication](https://github.com/GoogleCloudPlatform/google-cloud-java#authentication) section in the base directory's README.

About Stackdriver Monitoring
----------------------------

[Stackdriver Monitoring][stackdriver-monitoring] provides visibility into the performance, uptime, and overall health of cloud-powered applications. Stackdriver collects metrics, events, and metadata from Google Cloud Platform, Amazon Web Services, hosted uptime probes, application instrumentation, and a variety of common application components including Cassandra, Nginx, Apache Web Server, Elasticsearch, and many others.

See the [Monitoring client library docs][monitoring-client-lib-docs] to learn how to use this client library.

Getting Started
---------------
#### Prerequisites
You will need a [Google Developers Console](https://console.developers.google.com/) project with the Stackdriver Monitoring API enabled. [Follow these instructions](https://cloud.google.com/docs/authentication#preparation) to get your project set up. You will also need to set up the local development environment by [installing the Google Cloud SDK](https://cloud.google.com/sdk/) and running the following commands in command line: `gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

#### Installation and setup
You'll need to obtain the `google-cloud-monitoring` library.  See the [Quickstart](#quickstart) section to add `google-cloud-monitoring` as a dependency in your code.

Troubleshooting
---------------

To get help, follow the instructions in the [shared Troubleshooting document](https://github.com/GoogleCloudPlatform/gcloud-common/blob/master/troubleshooting/readme.md#troubleshooting).

Transport
---------
Monitoring uses gRPC for the transport layer.

Java Versions
-------------

Java 7 or above is required for using this client.

Versioning
----------

This library follows [Semantic Versioning](http://semver.org/).

It is currently in major version zero (``0.y.z``), which means that anything may change at any time and the public API should not be considered stable.

Contributing
------------

Contributions to this library are always welcome and highly encouraged.

See `google-cloud`'s [CONTRIBUTING] documentation and the [shared documentation](https://github.com/GoogleCloudPlatform/gcloud-common/blob/master/contributing/readme.md#how-to-contribute-to-gcloud) for more information on how to get started.

Please note that this project is released with a Contributor Code of Conduct. By participating in this project you agree to abide by its terms. See [Code of Conduct][code-of-conduct] for more information.

License
-------

Apache 2.0 - See [LICENSE] for more information.


[CONTRIBUTING]:https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/CONTRIBUTING.md
[code-of-conduct]:https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[LICENSE]: https://github.com/GoogleCloudPlatform/google-cloud-java/blob/master/LICENSE
[cloud-platform]: https://cloud.google.com/
[stackdriver-monitoring]: https://cloud.google.com/monitoring/
[monitoring-product-docs]: https://cloud.google.com/monitoring/docs/
[monitoring-client-lib-docs]: https://googlecloudplatform.github.io/google-cloud-java/latest/apidocs/index.html?com/google/cloud/monitoring/v3/package-summary.html