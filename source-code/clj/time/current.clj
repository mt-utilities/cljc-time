
(ns time.current
    (:require [time.timestamp :as timestamp]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn current-year
  ; @usage
  ; (current-year)
  ;
  ; @return (Y)
  []
  (-> (timestamp/timestamp-object)
      (timestamp/timestamp-object->year)))

(defn current-month
  ; @usage
  ; (current-month)
  ;
  ; @return (M)
  []
  (-> (timestamp/timestamp-object)
      (timestamp/timestamp-object->month)))

(defn current-week
  ; @usage
  ; (current-week)
  ;
  ; @return (W)
  []
  (-> (timestamp/timestamp-object)
      (timestamp/timestamp-object->week)))

(defn current-day
  ; @usage
  ; (current-day)
  ;
  ; @return (D)
  []
  (-> (timestamp/timestamp-object)
      (timestamp/timestamp-object->day)))

(defn current-date
  ; @example
  ; (current-date)
  ; =>
  ; "2020-04-20"
  ;
  ; @return (string)
  []
  (-> (timestamp/timestamp-string)
      (timestamp/timestamp-string->date)))

(defn current-hour
  ; @usage
  ; (current-hour)
  ;
  ; @return (h)
  []
  (-> (timestamp/timestamp-object)
      (timestamp/timestamp-object->hours)))

(defn hours-left-from-this-day
  ; @usage
  ; (hours-left-from-this-day)
  ;
  ; @return (h)
  []
  (let [current-hour (current-hour)]
       (- 24 current-hour)))

(defn current-minute
  ; @usage
  ; (current-minute)
  ;
  ; @return (m)
  []
  (-> (timestamp/timestamp-object)
      (timestamp/timestamp-object->minutes)))

(defn minutes-left-from-this-hour
  ; @usage
  ; (minutes-left-from-this-hour)
  ;
  ; @return (m)
  []
  (let [current-minute (current-minute)]
       (- 60 current-minute)))

(defn current-second
  ; @usage
  ; (current-second)
  ;
  ; @return (s)
  []
  (-> (timestamp/timestamp-object)
      (timestamp/timestamp-object->seconds)))

(defn seconds-left-from-this-minute
  ; @usage
  ; (seconds-left-from-this-minute)
  ;
  ; @return (s)
  []
  (let [current-second (current-second)]
       (- 60 current-second)))

(defn current-millisecond
  ; @usage
  ; (current-millisecond)
  ;
  ; @return (ms)
  []
  (-> (timestamp/timestamp-object)
      (timestamp/timestamp-object->milliseconds)))

(defn milliseconds-left-from-this-second
  ; @usage
  ; (milliseconds-left-from-this-second)
  ;
  ; @return (ms)
  []
  (let [current-millisecond (current-millisecond)]
       (- 1000 current-millisecond)))

(defn milliseconds-left-from-this-minute
  ; @usage
  ; (milliseconds-left-from-this-minute)
  ;
  ; @return (ms)
  []
  (let [seconds-left-from-this-minute (seconds-left-from-this-minute)]
       (* 1000 seconds-left-from-this-minute)))
