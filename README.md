# Quartzite, a thin Clojure layer on top the Quartz Scheduler

Quartzite is a powerful Clojure scheduling library built on top the [Quartz Scheduler](http://quartz-scheduler.org/).

Forked from [michaelklishin/quartzite](https://github.com/michaelklishin/quartzite)


## Project goals

 * Support all commonly used Quartz features but follow the 80/20 rule
 * Be (reasonably) idiomatic but easy to understand for people familiar with Quartz
 * Be [well documented](doc/guides/README.md)
 * Be [well tested](https://github.com/vincentjames501/quartzite/tree/master/test/clojurewerkz/quartzite/test)
 * Not a half-assed effort: libraries should be well maintained and test-driven or not be open sourced in the first place


## Project Maturity

Quartzite is past `2.0`. We consider it to be stable
and reasonably mature. Quartz Scheduler is a very mature project.

API changes generally follow semantic versioning and are driven by the user
feedback.


## Supported Clojure Versions

Quartzite requires Clojure 1.12 or later. The most recent release is always
recommended.

## Artifacts

Quartzite artifacts are [released to Clojars](https://clojars.org/io.github.vincentjames501/quartzite).

Releases up to and including `2.2.0` were published as `clojurewerkz/quartzite`; this fork
publishes under `io.github.vincentjames501/quartzite` starting with `2.3.0`.

### The Most Recent Version

[![Clojars Project](https://img.shields.io/clojars/v/io.github.vincentjames501/quartzite.svg)](https://clojars.org/io.github.vincentjames501/quartzite)

With Leiningen:

    [io.github.vincentjames501/quartzite "2.3.0"]



## Getting Started, Documentation

Please refer to the [Getting Started with Clojure and Quartz](./doc/guides/getting_started.md).
[Quartzite documentation guides](./doc/guides) are not fully complete but cover most of the functionality.

Quality [Clojure documentation](http://clojure-doc.org) is available elsewhere.


## Community

[Quartzite has a mailing list](https://groups.google.com/group/clojure-quartz). Feel free to join it and ask any questions you may have.

To subscribe for announcements of releases, important changes and so on, please follow [@ClojureWerkz](https://twitter.com/#!/clojurewerkz) on Twitter.




## Quartzite Is a ClojureWerkz Project

Quartzite is part of the [group of Clojure libraries known as ClojureWerkz](http://clojurewerkz.org).



## Continuous Integration

[![Tests](https://github.com/vincentjames501/quartzite/actions/workflows/tests.yml/badge.svg)](https://github.com/vincentjames501/quartzite/actions/workflows/tests.yml)


CI is hosted by [GitHub Actions](https://github.com/vincentjames501/quartzite/actions)



## Development

Quartzite uses [Leiningen 2](https://github.com/technomancy/leiningen/blob/master/doc/TUTORIAL.md). Make
sure you have it installed and then run tests against all supported Clojure versions using

    lein test

Then create a branch and make your changes on it. Once you are done with your changes and all
tests pass, submit a pull request on Github.


## License

Copyright (C) 2011-2023 Michael S. Klishin, Alex Petrov, the ClojureWerkz team and contributors.

Distributed under the Eclipse Public License, the same as Clojure.
