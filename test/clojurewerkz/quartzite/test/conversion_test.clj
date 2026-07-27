(ns clojurewerkz.quartzite.test.conversion-test
  (:require [clojure.test :refer [are deftest is testing]]
            [clojurewerkz.quartzite.conversion :refer [from-job-data to-date to-job-data]])
  (:import (java.time Instant LocalDate LocalDateTime OffsetDateTime ZoneId ZonedDateTime)
           (java.util Calendar Date)))

(defrecord Abc [a b c])

(deftest test-job-data-conversion
  (are [input expected] (= (from-job-data (to-job-data input))
                           (or expected input))

       ; Simple case..
       {"string" "hello"
        "number" 123
        "boolean" true
        "character" \newline
        "keyword" :keyword
        "symbol" 'symbol}
       nil ; nil means that expected is same as input

        ; Check that first-level keys are stringified
       {123 123
        true true
        \newline \newline
        :keyword :keyword
        'symbol 'symbol}
       {"123" 123
        "true" true
        "\n" \newline
        "keyword" :keyword
        "symbol" 'symbol}

        ; Check that keys of nested maps not stringified.
        {"nested" {:a :a}}
        nil

        ; Check that nested record not converted to map.
        {"record" (->Abc :a :b :c)}
        nil))


(deftest test-date-conversion
  (let [instant (Instant/parse "2035-02-15T12:30:00Z")
        date    (Date/from instant)]
    (testing "java.util types"
      (is (= date (to-date date)))
      (is (= date (to-date (doto (Calendar/getInstance)
                             (.setTimeInMillis (.toEpochMilli instant)))))))

    (testing "java.time types carrying an instant"
      (is (= date (to-date instant)))
      (is (= date (to-date (OffsetDateTime/ofInstant instant (ZoneId/of "UTC")))))
      (is (= date (to-date (ZonedDateTime/ofInstant instant (ZoneId/of "UTC")))))))

  (testing "LocalDateTime is interpreted in the system default zone"
    (let [ldt (LocalDateTime/of 2035 2 15 12 30 0)
          d   (to-date ldt)]
      (is (instance? Date d))
      (is (= ldt (LocalDateTime/ofInstant (.toInstant ^Date d) (ZoneId/systemDefault))))))

  (testing "LocalDate becomes start of day in the system default zone"
    (let [ld (LocalDate/of 2035 2 15)
          d  (to-date ld)]
      (is (instance? Date d))
      (is (= (.atStartOfDay ld)
             (LocalDateTime/ofInstant (.toInstant ^Date d) (ZoneId/systemDefault)))))))

