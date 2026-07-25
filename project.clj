(defproject io.github.vincentjames501/quartzite "2.3.0-SNAPSHOT"
  :description "Quarzite is a thin Clojure layer on top the Quartz Scheduler"
  :url "https://github.com/vincentjames501/quartzite"
  :scm {:name "git" :url "https://github.com/vincentjames501/quartzite"}
  :license {:name "Eclipse Public License"}
  :dependencies [[org.clojure/clojure "1.12.5"]
                 [org.quartz-scheduler/quartz "2.5.2"]]
  :source-paths ["src/clojure"]
  :java-source-paths ["src/java"]
  :profiles {:dev {:resource-paths ["test/resources" "resources"]
                   :dependencies   [[org.clojure/tools.logging "1.3.1" :exclusions [org.clojure/clojure]]
                                    [org.slf4j/slf4j-log4j12 "2.0.18"]]}}
  :global-vars {*warn-on-reflection* true}
  :plugins [[codox "0.10.8"]]
  :codox {:sources    ["src/clojure"]
          :output-dir "doc/api"})
