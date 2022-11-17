
(ns time.timestamp
    (:import org.joda.time.DateTime org.bson.types.BSONTimestamp)
    (:require [candy.api     :refer [return]]
              [clj-time.core :as clj-time.core]
              [format.api    :as format]
              [string.api    :as string]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn timestamp-object
  ; @param (string)(opt) time-zone
  ;
  ; @example
  ; (timestamp-object)
  ; =>
  ; #<DateTime 2020-04-20T16:20:00.123Z>
  ;
  ; @example
  ; (timestamp-object "Europe/Budapest")
  ; =>
  ; #<DateTime 2020-04-20T16:20:00.123+02:00>
  ;
  ; @return (object)
  ([]
   (clj-time.core/now))

  ([time-zone]
   (let [timestamp (clj-time.core/now)
         time-zone (clj-time.core/time-zone-for-id time-zone)]
        (clj-time.core/to-time-zone timestamp time-zone))))

(defn timestamp-string
  ; @param (string)(opt) time-zone
  ;
  ; @example
  ; (timestamp-string)
  ; =>
  ; "2020-04-20T16:20:00.123Z"
  ;
  ; @example
  ; (timestamp-string "Europe/Budapest")
  ; =>
  ; "2020-04-20T16:20:00.123+02:00"
  ;
  ; @return (string)
  ([]
   ; XXX#0081 (source-code/cljs/time/timestamp.cljs)
   (let [timestamp-object (timestamp-object)]
        (str timestamp-object)))

  ([time-zone]
   ; XXX#0081 (source-code/cljs/time/timestamp.cljs)
   (let [timestamp-object (timestamp-object time-zone)]
        (str timestamp-object))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn timestamp-string?
  ; @param (*) n
  ;
  ; @example
  ; (timestamp-string? "2020-04-20T20:00.123+00:00")
  ; =>
  ; true
  ;
  ; @example
  ; (timestamp-string? "2020-04-20T16:20:00.123Z")
  ; =>
  ; true
  ;
  ; @example
  ; (timestamp-string? "2020-04-20T16:20:00.123")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (and (string? n)
       (or (re-matches #"\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}.\d{3}\+\d{2}:\d{2}" n)
           (re-matches #"\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}.\d{3}Z"             n)
           (re-matches #"\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}.\d{3}"              n))))

(defn timestamp-object?
  ; @param (*) n
  ;
  ; @example
  ; (timestamp-object? #<DateTime 2020-04-20T16:20:00.123+02:00>)
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [type (type n)]
       (= type org.joda.time.DateTime)))

(defn date-string?
  ; @param (*) n
  ;
  ; @example
  ; (date-string? "2020-04-20")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (and (string? n)
       (re-matches #"\d{4}[-|.]\d{2}[-|.]\d{2}" n)))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn timestamp-string->year
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-string->year "2020-04-20T16:20:00.123Z")
  ; =>
  ; "2020"
  ;
  ; @return (string)
  [n]
  (string/part n 0 4))

(defn timestamp-object->year
  ; @param (object) n
  ;
  ; @example
  ; (timestamp-object->year #<DateTime 2020-04-20T16:20:00.123Z>)
  ; =>
  ; 2020
  ;
  ; @return (Y)
  [n]
  (clj-time.core/year n))

(defn timestamp-string->month
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-string->month "2020-04-20T16:20:00.123Z")
  ; =>
  ; "04"
  ;
  ; @return (string)
  [n]
  (string/part n 5 7))

(defn timestamp-object->month
  ; @param (object) n
  ;
  ; @example
  ; (timestamp-object->month #<DateTime 2020-04-20T16:20:00.123Z>)
  ; =>
  ; 4
  ;
  ; @return (M)
  [n]
  (clj-time.core/month n))

(defn timestamp-string->day
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-string->day "2020-04-20T16:20:00.123Z")
  ; =>
  ; "20"
  ;
  ; @return (string)
  [n]
  (string/part n 8 10))

(defn timestamp-object->day
  ; @param (object) n
  ;
  ; @example
  ; (timestamp-object->day #<DateTime 2020-04-20T16:20:00.123Z>)
  ; =>
  ; 20
  ;
  ; @return (integer)
  [n]
  (clj-time.core/day n))

(defn timestamp-string->hours
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-string->hours "2020-04-20T16:20:00.123Z")
  ; =>
  ; "16"
  ;
  ; @return (string)
  [n]
  (string/part n 11 13))

(defn timestamp-object->hours
  ; @param (object) n
  ;
  ; @example
  ; (timestamp-object->hours #<DateTime 2020-04-20T16:20:00.123Z>)
  ; =>
  ; 16
  ;
  ; @return (h)
  [n]
  (clj-time.core/hours n))

(defn timestamp-string->minutes
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-string->minutes "2020-04-20T16:20:00.123Z")
  ; =>
  ; "20"
  ;
  ; @return (string)
  [n]
  (string/part n 14 16))

(defn timestamp-object->minutes
  ; @param (object) n
  ;
  ; @example
  ; (timestamp-object->minutes #<DateTime 2020-04-20T16:20:00.123Z>)
  ; =>
  ; 20
  ;
  ; @return (m)
  [n]
  (clj-time.core/minutes  n))

(defn timestamp-string->seconds
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-string->seconds "2020-04-20T16:20:00.123Z")
  ; =>
  ; "00"
  ;
  ; @return (string)
  [n]
  (string/part n 17 19))

(defn timestamp-object->seconds
  ; @param (object) n
  ;
  ; @example
  ; (timestamp-object->seconds #<DateTime 2020-04-20T16:20:00.123Z>)
  ; =>
  ; 0
  ;
  ; @return (s)
  [n]
  (clj-time.core/seconds n))

(defn timestamp-string->milliseconds
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-string->milliseconds "2020-04-20T16:20:00.123Z")
  ; =>
  ; "123"
  ;
  ; @return (string)
  [n]
  (string/part n 20 23))

(defn timestamp-object->milliseconds
  ; @param (object) n
  ;
  ; @example
  ; (timestamp-object->milliseconds #<DateTime 2020-04-20T16:20:00.123Z>)
  ; =>
  ; 123
  ;
  ; @return (ms)
  [n]
  (clj-time.core/milli n))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn timestamp-string->date
  ; @param (string) n
  ; @param (keyword)(opt) format
  ; :yyyymmdd, :yymmdd
  ; Default: :yyyymmdd
  ;
  ; @example
  ; (timestamp-string->date "2020-04-20T16:20:00.123Z" :yyyymmdd)
  ; =>
  ; "2020-04-20"
  ;
  ; @return (string)
  ([n]
   (timestamp-string->date n :yyyymmdd))

  ([n format]
   (if (string/nonblank? n)
       (let [year  (timestamp-string->year n)
             month (format/leading-zeros (timestamp-string->month n) 2)
             day   (format/leading-zeros (timestamp-string->day   n) 2)]
            (case format :yyyymmdd (str year "-" month "-" day)
                         :yymmdd   (let [year (string/part year 2 2)]
                                        (str year "-" month "-" day))
                         (return n))))))

(defn timestamp-string->time
  ; @param (string) n
  ; @param (keyword)(opt) format
  ; :hhmmss, :hhmm
  ; Default: :hhmmss
  ;
  ; @example
  ; (timestamp-string->time "2020-04-20T16:20:00.123Z" :hhmmss)
  ; =>
  ; "16:20:00"
  ;
  ; @return (string)
  ([n]
   (timestamp-string->time n :hhmmss))

  ([n format]
   (if (string/nonblank? n)
       (let [hours   (format/leading-zeros (timestamp-string->hours   n) 2)
             minutes (format/leading-zeros (timestamp-string->minutes n) 2)
             seconds (format/leading-zeros (timestamp-string->seconds n) 2)]
            (case format :hhmmss (str hours ":" minutes ":" seconds)
                         :hhmm   (str hours ":" minutes)
                         (return n))))))

(defn timestamp-string->date-time
  ; @param (string) n
  ; @param (keyword)(opt) date-format
  ; :yyyymmdd, :yymmdd
  ; Default: :yyyymmdd
  ; @param (keyword)(opt) time-format
  ; :hhmmss, :hhmm
  ; Default: :hhmmss
  ;
  ; @example
  ; (timestamp-string->date-time "2020-04-20T16:20:00.123Z" :yyyymmdd :hhmmss)
  ; =>
  ; "2020-04-20 - 16:20:00"
  ;
  ; @return (string)
  ([n]
   (timestamp-string->date-time n :yyyymmdd :hhmmss))

  ([n time-format]
   (timestamp-string->date-time n :yyyymmdd time-format))

  ([n date-format time-format]
   (if (string/nonblank? n)
       (let [date (timestamp-string->date n date-format)
             time (timestamp-string->time n time-format)]
            (str date " - " time)))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn timestamp-string->today?
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-string->today "2020-04-20T16:20:00.123Z")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n])
  ; TODO

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn timestamp-string->elapsed-ms
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-string->elapsed-ms "2020-04-20T16:20:00.123Z")
  ; =>
  ; "00"
  ;
  ; @return (ms)
  [n]
  ; TODO
  0)

(defn timestamp-object->elapsed-ms
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-object->elapsed-ms #<DateTime 2020-04-20T16:20:00.123Z>)
  ; =>
  ; "00"
  ;
  ; @return (ms)
  [n]
  ; TODO
  0)

(defn timestamp-string->elapsed-s
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-string->elapsed-s "2020-04-20T16:20:00.123Z")
  ; =>
  ; "00"
  ;
  ; @return (s)
  [n]
  ; TODO
  0)

(defn timestamp-object->elapsed-s
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-object->elapsed-s #<DateTime 2020-04-20T16:20:00.123Z>)
  ; =>
  ; "00"
  ;
  ; @return (s)
  [n]
  ; TODO
  0)
