
(ns time.current
    (:require [time.timestamp :as timestamp]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn current-year
  ; @description
  ; Returns the actual year value.
  ;
  ; @usage
  ; (current-year)
  ; =>
  ; 2020
  ;
  ; @return (Y)
  []
  (-> (timestamp/timestamp-object)
      (timestamp/timestamp-object->year)))

(defn current-month
  ; @description
  ; Returns the actual month value.
  ;
  ; @usage
  ; (current-month)
  ; =>
  ; 4
  ;
  ; @return (M)
  []
  (-> (timestamp/timestamp-object)
      (timestamp/timestamp-object->month)))

(defn current-week
  ; @description
  ; Returns the actual week value.
  ;
  ; @usage
  ; (current-week)
  ; =>
  ; 17
  ;
  ; @return (W)
  []
  (-> (timestamp/timestamp-object)
      (timestamp/timestamp-object->week)))

(defn current-day
  ; @description
  ; Returns the actual day value.
  ;
  ; @usage
  ; (current-day)
  ; =>
  ; 20
  ;
  ; @return (D)
  []
  (-> (timestamp/timestamp-object)
      (timestamp/timestamp-object->day)))

(defn current-date
  ; @description
  ; Returns the actual formatted date string.
  ;
  ; @usage
  ; (current-date)
  ; =>
  ; "2020-04-20"
  ;
  ; @return (string)
  []
  (-> (timestamp/timestamp-string)
      (timestamp/timestamp-string->date)))

(defn current-hour
  ; @description
  ; Returns the actual hour value.
  ;
  ; @usage
  ; (current-hour)
  ; =>
  ; 16
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
  ; =>
  ; 7.66'
  ;
  ; @return (h)
  []
  ; The output is not always a whole number. Therefore, it has to be converted into double.
  (let [timestamp-object    (timestamp/timestamp-object)
        current-hour        (timestamp/timestamp-object->hours        timestamp-object)
        current-minute      (timestamp/timestamp-object->minutes      timestamp-object)
        current-second      (timestamp/timestamp-object->seconds      timestamp-object)
        current-millisecond (timestamp/timestamp-object->milliseconds timestamp-object)]
       (-> 86400000 (- (* current-hour  3600000)
                       (* current-minute  60000)
                       (* current-second   1000)
                       (* current-millisecond 1))
                    (/ 3600000)
                    (double))))

(defn current-minute
  ; @description
  ; Returns the actual minute value.
  ;
  ; @usage
  ; (current-minute)
  ; =>
  ; 20
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
  ; =>
  ; 40
  ;
  ; @return (m)
  []
  ; The output is not always a whole number. Therefore, it has to be converted into double.
  (let [timestamp-object    (timestamp/timestamp-object)
        current-minute      (timestamp/timestamp-object->minutes      timestamp-object)
        current-second      (timestamp/timestamp-object->seconds      timestamp-object)
        current-millisecond (timestamp/timestamp-object->milliseconds timestamp-object)]
       (-> 3600000 (- (* current-minute  60000)
                      (* current-second   1000)
                      (* current-millisecond 1))
                   (/ 60000)
                   (double))))

(defn current-second
  ; @description
  ; Returns the actual second value.
  ;
  ; @usage
  ; (current-second)
  ; =>
  ; 0
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
  ; =>
  ; 60
  ;
  ; @return (s)
  []
  ; The output is not always a whole number. Therefore, it has to be converted into double.
  (let [timestamp-object    (timestamp/timestamp-object)
        current-second      (timestamp/timestamp-object->seconds      timestamp-object)
        current-millisecond (timestamp/timestamp-object->milliseconds timestamp-object)]
       (-> 60000 (- (* current-second   1000)
                    (* current-millisecond 1))
                 (/ 1000)
                 (double))))

(defn current-millisecond
  ; @description
  ; Returns the actual millisecond value.
  ;
  ; @usage
  ; (current-millisecond)
  ; =>
  ; 0
  ;
  ; @return (ms)
  []
  (-> (timestamp/timestamp-object)
      (timestamp/timestamp-object->milliseconds)))

(defn milliseconds-left-from-current-minute
  ; @description
  ; Returns how many milliseconds left from the actual minute.
  ;
  ; @usage
  ; (milliseconds-left-from-current-minute)
  ; =>
  ; 60000
  ;
  ; @return (ms)
  []
  ; The output is always a whole number. Therefore, there is no need to convert it into double.
  (let [timestamp-object    (timestamp/timestamp-object)
        current-second      (timestamp/timestamp-object->seconds      timestamp-object)
        current-millisecond (timestamp/timestamp-object->milliseconds timestamp-object)]
       (-> 60000 (- (* current-second   1000)
                    (* current-millisecond 1)))))

(defn milliseconds-left-from-current-second
  ; @description
  ; Returns how many milliseconds left from the actual second.
  ;
  ; @usage
  ; (milliseconds-left-from-current-second)
  ; =>
  ; 1000
  ;
  ; @return (ms)
  []
  ; The output is always a whole number. Therefore, there is no need to convert it into double.
  (let [timestamp-object    (timestamp/timestamp-object)
        current-millisecond (timestamp/timestamp-object->milliseconds timestamp-object)]
       (- 1000 current-millisecond)))
