
(ns time.current
    (:require [time.timestamp :as timestamp]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-year
  ; @usage
  ; (get-year)
  ;
  ; @return (Y)
  []
  (-> (timestamp/timestamp-object)
      (timestamp/timestamp-object->year)))

(defn get-month
  ; @usage
  ; (get-month)
  ;
  ; @return (M)
  [])
  ; TODO

(defn get-week
  ; @usage
  ; (get-week)
  ;
  ; @return (W)
  [])
  ; TODO

(defn get-day
  ; @usage
  ; (get-day)
  ;
  ; @return (D)
  [])
  ; TODO

(defn get-date
  ; @example
  ; (get-date)
  ; =>
  ; "2020-04-20"
  ;
  ; @return (string)
  []
  (-> (timestamp/timestamp-string)
      (timestamp/timestamp-string->date)))

(defn get-hours
  ; @usage
  ; (get-hours)
  ;
  ; @return (h)
  [])
  ; TODO

(defn get-hours-left-from-this-day
  ; @usage
  ; (get-hours-left-from-this-day)
  ;
  ; @return (h)
  []
  (let [hours (get-hours)]
       (- 24 hours)))

(defn get-minutes
  ; @usage
  ; (get-minutes)
  ;
  ; @return (m)
  [])
  ; TODO

(defn get-minutes-left-from-this-hour
  ; @usage
  ; (get-minutes-left-from-this-hour)
  ;
  ; @return (m)
  []
  (let [minutes (get-minutes)]
       (- 60 minutes)))

(defn get-seconds
  ; @usage
  ; (get-seconds)
  ;
  ; @return (s)
  [])
  ; TODO

(defn get-seconds-left-from-this-minute
  ; @usage
  ; (get-seconds-left-from-this-minute)
  ;
  ; @return (s)
  []
  (let [seconds (get-seconds)]
       (- 60 seconds)))

(defn get-milliseconds
  ; @usage
  ; (get-milliseconds)
  ;
  ; @return (ms)
  [])
  ; TODO

(defn get-milliseconds-left-from-this-second
  ; @usage
  ; (get-milliseconds-left-from-this-second)
  ;
  ; @return (ms)
  [])
  ; TODO

(defn get-milliseconds-left-from-this-minute
  ; @usage
  ; (get-milliseconds-left-from-this-minute)
  ;
  ; @return (ms)
  []
  (let [seconds-left (get-seconds-left-from-this-minute)]
       (* 1000 seconds-left)))
