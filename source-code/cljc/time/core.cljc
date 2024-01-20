
(ns time.core
    #?(:clj (:require [clj-time.core])))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn years
  ; @description
  ; Returns a PeriodType object, or a Years object (in case the 'n' parameter is provided).
  ;
  ; @param (number)(opt) n
  ;
  ; @usage
  ; (years)
  ; =>
  ; #<PeriodType Years>
  ;
  ; @usage
  ; (years 5)
  ; =>
  ; #<Years 5>
  ;
  ; @usage
  ; (plus (parse-date "2020-04-20")
  ;       (years 5))
  ; =>
  ; #<DateTime 2025-04-20T00:00:00.000Z>
  ;
  ; @return (object)
  ([]
   #?(:clj (clj-time.core/years)))

  ([n]
   #?(:clj (clj-time.core/years n))))

(defn months
  ; @description
  ; Returns a PeriodType object, or a Months object (in case the 'n' parameter is provided).
  ;
  ; @param (number)(opt) n
  ;
  ; @usage
  ; (months)
  ; =>
  ; #<PeriodType Months>
  ;
  ; @usage
  ; (months 5)
  ; =>
  ; #<Months 5>
  ;
  ; @usage
  ; (plus (parse-date "2020-04-20")
  ;       (months 5))
  ; =>
  ; #<DateTime 2020-09-20T00:00:00.000Z>
  ;
  ; @return (object)
  ([]
   #?(:clj (clj-time.core/months)))

  ([n]
   #?(:clj (clj-time.core/months n))))

(defn weeks
  ; @description
  ; Returns a PeriodType object, or a Weeks object (in case the 'n' parameter is provided).
  ;
  ; @param (number)(opt) n
  ;
  ; @usage
  ; (weeks)
  ; =>
  ; #<PeriodType Weeks>
  ;
  ; @usage
  ; (weeks 5)
  ; =>
  ; #<Weeks 5>
  ;
  ; @usage
  ; (plus (parse-date "2020-04-20")
  ;       (weeks 5))
  ; =>
  ; #<DateTime 2020-05-25T00:00:00.000Z>
  ;
  ; @return (object)
  ([]
   #?(:clj (clj-time.core/weeks)))

  ([n]
   #?(:clj (clj-time.core/weeks n))))

(defn days
  ; @description
  ; Returns a PeriodType object, or a Days object (in case the 'n' parameter is provided).
  ;
  ; @param (number)(opt) n
  ;
  ; @usage
  ; (days)
  ; =>
  ; #<PeriodType Days>
  ;
  ; @usage
  ; (days 5)
  ; =>
  ; #<Days 5>
  ;
  ; @usage
  ; (plus (parse-date "2020-04-20")
  ;       (days 5))
  ; =>
  ; #<DateTime 2020-04-25T00:00:00.000Z>
  ;
  ; @return (object)
  ([]
   #?(:clj (clj-time.core/days)))

  ([n]
   #?(:clj (clj-time.core/days n))))

(defn hours
  ; @description
  ; Returns a PeriodType object, or an Hours object (in case the 'n' parameter is provided).
  ;
  ; @param (number)(opt) n
  ;
  ; @usage
  ; (hours)
  ; =>
  ; #<PeriodType Hours>
  ;
  ; @usage
  ; (hours 5)
  ; =>
  ; #<Hours 5>
  ;
  ; @usage
  ; (plus (parse-date "2020-04-20")
  ;       (hours 5))
  ; =>
  ; #<DateTime 2020-04-20T05:00:00.000Z>
  ;
  ; @return (object)
  ([]
   #?(:clj (clj-time.core/hours)))

  ([n]
   #?(:clj (clj-time.core/hours n))))

(defn minutes
  ; @description
  ; Returns a PeriodType object, or an Minutes object (in case the 'n' parameter is provided).
  ;
  ; @param (number)(opt) n
  ;
  ; @usage
  ; (minutes)
  ; =>
  ; #<PeriodType Minutes>
  ;
  ; @usage
  ; (minutes 5)
  ; =>
  ; #<Minutes 5>
  ;
  ; @usage
  ; (plus (parse-date "2020-04-20")
  ;       (minutes 5))
  ; =>
  ; #<DateTime 2020-04-20T00:05:00.000Z>
  ;
  ; @return (object)
  ([]
   #?(:clj (clj-time.core/minutes)))

  ([n]
   #?(:clj (clj-time.core/minutes n))))

(defn seconds
  ; @description
  ; Returns a PeriodType object, or an Seconds object (in case the 'n' parameter is provided).
  ;
  ; @param (number)(opt) n
  ;
  ; @usage
  ; (seconds)
  ; =>
  ; #<PeriodType Seconds>
  ;
  ; @usage
  ; (seconds 5)
  ; =>
  ; #<Seconds 5>
  ;
  ; @usage
  ; (plus (parse-date "2020-04-20")
  ;       (seconds 5))
  ; =>
  ; #<DateTime 2020-04-20T00:00:05.000Z>
  ;
  ; @return (object)
  ([]
   #?(:clj (clj-time.core/seconds)))

  ([n]
   #?(:clj (clj-time.core/seconds n))))

(defn millseconds
  ; @description
  ; Returns a PeriodType object, or an Millis object (in case the 'n' parameter is provided).
  ;
  ; @param (number)(opt) n
  ;
  ; @usage
  ; (millseconds)
  ; =>
  ; #<PeriodType Millis>
  ;
  ; @usage
  ; (millseconds 5)
  ; =>
  ; #<Millis 5>
  ;
  ; @usage
  ; (plus (parse-date "2020-04-20")
  ;       (millseconds 5))
  ; =>
  ; #<DateTime 2020-04-20T00:00:00.005Z>
  ;
  ; @return (object)
  ([]
   #?(:clj (clj-time.core/millis)))

  ([n]
   #?(:clj (clj-time.core/millis n))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn plus
  ; @description
  ; Returns a DateTime object corresponding to the given DateTime object moved forwards by the given periods.
  ;
  ; @param (object) timestamp
  ; @param (object) period
  ; @param (list of objects)(opt) periods
  ;
  ; @usage
  ; (plus (parse-date "2020-04-20")
  ;       (days 5))
  ; =>
  ; #<DateTime 2020-04-25T00:00:00.000Z>
  ;
  ; @usage
  ; (plus (parse-date "2020-04-20")
  ;       (days        5)
  ;       (hours       5)
  ;       (minutes     5)
  ;       (seconds     5)
  ;       (millseconds 5))
  ; =>
  ; #<DateTime 2020-04-25T05:05:05.005Z>
  ;
  ; @return (object)
  [timestamp period & periods]
  #?(:clj (apply clj-time.core/plus timestamp period periods)))

(defn minus
  ; @description
  ; Returns a DateTime object corresponding to the given DateTime object moved backwards by the given periods.
  ;
  ; @param (object) timestamp
  ; @param (object) period
  ; @param (list of objects)(opt) periods
  ;
  ; @usage
  ; (minus (parse-date "2020-04-20")
  ;        (days 5))
  ; =>
  ; #<DateTime 2020-04-15T00:00:00.000Z>
  ;
  ; @usage
  ; (minus (parse-date "2020-04-20")
  ;        (days        5)
  ;        (hours       5)
  ;        (minutes     5)
  ;        (seconds     5)
  ;        (millseconds 5))
  ; =>
  ; #<DateTime 2020-04-14T18:54:54.995Z>
  ;
  ; @return (object)
  [timestamp period & periods]
  #?(:clj (apply clj-time.core/minus timestamp period periods)))
