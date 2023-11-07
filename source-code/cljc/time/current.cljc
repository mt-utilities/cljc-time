
(ns time.current
    (:require [time.timestamp :as timestamp]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn current-year
  ; @description
  ; Returns the actual year.
  ;
  ; @usage
  ; (current-year)
  ;
  ; @return (Y)
  []
  (-> (timestamp/timestamp-object)
      (timestamp/timestamp-object->year)))

(defn current-month
  ; @description
  ; Returns the actual month.
  ;
  ; @usage
  ; (current-month)
  ;
  ; @return (M)
  []
  (-> (timestamp/timestamp-object)
      (timestamp/timestamp-object->month)))

(defn current-week
  ; @description
  ; Returns the actual week.
  ;
  ; @usage
  ; (current-week)
  ;
  ; @return (W)
  []
  (-> (timestamp/timestamp-object)
      (timestamp/timestamp-object->week)))

(defn current-day
  ; @description
  ; Returns the actual day.
  ;
  ; @usage
  ; (current-day)
  ;
  ; @return (D)
  []
  (-> (timestamp/timestamp-object)
      (timestamp/timestamp-object->day)))

(defn current-date
  ; @description
  ; Returns the actual date.
  ;
  ; @usage
  ; (current-date)
  ;
  ; @return (string)
  []
  (-> (timestamp/timestamp-string)
      (timestamp/timestamp-string->date)))

(defn current-hour
  ; @description
  ; Returns the actual hour.
  ;
  ; @usage
  ; (current-hour)
  ;
  ; @return (h)
  []
  (-> (timestamp/timestamp-object)
      (timestamp/timestamp-object->hours)))

(defn hours-left-from-current-day
  ; @description
  ; Returns how many hours left from the actual day.
  ;
  ; @usage
  ; (hours-left-from-current-day)
  ;
  ; @return (h)
  []
  (let [current-hour (current-hour)]
       (- 24 current-hour)))

(defn current-minute
  ; @description
  ; Returns the actual minute.
  ;
  ; @usage
  ; (current-minute)
  ;
  ; @return (m)
  []
  (-> (timestamp/timestamp-object)
      (timestamp/timestamp-object->minutes)))

(defn minutes-left-from-current-hour
  ; @description
  ; Returns how many minutes left from the actual hour.
  ;
  ; @usage
  ; (minutes-left-from-current-hour)
  ;
  ; @return (m)
  []
  (let [current-minute (current-minute)]
       (- 60 current-minute)))

(defn current-second
  ; @description
  ; Returns the actual second.
  ;
  ; @usage
  ; (current-second)
  ;
  ; @return (s)
  []
  (-> (timestamp/timestamp-object)
      (timestamp/timestamp-object->seconds)))

(defn seconds-left-from-current-minute
  ; @description
  ; Returns how many seconds left from the actual minute.
  ;
  ; @usage
  ; (seconds-left-from-current-minute)
  ;
  ; @return (s)
  []
  (let [current-second (current-second)]
       (- 60 current-second)))

(defn current-millisecond
  ; @description
  ; Returns the actual millisecond.
  ;
  ; @usage
  ; (current-millisecond)
  ;
  ; @return (ms)
  []
  (-> (timestamp/timestamp-object)
      (timestamp/timestamp-object->milliseconds)))

(defn milliseconds-left-from-current-second
  ; @description
  ; Returns how many milliseconds left from the actual second.
  ;
  ; @usage
  ; (milliseconds-left-from-current-second)
  ;
  ; @return (ms)
  []
  (let [current-millisecond (current-millisecond)]
       (- 1000 current-millisecond)))

(defn milliseconds-left-from-current-minute
  ; @description
  ; Returns how many milliseconds left from the actual minute.
  ;
  ; @usage
  ; (milliseconds-left-from-current-minute)
  ;
  ; @return (ms)
  []
  (let [seconds-left-from-current-minute (seconds-left-from-current-minute)]
       (* 1000 seconds-left-from-current-minute)))
