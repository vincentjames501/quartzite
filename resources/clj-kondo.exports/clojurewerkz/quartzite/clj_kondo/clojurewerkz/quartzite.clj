(ns clj-kondo.clojurewerkz.quartzite
  (:require [clj-kondo.hooks-api :as api]))

(defn threaded* [builder-sym final-sym {:keys [node]}]
  (let [body     (rest (:children node))
        new-node (api/list-node
                  (list*
                   (api/token-node '->)
                   (concat (when builder-sym
                             [(api/token-node builder-sym)])
                           body
                           (when final-sym
                             [(api/token-node final-sym)]))))]
    {:node new-node}))

(defn triggers-build [ctx]
  (threaded* '(org.quartz.TriggerBuilder/newTrigger)
             '(clojurewerkz.quartzite.triggers/finalize)
             ctx))

(defn jobs-build [ctx]
  (threaded* '(org.quartz.JobBuilder/newJob)
             '(clojurewerkz.quartzite.jobs/finalize)
             ctx))

;; The schedule DSLs thread a builder too, but unlike job/trigger builders they
;; do not finalize for you, so callers pass `finalize` explicitly.

(defn simple-schedule [ctx]
  (threaded* '(org.quartz.SimpleScheduleBuilder/simpleSchedule) nil ctx))

(defn calendar-interval-schedule [ctx]
  (threaded* '(org.quartz.CalendarIntervalScheduleBuilder/calendarIntervalSchedule) nil ctx))

(defn daily-interval-schedule [ctx]
  (threaded* '(org.quartz.DailyTimeIntervalScheduleBuilder/dailyTimeIntervalSchedule) nil ctx))

;; cron/schedule takes the builder itself as its first form rather than
;; constructing one, so there is nothing to prepend.
(defn cron-schedule [ctx]
  (threaded* nil nil ctx))
